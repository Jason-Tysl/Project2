public class Decl {
    
    DeclInteger declInteger;
    DeclRecord declRecord;

    void parse(Scanner scanner) {
        Core currentToken = scanner.currentToken();

        if (currentToken == Core.INTEGER) {
            declInteger = new DeclInteger();
            scanner.nextToken();
            declInteger.parse(scanner);
        } else if (currentToken == Core.RECORD) {
            // currentToken == Core.RECORD
            declRecord = new DeclRecord();
            scanner.nextToken();
            declRecord.parse(scanner);
        } else {
            System.out.println("ERROR: Expected Decl child token, got: " + currentToken.toString());
            System.exit(0);
        }
    }

    void semantic() {

    }

    void print() {
        
    }

}
