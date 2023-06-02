public class DeclRecord {

    // Add fields for each child the DeclRecord node could have
    Id id;
    Record record;

    void parse(Scanner scanner) {
        ParseTree.mapOfIds.put(scanner.getId(), null);
        scanner.nextToken();
        Core currentToken = scanner.currentToken();
        if (currentToken != Core.SEMICOLON) {
            System.out.println("Expected \"SEMICOLON\" token, got: " + currentToken.toString());
            System.exit(0);
        }
        scanner.nextToken();
    }

    void semantic() {

    }

    void print() {
        
    }

}