public class Cond {
    
    // Add fields for each child the Cond node could have
    Cmpr cmpr;
    Cond cond;
    conditionType condType;

    enum conditionType {
        BASE, NOT, OR, AND
    }

    void parse(Scanner scanner) {
        Core currentToken = scanner.currentToken();
        
        if (currentToken == Core.NOT) {
            scanner.nextToken();
            currentToken = scanner.currentToken();
            condType = conditionType.NOT;
        } else {
            // parse cmpr first
            cmpr = new Cmpr();
            cmpr.parse(scanner);
            currentToken = scanner.currentToken();
            if (currentToken == Core.OR) {
                scanner.nextToken();
                condType = conditionType.OR;
            } else if (currentToken == Core.AND) {
                scanner.nextToken();
                condType = conditionType.AND;
            } else {
                condType = conditionType.BASE;
            }
        }

        // if it's not the base cond, parse the cond (for not, or, and and)
        if (condType != conditionType.BASE) {
            cond = new Cond();
            cond.parse(scanner);
        }

    }

    void semantic() {

    }

    void print() {
        
    }

}
