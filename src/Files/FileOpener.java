package Files;
import Constants.C;
import Items.Element;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class FileOpener {

    private final String fName;
    private ArrayList<Element> list;

    public FileOpener(String title) {
        this.fName = title;
        list = new ArrayList<>();
    }
    
    public FileOpener(String title, ArrayList<Element> list) {
        this.fName = title;
        this.list = list;
    }

    public ArrayList<Element> loadFile() throws FileNotFoundException, IOException, ParseException {
        if (fileExists()) {
            if (fileNotEmpty()) {
                BufferedReader br = new BufferedReader(new FileReader(new File(C.ITEMSPATH + fName)));
                String line;

                LocalDate current = LocalDate.now();

                while ((line = br.readLine()) != null) {
                    if (hasDate(line)) {
                        String[] parts = line.split(":", -2);
                        String question = parts[0];
                        String answer = parts[1];
                        String strDate = parts[2];
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        LocalDate date = LocalDate.parse(strDate, dtf);

                        Element ele = new Element(question, answer, date);

                        // add Elements to list with dates that are in the past
                        if (date.isBefore(current) || date.isEqual(current)) {
                            ele.setReviewable(true);
                            ele.setDate(current);
                        }

                        else { 
                            ele.setReviewable(false);
                        }
                        list.add(ele);
                    }
                }
                br.close();
                return list;
            }
            System.exit(0);
        }
        return null;
    }

    private boolean fileExists() {
        File file = new File(C.ITEMSPATH + fName);
        return file.exists();
    }
    
    private boolean fileNotEmpty() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(C.ITEMSPATH + fName)));
        if (br.readLine() != null) {
            br.close();
            return true;
        }
        else {
            br.close();
            return false;
        }
    }

    private boolean hasDate(String line) {
        int lastIndex = 0;
        int semicolons = 0;
        for (int i = 0; i < line.length(); i++) {
            if (semicolons == 2) break;
            if (line.charAt(i) == ':') {
                semicolons++;
            }
            lastIndex++;
        }
        
        if (semicolons < 2) return false;
        
        String subStringed = line.substring(lastIndex);
//        Boolean result = subStringed.matches(line)
        
        
        return true;
    }
}