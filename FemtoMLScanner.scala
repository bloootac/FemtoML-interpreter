package femtoml

import femtoml.Scanner._
import org.sufrin.scalalr._
import org.sufrin.utility._


class FemtoMLScanner(source: SourceTextCursor) extends SimpleScannerCore[Token](source) {
	override val IDENTIFIER: String => Token = ID.apply
	override val LONG: Long => Token = NUM.apply
	override def TOKENMAP: Map[String, Token] = femtoml.Scanner.symbolToken
	override val ENDSTREAM  = $end	
}
