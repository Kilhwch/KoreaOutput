
package Errors;

import java.util.ArrayList;

public class ItemSyntax {

    private ArrayList<String> errors;
    
    public ItemSyntax() {
        errors = new ArrayList<>();
    }

    public void addError(String error, int lineNr) {
        errors.add("Line number["+lineNr+"]: " + error);
    }
    
    public Boolean noErrors() {
        return errors.isEmpty();
    }
}
