package Main;

import Elements.Element;
import Files.FileParser;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StudyFrame extends JPanel {
    protected static int WINDOW_WIDTH = 500;
    protected static int WINDOW_HEIGHT = 500;
    protected static final String ICONPATH = "./Files/Icons/main.jpg";
    
    private String fName;
    private JFrame f = new JFrame(fName);
    private JPanel layoutPanel;
    
    public ArrayList<Element> list;

    public StudyFrame() {
        
    }
    
    

    public StudyFrame(String fName) {
        this.fName = fName;
        FileParser file = new FileParser(fName);
        try {
            list = file.loadFile();
        } catch (IOException | ParseException ex) {
            Logger.getLogger(StudyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void windowInit(String command) {
        // Choose the view
        if (command.equals("StudyFrameHide")) {
            layoutPanel = new StudyFrameHide(f, list);
        }
        else {
            layoutPanel = new StudyFrameShow(f, list);
        }
        
        f.add(layoutPanel);
        ImageIcon icon = new ImageIcon(ICONPATH);
        f.setIconImage(icon.getImage());
        f.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}