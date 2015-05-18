/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Windows_Study_Show;

import Elements.Element;
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

    private int index = 1;
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
            showAnswer();
        }
    }
    
    
    private void showAnswer() {
        if (hasNext()) {
            question.setText(list.get(index).getQuestion());
            index++;
        }
    }
    
    private boolean hasNext() {
        return index < list.size();
    }
}
