package Windows_Study_Show;

import Constants.C;
import Items.Element;
import Files.FileUpdater;
import Files.StatsReader;
import Files.UpdateStats;
import Items.StatsHistory;
import Windows_Study.Study;
import Windows_Study.UISwapInterface;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


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
            swap.swapView(C.SHOW);
            setFields();
        }
    }
    
    private void setFields() {
        while (true) {
            if (!lastItem()) {
                ++Study.index;
                if (hasNext()) {
                    if (list.get(Study.index).isReviewable()) {
                        question.setText(list.get(Study.index).getQuestion());
                        answer.setText(list.get(Study.index).getAnswer());
                        answer.setVisible(false);
                        userInput.setVisible(true);
                        break;
                    }
                }
            } else {
                // show complete window or break so the user sees the last answer
                // last items date is not also updated
                close();
            }
        }
    }
    
    private boolean hasNext() {
        return Study.index < list.size();
    }
    
    private boolean lastItem() {
        return Study.index+1 == list.size();
    }
    
    private void close() {
        FileUpdater file = new FileUpdater(Study.fName);
        file.update(Study.list);
        
        
        try {
            StatsHistory history = new StatsReader().getHistory();
            UpdateStats.update(history);
        } catch (IOException ex) {
                Logger.getLogger(ShowListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }
}
