package Files;

import Constants.C;
import Items.StatsHistory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class StatsReader {
    
    public StatsReader() {
    }
    
    public StatsHistory getHistory() throws FileNotFoundException, IOException { 
        BufferedReader br = new BufferedReader(new FileReader(new File(C.STATSPATH + C.STATS)));
        
        String tmp1 = br.readLine().substring(16);
        long reviewed = Integer.parseInt(tmp1);
        
        String tmp2 = br.readLine().substring(17);
        long memorized = Integer.parseInt(tmp2);
        
        StatsHistory history = new StatsHistory();
        history.setMemorized(memorized);
        history.setReviewed(reviewed);
        
        br.close();
        return history;
    }
}
