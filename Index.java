public class Index {
    
    // Add fields for each child the Index node could have
    Expr expr;
    String epsilon;

    void parse(Scanner scanner) {
        Core currentToken = scanner.currentToken();

        if (currentToken != Core.LBRACE) {
            System.out.println("ERROR: Expected \"LBRACE\" token in Index.java, got: " + currentToken.toString());
            System.exit(0);
        }

        scanner.nextToken();
        expr = new Expr();
        expr.parse(scanner);

        // expr.parse will give the next token

        currentToken = scanner.currentToken();
        if (currentToken != Core.RBRACE) {
            System.out.println("ERROR: Expected \"RBRACE\" token in Index.java, got: " + currentToken.toString());
            System.exit(0);
        }

        // give token out of <index> (should be ASSIGN)
        scanner.nextToken();
    }

    void semantic() {

    }

    void print() {
        
    }

}
