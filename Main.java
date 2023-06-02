
class Main {
	public static void main(String[] args) {
		// Initialize the scanner with the input file.
		Scanner mainScanner = new Scanner(args[0]);

		// Initialize the Parser with the new scanner.
		Parser.scanner = mainScanner;

		// Use the program class to create the start of a parse tree
		ParseTree parseTree = new ParseTree();

		// Generate a parse tree for the input Core program using recursive descent.
		parseTree.parse(mainScanner);

		// Perform semantic checks on the parse tree.
		parseTree.semanticCheck();

		// Use recursive descent to print the Core program from the parse tree.
		parseTree.print();
		
		// Parser.printHello(args[0]);
	}
}