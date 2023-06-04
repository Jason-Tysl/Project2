public class Factor {
    
    // Add fields for each child the Factor node could have
    String id;
    Expr expr;
    int constant;
    factorType fType;

    enum factorType {
        ID, ARRAY, CONST, EXPR, IN
    }

    void parse(Scanner scanner) {
        Core currentToken = scanner.currentToken();

        if (currentToken == Core.ID) {
            id = scanner.getId();
            scanner.nextToken();
            currentToken = scanner.currentToken();

            // just an id, not an array
            if (currentToken != Core.LBRACE) {
                fType = factorType.ID;
                return;
            } else {
                fType = factorType.ARRAY;
                checkIDRecord();
                scanner.nextToken();
                expr = new Expr();
                expr.parse(scanner);
                currentToken = scanner.currentToken();
                if (currentToken != Core.RBRACE) {
                    System.out.println("ERROR: Expected \"RBRACE\" token in Factor.java, got: " + currentToken.toString());
                    System.exit(0);
                }

                //give token after RBRACE
                scanner.nextToken();
            }
        } else if (currentToken == Core.CONST) {
            constant = scanner.getConst();
            fType = factorType.CONST;
            scanner.nextToken();
        } else if (currentToken == Core.LPAREN) {
            fType = factorType.EXPR;
            scanner.nextToken();
            expr = new Expr();
            expr.parse(scanner);
            currentToken = scanner.currentToken();
            if (currentToken != Core.RPAREN) {
                System.out.println("ERROR: Expected \"RPAREN\" token in Factor.java, got: " + currentToken.toString());
                System.exit(0);
            }
            scanner.nextToken();
        } else if (currentToken == Core.IN) {
            fType = factorType.IN;
            scanner.nextToken();
            currentToken = scanner.currentToken();
            if (currentToken != Core.LPAREN) {
                System.out.println("ERROR: Expected \"LPAREN\" token in Factor.java, got: " + currentToken.toString());
                System.exit(0);
            }
            scanner.nextToken();
            currentToken = scanner.currentToken();
            if (currentToken != Core.RPAREN) {
                System.out.println("ERROR: Expected \"RPAREN\" token in Factor.java, got: " + currentToken.toString());
                System.exit(0);
            }
            scanner.nextToken();
        }
    }

    private void checkIDRecord() {
        String intOrRec = Procedure.mapOfIds.get(id);
        if (!intOrRec.equals("record")) {
            System.out.println("SEMANTIC ERROR: id declared as integer, not record. id: " + id);
            System.exit(0);
        }
    }

    void semantic() {

    }

    void print() {
        if (fType == factorType.ID) {
            System.out.print(id);
        } else if (fType == factorType.ARRAY) {
            System.out.print(id + "[");
            expr.print();
            System.out.print("]");
        } else if (fType == factorType.CONST) {
            System.out.print(String.valueOf(constant));
        } else if (fType == factorType.EXPR) {
            System.out.print("(");
            expr.print();
            System.out.print(")");
        } else if (fType == factorType.IN) {
            System.out.print("in()");
        }
    }

}
