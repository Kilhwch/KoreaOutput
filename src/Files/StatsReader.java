package Files;

import Constants.C;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class StatsReader {

    private long memorized;
    private long reviewed;
    
    public StatsReader() {
    }
    
    public void readStats() throws FileNotFoundException, IOException { 
        BufferedReader br = new BufferedReader(new FileReader(new File(C.STATSPATH + C.STATS)));
        
        String tmp1 = br.readLine().substring(16);
        memorized = Integer.parseInt(tmp1);
        
        String tmp2 = br.readLine().substring(25);
        reviewed = Integer.parseInt(tmp2);
        br.close();
    }

    public long getMemorized() {
        return memorized;
    }

    public long getReviewed() {
        return reviewed;
    }
}
