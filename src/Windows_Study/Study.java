package Windows_Study;

import Constants.C;
import Windows_Study_Show.Show;
import Windows_Study_Hide.Hide;
import Items.Element;
import Files.FileOpener;
import Save.Save;
import Windows_Submenus.StudyMenu;
import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Study extends JFrame implements UISwapInterface {

    public static int memorized, reviewed, index = 0;
    public static String fName;
    public static JFrame mainFrame;
    private CardLayout cards = new CardLayout();
    public static ArrayList<Element> list;

    public Study(String fName, JFrame mainFrame) throws IOException {
        this.fName = fName;
        this.mainFrame = mainFrame;
        FileOpener file = new FileOpener(fName);
        try {
            list = file.loadFile();
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Study.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void windowInit() {
        StudyMenu sMenu = new StudyMenu();
        JMenuItem[] menuItems = sMenu.getMenuItems();
        JMenuBar jMenu = sMenu;
        setJMenuBar(jMenu);
        
        setLayout(cards);
        Hide hide = new Hide(this, menuItems);
        Show show = new Show(this, menuItems);
        
        add(hide, C.HIDE);
        add(show, C.SHOW);
        
        
        setTitle(fName);
        ImageIcon icon = new ImageIcon(C.ICONPATH);
        setIconImage(icon.getImage());
        setSize(C.WINDOW_WIDTH, C.WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new Save().andClose(true);
                e.getWindow().dispose();
            }
        });
    }
    
    @Override
    public void swapView(String view) {
        if (view.equals(C.MAIN)) {
            mainFrame.setVisible(true);
            setVisible(false);
        }
        else {
            cards.show(getContentPane(), view);
        }
    }
}

// Next open FileOpener, and learn regex to check if string is a valid date
// Goal is to set date to Current if user doesnt specify a date @ txt file