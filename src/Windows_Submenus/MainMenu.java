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

        JMenuItem importFile = new JMenuItem("Import", KeyEvent.VK_I);
        importFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_DOWN_MASK));
        
        JMenuItem stats = new JMenuItem("Statistics", KeyEvent.VK_S);
        stats.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        
        JMenuItem exit = new JMenuItem("Exit", KeyEvent.VK_E);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
        
        menu1.add(importFile);
        menu1.add(stats);
        menu1.add(exit);

        menuBar1.add(menu1);
        add(menuBar1);
        
        // HELP
        
        JMenuBar menuBar2 = new JMenuBar();
        JMenu menu2 = new JMenu("Help");
        
        JMenuItem help = new JMenuItem("Help", KeyEvent.VK_H);
        help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK));
        menu2.add(help);
        
        menuBar2.add(menu2);
        add(menuBar2);
        
        ActionListener listener = new MainMenuListener(importFile, stats, help, exit);
        importFile.addActionListener(listener);
        stats.addActionListener(listener);
        help.addActionListener(listener);
        exit.addActionListener(listener);
    }
}
