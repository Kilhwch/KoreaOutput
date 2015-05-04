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
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class FileParser {

    private final String fName;
    private final String PATH = "./Files/Items/";
    private ArrayList<Element> list;

    public FileParser(String title) {
        this.fName = title;
        list = new ArrayList<>();
    }
    
    public FileParser(String title, ArrayList<Element> list) {
        this.fName = title;
        this.list = list;
    }

    public ArrayList<Element> loadFile() throws FileNotFoundException, IOException, ParseException {
        if (notEmptyFile(PATH + fName)) {
            BufferedReader br = new BufferedReader(new FileReader(new File(PATH + fName)));
            String line;

            LocalDate current = LocalDate.now();
            
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":", -2);
                String question = parts[0];
                String answer = parts[1];
                String strDate = parts[2];
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(strDate, dtf);
                
                Element ele = new Element(question, answer, date);
                
                // add Elements to list with dates that are in the past
                if (date.isBefore(current)) list.add(ele);
            }
            br.close();
            return list;
        }
        return null;
    }
    
    public void updateFile() {
        System.out.println("updating file");
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

    private boolean notEmptyFile(String path) {
        File file = new File(path);
        return file.exists();
    }
}
