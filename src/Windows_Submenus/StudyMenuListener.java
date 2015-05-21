package Windows_Submenus;

import Files.FileUpdater;
import Files.StatsReader;
import Files.UpdateStats;
import Items.StatsHistory;
import Windows_Study.Study;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            FileUpdater file = new FileUpdater(Study.fName);
            file.update(Study.list);
            
            try {
                StatsHistory history = new StatsReader().getHistory();
                UpdateStats.update(history);
            } catch (IOException ex) {
                Logger.getLogger(StudyMenuListener.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.exit(0);
        }
    }
}
