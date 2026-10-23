object FemtoML {

	import femtoml._
	import femtoml.Scanner._
	import femtoml.Components._
	import org.sufrin.scalalr._
	import org.sufrin.utility._
	import org.sufrin.utility.PrettyPrint._
	
	import java.nio.file.{Files, Paths}
	
	
	def main(args: Array[String]): Unit = {
	
		//attempt to import and run file if one is given
		if (!args.isEmpty) runFile()
		//run interactive interpreter 
		runInTerminal()
		
	}
	
	def runInTerminal(): Unit = {
	
		//for now, just blindly attempt to lex + parse user input and pretty print the AST
		
		//TODO: allow the user to exit the script
		//TODO: run parsed AST into interpreter 
	
		while (true) {
			val program = scala.io.StdIn.readLine() 
			val scanner = new FemtoMLScanner(SourceTextCursor(program))
			val parser  = LRParser.Pull[Token](Components)(scanner.sourceLocation)
			parser.run(scanner.next).prettyPrint()
		}
	}
	
	def runFile(filePath: String): Unit = {
		val path = Paths.get(filePath)
		
		if (Files.exists(path)) {
			//TODO: run each line in file through interpreter
			println("File found.")
			
		} else {
			//TODO: more descriptive error message
			println("File not found.")
		}
	}
}
