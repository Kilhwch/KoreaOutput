
package Windows_Submenus;

import Windows_Study.UISwapInterface;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class StudyMenu extends JMenuBar {
    public StudyMenu(UISwapInterface swap) {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem menuAdd = new JMenuItem("Add");
        menuAdd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
        menuAdd.setEnabled(false);
        JMenuItem menuDel = new JMenuItem("Delete", KeyEvent.VK_DELETE);
        menuDel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));
        JMenuItem menuExit = new JMenuItem("Exit", KeyEvent.VK_E);
        menuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
        
        menuBar.add(menu);
        menu.add(menuAdd);
        menu.add(menuDel);
        menu.add(menuExit);
        
        add(menuBar);
        
        addListeners(menuAdd, menuDel, menuExit, swap);
    }

    protected void addListeners(JMenuItem menuAdd, JMenuItem menuDel, JMenuItem menuExit, UISwapInterface swap) {
        ActionListener listener = new StudyMenuListener(menuAdd, menuDel, menuExit, swap);
        menuAdd.addActionListener(listener);
        menuDel.addActionListener(listener);
        menuExit.addActionListener(listener);
    }
}
