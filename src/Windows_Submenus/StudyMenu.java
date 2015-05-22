package Windows_Submenus;

import Windows_Study.UISwapInterface;
import Windows_Study_Hide.HideListener;
import Windows_Study_Show.ShowListener;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class StudyMenu extends JMenuBar {
    
    public JMenuItem menuAdd, menuDel, menuExit;
    
    public StudyMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        
        menuAdd = new JMenuItem("Add");
        menuAdd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
        menuAdd.setEnabled(false);
        
        menuDel = new JMenuItem("Delete", KeyEvent.VK_DELETE);
        menuDel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));
        
        menuExit = new JMenuItem("Exit", KeyEvent.VK_E);
        menuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
        
        menu.add(menuAdd);
        menu.add(menuDel);
        menu.add(menuExit);
        
        menuBar.add(menu);
        add(menuBar);
    }
    
    public JMenuItem getDelete() {
        return menuDel;
    }

    public JMenuItem getMenuExit() {
        return menuExit;
    }
}
