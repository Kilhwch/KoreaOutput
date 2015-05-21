package Files;

import Constants.C;
import Items.StatsHistory;
import Windows_Study.Study;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class UpdateStats {

    public UpdateStats() {
        
    }
    
        public static void update(StatsHistory history) {
            try {
                File file = new File(C.STATSPATH + C.STATS);
                File temp = new File(C.STATSPATH + "tmp1.txt");

                BufferedReader br = new BufferedReader(new FileReader(file));
                BufferedWriter pw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(temp), "UTF-8"));
                
                pw.write(C.REVIEWED + (Study.reviewed + history.getReviewed()));
                pw.newLine();
                pw.write(C.MEMORIZED + (Study.memorized + history.getMemorized()));
                
                pw.flush();
                pw.close();
                br.close();
                file.delete();
                temp.renameTo(file);
        }
        
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
