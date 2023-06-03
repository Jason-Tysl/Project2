public class Assign {
    
    // Add fields for each child the Assign node could have
    String id;
    Index index;
    Expr expr;
    Id leftId;
    String rightId;

    void parse(Scanner scanner) {
        Core currentToken = scanner.currentToken();
        id = scanner.getId();
        scanner.nextToken();
        currentToken = scanner.currentToken();

        // current token will either be LBRACE for <index> or ASSIGN
        if (currentToken == Core.LBRACE) {
            index = new Index();
            index.parse(scanner);
            currentToken = scanner.currentToken();
        }

        if (currentToken == Core.ASSIGN) {
            // currentToken == ASSIGN
            scanner.nextToken();
            currentToken = scanner.currentToken();
            
        } else {
            System.out.println("ERROR: Expected \"ASSIGN\" token in Assign.java, got: " + currentToken.toString());
            System.exit(0);
        }


        // token after ASSIGN: <expr>, new, or record
        if (currentToken == Core.NEW) {
            scanner.nextToken(); // token will be RECORD
            scanner.nextToken(); // token will be LBRACE
            currentToken = scanner.currentToken();
            if (currentToken != Core.LBRACE) {
                System.out.println("ERROR: Expected \"LBRACE\" token in Assign.java, got: " + currentToken.toString());
                System.exit(0);
            }
            scanner.nextToken(); // token will be <expr>
            expr = new Expr();
            expr.parse(scanner);

            currentToken = scanner.currentToken();
            if (currentToken != Core.RBRACE) {
                System.out.println("ERROR: Expected \"RBRACE\" token in Assign.java, got: " + currentToken.toString());
                System.exit(0);
            }

            scanner.nextToken(); 

        } else if (currentToken == Core.RECORD) {
            scanner.nextToken(); 
            currentToken = scanner.currentToken(); // token is id
            rightId = scanner.getId();
            int rightValue = ParseTree.mapOfIds.get(rightId);
            ParseTree.mapOfIds.put(id, rightValue);
            scanner.nextToken(); 
        } else {
            // <expr>
            expr = new Expr();
            expr.parse(scanner);

        }

        currentToken = scanner.currentToken(); //token is semicolon
        if (currentToken != Core.SEMICOLON) {
            System.out.println("ERROR: Expected \"SEMICOLON\" token in Assign.java, got: " + currentToken.toString());
            System.exit(0);
        }

        // Don't know if we have to handle setting id to something else
        // here or if the parsing took care of it?
    }

    void semantic() {

    }

    void print() {
        
    }

}
