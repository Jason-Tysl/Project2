Name: Jason Tysl

This is the readme file for CSE 3341 Project 2, the CORE language Parser.

Files: 
Assign.java - this file contains the parsing and printing for the three different productions of <assign>. 
    It also contains two semantic error checks that check if the id has been declared and if it
    is a record id when needed.

Cmpr.java - this file contains the parsing and printing for the three different productions of <cmpr>.

Cond.java - this file contains the parsing and printing for the three different productions of <cond>.

Core.java - this file contains the Core enum that is used to check if we're accessing the correct token.

Decl.java - this file contains the parsing and printing for the two different productions of <decl>.

DeclInteger.java - this file contains the parsing and printing for the <decl-integer> production. It stores
    the id into the map to be checked later. It also checks for doubly declaring.

DeclRecord.java - this file contains the parsing and printing for the <decl-record> production. It stores
    the id into the map to be checked later. It also checks for doubly declaring.

DeclSeq.java - this file contains the parsing and printing for the two different productions of <decl-seq>.

Expr.java - this file contains the parsing and printing for the three different productions of <expr>.

Factor.java - this file contains the parsing and printing for the five different productions of <factor>.
    It is the last production.

If.java - this file contains the parsing and printing for the two different productions of <if>.

Index.java - this file contains the parsing and printing for the two different productions of <index>.

Loop.java - this file contains the parsing and printing for the <loop>.

Main.java - this file creates a scanner which gets used by the parser which parses the input file then
    prints the results to stdout.

Out.java - this file contains the parsing and printing for the <out>.

Procedure.java - this file contains the parsing and printing for the two productions of <procedure>.

README.txt - this file contains the creator's name and information about how the entire parser program works.

Scanner.java - this file contains the scanner that was taken from the "PerfectProject1.zip" from carmen. It
    scans and tokenizes all of the words from an input file.

Stmt.java - this file contains the parsing and printing for the five different productions of <stmt>.

StmtSeq.java - this file contains the parsing and printing for the two different productions of <stmt-seq>.
 
Term.java - this file contains the parsing and printing for the three different productions of <term>.

TestCode.code - this file was used throughout the creation of this parser to incrementally test new pieces of the
    parser. The file started off small and then grew with needs.

Special Features: N/A

Overall design: The parseTree is created as each of the tokens is brought in. Unnecessary tokens are tossed and 
glossed over by scanner.nextToken(). With this however, we use the currentToken to check if we are in the right 
position in the program and we send an error if we're not. It uses recursion to build a parse tree to be used in
the future. After it finishes building the parseTree we print the tree back to stdout to make sure it was done correctly.

Testing and bugs: The file TestCode.code is what I used to do most of my debugging throughout the program.
I slowly added more and more conditions until it used just about everything that it could.
As Sarah Lee asked in the piazza, I couldn't figure out why Error 02.code and 05.code file wasn't throwing an 
error. I don't even see when looking at it what's wrong semantically or parser-ly. Everything else should work though.
Also my original structure had me using semantic() functions in each file, but I changed and didn't have time to remove
all of them so consider them to be commented out.

