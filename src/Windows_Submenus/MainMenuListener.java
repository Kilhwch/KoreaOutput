package Windows_Submenus;

import Files.Import.Import;
import Windows_Statistics.Statistics;
import Windows_Help.Help;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JMenuItem;

public class MainMenuListener extends AbstractAction {

    JMenuItem importFile, stats, help, exit;
    
    public MainMenuListener(JMenuItem importFile, JMenuItem stats, JMenuItem help, JMenuItem exit) {
        this.importFile = importFile;
        this.stats = stats;
        this.help = help;
        this.exit = exit;
    }
    
    private enum Actions {
        Import, Statistics, Help, Exit
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(Actions.Statistics.name())) {
            try {
                new Statistics().open();
            } catch (IOException ex) {
                Logger.getLogger(MainMenuListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if (e.getActionCommand().equals(Actions.Help.name())) {
            new Help().open();
        }
        
        else if (e.getActionCommand().equals(Actions.Import.name())) {
            new Import().open();
        }
        
        else if (e.getActionCommand().equals(Actions.Exit.name())) {
            System.exit(0);
        }
        
        else {
            
        }
    }
}
