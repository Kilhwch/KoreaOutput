
package Windows;

import javax.swing.JFrame;


public class Help extends JFrame {

    protected static final int WINDOW_WIDTH = 500;
    protected static final int WINDOW_HEIGHT = 500;
    
    
    public Help() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Help");
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
    }
    
    public void open() {

    }
}
