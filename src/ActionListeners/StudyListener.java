package ActionListeners;
import Elements.Element;
import Files.FileParser;
import Main.StudyFrame;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StudyListener extends AbstractAction {
    
    private JButton check, easy, medium, hard;
    private JTextField userInput;
    private JLabel question, answer;
    private ArrayList<Element> list;
    private int index = 0;
    private String fName;
    
    private FileParser file;

    public StudyListener() {
        
    }
    
    
    public StudyListener(String msg, Integer mnemonic) {
        super(msg);
        putValue(MNEMONIC_KEY, mnemonic);
    }
    
    public StudyListener(JButton check, JLabel question, 
            JLabel answer, JTextField userInput, ArrayList<Element> list) {
            this.check = check; this.question = question; this.answer = answer; 
            this.userInput = userInput; this.list = list;
            init();
    }
    
    public StudyListener(JButton easy, JButton medium, JButton hard, 
            JLabel question, JLabel answer, JTextField userInput, ArrayList<Element> list) {
            
            this.easy = easy; this.medium = medium; this.hard = hard; 
            this.question = question; this.answer = answer; this.userInput = userInput; this.list = list;
            
            init();
    }
    
    private void init() {
        System.out.println(question.isVisible());
    }
   
    
    public enum Actions {
        Exit,
        Check,
        Easy, Medium, Hard,
        Add,
        Delete
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(Actions.Check.name())) {
            show();
        }
        
        else if (e.getActionCommand().equals(Actions.Hard.name())) {
//            long days = list.get(index).calculateDue("Hard");
//            updateDate(days);
            nullCheck();
            hide();
//            study = new StudyFrame();
//            study.windowInit("StudyFrameHide");
        }
        
        else if (e.getActionCommand().equals(Actions.Medium.name())) {
//            long days = list.get(index).calculateDue("Medium");
//            updateDate(days);
            nullCheck();
            hide();
//            study = new StudyFrame();
//            study.windowInit("StudyFrameHide");
        }
                
        else if (e.getActionCommand().equals(Actions.Easy.name())) {
//            long days = list.get(index).calculateDue("Easy");
//            updateDate(days);
            nullCheck();
            hide();
//            study = new StudyFrame();
//            study.windowInit("StudyFrameHide");
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
            }
            
            // removing the last and jump to the beginning
            else if (list.size() > 1) {
                remove();
                index = 0;
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
    
    public void show() {
        question.setText(list.get(index).getQuestion());
        answer.setText(list.get(index).getAnswer());
        
        userInput.setVisible(false);
        question.setVisible(true);
        answer.setVisible(true);
        easy.setVisible(true);
        medium.setVisible(true);
        hard.setVisible(true);
    }
    
    public void hide() {
        question.setText(list.get(index).getQuestion());
        answer.setText(list.get(index).getAnswer());
        userInput.setVisible(true);
        answer.setVisible(false);
        
        check.setVisible(true);
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
    
    public void updateDate(long days) {
        LocalDate newDate = LocalDate.parse(list.get(index).getDate().toString()).plusDays(days);
        list.get(index).setDate(newDate);
    }
}