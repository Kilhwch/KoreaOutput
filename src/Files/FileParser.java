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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FileParser {

    private final String fName;
    private final String PATH = "./Files/Items/";
    private ArrayList<Element> list;

    public FileParser(String title) {
        this.fName = title;
        list = new ArrayList<>();
    }

    public ArrayList<Element> loadFile() throws FileNotFoundException, IOException, ParseException {
        if (notEmptyFile(PATH + fName)) {
            BufferedReader br = new BufferedReader(new FileReader(new File(PATH + fName)));
            String line;

            Date current = new Date();
            
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":", -2);
                String question = parts[0];
                String answer = parts[1];
                String strDate = parts[2];
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date date = format.parse(strDate);
                
                Element ele = new Element(question, answer, date);
                if (date.before(current)) list.add(ele); // add to list Only if date is smaller or equal to current date
            }
            br.close();
            return list;
        }
        System.out.println("nullia");
        return null;
    }
    
    public void removeLine(int index) {
        try {
        File file = new File(PATH + fName);
        File temp = new File(PATH + "tmp.txt");
        String line;
        
        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter pw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(temp), "UTF-8"));
        int counter = 0;
        
        while ((line = br.readLine()) != null) {
            if (counter != index) {
                pw.write(line);
                pw.newLine();
            }
            counter++;
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

    private boolean notEmptyFile(String path) {
        File file = new File(path);
        return file.exists();
    }
}
