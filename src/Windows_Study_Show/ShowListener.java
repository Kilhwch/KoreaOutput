package Windows_Study_Show;

import Constants.C;
import Save.Save;
import Windows_Study.Study;
import Windows_Study.UISwapInterface;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;


public class ShowListener extends AbstractAction {

    private JButton check;
    private JLabel question, answer;
    private JTextPane userInput;
    private UISwapInterface swap;
    private JMenuItem[] menuItems;
    
    
    public ShowListener(UISwapInterface swap, JButton check, JLabel question, 
            JLabel answer, JTextPane userInput, JMenuItem[] menuItems) {
        this.swap = swap;
        this.check = check;
        this.question = question;
        this.answer = answer;
        this.userInput = userInput;
        this.menuItems = menuItems;
    }
    
    private enum Actions {
        Check, Edit, Exit, Delete, Add, Back
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
            setNextItem(Study.index);
            swap.swapView(C.HIDE);
        }
        
        else if (e.getActionCommand().equals(Actions.Add.name())) {
            System.out.println("add SL");
        }
        
        else if (e.getActionCommand().equals(Actions.Back.name())) {
            System.out.println("back");
        }
        
        else if (e.getActionCommand().equals(Actions.Edit.name())) {
//            System.out.println("Edit called");
//            setNextItem(Study.index);
        }
        
        else {
            new Save().andClose(true);
        }
    }
    
    
    private void setNextItem(Integer index) {
        System.out.println("ShowList sets answer" + Study.list.get(index).getAnswer());
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
