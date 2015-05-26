package Windows_Study_Hide;

import Windows_Study_Show.ShowListener;
import Items.Element;
import Windows_Study.Study;
import Windows_Study.UISwapInterface;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


public class Hide extends JPanel {

    private UISwapInterface swap;
    private JMenuItem[] menuItems;
    
    public Hide(UISwapInterface swap, JMenuItem[] menuItems) {
        this.swap = swap;
        this.menuItems = menuItems;
        
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridbag);
        setBackground(Color.WHITE);
        
        c.weightx = 4;
        c.weighty = 4;
        c.anchor = GridBagConstraints.SOUTH;
        c.gridx = 6; 
        c.gridy = 5;
        JButton check = new JButton("Check");
        check.setBackground(Color.white);
        check.setPreferredSize(new Dimension(300, 30));
        gridbag.setConstraints(check, c);
        add(check);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 6; 
        c.gridy = 3;
        c.anchor = GridBagConstraints.CENTER;
        JLabel question = new JLabel("", SwingConstants.CENTER);
        
        question.setText(getFirstQuestion());
        if (question.getText().equals("")) System.exit(0);
        
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
        
        JTextPane userInput = new JTextPane();
            StyledDocument doc = userInput.getStyledDocument();
            SimpleAttributeSet center = new SimpleAttributeSet();
            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
            doc.setParagraphAttributes(0, doc.getLength(), center, false);
        JScrollPane scroll = new JScrollPane(userInput);
        scroll.setBorder(null);
        gridbag.setConstraints(scroll, c);
        add(scroll); 
        
        ActionListener listener = new ShowListener(swap, check, question, answer, userInput, menuItems);
        check.addActionListener(listener);
        
        for (JMenuItem menuItem : menuItems) {
            menuItem.addActionListener(listener);
        }
    }
    
    private String getFirstQuestion() {
        for (Element elem : Study.list) {
            if (elem.isReviewable()) {
                return elem.getQuestion();
            } else {
                Study.index++;
            }
        }
        return "";
    }
}
