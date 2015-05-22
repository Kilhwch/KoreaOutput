package Windows_Study_Hide;

import Constants.C;
import SaveAndClose.SaveAndClose;
import Windows_Study.Study;
import Windows_Study.UISwapInterface;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class HideListener extends AbstractAction {

    public UISwapInterface swap;
    private JButton easy, medium, hard;
    private JLabel question, answer;
    private JTextField userInput;
    private JMenuItem delete;
    
    public HideListener(JButton easy, JButton medium, JButton hard, JLabel question, JLabel answer, 
            JTextField userInput, UISwapInterface swap, JMenuItem delete) {
        this.easy = easy;
        this.medium = medium;
        this.hard = hard;
        this.question = question;
        this.answer = answer;
        this.userInput = userInput;
        this.swap = swap;
        this.delete = delete;
    }
    
    private enum Actions {
        Easy, Medium, Hard, Delete
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ++Study.reviewed;
        if (e.getActionCommand().equals(Actions.Easy.name())) {
            Study.list.get(Study.index).calculateDue("easy");
            if (!lastItem()) {
                Study.index++;
                setNextItem(Study.index+1);
                swap.swapView(C.HIDE);
                
            } else new SaveAndClose().execute();
        }
        
        else if (e.getActionCommand().equals(Actions.Medium.name())) {
            Study.list.get(Study.index).calculateDue("medium");
            if (!lastItem()) {
                Study.index++;
                setNextItem(Study.index+1);
                swap.swapView(C.HIDE);

            } else new SaveAndClose().execute();
        }
        
        else if (e.getActionCommand().equals(Actions.Hard.name())) {
            Study.list.get(Study.index).calculateDue("hard");
            if (!lastItem()) {
                Study.index++;
                setNextItem(Study.index+1);
                swap.swapView(C.HIDE);
            } else new SaveAndClose().execute();
        }
        
        else if (e.getActionCommand().equals(Actions.Delete.name())) {
            System.out.println("delete @ hide");
            Study.list.remove(Study.index);
            setNextItem(Study.index);
            swap.swapView(C.HIDE);
        }
        
        else { 
            new SaveAndClose().execute();
        }
    }
    
    public void setNextItem(Integer index) {
        question.setText(Study.list.get(Study.index).getQuestion());
        answer.setText(Study.list.get(Study.index).getAnswer());
        answer.setVisible(true);
        userInput.setVisible(false);
    }
    
    private boolean lastItem() {
        if ((Study.list.size()-1) == Study.index) {
            return true;
        } else return false;
    }
}
