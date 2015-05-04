package ActionListeners;
import Dates.Dates;
import Elements.Element;
import Files.FileParser;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StudyListener extends AbstractAction {
    
    public JButton check;
    public JButton next;
    public JTextField userInput;
    public JLabel question;
    public JLabel answer;
    public ArrayList<Element> list;
    public int index;
    public int guessCounter = 3;
    public String fName;
    
    private FileParser file;
    
    
    public StudyListener() {
    }
    
    public StudyListener(String msg, Integer mnemonic) {
        super(msg);
        putValue(MNEMONIC_KEY, mnemonic);
    }

    public StudyListener(JButton check, JButton next, JLabel question, JLabel answer, 
            JTextField userInput, ArrayList<Element> list, int index, String fName) {
        this.check = check;
        this.next = next;
        this.question = question;
        this.answer = answer;
        this.userInput = userInput;
        this.list = list;
        this.index = index;
        this.fName = fName;
        if (list.isEmpty()) {
            loadEmpty();
        }
        
        // first question
        else {
            question.setText(list.get(index).getQuestion());
            answer.setText(list.get(index).getAnswer());
            answer.setVisible(false);
        }
        
        
    }
    
    public enum Actions {
        Exit,
        Check,
        Next,
        Add,
        Delete
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getActionCommand().equals(Actions.Check.name())) {
            if (!userInput.getText().equals(answer.getText())) {
                --guessCounter;
            }
            else if (userInput.getText().equals(answer.getText())) {
                showAnswer();
                userInput.setVisible(false);
            }
            checkCounter();
        }
        
        
        else if (e.getActionCommand().equals(Actions.Next.name())) {
            long days = 40;
            updateDate(days);
            nullCheck();
            initNext();
            
        }
        
        else if (e.getActionCommand().equals(Actions.Exit.name())) {
            file = new FileParser(fName, list);
            file.updateFile();
            System.exit(0);
        }
        
        else if (e.getActionCommand().equals(Actions.Add.name())) {
            System.out.println("ADD");
        }
        
        else if (e.getActionCommand().equals(Actions.Delete.name())) {
            if (list.size() <= 0) return; // empty file
            
            // removing the first or middle index
            if (hasIndex(index)) {
                remove();
                loadNext();
            }
            
            // removing the last and jump to the beginning
            else if (list.size() > 1) {
                remove();
                index = 0;
                loadNext();
            }
            else {
                remove();
                loadEmpty();
            }
        }
    }
    
    // assist methods
    
    private void remove() {
        list.remove(index);
    }
    
    private void initNext() {
        userInput.setVisible(true);
        userInput.setEnabled(true);
        question.setText(list.get(index).getQuestion());
        answer.setText(list.get(index).getAnswer());
        userInput.setText("");
        next.setVisible(false);
        check.setVisible(true);
        answer.setVisible(false);
    }
    
    public void loadNext() {
        question.setText(list.get(index).getQuestion());
        answer.setText(list.get(index).getAnswer());
        
        answer.setVisible(false);
        next.setVisible(false);
    }
    
    public void loadEmpty() {
        question.setVisible(false);
        check.setEnabled(false);
        userInput.setVisible(false);
    }
    
    public boolean hasIndex(int index) {
        return index < list.size()-1;
    }
    
    public void nullCheck() {
        if (hasIndex(index)) {
            ++index;
        }
        else {
            index = 0;
        }
    }
    
    public void checkCounter() {
        userInput.setText("");
        if (guessCounter <= 0) {
            userInput.setVisible(false);
            next.setVisible(false);
            check.setVisible(true);
            guessCounter = 3;
            showAnswer();
        }
    }
    
    public void showAnswer() {
        answer.setText(list.get(index).getAnswer());
        answer.setVisible(true);
        check.setVisible(false);
        next.setVisible(true);
    }
    
    public void updateDate(long days) {
        LocalDate newDate = LocalDate.parse(list.get(index).getDate().toString()).plusDays(days);
        list.get(index).setDate(newDate);
    }
}