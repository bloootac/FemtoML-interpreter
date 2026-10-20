

package femtoml
object Reduction {



	import femtoml.AST._



def reduction(dol$START:  org.sufrin.scalalr.SourceLocation, dol$END:  org.sufrin.scalalr.SourceLocation, n: Int): PartialFunction[List[Any], Any] = n match {
 /* program: Program =  {  EmptyStmt  }  */
 case 1 => 
  { case List() =>  EmptyStmt } 
 /* program: Program = expr `;;` program {  SeqStmt($expr, $program)  }  */
 case 2 => 
  { case List(dol$expr: Expr, _, dol$program: Program) =>  SeqStmt(dol$expr, dol$program) } 
 /* program: Program = decl `;;` program {  SeqStmt($decl, $program)  }  */
 case 3 => 
  { case List(dol$decl: Decl, _, dol$program: Program) =>  SeqStmt(dol$decl, dol$program) } 
 /* expr: Expr = NUM {  Num($NUM)  }  */
 case 4 => 
  { case List(dol$NUM: Long) =>  Num(dol$NUM) } 
 /* expr: Expr = CHAR {  Character($CHAR)  }  */
 case 5 => 
  { case List(dol$CHAR: Char) =>  Character(dol$CHAR) } 
 /* expr: Expr = ID {  Identifier($ID)   }  */
 case 6 => 
  { case List(dol$ID: String) =>  Identifier(dol$ID) } 
 /* expr: Expr = `(` expr `)` {  $expr  }  */
 case 7 => 
  { case List( _ , dol$expr: Expr,  _ ) =>  dol$expr } 
 /* expr: Expr = `<` ID `,` `[` args: S_1 `]` `>` {  Constructor($ID, $args)  }  */
 case 8 => 
  { case List( _ , dol$ID: String,  _ ,  _ , dol$args: List[Expr @unchecked],  _ ,  _ ) => 
        Constructor(dol$ID, dol$args)
  }
 /* expr: Expr = `\` ID `.` expr {  Fun($ID, $expr)  }  */
 case 9 => 
  { case List( _ , dol$ID: String,  _ , dol$expr: Expr) =>  Fun(dol$ID, dol$expr) } 
 /* expr: Expr = `\` `(` cases: S_2 `)` {  CaseFun($cases)  }  */
 case 10 => 
  { case List( _ ,  _ , dol$cases: List[Tuple2[Expr @unchecked,Expr @unchecked] @unchecked],  _ ) => 
        CaseFun(dol$cases)
  }
 /* expr: Expr = `let` decl `in` expr {  Let($decl, $expr)  }  */
 case 11 => 
  { case List( _ , dol$decl: Decl,  _ , dol$expr: Expr) =>  Let(dol$decl, dol$expr) } 
 /* pattern: Tuple2[Expr,Expr] = a: expr `->` b: expr {  ($a, $b)  }  */
 case 12 => 
  { case List(dol$a: Expr, _, dol$b: Expr) =>  (dol$a, dol$b) } 
 /* type_expr: TypeExpr = type_expr_body {  $type_expr_body  }  */
 case 13 => 
  { case List(dol$type_expr_body: TypeExpr) =>  dol$type_expr_body } 
 /* type_expr: TypeExpr = `@` args: S_3 `.` type_expr {  PolyType($args, $type_expr)  }  */
 case 14 => 
  { case List( _ , dol$args: List[String @unchecked],  _ , dol$type_expr: TypeExpr) => 
        PolyType(dol$args, dol$type_expr)
  }
 /* type_expr_body: TypeExpr = `Num` {  NumType  }  */
 case 15 => 
  { case List(_) =>  NumType } 
 /* type_expr_body: TypeExpr = `Char` {  CharType  }  */
 case 16 => 
  { case List(_) =>  CharType } 
 /* type_expr_body: TypeExpr = ID {  VarType($ID)  }  */
 case 17 => 
  { case List(dol$ID: String) =>  VarType(dol$ID) } 
 /* type_expr_body: TypeExpr = `Constructor` `[` args: S_4 `]` {  ConstructorType($args)  }  */
 case 18 => 
  { case List( _ ,  _ , dol$args: List[TypeExpr @unchecked],  _ ) => 
        ConstructorType(dol$args)
  }
 /* type_expr_body: TypeExpr = a: type_expr_body `->` b: type_expr_body {  FunType($a, $b)  }  */
 case 19 => 
  { case List(dol$a: TypeExpr, _, dol$b: TypeExpr) =>  FunType(dol$a, dol$b) } 
 /* type_expr_body: TypeExpr = `(` type_expr `)` {  $type_expr  }  */
 case 20 => 
  { case List( _ , dol$type_expr: TypeExpr,  _ ) =>  dol$type_expr } 
 /* decl: Decl = ID `=` expr {  ValDec($ID, $expr)  }  */
 case 21 => 
  { case List(dol$ID: String, _, dol$expr: Expr) =>  ValDec(dol$ID, dol$expr) } 
 /* decl: Decl = a: decl `and` b: decl {  AndDec($a, $b)  }  */
 case 22 => 
  { case List(dol$a: Decl, _, dol$b: Decl) =>  AndDec(dol$a, dol$b) } 
 /* decl: Decl = a: decl `;` b: decl {  SeqDec($a, $b)  }  */
 case 23 => 
  { case List(dol$a: Decl, _, dol$b: Decl) =>  SeqDec(dol$a, dol$b) } 
 /* decl: Decl = `rec` ID `=` expr {  RecDec(ValDec($ID, $expr))  }  */
 case 24 => 
  { case List( _ , dol$ID: String,  _ , dol$expr: Expr) => 
        RecDec(ValDec(dol$ID, dol$expr))
  }
 /* decl: Decl = ID `:` type_expr {  HasType($ID, $type_expr)  }  */
 case 25 => 
  { case List(dol$ID: String, _, dol$type_expr: TypeExpr) => 
        HasType(dol$ID, dol$type_expr)
  }
 /* S_1_L: List[Expr] = expr { List($expr) }  */
 case 26 => 
  { case List(dol$expr: Expr) =>  List(dol$expr) } 
 /* S_1_L: List[Expr] = S_1_L `,` expr { $expr :: $S_1_L }  */
 case 27 => 
  { case List(dol$S_1_L: List[Expr @unchecked], _, dol$expr: Expr) => 
        dol$expr :: dol$S_1_L
  }
 /* S_1: List[Expr] =  { Nil }  */
 case 28 => 
  { case List() =>  Nil } 
 /* S_1: List[Expr] = S_1_L { $S_1_L.reverse }  */
 case 29 => 
  { case List(dol$S_1_L: List[Expr @unchecked]) =>  dol$S_1_L.reverse } 
 /* S_2_L: List[Tuple2[Expr @unchecked,Expr @unchecked]] = pattern { List($pattern) }  */
 case 30 => 
  { case List(dol$pattern: Tuple2[Expr @unchecked,Expr @unchecked]) =>  List(dol$pattern) } 
 /* S_2_L: List[Tuple2[Expr @unchecked,Expr @unchecked]] = S_2_L `|` pattern { $pattern :: $S_2_L }  */
 case 31 => 
  { case List(dol$S_2_L: List[Tuple2[Expr @unchecked,Expr @unchecked] @unchecked], _, dol$pattern: Tuple2[Expr @unchecked,Expr @unchecked]) => 
        dol$pattern :: dol$S_2_L
  }
 /* S_2: List[Tuple2[Expr @unchecked,Expr @unchecked]] =  { Nil }  */
 case 32 => 
  { case List() =>  Nil } 
 /* S_2: List[Tuple2[Expr @unchecked,Expr @unchecked]] = S_2_L { $S_2_L.reverse }  */
 case 33 => 
  { case List(dol$S_2_L: List[Tuple2[Expr @unchecked,Expr @unchecked] @unchecked]) => 
        dol$S_2_L.reverse
  }
 /* S_3_L: List[String] = ID { List($ID) }  */
 case 34 => 
  { case List(dol$ID: String) =>  List(dol$ID) } 
 /* S_3_L: List[String] = S_3_L `,` ID { $ID :: $S_3_L }  */
 case 35 => 
  { case List(dol$S_3_L: List[String @unchecked], _, dol$ID: String) => 
        dol$ID :: dol$S_3_L
  }
 /* S_3: List[String] =  { Nil }  */
 case 36 => 
  { case List() =>  Nil } 
 /* S_3: List[String] = S_3_L { $S_3_L.reverse }  */
 case 37 => 
  { case List(dol$S_3_L: List[String @unchecked]) =>  dol$S_3_L.reverse } 
 /* S_4_L: List[TypeExpr] = type_expr_body { List($type_expr_body) }  */
 case 38 => 
  { case List(dol$type_expr_body: TypeExpr) =>  List(dol$type_expr_body) } 
 /* S_4_L: List[TypeExpr] = S_4_L `,` type_expr_body { $type_expr_body :: $S_4_L }  */
 case 39 => 
  { case List(dol$S_4_L: List[TypeExpr @unchecked], _, dol$type_expr_body: TypeExpr) => 
        dol$type_expr_body :: dol$S_4_L
  }
 /* S_4: List[TypeExpr] =  { Nil }  */
 case 40 => 
  { case List() =>  Nil } 
 /* S_4: List[TypeExpr] = S_4_L { $S_4_L.reverse }  */
 case 41 => 
  { case List(dol$S_4_L: List[TypeExpr @unchecked]) =>  dol$S_4_L.reverse } 

 }

}
