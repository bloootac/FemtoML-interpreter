package femtoml

import femtoml.Scanner._
import org.sufrin.scalalr._
import org.sufrin.utility._

//FemtoML lexer
class FemtoMLScanner(source: SourceTextCursor) extends SimpleScannerCore[Token](source) {
	override val IDENTIFIER: String => Token = ID.apply
	override val LONG: Long => Token = NUM.apply
	override def TOKENMAP: Map[String, Token] = femtoml.Scanner.symbolToken
	override val ENDSTREAM  = $end	
			
	//override mkString to only allow single characters encased in single quotes
	override def mkString(openQuote: String, closeQuote: String, body: Seq[Char]): Token = {
		if (openQuote == "'" && closeQuote == "'") {
	        if (body.length == 1)
	            CHAR(body.head)
	        else
	            throw new IllegalArgumentException(
	                "Character literals must contain exactly one character"
	            )
	    } else {
	        throw new IllegalArgumentException(
	            "Unexpected string literal"
	        )
	    }
	}
}
