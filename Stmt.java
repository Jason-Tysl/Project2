public class Stmt {
    
    Assign assign;
    If ifClass;
    Loop loop;
    Out out;
    Decl decl;

    void parse(Scanner scanner) {
        Core currentToken = scanner.currentToken();

        // if token is ID, it's assign
        if (currentToken == Core.ID) {
            assign = new Assign();
            assign.parse(scanner);
        } else if (currentToken == Core.IF) {
            ifClass = new If();
            ifClass.parse(scanner);
        } else if (currentToken == Core.WHILE) {
            loop = new Loop();
            loop.parse(scanner);
        } else if (currentToken == Core.OUT) {
            out = new Out();
            out.parse(scanner);
        } else if (currentToken == Core.INTEGER || currentToken == Core.RECORD) {
            decl = new Decl();
            decl.parse(scanner);
        } else {
            System.out.println("ERROR: Expected Stmt child token, got: " + currentToken.toString());
            System.exit(0);
        }
    }

    void semantic() {

    }

    void print() {
        
    }

}
