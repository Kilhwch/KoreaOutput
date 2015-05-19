package Windows_Study;

import Windows_Study_Show.Show;
import Windows_Study_Hide.Hide;
import Elements.Element;
import Files.FileOpener;
import Windows_Submenus.Menu;
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
    public static String fName;
    public static int index = 0;
    CardLayout cards = new CardLayout();
    
    public static ArrayList<Element> list;

    public StudyF(String fName) {
        this.fName = fName;
        FileOpener file = new FileOpener(fName);
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