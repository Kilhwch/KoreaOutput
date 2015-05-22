package Windows_Study_Hide;

import Windows_Study_Show.ShowListener;
import Items.Element;
import Windows_Study.Study;
import Windows_Study.UISwapInterface;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Hide extends JPanel {

    private UISwapInterface swap;
    private JMenuItem delete;

    public Hide(UISwapInterface swap, JMenuItem delete) {
        this.swap = swap;
        this.delete = delete;
        
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridbag);
        
        c.weightx = 4;
        c.weighty = 4;
        c.anchor = GridBagConstraints.SOUTH;
        c.gridx = 6; 
        c.gridy = 5;
        JButton check = new JButton("Check");
        check.setPreferredSize(new Dimension(300, 30));
        gridbag.setConstraints(check, c);
        add(check);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 6; 
        c.gridy = 3;
        c.anchor = GridBagConstraints.CENTER;
        JLabel question = new JLabel("", SwingConstants.CENTER);
        if (hasFirstQuestion()) {
            question.setText(getFirstQuestion());
        } else System.exit(0);
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
        
        c.fill = GridBagConstraints.RELATIVE;
        c.ipady = 15;
        c.ipadx = 300;
        c.gridwidth = 2;
        c.gridx = 6;
        c.gridy = 5;
        c.anchor = GridBagConstraints.CENTER;
        JTextField userInput = new JTextField();
        gridbag.setConstraints(userInput, c);
        add(userInput); 
        
        ActionListener listener = new ShowListener(swap, check, question, answer, userInput, delete);
        check.addActionListener(listener);
        delete.addActionListener(listener);
    }
    
    private Boolean hasFirstQuestion() {
        for (Element elem : Study.list) {
            if (elem.isReviewable()) {
                return true;
            } else {
                Study.index++;
            }
        }
        return false;
    }
    
    private String getFirstQuestion() {
        return Study.list.get(0).getQuestion();
    }
}
