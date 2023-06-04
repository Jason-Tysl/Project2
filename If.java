public class If {
    
    // Add fields for each child the If node could have
    Cond cond;
    StmtSeq stmtSeq;
    StmtSeq secondStmtSeq;

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

        if (currentToken == Core.ELSE) {
            scanner.nextToken();
            secondStmtSeq = new StmtSeq();
            secondStmtSeq.parse(scanner);
        }

        currentToken = scanner.currentToken();

        if (currentToken != Core.END) {
            System.out.println("ERROR: Expected \"END\" token in If.java, got: " + currentToken.toString());
            System.exit(0);
        }

        scanner.nextToken();
        
    }

    void semantic() {

    }

    void print(int numOfIndentations) {
        for (int i = 0; i < numOfIndentations; i++) {
            System.out.print("\t");
        }
        System.out.print("if ");
        cond.print();
        System.out.println(" then");
        stmtSeq.print(numOfIndentations + 1);
        if (secondStmtSeq != null) {
            for (int i = 0; i < numOfIndentations; i++) {
                System.out.print("\t");
            }
            System.out.println("else");
            secondStmtSeq.print(numOfIndentations + 1);
        }
        for (int i = 0; i < numOfIndentations; i++) {
            System.out.print("\t");
        }
        System.out.println("end");
    }

}
