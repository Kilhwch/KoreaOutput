package Windows_Statistics;

import Constants.C;
import Files.StatsReader;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class Statistics extends JFrame {


    public Statistics() {
        setSize(C.MAIN_W, C.MAIN_H);
        setTitle("Statistics");
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
    }

    public void open() throws IOException {
        
        StatsReader stats = new StatsReader();
        stats.getHistory();
        
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridbag);
        
        c.gridx = 1;
        c.gridy = 2;
        JLabel reviewed = new JLabel();
        reviewed.setText(C.REVIEWED + stats.getHistory().getReviewed());
        gridbag.setConstraints(reviewed, c);
        add(reviewed);
        
        c.gridx = 1;
        c.gridy = 3;
        JLabel memorized = new JLabel();
        memorized.setText(C.MEMORIZED + stats.getHistory().getMemorized());
        gridbag.setConstraints(memorized, c);
        add(memorized);
    }
}
