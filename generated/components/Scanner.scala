
package femtoml
object Scanner{


trait Token extends org.sufrin.scalalr.Lexeme { val value: Any ; val symbol: Int } 
case object $end extends Token { val value = (); val symbol = 0 }
val ENDSTREAM: Token = $end
case object error extends Token { val value = (); val symbol = 1 }
case object UNDEF extends Token { val value = (); val symbol = 2 }
case class NUM(value: Long) extends Token { val symbol = 3 }
case class CHAR(value: Char) extends Token { val symbol = 4 }
case class ID(value: String) extends Token { val symbol = 5 }
case object `(` extends Token { val value = (); val symbol = 6 }
case object `)` extends Token { val value = (); val symbol = 7 }
case object `[` extends Token { val value = (); val symbol = 8 }
case object `]` extends Token { val value = (); val symbol = 9 }
case object `<` extends Token { val value = (); val symbol = 10 }
case object `>` extends Token { val value = (); val symbol = 11 }
case object `\\` extends Token { val value = (); val symbol = 12 }
case object `.` extends Token { val value = (); val symbol = 13 }
case object `,` extends Token { val value = (); val symbol = 14 }
case object `|` extends Token { val value = (); val symbol = 15 }
case object `@` extends Token { val value = (); val symbol = 16 }
case object `=` extends Token { val value = (); val symbol = 17 }
case object `:` extends Token { val value = (); val symbol = 18 }
case object `let` extends Token { val value = (); val symbol = 19 }
case object `in` extends Token { val value = (); val symbol = 20 }
case object `and` extends Token { val value = (); val symbol = 21 }
case object `rec` extends Token { val value = (); val symbol = 22 }
case object `Num` extends Token { val value = (); val symbol = 23 }
case object `Char` extends Token { val value = (); val symbol = 24 }
case object `Constructor` extends Token { val value = (); val symbol = 25 }
case object `;;` extends Token { val value = (); val symbol = 26 }
case object `;` extends Token { val value = (); val symbol = 27 }
case object `->` extends Token { val value = (); val symbol = 28 }
// MAP SYMBOL NUMBERS TO NAMES
val symbolName: collection.immutable.Map[Int, String] = {
     import org.sufrin.utility.ArrayMap
    val arr = new Array[String](46)
         locally {
          arr(0) = """$end"""
          arr(1) = """error"""
          arr(2) = """UNDEF"""
          arr(3) = """NUM"""
          arr(4) = """CHAR"""
          arr(5) = """ID"""
          arr(6) = """`(`"""
          arr(7) = """`)`"""
          arr(8) = """`[`"""
          arr(9) = """`]`"""
          arr(10) = """`<`"""
          arr(11) = """`>`"""
          arr(12) = """`\`"""
          arr(13) = """`.`"""
          arr(14) = """`,`"""
          arr(15) = """`|`"""
          arr(16) = """`@`"""
          arr(17) = """`=`"""
          arr(18) = """`:`"""
          arr(19) = """`let`"""
          arr(20) = """`in`"""
          arr(21) = """`and`"""
          arr(22) = """`rec`"""
          arr(23) = """`Num`"""
          arr(24) = """`Char`"""
          arr(25) = """`Constructor`"""
          arr(26) = """`;;`"""
          arr(27) = """`;`"""
          arr(28) = """`->`"""
          arr(29) = """$accept"""
          arr(30) = """program"""
          arr(31) = """expr"""
          arr(32) = """app_expr"""
          arr(33) = """const_expr"""
          arr(34) = """pattern"""
          arr(35) = """type_expr"""
          arr(36) = """type_expr_body"""
          arr(37) = """decl"""
          arr(38) = """S_1_L"""
          arr(39) = """S_1"""
          arr(40) = """S_2_L"""
          arr(41) = """S_2"""
          arr(42) = """S_3_L"""
          arr(43) = """S_3"""
          arr(44) = """S_4_L"""
          arr(45) = """S_4"""
         } // locally
         ArrayMap(arr)
     }


// MAP QUOTED SYMBOL NAMES TO TOKENS 
lazy val symbolToken: collection.immutable.Map[String, Token] =  collection.immutable.ListMap(
    """(""" -> `(`,
    """)""" -> `)`,
    """[""" -> `[`,
    """]""" -> `]`,
    """<""" -> `<`,
    """>""" -> `>`,
    """\""" -> `\\`,
    """.""" -> `.`,
    """,""" -> `,`,
    """|""" -> `|`,
    """@""" -> `@`,
    """=""" -> `=`,
    """:""" -> `:`,
    """let""" -> `let`,
    """in""" -> `in`,
    """and""" -> `and`,
    """rec""" -> `rec`,
    """Num""" -> `Num`,
    """Char""" -> `Char`,
    """Constructor""" -> `Constructor`,
    """;;""" -> `;;`,
    """;""" -> `;`,
    """->""" -> `->`,
    ""->ENDSTREAM)
lazy val TokenMap: collection.immutable.Map[String, Token] = symbolToken
}
