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
            list.get(StudyF.index).calculateDue("easy");
            if (hasNext()) swap.swapView("hide");
        }
        
        else if (e.getActionCommand().equals(Actions.Medium.name())) {
            list.get(StudyF.index).calculateDue("medium");
            if (hasNext()) swap.swapView("hide");
        }
        
        else {
            list.get(StudyF.index).calculateDue("hard");
            if (hasNext()) swap.swapView("hide");
            
        }
        showQuestion();
    }
    
    private boolean hasNext() {
        return StudyF.index < list.size();
    }
    
    private void showQuestion() {
        if (hasNext()) {
            if (list.get(StudyF.index).isReviewable()) {
                question.setText(list.get(StudyF.index).getQuestion());
                answer.setText(list.get(StudyF.index).getAnswer());
                userInput.setVisible(false);
            } else {
                showQuestion();
            }
                
        } else {
            FileUpdater file = new FileUpdater(StudyF.fName);
            file.update(StudyF.list);
            System.exit(0);
        }
    }
}
