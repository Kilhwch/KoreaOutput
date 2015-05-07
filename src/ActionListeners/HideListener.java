/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionListeners;

import Windows.Study.UISwapInterface;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;

public class HideListener extends AbstractAction {

    private final JButton easy, medium, hard;
    public UISwapInterface swap;
    
    public HideListener(JButton easy, JButton medium, JButton hard, UISwapInterface swap) {
        this.easy = easy; 
        this.medium = medium; 
        this.hard = hard; 
        this.swap = swap;
    }
    
    private enum Actions {
        Easy, Medium, Hard
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(Actions.Easy.name())) {
            swap.swapView("hide");
        }
        
        else if (e.getActionCommand().equals(Actions.Medium.name())) {
            swap.swapView("hide");
        }
        
        else {
            swap.swapView("hide");
        }
    }
}
