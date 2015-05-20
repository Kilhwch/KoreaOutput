
package Windows_Submenus;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MainMenu extends JMenuBar {

    public MainMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem menuStats = new JMenuItem("Statistics", KeyEvent.VK_DELETE);
        menuStats.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_DOWN_MASK));
        JMenuItem menuHelp = new JMenuItem("Help", KeyEvent.VK_DELETE);
        menuHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK));
        JMenuItem menuExit = new JMenuItem("Exit", KeyEvent.VK_E);
        menuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
        
        menuBar.add(menu);
        menu.add(menuStats);
        menu.add(menuHelp);
        menu.add(menuExit);
        
        add(menuBar);
        
        addListeners(menuStats, menuHelp, menuExit);
    }
    
    protected void addListeners(JMenuItem menuStats, JMenuItem menuHelp, JMenuItem menuExit) {
        ActionListener listener = new MainMenuListener(menuStats, menuHelp, menuExit);
        menuStats.addActionListener(listener);
        menuExit.addActionListener(listener);
    }
}
