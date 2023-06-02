public class Procedure {
    
    // Add fields for each child the Procedure node could have
    static DeclSeq declSeq;
    static StmtSeq stmtSeq;
    static String id;


    static void parse(Scanner scanner) {
        Core currentToken = scanner.currentToken();

        if (currentToken != Core.PROCEDURE) {
            System.out.println("Error: Expected \"PROCEDURE\" token, got: " + currentToken.toString());
            System.exit(0);
        }
        scanner.nextToken();
        currentToken = scanner.currentToken();

        if (currentToken != Core.ID) {
            System.out.println("Error: Expected \"ID\" token, got: " + currentToken.toString());
            System.exit(0);
        }

        id = scanner.getId();

        scanner.nextToken();
        currentToken = scanner.currentToken();

        if (currentToken != Core.IS) {
            System.out.println("Error: Expected \"IS\" token, got: " + currentToken.toString());
            System.exit(0);
        }

        scanner.nextToken();
        currentToken = scanner.currentToken();

        if (currentToken != Core.BEGIN) {
            // Assume it's a decl-seq
            declSeq = new DeclSeq();
            // declSeq.parse() iterates to the next token so we don't need to call it again
            declSeq.parse(scanner);
        }

        // next token goes towards stmt-seq
        scanner.nextToken();
        currentToken = scanner.currentToken();

        stmtSeq = new StmtSeq();
        stmtSeq.parse(scanner);
        // stmtSeq.parse() iterates to the next token so we don't need to call it again

        currentToken = scanner.currentToken();

        if (currentToken != Core.END) {
            System.out.println("Expected \"END\" token, got: " + currentToken.toString());
            System.exit(0);
        }

        scanner.nextToken();
        currentToken = scanner.currentToken();

        if (currentToken != Core.EOS) {
            System.out.println("Expected \"EOS\" token, got: " + currentToken.toString());
            System.exit(0);
        }
    }

    static void semantic() {

    }

    static void print() {
        
    }

}
