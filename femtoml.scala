object FemtoML {

	import femtoml._
	import femtoml.Scanner._
	import femtoml.Components._
	import femtoml.Semantics._
	import org.sufrin.scalalr._
	import org.sufrin.scalalr.LRParser._
	import org.sufrin.utility._
	import org.sufrin.utility.PrettyPrint._
	
	import java.nio.file.{Files, Paths}
	
	
	def main(args: Array[String]): Unit = {
	
		//attempt to import and run file if one is given
		if (!args.isEmpty) loadFile(args(0))
		//run interactive interpreter 
		runInTerminal()
		
	}
	
	def runInTerminal(): Unit = {
		// TODO: make prettier, allow user to exit script, allow multi-line statements
		
		// initialise environment
		var env : Env = scala.collection.mutable.Map.empty[String, Value]
		
		while (true) {
			// collect one-line user input
			val program = scala.io.StdIn.readLine() 
			
			// initialise scanner and parser (TODO: does this need to be in the while block?)
			val scanner = new FemtoMLScanner(SourceTextCursor(program))
			val parser  = org.sufrin.scalalr.LRParser.Pull[Token](Components)(scanner.sourceLocation)
			
			try {
				// run parser on input
				parser.run(scanner.next) match {
					case ACCEPTED(value) => 
					
						// if successful, print AST
						value.prettyPrint()
						println("***")
						
						// run program through interpreter; print output
						value match
							case p : Program => 
								try
									evalProgram(p, env, xs => for (i <- xs) println(i))
								catch
									// the user has done something wrong
									case InterpreterException(s) => println(s"ERROR: $s")
									
									// I have done something wrong
									case err                     => println(s"Unexpected error: $err")
								
					// print error message if parsing failed
					case ERRONEOUS(diagnosis) => println(diagnosis)
				}
				
			} catch {
					case err                  => println(err)
			}
		}
			
	}
	
	def loadFile(filePath: String): Unit = {
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
