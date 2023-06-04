public class Factor {
    
    // Add fields for each child the Factor node could have
    String id;
    Expr expr;
    int constant;
    factorType fType;

    enum factorType {
        ID, ARRAY, CONST, EXPR, IN
    }

    void parse(Scanner scanner) {
        Core currentToken = scanner.currentToken();

        if (currentToken == Core.ID) {
            id = scanner.getId();
            scanner.nextToken();
            currentToken = scanner.currentToken();

            // just an id, not an array
            if (currentToken != Core.LBRACE) {
                fType = factorType.ID;
                return;
            } else {
                fType = factorType.ARRAY;
                scanner.nextToken();
                expr = new Expr();
                expr.parse(scanner);
                currentToken = scanner.currentToken();
                if (currentToken != Core.RBRACE) {
                    System.out.println("ERROR: Expected \"RBRACE\" token in Factor.java, got: " + currentToken.toString());
                    System.exit(0);
                }

                //give token after RBRACE
                scanner.nextToken();
            }
        } else if (currentToken == Core.CONST) {
            constant = scanner.getConst();
            fType = factorType.CONST;
            scanner.nextToken();
        } else if (currentToken == Core.LPAREN) {
            fType = factorType.EXPR;
            scanner.nextToken();
            expr = new Expr();
            expr.parse(scanner);
            currentToken = scanner.currentToken();
            if (currentToken != Core.RPAREN) {
                System.out.println("ERROR: Expected \"RPAREN\" token in Factor.java, got: " + currentToken.toString());
                System.exit(0);
            }
            scanner.nextToken();
        } else if (currentToken == Core.IN) {
            scanner.nextToken();
            currentToken = scanner.currentToken();
            if (currentToken != Core.LPAREN) {
                System.out.println("ERROR: Expected \"LPAREN\" token in Factor.java, got: " + currentToken.toString());
                System.exit(0);
            }
            scanner.nextToken();
            currentToken = scanner.currentToken();
            if (currentToken != Core.RPAREN) {
                System.out.println("ERROR: Expected \"RPAREN\" token in Factor.java, got: " + currentToken.toString());
                System.exit(0);
            }
            scanner.nextToken();
        }
    }

    void semantic() {

    }

    void print() {
        
    }

}
