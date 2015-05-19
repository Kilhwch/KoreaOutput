
package Windows_Study_Hide;

import Windows_Study_Show.ShowListener;
import Elements.Element;
import Windows_Study.StudyF;
import Windows_Study.UISwapInterface;
import java.awt.Dimension;
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

    private UISwapInterface swap;
    private ArrayList<Element> list;

    public Hide(UISwapInterface swap, ArrayList<Element> list) {
        this.swap = swap;
        this.list = list;
        
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
        gridbag.setConstraints(question, c);
        // first question
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(StudyF.index).isReviewable()) {
                question.setText(list.get(StudyF.index).getQuestion());
                break;
            }
            else {
                StudyF.index++;
            }
        }

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
        
        ActionListener listener = new ShowListener(swap, check, question, answer, userInput, list);
        check.addActionListener(listener);
    }
}
