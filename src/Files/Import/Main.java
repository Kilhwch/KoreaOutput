package Files.Import;

import Constants.C;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame {
    
    public Main() {
        setSize(C.MAIN_W, C.MAIN_H);
        setTitle("Import file");
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
    }
    
    public void open() {
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridbag);
        
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 1;
        c.gridy = 2;
        JLabel helpText = new JLabel();
        helpText.setText("Import here");
        gridbag.setConstraints(helpText, c);
        add(helpText);
    }
}
