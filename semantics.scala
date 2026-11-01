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
def evalProgram[A](p: Program, env: Env = Map.empty, cont: List[Value] => A): A = {
	
	p match
		case EmptyStmt => cont(Nil)
		case SeqStmt(h,t) => {
			h match
				// evaluate expression
				case e : Expr => evalExpr(env, e, x => evalProgram(t, env, xs => cont(x::xs)))
				
				// evaluate declaration; add to environment
				case d : Decl => evalDecl(env, d, { env2 => env++=env2; evalProgram(t, env, cont) } )

		}
}


/* ============================================================ */

// expression evaluation
def evalExpr[A](env: Env, expr: Expr, cont: Value => A): A = {
	expr match
		// primitives
		case Identifier(id)                 => cont(env(id))
		case Num(n)                         => cont(NumVal(n))
		case Character(c)                   => cont(CharVal(c))
		
		// delay evaluation of Constructor arguments
		case Constructor(id, args)          => evalConstructorArgs(env, args, vs => cont(ConstructorVal(id, vs)))
		
		// delay evaluation of functions 
		case Fun(arg, body)                 => cont(Closure(env, arg, body))
		case CaseFun(cases)                 => cont(CaseFunVal(env, cases))
		
		case Let(decl, body)                =>
			// evaluate decl, then evaluate the body with the augmented environment
			evalDecl(env, decl, env2 => evalExpr(env++env2, body, cont))
	
		case Apply(f, x)                    => 
			//force evaluation of function f
			strictEval(env, f, {
				//if a closure, add arg -> (delayed x) to the environment and evaluate f in that context
				case Closure(env2, arg, body) => delay(env, x, v => evalExpr(env2 + (arg -> v), body, cont))
					
				//if a case function, attempt to find a matching pattern, and evaluate the corresponding body with the augmented environment
				case CaseFunVal(env2, cases) => delay(env, x, v => findCase(env2, v, cases, { case(env3, body) => evalExpr(env2 ++ env3, body, cont) }))
			})
		
}

// delay the evaluation of all constructor arguments
def evalConstructorArgs[A](env: Env, args: List[Expr], cont: List[Value] => A): A = {
	args match
		case x::xs => delay(env, x, v => evalConstructorArgs(env, xs, vs => cont(v::vs)))
		case Nil => cont(Nil)
		
}

// strict expression evaluation
def strictEval[A](env: Env, expr: Expr, cont: Value => A): A = evalExpr(env, expr, x => force(x, cont))


// if a value's evaluation has been delayed, force evaluation of it and permanently assign the evaluated result to the value object
def force[A](value: Value, cont: Value => A): A = {
	value match
		
		case d: Delay =>
			d.exprOrVal match
				// if the delayed value has already been evaluated, return that 
				case Right(v) => cont(v)
				
				// otherwise, force evaluation of the expression, and assign the result to the object
				// this avoids repeated parameter evaluation
				case Left((env, expr2)) => strictEval(env, expr2, v => { d.exprOrVal = Right(v); cont(v) } )

		// if the value's evaluation has not been delayed, return as-is
		case _ => cont(value) 
		
}


// delay the evaluation of parameters or declarations
def delay[A](env: Env, expr: Expr, cont: Value => A): A = {
	expr match
		case Let(decl, body)                => cont(Delay(Left(env, expr)))
		case Apply(f, x)                    => cont(Delay(Left(env, expr)))
		case _                              => evalExpr(env, expr, cont)
}

// given a value and list of cases, attempt to find a matching case
def findCase[A](env: Env, value: Value, cases: List[(Expr, Expr)], cont: (Env, Expr) => A): A = {

	cases match
		case (pat,body)::xs => patternMatch(env, pat, value, {
			case Some(env2) => cont(env2, body)
			case None => findCase(env, value, xs, cont)
		})
		case Nil            => throw new Exception("No matches found in case function application")	
}

// attempt to match a value to a pattern
def patternMatch[A](env: Env, pat: Expr, value: Value, cont: Option[Env] => A): A = {
	pat match
		// "blindly" match identifier with value 
		case Identifier(i)                   => cont(Some(Map(i -> value)))
		
		// force evaluation of value, check if number/character matches expression
		case Num(n)                          => 	
			force(value, _ match
				case NumVal(n2) => if (n==n2) cont(Some(Map.empty)) else cont(None)
				case _          => cont(None)
			)
			
		case Character(c)                    =>
			force(value, _ match
				case CharVal(c2) => if (c==c2) cont(Some(Map.empty)) else cont(None)
				case _           => cont(None)
			)
			
		// force evaluation of value, attempt to pattern match each args(i) with args2(i)
		// only return an environment if all of these matches are successful	
		case Constructor(id, args)           =>
		
			force(value, _ match
				case ConstructorVal(id2, args2) =>
				
					if (id == id2 && args.length == args2.length) patternMatchConstructorArgs(env, args, args2, x => cont(x))
					else cont(None)
					
				case _                         => cont(None)
				)
}


// attempt to match a list of patterns to a list of constructor arguments
// only return a complete environment if every match succeeds
def patternMatchConstructorArgs[A](env: Env, patArgs: List[Expr], valArgs: List[Value], cont: Option[Env] => A): A = {

	(patArgs, valArgs) match
		case (p::pats, v::vals) => patternMatch(env, p, v, {
			case Some(env2) => patternMatchConstructorArgs(env, pats, vals, {
				case Some(env3) => cont(Some(env2++env3))
				case None       => cont(None)
				})
			case None       => cont(None)
		})
		case (Nil, Nil)       => cont(Some(Map.empty))
		case _                => throw new Exception("Error in evaluating case function application")

}


/* ============================================================ */

// declaration evaluation
def evalDecl[A](env: Env, decl: Decl, cont: Env => A): A = {
	decl match
		// delay evaluation of declarations
		case ValDec(id, expr) => delay(env, expr, v => cont(Map(id -> v)))
		
		case AndDec(d1, d2)   => evalDecl(env, d1, env1 => evalDecl(env, d2, env2 => cont(env1++env2)))
		
		case SeqDec(d1, d2)   => evalDecl(env, d1, env2 => evalDecl(env++env2, d2, env3 => cont(env3++env2)))
		
		// for now, ignore type declarations
		case HasType(_, _)    => cont(Map())
		
		// knot-tying...
		case RecDec(d)        => {
			// create a copy of the given environment
			val env2 = scala.collection.mutable.Map.from(env)
			
			// evaluate the declaration in that context, add the closure to the environment copy
			// not the closyre references the environment, and the environment references the closure
			evalDecl(env2, d, ext => { env2 ++= ext; cont(ext) })
			
		}
}







