
package Elements;

import Dates.Due;
import java.time.LocalDate;


public class Element {

    private final String question, answer;
    private LocalDate date;
    private final Due due;
    private boolean reviewable;
    
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
    
    public boolean isReviewable() {
        return reviewable;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setReviewable(boolean reviewable) {
        this.reviewable = reviewable;
    }
    
    public void calculateDue(String difficulty) {
        setDate(date.plusDays(due.calculate(difficulty)));
    }

    @Override
    public String toString() {
        return question+":"+answer+":"+date;
    }
}
