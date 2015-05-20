package Windows_Study_Hide;

import Elements.Element;
import Files.FileUpdater;
import Windows_Study.StudyF;
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
        if (e.getActionCommand().equals(Actions.Easy.name())) {
            System.out.println("Updating due: " + list.get(StudyF.index-1).getQuestion());
            list.get(StudyF.index-1).calculateDue("easy");
            showAnswer();
            swap.swapView("hide");
            
            
        }
        
        else if (e.getActionCommand().equals(Actions.Medium.name())) {
            list.get(StudyF.index).calculateDue("medium");
            showAnswer();
            swap.swapView("hide");
            
        }
        
        else if (e.getActionCommand().equals(Actions.Hard.name())) {
            list.get(StudyF.index).calculateDue("hard");
            showAnswer();
            swap.swapView("hide");
        }
    }
    
    private void showAnswer() {
        question.setText(list.get(StudyF.index).getQuestion());
        answer.setText(list.get(StudyF.index).getAnswer());
        answer.setVisible(true);
        userInput.setVisible(false);
    }
}
