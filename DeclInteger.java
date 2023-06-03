public class DeclInteger {
    
    // Add fields for each child the DeclInteger node could have
    Id id;
    int idInt;

    void parse(Scanner scanner) {
        ParseTree.mapOfIds.put(scanner.getId(), null);
        scanner.nextToken();
        Core currentToken = scanner.currentToken();
        if (currentToken != Core.SEMICOLON) {
            System.out.println("Expected \"SEMICOLON\" token in DeclInteger.java, got: " + currentToken.toString());
            System.exit(0);
        }
        scanner.nextToken();
    }

    void semantic() {

    }

    void print() {
        
    }

}
