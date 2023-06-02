public class Procedure {
    
    // Add fields for each child the Procedure node could have
    static DeclSeq declSeq;
    static StmtSeq stmtSeq;
    static String id;


    static void parse(Scanner scanner) {
        Core currentToken = scanner.currentToken();

        if (currentToken != Core.PROCEDURE) {
            System.out.println("Expected \"Procedure\" token, got: " + currentToken.toString());
            return;
        }
        scanner.nextToken();
        currentToken = scanner.currentToken();

        if (currentToken != Core.ID) {
            System.out.println("Expected \"ID\" token, got: " + currentToken.toString());
            return;
        }

        id = scanner.getId();

        scanner.nextToken();
        currentToken = scanner.currentToken();

        if (currentToken != Core.IS) {
            System.out.println("Expected \"IS\" token, got: " + currentToken.toString());
            return;
        }

        scanner.nextToken();
        currentToken = scanner.currentToken();

        if (currentToken != Core.BEGIN) {
            // Assume it's a decl-seq
            // declSeq.parse() iterates to the next token so we don't need to call it again
            declSeq.parse(scanner);
        }

        currentToken = scanner.currentToken();
        
        // stmtSeq.parse() iterates to the next token so we don't need to call it again
        stmtSeq.parse(scanner);

        currentToken = scanner.currentToken();

        if (currentToken != Core.END) {
            System.out.println("Expected \"END\" token, got: " + currentToken.toString());
            return;
        }

        scanner.nextToken();
        currentToken = scanner.currentToken();

        if (currentToken != Core.EOS) {
            System.out.println("Expected \"EOS\" token, got: " + currentToken.toString());
            return;
        }
    }

    static void semantic() {

    }

    static void print() {
        
    }

}
