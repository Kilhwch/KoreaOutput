
package Elements;

import java.util.Date;


public class Element {

    private final String question;
    private final String answer;
    private Date date;
    
    public Element(String question, String answer, Date date) {
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
    
    
    
}
