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

	import scala.collection.mutable.Map
	import Console.{GREEN, RED, BLUE, RESET}


	val error_str = s"${RED}ERROR:${RESET}"
	val femtoml_str = s"${BLUE}femtoml>${RESET} "

	// interpreter's main entry point
	def main(args: Array[String]): Unit = {

		//attempt to import and run file if one is given
		var env = if (!args.isEmpty) loadFiles(args) else Map.empty
		
		//run interactive interpreter 
		runInTerminal(env)
		
	}

	// terminal interface for interpreter
	def runInTerminal(env: Env = Map.empty): Unit = {
		// TODO: make prettier, allow user to exit script, allow multi-line statements
		
		while (true) {
			// collect one-line user input
			print(femtoml_str)
			val program = scala.io.StdIn.readLine()
			
			val res = parseAndInterpret(program, xs => for (x <- xs) println(x), env)
				
			res match
				case Left(_)      => ()
				case Right(err)   => println(s"$error_str $err")

		}
			
	}

	// run interpreter on multiple files
	def loadFiles(filePaths: Array[String]): Env = {

		// initialise environment
		var env : Env = Map.empty[String, Value]

		for (file <- filePaths) 
		do
			val path = Paths.get(file)
			
			if (Files.exists(path)) 
				val content = scala.io.Source.fromFile(file).getLines().mkString("\n")

				
				val res = parseAndInterpret(content, xs => for (x <- xs) println(x), env)
				
				res match
					case Left(_)      => println(s"Loaded $file")
					case Right(err)   => println(s"$error_str: File $file could not be loaded. $err")
				
			else
				println(s"$error_str: File $file not found.")
				
		println("Running interpreter in terminal...")
		env
	}

	// given a program string, attempt to parse and interpret it
	def parseAndInterpret[A](program: String, cont: List[Value] => A, env: Env = Map.empty): Either[A, Throwable] = {
		// initialise scanner and parser
		val scanner = new FemtoMLScanner(SourceTextCursor(program))
		val parser  = org.sufrin.scalalr.LRParser.Pull[Token](Components)(scanner.sourceLocation)
		
		try {
			// run parser on input
			parser.run(scanner.next) match {
				case ACCEPTED(value) => 
				
					// Uncomment to print AST:
					// value.prettyPrint()
					// println("***")
					
					// run program through interpreter, run continuation on output
					value match
						case p : Program => 
							try
								Left(evalProgram(p, env, cont))
							catch
								case s => Right(s)
							
				// print error message if parsing failed
				case ERRONEOUS(diagnosis) => Right(new Exception(diagnosis))
				case _                    => Right(new Exception)
			}
			
		} catch {
				case err                  => Right(err)

		}
	}
}

