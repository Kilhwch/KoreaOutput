
package ActionListeners;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JMenuItem;

public class MenuListener extends AbstractAction {
    
    JMenuItem menuAdd, menuDel, menuExit;
    
    public MenuListener(JMenuItem menuAdd, JMenuItem menuDel, JMenuItem menuExit) {
        this.menuAdd = menuAdd;
        this.menuDel = menuDel;
        this.menuExit = menuExit;
    }
    
    private enum Actions {
        Add,
        Delete,
        Exit
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(Actions.Add.name())) {
            
        }
        
        else if (e.getActionCommand().equals(Actions.Delete.name())) {
            
        }
        
        else {
            // update files before closing here
            System.exit(0);
        }
    }
}
