package Windows;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class Stats extends JFrame {

    protected static final int WINDOW_WIDTH = 500;
    protected static final int WINDOW_HEIGHT = 500;

    public Stats() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Statistics");
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
    }

    public void open() {
        
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridbag);
        
        c.insets = new Insets(0, 0, 30, 0);
        c.fill = GridBagConstraints.HORIZONTAL;
        JSeparator top = new JSeparator(JSeparator.HORIZONTAL);
        c.gridx = 1;
        c.gridy = 1;
        gridbag.setConstraints(top, c);
        add(top);
        
        
        c.gridx = 1;
        c.gridy = 2;
        JLabel reviewed = new JLabel();
        reviewed.setText("Items reviewed: file.readCount");
        gridbag.setConstraints(reviewed, c);
        add(reviewed);
        
        c.gridx = 1;
        c.gridy = 3;
        JLabel deleted = new JLabel();
        deleted.setText("Items deleted: file.readCount");
        gridbag.setConstraints(deleted, c);
        add(deleted);
        
        
        
        c.insets = new Insets(30, 0, 0, 0);
        c.anchor = GridBagConstraints.PAGE_END;
        c.fill = GridBagConstraints.HORIZONTAL;
        JSeparator bottom = new JSeparator(JSeparator.HORIZONTAL);
        c.gridx = 1;
        c.gridy = 5;
        gridbag.setConstraints(bottom, c);
        add(bottom);
    }
}
