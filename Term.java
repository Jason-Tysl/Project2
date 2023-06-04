public class Term {
    
    // Add fields for each child the Term node could have
    Factor factor;
    Term term;
    termType trmType;

    enum termType {
        BASE, MULTIPLY, DIVIDE
    }

    void parse(Scanner scanner) {
        factor = new Factor();
        factor.parse(scanner);

        Core currentToken = scanner.currentToken();
        if (currentToken == Core.MULTIPLY) {
            trmType = termType.MULTIPLY;
        } else if (currentToken == Core.DIVIDE) {
            trmType = termType.DIVIDE;
        } else {
            trmType = termType.BASE;
            return;
        }

        scanner.nextToken();
        term = new Term();
        term.parse(scanner);

    }

    void semantic() {

    }

    void print() {
        factor.print();
        if (trmType == termType.MULTIPLY) {
            System.out.print(" * ");
            term.print();
        } else if (trmType == termType.DIVIDE) {
            System.out.print(" / ");
            term.print();
        }
    }

}
