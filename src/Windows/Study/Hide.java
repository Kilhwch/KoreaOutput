
package Windows.Study;

import ActionListeners.ShowListener;
import Elements.Element;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Hide extends JPanel {

    public UISwapInterface swap;
    public static final String SHOW = "show";
    public ArrayList<Element> list;

    public Hide(UISwapInterface swap, ArrayList<Element> list) {
        this.swap = swap;
        this.list = list;
        init(list);
    }
    
    private void init(ArrayList<Element> list) {
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridbag);
        
        c.weightx = 4;
        c.weighty = 4;
        c.anchor = GridBagConstraints.LAST_LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 6; 
        c.gridy = 5;
        JButton check = new JButton("Check");
        gridbag.setConstraints(check, c);
        add(check);

        c.gridx = 6; 
        c.gridy = 3;
        c.anchor = GridBagConstraints.CENTER;
        JLabel question = new JLabel("", SwingConstants.CENTER);
        gridbag.setConstraints(question, c);
        add(question);
        
        c.gridx = 6;
        c.gridy = 4;
        c.anchor = GridBagConstraints.CENTER;
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        gridbag.setConstraints(separator, c);
        add(separator);
        
        c.gridx = 6;
        c.gridy = 4;
        c.anchor = GridBagConstraints.PAGE_END;
        JLabel answer = new JLabel("", SwingConstants.CENTER);
        answer.setVisible(false);
        gridbag.setConstraints(answer, c);
        add(answer);
        
        c.ipady = 30;
        c.gridwidth = 2;
        c.gridx = 6;
        c.gridy = 5;
        c.anchor = GridBagConstraints.CENTER;
        JTextField userInput = new JTextField();
        gridbag.setConstraints(userInput, c);
        add(userInput); 
        
        addListeners(check, question, answer, userInput, list);
    }
    
    protected void addListeners(JButton check, JLabel question, JLabel answer, JTextField userInput, 
                                ArrayList<Element> list) {
        ActionListener listener = new ShowListener(swap, check, question, answer, userInput, list);
        check.addActionListener(listener);
    }
}
