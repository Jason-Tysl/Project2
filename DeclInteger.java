public class DeclInteger {
    
    // Add fields for each child the DeclInteger node could have
    String id;
    int idInt;

    void parse(Scanner scanner) {
        id = scanner.getId();
        Procedure.mapOfIds.put(id, null);
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

    void print(int numOfIndentations) {
        for (int i = 0; i < numOfIndentations; i++) {
            System.out.print("\t");
        }
        System.out.println("integer " + id + ";");
    }

}
