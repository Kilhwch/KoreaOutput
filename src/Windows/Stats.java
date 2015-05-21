package Windows;


import Constants.C;
import Files.StatsReader;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class Stats extends JFrame {


    public Stats() {
        setSize(C.WINDOW_WIDTH, C.WINDOW_HEIGHT);
        setTitle("Statistics");
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
    }

    public void open() throws IOException {
        
        StatsReader stats = new StatsReader();
        stats.readStats();
        
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
        reviewed.setText(C.REVIEWED + stats.getReviewed());
        gridbag.setConstraints(reviewed, c);
        add(reviewed);
        
        c.gridx = 1;
        c.gridy = 3;
        JLabel memorized = new JLabel();
        memorized.setText(C.MEMORIZED + stats.getMemorized());
        gridbag.setConstraints(memorized, c);
        add(memorized);
        
        
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
