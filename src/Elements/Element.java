
package Elements;

import java.time.LocalDate;


public class Element {

    public final String question;
    public final String answer;
    public LocalDate date;
    
    public Element(String question, String answer, LocalDate date) {
        this.question = question;
        this.answer = answer;
        this.date = date;
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

    @Override
    public String toString() {
        return question+":"+answer+":"+date;
    }
}
