object TestParser {
	import femtoml._
	import femtoml.Scanner._
	import femtoml.Components._
	import org.sufrin.scalalr._
	import org.sufrin.utility._
	import org.sufrin.utility.PrettyPrint._
	
	def main(args: Array[String]): Unit = {
		while (true) {
			val program = scala.io.StdIn.readLine() 
			val scanner = new FemtoMLScanner(SourceTextCursor(program))
			val parser  = LRParser.Pull[Token](Components)(scanner.sourceLocation)
			parser.run(scanner.next).prettyPrint()
		}
	}
}
