package ActionListeners;
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
    
    public JButton check, easy, medium, hard;
    public JTextField userInput;
    public JLabel question, answer;
    public ArrayList<Element> list;
    public int index = 0;
    public int guessCounter = 3;
    public String fName;
    
    private FileParser file;
    
    public StudyListener(String msg, Integer mnemonic) {
        super(msg);
        putValue(MNEMONIC_KEY, mnemonic);
    }

    public StudyListener(JButton check, JButton easy, JButton medium, JButton hard, JLabel question, 
            JLabel answer, ArrayList<Element> list) {
        
        this.check = check; this.easy = easy; this.medium = medium; this.hard = hard;
        this.question = question; this.list = list;
        
        if (list.isEmpty()) {
            loadEmpty();
        }
        
        // first question
        else {
            question.setText(list.get(index).getQuestion());
            answer.setText(list.get(index).getAnswer());
            answer.setVisible(false);
//            easy.setVisible(false);
//            medium.setVisible(false);
//            hard.setVisible(false);
        }
    }
    
    public enum Actions {
        Exit,
        Check,
        Hard, Medium, Easy,
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
        
        
        else if (e.getActionCommand().equals(Actions.Hard.name())) {
            long days = list.get(index).calculateDue("Hard");
            updateDate(days);
            nullCheck();
            initNext();
        }
        
        else if (e.getActionCommand().equals(Actions.Medium.name())) {
            long days = list.get(index).calculateDue("Medium");
            updateDate(days);
            nullCheck();
            initNext();
        }
                
        else if (e.getActionCommand().equals(Actions.Easy.name())) {
            long days = list.get(index).calculateDue("Easy");
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
        easy.setVisible(false);
        medium.setVisible(false);
        hard.setVisible(false);
        check.setVisible(true);
        answer.setVisible(false);
    }
    
    public void loadNext() {
        question.setText(list.get(index).getQuestion());
        answer.setText(list.get(index).getAnswer());
        
        answer.setVisible(false);
        easy.setVisible(false);
        medium.setVisible(false);
        hard.setVisible(false);
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
            easy.setVisible(false);
            medium.setVisible(false);
            hard.setVisible(false);
            check.setVisible(true);
            guessCounter = 3;
            showAnswer();
        }
    }
    
    public void showAnswer() {
        answer.setText(list.get(index).getAnswer());
        answer.setVisible(true);
        check.setVisible(false);
        easy.setVisible(true);
        medium.setVisible(true);
        hard.setVisible(true);
    }
    
    public void updateDate(long days) {
        LocalDate newDate = LocalDate.parse(list.get(index).getDate().toString()).plusDays(days);
        list.get(index).setDate(newDate);
    }
}