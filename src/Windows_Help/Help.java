package Windows_Help;

import Constants.C;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Help extends JFrame {
    
    public Help() {
        setSize(C.MAIN_W, C.MAIN_H);
        setTitle("Help");
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
        helpText.setText(C.HELPTEXT);
        gridbag.setConstraints(helpText, c);
        add(helpText);
    }
}
