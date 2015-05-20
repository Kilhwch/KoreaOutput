package Files;

import Elements.Element;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class FileUpdater {

    private final String PATH = "./Files/Items/";
    private final String fName;
    
    public FileUpdater(String fName) {
        this.fName = fName;
    }
    
        public void update(ArrayList<Element> list) {
        try {
            File file = new File(PATH + fName);
            File temp = new File(PATH + "tmp.txt");

            BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedWriter pw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(temp), "UTF-8"));

            for (Element element : list) {
                pw.write(element.toString());
                pw.newLine();
            }

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
