package Windows_Submenus;

import Constants.C;
import SaveAndClose.SaveAndClose;
import Windows_Study.Study;
import Windows_Study.UISwapInterface;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JMenuItem;

public class StudyMenuListener extends AbstractAction {
    
    private JMenuItem menuAdd, menuDel, menuExit;
    private UISwapInterface swap;
    
    public StudyMenuListener(JMenuItem menuAdd, JMenuItem menuDel, JMenuItem menuExit, UISwapInterface swap) {
        this.menuAdd = menuAdd;
        this.menuDel = menuDel;
        this.menuExit = menuExit;
        this.swap = swap;
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
//            Study.list.remove(Study.index);
//            Study.memorized++;
//            swap.swapView(C.SHOW);
        }
        
        else {
            new SaveAndClose().execute();
        }
    }
}
