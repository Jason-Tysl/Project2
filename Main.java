import java.util.*;

class Main {
	public static void main(String[] args) {
		// Initialize the scanner with the input file.
		Scanner S = new Scanner(args[0]);

		// Initialize the Parser with the new scanner.
		Parser.scanner = S;

		// Use the program class to create the start of a parse tree
		ParseTree parseTree = new ParseTree();

		// Generate a parse tree for the input Core program using recursive descent.
		parseTree.parse();

		// Perform semantic checks on the parse tree.
		parseTree.semantic();

		// Use recursive descent to print the Core program from the parse tree.
		parseTree.print();
		
		// Parser.printHello(args[0]);
	}
}