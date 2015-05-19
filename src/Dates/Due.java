
package Dates;


public class Due {

    private int currentDue = 0;
    
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
        if (currentDue == 0) currentDue += 6;
        else currentDue *= 6;
        return currentDue;
    }
        
    private long medium() {
        if (currentDue == 0) currentDue += 3;
        else currentDue *= 3;
        return currentDue;
    }

    private long hard() {
        currentDue = 0;
        return currentDue;
    }
}
