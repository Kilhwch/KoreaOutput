
package Dates;

import java.time.LocalDate;


public class Dates {

    public Dates() {
    
    }
    
    public LocalDate increment(String currentDate, int increment) {
        return LocalDate.parse(currentDate).plusDays(increment);
    }
}
