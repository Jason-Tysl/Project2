public class DeclRecord {

    // Add fields for each child the DeclRecord node could have
    String id;

    void parse(Scanner scanner) {
        id = scanner.getId();
        doublyDeclaredCheck();
        Procedure.mapOfIds.put(id, "record");
        scanner.nextToken();
        Core currentToken = scanner.currentToken();
        if (currentToken != Core.SEMICOLON) {
            System.out.println("Expected \"SEMICOLON\" token in DeclRecord.java, got: " + currentToken.toString());
            System.exit(0);
        }
        scanner.nextToken();
    }

    private void doublyDeclaredCheck() {
        if (Procedure.mapOfIds.containsKey(id)) {
            System.out.println("SEMANTIC ERROR: id doubly declared. id: " + id);
            System.exit(0);
        }
    }

    void semantic() {

    }

    void print(int numOfIndentations) {
        for (int i = 0; i < numOfIndentations; i++) {
            System.out.print("\t");
        }
        System.out.println("record " + id + ";");
    }

}