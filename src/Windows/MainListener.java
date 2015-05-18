package Windows;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;


public class MainListener extends AbstractAction {
    public JButton quit;
    public JFrame frame;
    
    public MainListener(JButton quit, JFrame frame) {
        this.quit = quit;
        this.frame = frame;
    }

    private enum Actions {
        Exit
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(Actions.Exit.name())) {
            System.exit(0);
        }
    }
}
