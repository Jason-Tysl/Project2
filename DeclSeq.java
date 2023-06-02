public class DeclSeq {
    
    Decl decl;
    DeclSeq declSeq;

    void parse(Scanner scanner) {
        Core currentToken = scanner.currentToken();

        decl = new Decl();
        decl.parse(scanner);

        if (currentToken != Core.BEGIN) {
            declSeq = new DeclSeq();
            declSeq.parse(scanner);
        }
        
        scanner.nextToken();
    }

    void semantic() {

    }

    void print() {
        
    }

}
