public class Loop {
    
    // Add fields for each child the Loop node could have
    Cond cond;
    StmtSeq stmtSeq;

    void parse(Scanner scanner) {
        Core currentToken = scanner.currentToken();

        scanner.nextToken();
        cond = new Cond();
        cond.parse(scanner);

        currentToken = scanner.currentToken();
        if (currentToken != Core.DO) {
            System.out.println("ERROR: Expected \"DO\" token in Loop.java, got: " + currentToken.toString());
            System.exit(0);
        }

        scanner.nextToken();
        currentToken = scanner.currentToken();
        stmtSeq = new StmtSeq();
        stmtSeq.parse(scanner);
        
        if (currentToken != Core.END) {
            System.out.println("ERROR: Expected \"END\" token in Loop.java, got: " + currentToken.toString());
            System.exit(0);
        }

    }

    void semantic() {

    }

    void print(int numOfIndentations) {
        
    }

}
