public class Out {
    
    // Add fields for each child the Out node could have
    Expr expr;

    void parse(Scanner scanner) {
        Core currentToken = scanner.currentToken();

        scanner.nextToken();
        currentToken = scanner.currentToken();
        if (currentToken != Core.LPAREN) {
            System.out.println("ERROR: Expected \"LPAREN\" token in Out.java, got: " + currentToken.toString());
            System.exit(0);
        }

        // after '(' it will be the expr token
        scanner.nextToken();
        expr = new Expr();
        expr.parse(scanner);


        currentToken = scanner.currentToken();
        if (currentToken != Core.RPAREN) {
            System.out.println("ERROR: Expected \"RPAREN\" token in Out.java, got: " + currentToken.toString());
            System.exit(0);
        }

        scanner.nextToken();
        currentToken = scanner.currentToken();
        if (currentToken != Core.SEMICOLON) {
            System.out.println("ERROR: Expected \"SEMICOLON\" token in Out.java, got: " + currentToken.toString());
            System.exit(0);
        }
        scanner.nextToken();

    }

    void semantic() {

    }

    void print() {
        
    }

}
