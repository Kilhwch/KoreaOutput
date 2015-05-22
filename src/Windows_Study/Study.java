package Windows_Study;

import Constants.C;
import Windows_Study_Show.Show;
import Windows_Study_Hide.Hide;
import Items.Element;
import Files.FileOpener;
import Windows_Submenus.StudyMenu;
import java.awt.CardLayout;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class Study extends JFrame implements UISwapInterface {

    public static boolean HIDEON = false;
    public static int memorized, reviewed, index = 0;
    public static String fName;
    private CardLayout cards = new CardLayout();
    public static ArrayList<Element> list;

    public Study(String fName) throws IOException {
        this.fName = fName;
        FileOpener file = new FileOpener(fName);
        try {
            list = file.loadFile();
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Study.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void windowInit() {
        StudyMenu studyMenu = new StudyMenu(); // swap oli parametreis
        JMenuBar menu = studyMenu;
        setJMenuBar(menu);
        
        setLayout(cards);
        Hide hide = new Hide(this, studyMenu.getDelete());
        Show show = new Show(this, studyMenu.getDelete());
        
        add(hide, C.HIDE);
        add(show, C.SHOW);
        
        setTitle(fName);
        ImageIcon icon = new ImageIcon(C.ICONPATH);
        setIconImage(icon.getImage());
        setSize(C.WINDOW_WIDTH, C.WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    @Override
    public void swapView(String view) {
        if (view.equals(C.HIDE)) {
            HIDEON = true;
        }
        else {
            HIDEON = false;
        }
        cards.show(getContentPane(), view);
    }
}


// Removing last item bug fix