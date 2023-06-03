public class Cmpr {

    // Add fields for each child the Cmpr node could have
    Expr exprLeft;
    Expr exprRight;
    compareType cmprType;

    enum compareType {
        EQUALS, LESSTHAN
    }

    void parse(Scanner scanner) {

        exprLeft = new Expr();
        exprLeft.parse(scanner);

        Core currentToken = scanner.currentToken();
        if (currentToken == Core.EQUAL) {
            cmprType = compareType.EQUALS;
        } else if (currentToken == Core.LESS) {
            cmprType = compareType.LESSTHAN;
        } else {
            System.out.println("ERROR: Expected \"EQUAL\" or \"LESS\" token in Cmpr.java, got: " + currentToken.toString());
            System.exit(0);
        }
        
        scanner.nextToken();
        exprRight = new Expr();
        exprRight.parse(scanner);

    }

    void semantic() {

    }

    void print() {
        
    }

}
