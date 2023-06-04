public class Assign {
    
    // Add fields for each child the Assign node could have
    String id;
    Index index;
    Expr expr;
    String rightId;
    assignmentType assignType;

    enum assignmentType {
        BASE, NEW, RECORD
    }

    void parse(Scanner scanner) {
        Core currentToken = scanner.currentToken();
        id = scanner.getId();
        checkIdDeclared();
        scanner.nextToken();
        currentToken = scanner.currentToken();
        
        // current token will either be LBRACE for <index> or ASSIGN
        if (currentToken == Core.LBRACE) {
            checkIDRecord();
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
            assignType = assignmentType.NEW;
            checkIDRecord();
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
            assignType = assignmentType.RECORD;
            checkIDRecord();
            scanner.nextToken(); 
            currentToken = scanner.currentToken(); // token is id
            rightId = scanner.getId();
            // int rightValue = Procedure.mapOfIds.get(rightId);
            // Procedure.mapOfIds.put(id, rightValue);
            scanner.nextToken(); 
        } else {
            // <expr>
            assignType = assignmentType.BASE;
            expr = new Expr();
            expr.parse(scanner);

        }

        currentToken = scanner.currentToken(); //token is semicolon
        if (currentToken != Core.SEMICOLON) {
            System.out.println("ERROR: Expected \"SEMICOLON\" token in Assign.java, got: " + currentToken.toString());
            System.exit(0);
        }

        // give them token after semicolon
        scanner.nextToken();


        // Don't know if we have to handle setting id to something else
        // here or if the parsing took care of it?
    }

    private void checkIDRecord() {
        String intOrRec = Procedure.mapOfIds.get(id);
        if (!intOrRec.equals("record")) {
            System.out.println("SEMANTIC ERROR: id declared as integer, not record. id: " + id);
            System.exit(0);
        }
    }

    private void checkIdDeclared() {
        if (!Procedure.mapOfIds.containsKey(id)) {
            System.out.println("SEMANTIC ERROR: id not declared. id: " + id);
            System.exit(0);
        }
    }

    void semantic() {

    }

    void print(int numOfIndentations) {
        for (int i = 0; i < numOfIndentations; i++) {
            System.out.print("\t");
        }
        System.out.print(id);

        if (assignType == assignmentType.BASE) {
            if (index != null) {
                index.print();
            }
            System.out.print(" := ");
            expr.print();
            System.out.println(";");
        } else if (assignType == assignmentType.NEW) {
            System.out.print(" := new record [");
            expr.print();
            System.out.println(" ];");
        } else if (assignType == assignmentType.RECORD) {
            System.out.println(":= record " + rightId + ";");
        }

    }

}
