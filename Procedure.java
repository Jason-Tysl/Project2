public class Procedure {
    
    // Add fields for each child the Procedure node could have
    static DeclSeq declSeq;
    static StmtSeq stmtSeq;
    static String id;


    static void parse(Scanner scanner) {
        Core currentToken = scanner.currentToken();

        if (currentToken != Core.PROCEDURE) {
            System.out.println("ERROR: Expected \"PROCEDURE\" token in Procedure.java, got: " + currentToken.toString());
            System.exit(0);
        }
        scanner.nextToken();
        currentToken = scanner.currentToken();

        if (currentToken != Core.ID) {
            System.out.println("ERROR: Expected \"ID\" token in Procedure.java, got: " + currentToken.toString());
            System.exit(0);
        }

        id = scanner.getId();

        scanner.nextToken();
        currentToken = scanner.currentToken();

        if (currentToken != Core.IS) {
            System.out.println("ERROR: Expected \"IS\" token in Procedure.java, got: " + currentToken.toString());
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

        // scanner should be on Begin now        
        scanner.nextToken();
        currentToken = scanner.currentToken();

        // current token is now first part of stmtSeq

        stmtSeq = new StmtSeq();
        stmtSeq.parse(scanner);
        // stmtSeq.parse() iterates to the next token so we don't need to call it again

        currentToken = scanner.currentToken();

        if (currentToken != Core.END) {
            System.out.println("ERROR: Expected \"END\" token in Procedure.java, got: " + currentToken.toString());
            System.exit(0);
        }

        scanner.nextToken();
        currentToken = scanner.currentToken();

        if (currentToken != Core.EOS) {
            System.out.println("ERROR: Expected \"EOS\" token in Procedure.java, got: " + currentToken.toString());
            System.exit(0);
        }
    }

    static void semantic() {

    }

    static void print() {
        
    }

}
