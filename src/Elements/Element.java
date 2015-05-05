
package Elements;

import Dates.Due;
import java.time.LocalDate;


public class Element {

    private final String question, answer;
    private LocalDate date;
    private final Due due;
    
    public Element(String question, String answer, LocalDate date) {
        this.question = question;
        this.answer = answer;
        this.date = date;
        due = new Due();
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public long calculateDue(String difficulty) {
        return due.calculate(difficulty);
    }

    @Override
    public String toString() {
        return question+":"+answer+":"+date;
    }
}
