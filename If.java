public class If {
    
    // Add fields for each child the If node could have
    Cond cond;
    StmtSeq stmtSeq;

    void parse(Scanner scanner) {
        scanner.nextToken();
        cond = new Cond();
        cond.parse(scanner);

        Core currentToken = scanner.currentToken();
        if (currentToken == Core.THEN) {
            scanner.nextToken();
            stmtSeq = new StmtSeq();
            stmtSeq.parse(scanner);
        }

        currentToken = scanner.currentToken();

        if (currentToken == Core.END) {
            scanner.nextToken();
        } else if (currentToken == Core.ELSE) {
            scanner.nextToken();
            stmtSeq = new StmtSeq();
            stmtSeq.parse(scanner);
        } else {
            System.out.println("ERROR: Expected \"END\" or \"ELSE\" token, got: " + currentToken.toString());
            System.exit(0);
        }

        
    }

    void semantic() {

    }

    void print() {
        
    }

}
