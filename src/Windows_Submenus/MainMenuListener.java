
package Windows_Submenus;

import Windows.Stats;
import Windows.Help;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JMenuItem;

public class MainMenuListener extends AbstractAction {

    JMenuItem menuStats, menuHelp, menuExit;
    
    public MainMenuListener(JMenuItem menuStats, JMenuItem menuHelp, JMenuItem menuExit) {
        this.menuStats = menuStats;
        this.menuExit = menuExit;
    }
    
    private enum Actions {
        Statistics,
        Help,
        Exit
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(Actions.Statistics.name())) {
            new Stats().open();
        
        }
        
        else if (e.getActionCommand().equals(Actions.Help.name())) {
            new Help().open();
        }
        
        else {
            System.exit(0);
        }
    }
}
