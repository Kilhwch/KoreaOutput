package Windows_Submenus;

import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class StudyMenu extends JMenuBar {
    
    private JMenuItem add, edit, delete, back, exit;
    private JMenuItem[] menuItems = new JMenuItem[5];
    
    public StudyMenu() {
        
        // SCREEN MENU
        
        JMenuBar viewBar = new JMenuBar();
        JMenu viewMenu = new JMenu("View");
        
        exit = new JMenuItem("Exit", KeyEvent.VK_E);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));
        
        back = new JMenuItem("Back", KeyEvent.VK_E);
        back.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_DOWN_MASK));
        
        viewMenu.add(back);
        viewMenu.add(exit);
        
        viewBar.add(viewMenu);
        add(viewBar);
        
        
        // ITEM MENU
        
        JMenuBar itemBar = new JMenuBar();
        JMenu itemMenu = new JMenu("Item");

        
        add = new JMenuItem("Add");
        add.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
        
        delete = new JMenuItem("Delete", KeyEvent.VK_DELETE);
        delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));
        
        edit = new JMenuItem("Edit");
        edit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
        
        itemMenu.add(add);
        itemMenu.add(edit);
        itemMenu.add(delete);
        
        itemBar.add(itemMenu);
        add(itemBar);
        
        menuItems[0] = back;
        menuItems[1] = exit;
        menuItems[2] = add;
        menuItems[3] = edit;
        menuItems[4] = delete;
    }
    
    public JMenuItem[] getMenuItems() {
        return menuItems;
    }
}
