package Main;

import ActionListeners.MainFrameListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JPanel {

    protected static final int WINDOW_WIDTH = 220;
    protected static final int WINDOW_HEIGHT = 120;
    protected static final String ICONPATH = "./Files/Icons/main.jpg";
    protected static final String title = "KoreaOutput";
    
    
    public static void main(String[] args) {
        JFrame f = new JFrame(title);
        JPanel pane = new MainFrame(f);
        f.add("Center", pane);
        
        ImageIcon icon = new ImageIcon(ICONPATH);
        f.setIconImage(icon.getImage());
        f.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setResizable(true);
        f.setVisible(true);
    }
    
    public MainFrame(JFrame f) {
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridbag);
        c.weightx = 1.0;
        c.weighty = 1.0;
        JButton open = makeButton("Open", gridbag, c);
        JButton exit = makeButton("Exit", gridbag, c);
        addListeners(open, exit, f);
    }
    
    protected JButton makeButton(String name, GridBagLayout gridbag, GridBagConstraints c) {
        JButton button = new JButton(name);
        gridbag.setConstraints(button, c);
        add(button);
        return button;
    }
    
    // Implementations @ MainFrameListener class
    protected void addListeners(JButton open, JButton exit, JFrame f) {
        ActionListener listener = new MainFrameListener(open, exit, f);
        open.addActionListener(listener);
        exit.addActionListener(listener);
    }
}
