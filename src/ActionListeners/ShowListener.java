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

/**
 *
 * @author kasper
 */
public class ShowListener extends AbstractAction {

    private final JButton check;
    public UISwapInterface swap;
    
    public ShowListener(JButton check, UISwapInterface swap) {
        this.check = check;
        this.swap = swap;
    }
    
    private enum Actions {
        Check
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(Actions.Check.name())) {
            swap.swapView("show");
        }
    }
}
