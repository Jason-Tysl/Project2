public class Expr {
    
    // Add fields for each child the Expr node could have
    Term term;
    Expr expr;
    expressionType exprType;

    enum expressionType {
        BASE, ADD, SUBTRACT
    }

    void parse(Scanner scanner) {
        term = new Term();
        term.parse(scanner);

        Core currentToken = scanner.currentToken();
        if (currentToken == Core.ADD) {
            exprType = expressionType.ADD;
        } else if (currentToken == Core.SUBTRACT) {
            exprType = expressionType.SUBTRACT;
        } else {
            exprType = expressionType.BASE;
            return;
        }

        scanner.nextToken();
        expr = new Expr();
        expr.parse(scanner);

    }

    void semantic() {

    }

    void print() {
        
    }

}
