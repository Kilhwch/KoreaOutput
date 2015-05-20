package Windows_Study_Show;

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

/**
 *
 * @author kasper
 */
public class ShowListener extends AbstractAction {

    private ArrayList<Element> list;
    private JButton check;
    private JLabel question, answer;
    private JTextField userInput;
    private UISwapInterface swap;
    
    
    public ShowListener(UISwapInterface swap, JButton check, JLabel question, JLabel answer, 
            JTextField userInput, ArrayList<Element> list) {
        this.swap = swap;
        this.check = check;
        this.question = question;
        this.answer = answer;
        this.userInput = userInput;
        this.list = list;
    }
    
    private enum Actions {
        Check
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(Actions.Check.name())) {
            swap.swapView("show");
            showQuestion();
        }
    }
    
    private void showQuestion() {
        while (true) {
            ++StudyF.index;
            if (hasNext()) {
                if (list.get(StudyF.index).isReviewable()) {
                    question.setText(list.get(StudyF.index).getQuestion());
                    answer.setText(list.get(StudyF.index).getAnswer());
                    answer.setVisible(false);
                    userInput.setVisible(true);
                    break;
                }
            }
            else close();
        }
    }
    
    private boolean hasNext() {
        return StudyF.index < list.size();
    }
    
    private void close() {
        FileUpdater file = new FileUpdater(StudyF.fName);
        file.update(StudyF.list);
        System.exit(0);
    }
}
