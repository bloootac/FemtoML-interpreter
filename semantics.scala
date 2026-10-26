package femtoml

import femtoml.AST
import femtoml.Env

object Semantics

/*TODO: implement eval func
	- num
	- char
	- constructor
	- fun
	- casefun
	- delay
*/


type Env = Map[String, Value]

sealed trait Value

/*
type value = NumVal int
			| CharVal char
			| ConstructorVal string [value]
			| FunVal environment string expr 
			| CaseFunVal environment [(value, expr)]
			
			| Delay expr_or_val ref
			
expr_or_value: Expression environment expr
			| Value value
*/

case class NumVal(value: Long) extends Value
case class CharVal(value: Char) extends Value
case class ConstructorVal(id: String, args: List[Value]) extends Value
case class FunVal(environment: Env, arg: String, body: Value) extends Value
case class CaseFunVal(environment: Env, cases: List[(Value, Value)]) extends Value

case class Delay(expr_or_val: Either[(Expr, Env), Value]) extends Value 



