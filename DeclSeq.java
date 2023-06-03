public class DeclSeq {
    
    Decl decl;
    DeclSeq declSeq;

    void parse(Scanner scanner) {
        Core currentToken = scanner.currentToken();

        // Parse the first declaration
        decl = new Decl();
        decl.parse(scanner);

        // update token after parsed through the decl
        currentToken = scanner.currentToken();

        if (currentToken != Core.BEGIN) {
            declSeq = new DeclSeq();
            declSeq.parse(scanner);
        }

    }

    void semantic() {

    }

    void print() {
        decl.print();
        if (declSeq != null) {
            declSeq.print();
        }
    }

}
