package Windows_Submenus;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MainMenu extends JMenuBar {

    public MainMenu() {
        
        // MENU
        JMenuBar menuBar1 = new JMenuBar();
        JMenu menu1 = new JMenu("Menu");

        JMenuItem menuImport = new JMenuItem("Import file", KeyEvent.VK_I);
        menuImport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_DOWN_MASK));
        
        JMenuItem menuStats = new JMenuItem("Statistics", KeyEvent.VK_S);
        menuStats.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        
        JMenuItem menuExit = new JMenuItem("Exit", KeyEvent.VK_E);
        menuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
        
        menu1.add(menuImport);
        menu1.add(menuStats);
        menu1.add(menuExit);

        menuBar1.add(menu1);
        add(menuBar1);
        
        // HELP
        
        JMenuBar menuBar2 = new JMenuBar();
        JMenu menu2 = new JMenu("Help");
        
        JMenuItem menuHelp = new JMenuItem("Help", KeyEvent.VK_H);
        menuHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK));
        menu2.add(menuHelp);
        
        menuBar2.add(menu2);
        add(menuBar2);
        
        ActionListener listener = new MainMenuListener(menuStats, menuHelp, menuExit);
        menuStats.addActionListener(listener);
        menuHelp.addActionListener(listener);
        menuExit.addActionListener(listener);
    }
}
