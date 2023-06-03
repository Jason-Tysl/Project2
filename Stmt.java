public class Stmt {
    
    Assign assign;
    If ifClass;
    Loop loop;
    Out out;
    Decl decl;
    enum statementType {
        ASSIGN, IF, WHILE, OUT, DECL
    }
    statementType stmtType;

    void parse(Scanner scanner) {
        Core currentToken = scanner.currentToken();
        statementType stmtType;

        // if token is ID, it's assign
        if (currentToken == Core.ID) {
            stmtType = statementType.ASSIGN;
            assign = new Assign();
            assign.parse(scanner);
        } else if (currentToken == Core.IF) {
            stmtType = statementType.IF;
            ifClass = new If();
            ifClass.parse(scanner);
        } else if (currentToken == Core.WHILE) {
            stmtType = statementType.WHILE;
            loop = new Loop();
            loop.parse(scanner);
        } else if (currentToken == Core.OUT) {
            stmtType = statementType.OUT;
            out = new Out();
            out.parse(scanner);
        } else if (currentToken == Core.INTEGER || currentToken == Core.RECORD) {
            stmtType = statementType.DECL;
            decl = new Decl();
            decl.parse(scanner);
        } else {
            System.out.println("ERROR: Expected Stmt child token in Stmt.java, got: " + currentToken.toString());
            System.exit(0);
        }
    }

    void semantic() {

    }

    void print(int numOfIndentations) {

        if (assign != null) {
            assign.print(numOfIndentations);
        } else if (ifClass != null) {
            ifClass.print(numOfIndentations);
        } else if (loop != null) {
            loop.print(numOfIndentations);
        } else if (out != null) {
            out.print(numOfIndentations);
        } else if (decl != null) {
            decl.print(numOfIndentations);
        }

    }

}
