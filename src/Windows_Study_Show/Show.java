package Windows_Study_Show;

import Windows_Study_Hide.HideListener; 
import Windows_Study.Study;
import Windows_Study.UISwapInterface;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Show extends JPanel {

    private UISwapInterface swap;
    private JMenuItem[] menuItems;
    
    public Show(UISwapInterface swap, JMenuItem[] menuItems) {
        this.swap = swap;
        this.menuItems = menuItems;
        
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridbag);
        setBackground(Color.WHITE);
        
        c.weightx = 4;
        c.weighty = 4;
        
        c.ipady = 8;
        c.anchor = GridBagConstraints.LAST_LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 6; 
        c.gridy = 5;
        JButton easy = new JButton("Easy");
        easy.setBackground(Color.white);
        gridbag.setConstraints(easy, c);
        add(easy);
        
        
        c.gridx = 5; 
        c.gridy = 5;
        JButton medium = new JButton("Medium");
        medium.setBackground(Color.white);
        gridbag.setConstraints(medium, c);
        add(medium);
        
        c.gridx = 4;
        c.gridy = 5;
        JButton hard = new JButton("Hard");
        hard.setBackground(Color.white);
        gridbag.setConstraints(hard, c);
        add(hard);
        
        c.ipady = 0;
        c.gridx = 5; 
        c.gridy = 3;
        c.anchor = GridBagConstraints.CENTER;
        JLabel question = new JLabel("", SwingConstants.CENTER);
        question.setText(Study.list.get(Study.index).getQuestion());
        gridbag.setConstraints(question, c);
        add(question);
        
        c.gridwidth = 3;
        c.gridx = 4; 
        c.gridy = 4;
        c.anchor = GridBagConstraints.CENTER;
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        gridbag.setConstraints(separator, c);
        add(separator);
        
        c.gridx = 4; 
        c.gridy = 4;
        c.anchor = GridBagConstraints.PAGE_END;
        JLabel answer = new JLabel("", SwingConstants.CENTER);
        answer.setText(Study.list.get(Study.index).getAnswer());
        gridbag.setConstraints(answer, c);
        add(answer);
        
        c.gridwidth = 1;
        c.gridx = 5; 
        c.gridy = 5;
        c.anchor = GridBagConstraints.CENTER;
        JTextField userInput = new JTextField();
        gridbag.setConstraints(userInput, c);
        userInput.setVisible(false);
        add(userInput);
        
        ActionListener listener = new HideListener(easy, medium, hard, question, answer, userInput, swap, menuItems);
        easy.addActionListener(listener);
        medium.addActionListener(listener);
        hard.addActionListener(listener);
        
        for (int i = 0; i < menuItems.length; i++) {
            menuItems[i].addActionListener(listener);
        }
    }
}
