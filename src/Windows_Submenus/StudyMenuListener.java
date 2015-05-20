package Windows_Submenus;

import Files.FileUpdater;
import Windows_Study.StudyF;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JMenuItem;

public class StudyMenuListener extends AbstractAction {
    
    JMenuItem menuAdd, menuDel, menuExit;
    
    public StudyMenuListener(JMenuItem menuAdd, JMenuItem menuDel, JMenuItem menuExit) {
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
            FileUpdater file = new FileUpdater(StudyF.fName);
            file.update(StudyF.list);
            System.exit(0);
        }
    }
}
