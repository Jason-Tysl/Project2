public class Decl {
    
    DeclInteger declInteger;
    DeclRecord declRecord;

    void parse(Scanner scanner) {
        Core currentToken = scanner.currentToken();

        if (currentToken == Core.INTEGER) {
            declInteger = new DeclInteger();
            scanner.nextToken();
            declInteger.parse(scanner);
        } else {
            // currentToken == Core.RECORD
            declRecord = new DeclRecord();
            scanner.nextToken();
            declRecord.parse(scanner);
        }
    }

    void semantic() {

    }

    void print() {
        
    }

}
