public class StmtSeq {
    
    Stmt stmt;
    StmtSeq stmtSeq;

    void parse(Scanner scanner) {
        Core currentToken = scanner.currentToken();

        // Parse the first statement
        stmt = new Stmt();
        stmt.parse(scanner);
        
        // update token after parsed through the stmt
        currentToken = scanner.currentToken();

        // check to see if there's another sequence
        if (currentToken != Core.END && currentToken != Core.THEN 
                && currentToken != Core.ELSE) {
            stmtSeq = new StmtSeq();
            stmtSeq.parse(scanner);
        }

    }

    void semantic() {

    }

    void print() {
        stmt.print();
        if (stmtSeq != null) {
            stmtSeq.print();
        }
    }

}
