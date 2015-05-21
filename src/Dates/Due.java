
package Dates;


public class Due {
    
    public Due() {
    
    }
    
    public long calculate(String difficulty) {
        switch (difficulty) {
            case "easy":
                return easy();
            case "medium":
                return medium();
            case "hard":
                return hard();
        }
        return 0;
    }

    private long easy() {
        return 6;
    }
        
    private long medium() {
        return 3;
    }

    private long hard() {
        return 0;
    }
}
