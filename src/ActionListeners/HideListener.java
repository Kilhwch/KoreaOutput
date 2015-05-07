/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionListeners;

import Elements.Element;
import Windows.Study.UISwapInterface;
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
    private int index = 1;
    
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
            if (hasNext()) swap.swapView("hide");
        }
        
        else if (e.getActionCommand().equals(Actions.Medium.name())) {
            if (hasNext()) swap.swapView("hide");
        }
        
        else {
            if (hasNext()) swap.swapView("hide");
            
        }
        showQuestion();
    }
    
    private boolean hasNext() {
        return index < list.size();
    }
    
    private void showQuestion() {
        if (hasNext()) {
            question.setText(list.get(index).getQuestion());
            answer.setText(list.get(index).getAnswer());
            index++;
        } else {
            System.exit(0);
        }
    }
}
