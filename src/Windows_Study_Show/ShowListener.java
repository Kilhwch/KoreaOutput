package Windows_Study_Show;

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


public class ShowListener extends AbstractAction {

    private JButton check;
    private JLabel question, answer;
    private JTextField userInput;
    private UISwapInterface swap;
    private JMenuItem delete;
    
    
    public ShowListener(UISwapInterface swap, JButton check, JLabel question, JLabel answer, 
            JTextField userInput, JMenuItem delete) {
        this.swap = swap;
        this.check = check;
        this.question = question;
        this.answer = answer;
        this.userInput = userInput;
        this.delete = delete;
    }
    
    
    private enum Actions {
        Check, Delete
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(Actions.Check.name())) {
            if (!lastItem()) {
                setNextItem(Study.index+1);
                swap.swapView(C.SHOW);
            } else {
                swap.swapView(C.SHOW);
            }
        }
        
        else if (e.getActionCommand().equals(Actions.Delete.name())) {
            System.out.println("Delete @ show");
            setNextItem(Study.index);
            swap.swapView(C.HIDE);
        }
        
        else { 
            new SaveAndClose().execute();
        }
    }
    
    
    private void setNextItem(Integer index) {
        question.setText(Study.list.get(index).getQuestion());
        answer.setText(Study.list.get(index).getAnswer());
        answer.setVisible(false);
        userInput.setVisible(true);
    }
    
    
    private boolean lastItem() {
        if ((Study.list.size()-1) == Study.index) {
            return true;
        } else return false;
    }
}
