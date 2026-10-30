

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
 /* expr: Expr = app_expr {  $app_expr  }  */
 case 4 => 
  { case List(dol$app_expr: Expr) =>  dol$app_expr } 
 /* expr: Expr = `\` ID `.` expr {  Fun($ID, $expr)  }  */
 case 5 => 
  { case List( _ , dol$ID: String,  _ , dol$expr: Expr) =>  Fun(dol$ID, dol$expr) } 
 /* expr: Expr = `\` `(` cases: S_1 `)` {  CaseFun($cases)  }  */
 case 6 => 
  { case List( _ ,  _ , dol$cases: List[Tuple2[Expr @unchecked,Expr @unchecked] @unchecked],  _ ) => 
        CaseFun(dol$cases)
  }
 /* expr: Expr = `let` decl `in` expr {  Let($decl, $expr)  }  */
 case 7 => 
  { case List( _ , dol$decl: Decl,  _ , dol$expr: Expr) =>  Let(dol$decl, dol$expr) } 
 /* app_expr: Expr = a: app_expr b: const_expr {  Apply($a, $b)  }  */
 case 8 => 
  { case List(dol$a: Expr, dol$b: Expr) =>  Apply(dol$a, dol$b) } 
 /* app_expr: Expr = const_expr {  $const_expr  }  */
 case 9 => 
  { case List(dol$const_expr: Expr) =>  dol$const_expr } 
 /* const_expr: Expr = NUM {  Num($NUM)  }  */
 case 10 => 
  { case List(dol$NUM: Long) =>  Num(dol$NUM) } 
 /* const_expr: Expr = CHAR {  Character($CHAR)  }  */
 case 11 => 
  { case List(dol$CHAR: Char) =>  Character(dol$CHAR) } 
 /* const_expr: Expr = ID {  Identifier($ID)   }  */
 case 12 => 
  { case List(dol$ID: String) =>  Identifier(dol$ID) } 
 /* const_expr: Expr = `<` ID `,` `[` args: S_2 `]` `>` {  Constructor($ID, $args)  }  */
 case 13 => 
  { case List( _ , dol$ID: String,  _ ,  _ , dol$args: List[Expr @unchecked],  _ ,  _ ) => 
        Constructor(dol$ID, dol$args)
  }
 /* const_expr: Expr = `(` expr `)` {  $expr  }  */
 case 14 => 
  { case List( _ , dol$expr: Expr,  _ ) =>  dol$expr } 
 /* patt_expr: Expr = NUM {  Num($NUM)  }  */
 case 15 => 
  { case List(dol$NUM: Long) =>  Num(dol$NUM) } 
 /* patt_expr: Expr = CHAR {  Character($CHAR)  }  */
 case 16 => 
  { case List(dol$CHAR: Char) =>  Character(dol$CHAR) } 
 /* patt_expr: Expr = ID {  Identifier($ID)   }  */
 case 17 => 
  { case List(dol$ID: String) =>  Identifier(dol$ID) } 
 /* patt_expr: Expr = `<` ID `,` `[` args: S_3 `]` `>` {  Constructor($ID, $args)  }  */
 case 18 => 
  { case List( _ , dol$ID: String,  _ ,  _ , dol$args: List[Expr @unchecked],  _ ,  _ ) => 
        Constructor(dol$ID, dol$args)
  }
 /* patt_expr: Expr = `(` patt_expr `)` {  $patt_expr  }  */
 case 19 => 
  { case List( _ , dol$patt_expr: Expr,  _ ) =>  dol$patt_expr } 
 /* pattern: Tuple2[Expr,Expr] = a: patt_expr `->` b: expr {  ($a, $b)  }  */
 case 20 => 
  { case List(dol$a: Expr, _, dol$b: Expr) =>  (dol$a, dol$b) } 
 /* type_expr: TypeExpr = type_expr_body {  $type_expr_body  }  */
 case 21 => 
  { case List(dol$type_expr_body: TypeExpr) =>  dol$type_expr_body } 
 /* type_expr: TypeExpr = `@` args: S_4 `.` type_expr {  PolyType($args, $type_expr)  }  */
 case 22 => 
  { case List( _ , dol$args: List[String @unchecked],  _ , dol$type_expr: TypeExpr) => 
        PolyType(dol$args, dol$type_expr)
  }
 /* type_expr_body: TypeExpr = `Num` {  NumType  }  */
 case 23 => 
  { case List(_) =>  NumType } 
 /* type_expr_body: TypeExpr = `Char` {  CharType  }  */
 case 24 => 
  { case List(_) =>  CharType } 
 /* type_expr_body: TypeExpr = ID {  VarType($ID)  }  */
 case 25 => 
  { case List(dol$ID: String) =>  VarType(dol$ID) } 
 /* type_expr_body: TypeExpr = `Constructor` `[` args: S_5 `]` {  ConstructorType($args)  }  */
 case 26 => 
  { case List( _ ,  _ , dol$args: List[TypeExpr @unchecked],  _ ) => 
        ConstructorType(dol$args)
  }
 /* type_expr_body: TypeExpr = a: type_expr_body `->` b: type_expr_body {  FunType($a, $b)  }  */
 case 27 => 
  { case List(dol$a: TypeExpr, _, dol$b: TypeExpr) =>  FunType(dol$a, dol$b) } 
 /* type_expr_body: TypeExpr = `(` type_expr `)` {  $type_expr  }  */
 case 28 => 
  { case List( _ , dol$type_expr: TypeExpr,  _ ) =>  dol$type_expr } 
 /* decl: Decl = ID `=` expr {  ValDec($ID, $expr)  }  */
 case 29 => 
  { case List(dol$ID: String, _, dol$expr: Expr) =>  ValDec(dol$ID, dol$expr) } 
 /* decl: Decl = a: decl `and` b: decl {  AndDec($a, $b)  }  */
 case 30 => 
  { case List(dol$a: Decl, _, dol$b: Decl) =>  AndDec(dol$a, dol$b) } 
 /* decl: Decl = a: decl `;` b: decl {  SeqDec($a, $b)  }  */
 case 31 => 
  { case List(dol$a: Decl, _, dol$b: Decl) =>  SeqDec(dol$a, dol$b) } 
 /* decl: Decl = `rec` ID `=` expr {  RecDec(ValDec($ID, $expr))  }  */
 case 32 => 
  { case List( _ , dol$ID: String,  _ , dol$expr: Expr) => 
        RecDec(ValDec(dol$ID, dol$expr))
  }
 /* decl: Decl = ID `:` type_expr {  HasType($ID, $type_expr)  }  */
 case 33 => 
  { case List(dol$ID: String, _, dol$type_expr: TypeExpr) => 
        HasType(dol$ID, dol$type_expr)
  }
 /* S_1_L: List[Tuple2[Expr @unchecked,Expr @unchecked]] = pattern { List($pattern) }  */
 case 34 => 
  { case List(dol$pattern: Tuple2[Expr @unchecked,Expr @unchecked]) =>  List(dol$pattern) } 
 /* S_1_L: List[Tuple2[Expr @unchecked,Expr @unchecked]] = S_1_L `|` pattern { $pattern :: $S_1_L }  */
 case 35 => 
  { case List(dol$S_1_L: List[Tuple2[Expr @unchecked,Expr @unchecked] @unchecked], _, dol$pattern: Tuple2[Expr @unchecked,Expr @unchecked]) => 
        dol$pattern :: dol$S_1_L
  }
 /* S_1: List[Tuple2[Expr @unchecked,Expr @unchecked]] =  { Nil }  */
 case 36 => 
  { case List() =>  Nil } 
 /* S_1: List[Tuple2[Expr @unchecked,Expr @unchecked]] = S_1_L { $S_1_L.reverse }  */
 case 37 => 
  { case List(dol$S_1_L: List[Tuple2[Expr @unchecked,Expr @unchecked] @unchecked]) => 
        dol$S_1_L.reverse
  }
 /* S_2_L: List[Expr] = expr { List($expr) }  */
 case 38 => 
  { case List(dol$expr: Expr) =>  List(dol$expr) } 
 /* S_2_L: List[Expr] = S_2_L `,` expr { $expr :: $S_2_L }  */
 case 39 => 
  { case List(dol$S_2_L: List[Expr @unchecked], _, dol$expr: Expr) => 
        dol$expr :: dol$S_2_L
  }
 /* S_2: List[Expr] =  { Nil }  */
 case 40 => 
  { case List() =>  Nil } 
 /* S_2: List[Expr] = S_2_L { $S_2_L.reverse }  */
 case 41 => 
  { case List(dol$S_2_L: List[Expr @unchecked]) =>  dol$S_2_L.reverse } 
 /* S_3_L: List[Expr] = patt_expr { List($patt_expr) }  */
 case 42 => 
  { case List(dol$patt_expr: Expr) =>  List(dol$patt_expr) } 
 /* S_3_L: List[Expr] = S_3_L `,` patt_expr { $patt_expr :: $S_3_L }  */
 case 43 => 
  { case List(dol$S_3_L: List[Expr @unchecked], _, dol$patt_expr: Expr) => 
        dol$patt_expr :: dol$S_3_L
  }
 /* S_3: List[Expr] =  { Nil }  */
 case 44 => 
  { case List() =>  Nil } 
 /* S_3: List[Expr] = S_3_L { $S_3_L.reverse }  */
 case 45 => 
  { case List(dol$S_3_L: List[Expr @unchecked]) =>  dol$S_3_L.reverse } 
 /* S_4_L: List[String] = ID { List($ID) }  */
 case 46 => 
  { case List(dol$ID: String) =>  List(dol$ID) } 
 /* S_4_L: List[String] = S_4_L `,` ID { $ID :: $S_4_L }  */
 case 47 => 
  { case List(dol$S_4_L: List[String @unchecked], _, dol$ID: String) => 
        dol$ID :: dol$S_4_L
  }
 /* S_4: List[String] =  { Nil }  */
 case 48 => 
  { case List() =>  Nil } 
 /* S_4: List[String] = S_4_L { $S_4_L.reverse }  */
 case 49 => 
  { case List(dol$S_4_L: List[String @unchecked]) =>  dol$S_4_L.reverse } 
 /* S_5_L: List[TypeExpr] = type_expr_body { List($type_expr_body) }  */
 case 50 => 
  { case List(dol$type_expr_body: TypeExpr) =>  List(dol$type_expr_body) } 
 /* S_5_L: List[TypeExpr] = S_5_L `,` type_expr_body { $type_expr_body :: $S_5_L }  */
 case 51 => 
  { case List(dol$S_5_L: List[TypeExpr @unchecked], _, dol$type_expr_body: TypeExpr) => 
        dol$type_expr_body :: dol$S_5_L
  }
 /* S_5: List[TypeExpr] =  { Nil }  */
 case 52 => 
  { case List() =>  Nil } 
 /* S_5: List[TypeExpr] = S_5_L { $S_5_L.reverse }  */
 case 53 => 
  { case List(dol$S_5_L: List[TypeExpr @unchecked]) =>  dol$S_5_L.reverse } 

 }

}
