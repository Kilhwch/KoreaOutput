
package Windows.Study;

import ActionListeners.ShowListener;
import Elements.Element;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Hide extends JPanel {

    private static final String SHOW = "show";
    private UISwapInterface swap;
    public ArrayList<Element> list;
    
    
    public Hide() {
    }

    public Hide(UISwapInterface swap, ArrayList<Element> list) {
        this.swap = swap;
        this.list = list;
        init(list);
    }
    
    public void init(final ArrayList<Element> list) {
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
        question.setText(list.get(0).getQuestion());
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
        final JLabel answer = new JLabel("", SwingConstants.CENTER);
        answer.setText(list.get(0).getAnswer());
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
        
        addListeners(check, swap);
    }
    
    protected void addListeners(JButton check, UISwapInterface swap) {
        ActionListener listener = new ShowListener(check, swap);
        check.addActionListener(listener);
    }
}
