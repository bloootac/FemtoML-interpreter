package femtoml

object AST

//a program is a list of statements
sealed trait Program
case object EmptyStmt extends Program
case class SeqStmt(head: Statement, tail: Program) extends Program 

//a statement is an expression or a declaration
sealed trait Statement

sealed trait Expr extends Statement

/*
expr:
	- Num number                          | 5067
	- Character char                      | c
	- Constructor string [expr]           | <"s", [e1, ..., eN]>
	- Identifier string                   | val
	- Apply expr expr                     | e1 e2
	- Fun identifier expr                 | \ i . e
	- CaseFun [(expr, expr)]              | \ ( p1 -> b1 | ... | pN -> bN)
	- Let decl expr                       | let d in e 
*/

case class Num(value: Long) extends Expr
case class Character(value: Char) extends Expr
case class Constructor(string: String, args: List[Expr]) extends Expr
case class Identifier(id: String) extends Expr
case class Apply(expr1: Expr, expr2: Expr) extends Expr
case class Fun(arg: String, body: Expr) extends Expr
case class CaseFun(cases: List[(Expr, Expr)]) extends Expr
case class Let(decl: Decl, expr: Expr) extends Expr


sealed trait TypeExpr
/*
type_expr:
	- NumType                             | Num
	- CharType                            | Char
	- VarType                             | a
	- ConstructorType [type_exprs]        | Constructor [t1, ..., tN]
	- FunType type_expr type_expr         | t1 -> t2
	- PolyType [identifier] type_expr     | @ i1, ..., iN. t
*/

case object NumType extends TypeExpr
case object CharType extends TypeExpr
case class VarType(id: String) extends TypeExpr
case class ConstructorType(arg_types: List[TypeExpr]) extends TypeExpr
case class FunType(arg_type: TypeExpr, return_type: TypeExpr) extends TypeExpr
case class PolyType(vars: List[String], body: TypeExpr) extends TypeExpr


sealed trait Decl extends Statement
/*
decl:
	- ValDec identifier expr              | i = e 
	- AndDec decl decl                    | d1 and d2
	- SeqDec decl decl                    | d1 ; d2
	- RecDec decl                         | rec d
	- HasType identifier type_expr        | i : e
*/
case class ValDec(id: String, value: Expr) extends Decl
case class AndDec(dec1: Decl, dec2: Decl) extends Decl
case class SeqDec(dec1: Decl, dec2: Decl) extends Decl
case class RecDec(decl: ValDec) extends Decl
case class HasType(id: String, type_expr: TypeExpr) extends Decl


