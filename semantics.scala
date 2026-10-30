package femtoml

import femtoml.AST

import scala.collection.mutable.Map



object Semantics
/*

TODO: finish implemeting eval func

TODO: make everything use cps...

TODO: change for better error messages

*/



/* ============================================================ */

sealed trait Value

type Env = Map[String, Value]

case class NumVal(value: Long) extends Value
case class CharVal(value: Char) extends Value
case class ConstructorVal(id: String, args: List[Value]) extends Value
case class CLosure(env: Env, arg: String, body: Expr) extends Value
case class CaseFunVal(env: Env, cases: List[(Expr, Expr)]) extends Value

case class Delay(var exprOrVal: Either[(Env, Expr), Value]) extends Value 

/* ============================================================ */

// top-level program evaluation
def evalProgram(p: Program, env: Env = Map.empty) = {
	
	p match
		case EmptyStmt => ()
		case SeqStmt(h,t) => {
			h match
				case e : Expr => evalExpr(env, e)
				case d : Decl => { env ++= evalDecl(env, d); ()}
			
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
		//TODO: casefun
			
		
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


/*
TODO 
findCase env val cases : [(expr, expr)]
	
	for each case in cases
		try to pattern match on the expr, edit env
		then eval 
	
*/

/*
TODO
patMatch: checks if pattern matches and changes env to fit

*/



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
			
			ext
		}
}







