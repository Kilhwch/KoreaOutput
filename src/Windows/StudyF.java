package Windows;

import Windows.Study.UISwapInterface;
import Windows.Study.Show;
import Windows.Study.Hide;
import Elements.Element;
import Files.FileParser;
import Windows.Study.Menu;
import java.awt.CardLayout;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class StudyF extends JFrame implements UISwapInterface {
    protected static int WINDOW_WIDTH = 500;
    protected static int WINDOW_HEIGHT = 500;
    protected static final String ICONPATH = "./Files/Icons/main.jpg";
    private static final String SHOW = "show";
    private static final String HIDE = "hide";
    private String fName;
    CardLayout cards = new CardLayout();
    
    public ArrayList<Element> list;

    public StudyF(String fName) {
        this.fName = fName;
        FileParser file = new FileParser(fName);
        try {
            list = file.loadFile();
        } catch (IOException | ParseException ex) {
            Logger.getLogger(StudyF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void windowInit() {
        setLayout(cards);
        Hide hide = new Hide(this, list);
        Show show = new Show(this, list);
        
        add(hide, HIDE);
        add(show, SHOW);
        
        JMenuBar menu = new Menu();
        setJMenuBar(menu);
        
        setTitle(fName);
        ImageIcon icon = new ImageIcon(ICONPATH);
        setIconImage(icon.getImage());
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    @Override
    public void swapView(String view) {
        cards.show(getContentPane(), view);
    }
}