
package Windows.Study;

import ActionListeners.HideListener;
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


public class Show extends JPanel {

    private UISwapInterface swap;
    
    public ArrayList<Element> list;

    public Show(UISwapInterface swap, ArrayList<Element> list) {
        this.swap = swap;
        this.list = list;
        
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridbag);
        
        c.weightx = 4;
        c.weighty = 4;
        
        c.anchor = GridBagConstraints.LAST_LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 6; 
        c.gridy = 5;
        JButton easy = new JButton("Easy");
        gridbag.setConstraints(easy, c);
        add(easy);
        
        c.gridx = 5; 
        c.gridy = 5;
        JButton medium = new JButton("Medium");
        gridbag.setConstraints(medium, c);
        add(medium);
        
        c.gridx = 4; 
        c.gridy = 5;
        JButton hard = new JButton("Hard");
        gridbag.setConstraints(hard, c);
        add(hard);
        

        c.gridx = 5; 
        c.gridy = 3;
        c.anchor = GridBagConstraints.CENTER;
        JLabel question = new JLabel("", SwingConstants.CENTER);
        gridbag.setConstraints(question, c);
        question.setText(list.get(0).getQuestion());
        add(question);
        

        c.gridx = 5; 
        c.gridy = 4;
        c.anchor = GridBagConstraints.CENTER;
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        gridbag.setConstraints(separator, c);
        add(separator);
        
        c.gridx = 5; 
        c.gridy = 4;
        c.anchor = GridBagConstraints.PAGE_END;
        JLabel answer = new JLabel("", SwingConstants.CENTER);
        answer.setText(list.get(0).getAnswer());
        gridbag.setConstraints(answer, c);
        add(answer);
        
        c.ipady = 30;
        c.gridwidth = 1;
        c.gridx = 5; 
        c.gridy = 5;
        c.anchor = GridBagConstraints.CENTER;
        JTextField userInput = new JTextField();
        gridbag.setConstraints(userInput, c);
        add(userInput);
        
        ActionListener listener = new HideListener(easy, medium, hard, question, answer, userInput, swap, list);
        easy.addActionListener(listener);
        medium.addActionListener(listener);
        hard.addActionListener(listener);
        
        System.out.println("SHOW: " + "Q: " + question.isVisible() + "A:" + answer.isVisible());
    }
}
