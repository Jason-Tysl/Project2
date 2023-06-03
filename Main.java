
class Main {
	public static void main(String[] args) {
		// Initialize the scanner with the input file.
		// Scanner mainScanner = new Scanner(args[0]);

		Scanner mainScanner = new Scanner("TestCode.code");

		// Initialize the Parser with the new scanner.
		Parser.scanner = mainScanner;

		// Use the program class to create the start of a parse tree
		Procedure procedure = new Procedure();

		// Generate a parse tree for the input Core program using recursive descent.
		procedure.parse(mainScanner);

		// Perform semantic checks on the parse tree.
		procedure.semantic();

		// Use recursive descent to print the Core program from the parse tree.
		procedure.print();
		
	}
}