package Files;
import Constants.C;
import Errors.ItemSyntax;
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
    private ItemSyntax errorHandler = new ItemSyntax();

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
                int lineNr = 0;

                LocalDate current = LocalDate.now();

                while ((line = br.readLine()) != null) {
                    lineNr++;
                    if (syntaxCheck(line, lineNr)) {
                        String[] parts = line.split(":", -2);
                        String question = parts[0];
                        String answer = parts[1];
                        String strDate = parts[2];
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        LocalDate date = LocalDate.parse(strDate, dtf);

                        Element ele = new Element(question, answer, date);

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

    private boolean syntaxCheck(String line, int lineNr) {
        int lastIndex = 0;
        int semicolons = 0;
        for (int i = 0; i < line.length(); i++) {
            if (semicolons == 2) break;
            if (line.charAt(i) == ':') {
                semicolons++;
            }
            lastIndex++;
        }
        
        if (semicolons < 2) { 
            errorHandler.addError(C.SemicolonMissing, lineNr);
            return false;
        }
        
        String subStringed = line.substring(lastIndex);
        if (subStringed.isEmpty()) {
            errorHandler.addError(C.DateMissing, lineNr);
        }
        
        Boolean result = subStringed.matches("^(\\d{4}-\\d{2}-\\d{2})$");
        if (!result) errorHandler.addError(C.DateSyntax, lineNr);
        return result;
    }
}