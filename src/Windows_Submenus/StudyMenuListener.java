package Windows_Submenus;

import Constants.C;
import Files.FileUpdater;
import Files.StatsReader;
import Files.UpdateStats;
import Items.StatsHistory;
import Windows_Study.Study;
import Windows_Study.UISwapInterface;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            // removing works now in the middle, but not on first or last item
            if (Study.HIDEON) {
                System.out.println("Removing1: " + Study.list.get(Study.index).getQuestion() + " (i) = " + (Study.index));
                Study.list.remove(Study.index);
            }
            else {
                System.out.println("Removing2: " + Study.list.get(Study.index-1).getQuestion() + " (i) = " + (Study.index-1));
                Study.list.remove(Study.index-1);
                
            }
            swap.swapView(C.HIDE);
            Study.memorized++;
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
