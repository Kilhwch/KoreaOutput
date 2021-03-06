package Save;

import Files.FileUpdater;
import Files.StatsReader;
import Files.UpdateStats;
import Items.StatsHistory;
import Windows_Study.Study;
import Windows_Study_Hide.HideListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Save {
 
    public void andClose(Boolean close) {
        FileUpdater file = new FileUpdater(Study.fName);
        file.update(Study.list);
        
        try {
            StatsHistory history = new StatsReader().getHistory();
            UpdateStats.update(history);
        } catch (IOException ex) {
                Logger.getLogger(HideListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (close) System.exit(0);
    }
}
