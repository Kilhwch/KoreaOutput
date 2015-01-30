package Main;

import ActionListeners.MainListener;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame {

    protected static final int WINDOW_WIDTH = 220;
    protected static final int WINDOW_HEIGHT = 120;
    protected static final String ICONPATH = "./Files/Icons/main.jpg";
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("KoreaOutput");
        
        ImageIcon icon = new ImageIcon(ICONPATH);
        frame.setIconImage(icon.getImage());
        
        frame.setLayout(null);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // elements start
        JButton fOpen = new JButton("Open");
        JButton exit = new JButton("Exit");
        
        fOpen.setBounds(30, 30, 70, 30);
        exit.setBounds(120, 30, 70, 30);
        
        frame.add(fOpen);
        frame.add(exit);
        // elements end
        ActionListener listener = new MainListener(fOpen, exit, frame);
        fOpen.addActionListener(listener);
        exit.addActionListener(listener);

        frame.setVisible(true);
    
    }
}
