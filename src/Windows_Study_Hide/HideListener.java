package Windows_Study_Hide;

import Constants.C;
import Items.Element;
import Windows_Study.Study;
import Windows_Study.UISwapInterface;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class HideListener extends AbstractAction {

    public UISwapInterface swap;
    private ArrayList<Element> list;
    private JButton easy, medium, hard;
    private JLabel question, answer;
    private JTextField userInput;
    
    public HideListener(JButton easy, JButton medium, JButton hard, JLabel question, JLabel answer, 
            JTextField userInput, UISwapInterface swap, ArrayList<Element> list) {
        this.easy = easy;
        this.medium = medium;
        this.hard = hard;
        this.question = question;
        this.answer = answer;
        this.userInput = userInput;
        this.swap = swap;
        this.list = list;
    }
    
    private enum Actions {
        Easy, Medium, Hard
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ++Study.reviewed;
        if (e.getActionCommand().equals(Actions.Easy.name())) {
            list.get(Study.index-1).calculateDue("easy");
            setFields();
            swap.swapView(C.HIDE);
        }
        
        else if (e.getActionCommand().equals(Actions.Medium.name())) {
            list.get(Study.index-1).calculateDue("medium");
            setFields();
            swap.swapView(C.HIDE);
        }
        
        else if (e.getActionCommand().equals(Actions.Hard.name())) {
            list.get(Study.index-1).calculateDue("hard");
            setFields();
            swap.swapView(C.HIDE);
        }
    }
    
    private void setFields() {
        question.setText(list.get(Study.index).getQuestion());
        answer.setText(list.get(Study.index).getAnswer());
        answer.setVisible(true);
        userInput.setVisible(false);
    }
}
