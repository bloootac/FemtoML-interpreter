# FemtoML [WIP] 

TODO: description

## Prerequisites
- [Scala](https://www.scala-lang.org/download/) version 3.9.0 or above 
- [ScalaLR](https://github.com/sufrin/ScalaLR) for parser generation

## Building the interpreter
### Parser

ScalaLR is used to generate the parser files. See `femtoml-parser.scalalr` for the reduction rules. These files are already included in this project under `generated/`, but you can re-generate them using this command:  
`PATH_TO_SCALALR/Assets/scalalr femtoml-parser.scalalr`

Compile the parser files:  
`scalac   -classpath PATH_TO_SCALALR/Assets/scalalrruntime.jar   -d .   AST.scala   FemtoMLScanner.scala   generated/components/*.scala   test-parser.scala`


## Usage

Currently, the project only contains a parser, which can be run using this command:  
`scala run . --main-class TestParser --classpath PATH_TO_SCALALR/Assets/scalalrruntime.jar`

The program repeatedly accepts a FemtoML program as terminal input and attempts to parse it. If parsing is successful, the AST is printed. Otherwise, ideally, an error message is displayed. 

Example usage:
```sh
\(<True, []> -> 't' | <False,[]> -> 'f');;
└─ACCEPTED
  └─values: SeqStmt
    └─head: CaseFun
    │ └─cases: [#2]
    │   └─Tuple2
    │   │ └─_1: Constructor
    │   │ │ └─string: True
    │   │ │ └─args: [#0]
    │   │ └─_2: Character(t)
    │   └─Tuple2
    │     └─_1: Constructor
    │     │ └─string: False
    │     │ └─args: [#0]
    │     └─_2: Character(f)
    └─tail: EmptyStmt

x:@a,b,c. (a -> b) -> c;;
└─ACCEPTED
  └─values: SeqStmt
    └─head: HasType
    │ └─id: x
    │ └─type_expr: PolyType
    │   └─vars: [#3]
    │     └─a
    │     └─b
    │     └─c
    │   └─body: FunType
    │     └─arg_type: FunType
    │     │ └─arg_type: VarType(a)
    │     │ └─return_type: VarType(b)
    │     └─return_type: VarType(c)
    └─tail: EmptyStmt

let x=5 in;;
└─ERRONEOUS(Syntax error at: @1.10 
  Found: ;;
  Expecting one of: CHAR ID NUM `(` `<` `\` `let`
)
```


