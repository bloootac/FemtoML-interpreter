package femtoml

import femtoml.AST

import scala.collection.mutable.Map



object Semantics
/*
TODO: make everything use cps...

TODO: change for better error messages

TODO: add type-checking

*/



/* ============================================================ */

sealed trait Value

type Env = Map[String, Value]

case class NumVal(value: Long) extends Value
case class CharVal(value: Char) extends Value
case class ConstructorVal(id: String, args: List[Value]) extends Value
case class Closure(env: Env, arg: String, body: Expr) extends Value { override def toString: String = "<closure>" }
case class CaseFunVal(env: Env, cases: List[(Expr, Expr)]) extends Value { override def toString: String = "<case function>" }

case class Delay(var exprOrVal: Either[(Env, Expr), Value]) extends Value { 
	override def toString: String = exprOrVal match {
        case Left(_)  => "<unevaluated>"
        case Right(v) => s"<evaluated: $v>"
    }
}

/* ============================================================ */

// top-level program evaluation
def evalProgram(p: Program, env: Env = Map.empty): List[Value] = {
	
	p match
		case EmptyStmt => Nil
		case SeqStmt(h,t) => {
			h match
				// evaluate expression
				case e : Expr => evalExpr(env, e) :: evalProgram(t,env)
				// evaluate declaration; add to environment
				case d : Decl => 
					env ++= evalDecl(env, d)
					evalProgram(t, env)
			
		}
}


/* ============================================================ */

// expression evaluation
def evalExpr(env: Env, expr: Expr) : Value = {
	expr match
		// primitives
		case Identifier(id)                 => env(id)
		case Num(n)                         => NumVal(n)
		case Character(c)                   => CharVal(c)
		
		// delay evaluation of Constructor arguments
		case Constructor(id, args)          => ConstructorVal(id, args.map(x => delay(env, x)))
		
		// delay evaluation of functions 
		case Fun(arg, body)                 => Closure(env, arg, body)
		case CaseFun(cases)                 => CaseFunVal(env, cases)
		
		case Let(decl, body)                =>
			// create an environment for variables in the declaration
			val env2 = evalDecl(env, decl)
			
			// evaluate the body within the context of the augmented environment
			evalExpr(env ++ env2, body)
	
		case Apply(f, x)                    => 
			// force evaluation of function f 
			(strictEval(env, f)) match
			
				// delay the evaluation of x
				
				// add arg -> x to the environment and evaluate f in that context 
				case Closure(env2, arg, body) => evalExpr(env2 + (arg -> delay(env, x)), body)

				// attempt to find a matching pattern
				// evaluate the corresponding body with the augmented environment
				case CaseFunVal(env2, cases) => 
					var (env3, body) = findCase(env2, delay(env, x), cases) 
					evalExpr(env2 ++ env3, body)
			
		
}

// strict expression evaluation
def strictEval(env: Env, expr: Expr): Value = force(evalExpr(env, expr))


// if a value's evaluation has been delayed, force evaluation of it and permanently assign the evaluated result to the value object
def force(value: Value): Value = {
	value match
		
		case d: Delay =>
			d.exprOrVal match
				// if the delayed value has already been evaluated, return that 
				case Right(v) => v
				
				// otherwise, force evaluation of the expression, and assign the result to the object
				// this avoids repeated parameter evaluation
				case Left((env, expr2)) => {
					val v = strictEval(env, expr2)
					d.exprOrVal = Right(v)
					v
				}
				
		// if the value's evaluation has not been delayed, return as-is
		case _ => value 
		
}


// delay the evaluation of parameters or declarations
def delay(env: Env, expr: Expr): Value = {
	expr match
		case Let(decl, body)                => Delay(Left(env, expr))
		case Apply(f, x)                    => Delay(Left(env, expr))
		case _                              => evalExpr(env, expr)
}

// given a value and list of cases, attempt to find a matching case
def findCase(env: Env, value: Value, cases: List[(Expr, Expr)]): (Env, Expr) = {

	for (pat, body) <- cases
	do 
		patternMatch(env, pat, value) match
			case Some(env2) => return (env2, body)
			case None       => ()
	
	throw new Exception("No matches found in case function application")
	
		
}

// attempt to match a value to a pattern
def patternMatch(env: Env, pat: Expr, value: Value): Option[Env] = {
	pat match
		// "blindly" match identifier with value 
		case Identifier(i)                   => Some(Map(i -> value))
		
		// force evaluation of value, check if number/character matches expression
		case Num(n)                          => 
			force(value) match
				case NumVal(n2) => if (n==n2) Some(Map.empty) else None
				case _          => None
			
		case Character(c)                    =>
			force(value) match
				case CharVal(c2) => if (c==c2) Some(Map.empty) else None
				case _           => None
			
		// force evaluation of value, attempt to pattern match each args(i) with args2(i)
		// only return an environment if all of these matches are successful	
		case Constructor(id, args)           =>
			force(value) match
				case ConstructorVal(id2, args2) =>
				
					if (id == id2 && args.length == args2.length)
						args.zip(args2).foldLeft(Option(Map.empty[String, Value]): Option[Env]) {
							case (acc, (a, b)) =>
								for {
									env1 <- acc
									env2 <- patternMatch(env, a, b)
								} yield env1 ++ env2
						}
							
					else None
}
// rec f = \('a' -> 0 | 'b' -> <bCase, [f 'a']>);; g = \( 0 -> 1 | <bCase, [0]> -> 100);; 

/* ============================================================ */

// declaration evaluation
def evalDecl(env: Env, decl: Decl): Env = {
	decl match
		// delay evaluation of declarations
		case ValDec(id, expr) => Map(id -> delay(env, expr))

		case AndDec(d1, d2)   => evalDecl(env,d1) ++ evalDecl(env,d2)
		case SeqDec(d1, d2)   => { val env2 = evalDecl(env, d1); env2 ++ evalDecl(env++env2, d2) }
		
		// for now, ignore type declarations
		case HasType(_, _)    => Map()
		
		// knot-tying...
		case RecDec(d)        => {
			// create a copy of the given environment 
			val env2 = scala.collection.mutable.Map.from(env)
			
			// evaluate the declaration in that context 
			val ext = evalDecl(env2, d)
			
			// add the closure to the copy of the environment
			// now the closure references the environment, and the environment references the closure 
			env2 ++= ext

			
		}
}







