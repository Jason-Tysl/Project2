public class Assign {
    
    // Add fields for each child the Assign node could have
    Id id;
    Index index;
    Expr expr;
    Id leftId;
    Id rightId;

    void parse(Scanner scanner) {
        Core currentToken = scanner.currentToken();
        
        ParseTree.mapOfIds.get("");
    }

    void semantic() {

    }

    void print() {
        
    }

}
