public class DeclRecord {

    // Add fields for each child the DeclRecord node could have
    String id;

    void parse(Scanner scanner) {
        id = scanner.getId();
        Procedure.mapOfIds.put(id, null);
        scanner.nextToken();
        Core currentToken = scanner.currentToken();
        if (currentToken != Core.SEMICOLON) {
            System.out.println("Expected \"SEMICOLON\" token in DeclRecord.java, got: " + currentToken.toString());
            System.exit(0);
        }
        scanner.nextToken();
    }

    void semantic() {

    }

    void print() {
        System.out.println("record " + id + ";");
    }

}