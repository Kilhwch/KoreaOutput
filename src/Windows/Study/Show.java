
package Windows.Study;

import ActionListeners.HideListener;
import Elements.Element;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;


public class Show extends JPanel {

    private static final String HIDE = "hide";
    private UISwapInterface swap;
    
    public ArrayList<Element> list;

    public Show(UISwapInterface swap, ArrayList<Element> list) {
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
        question.setText(list.get(0).getQuestion());
        gridbag.setConstraints(question, c);
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
        final JLabel answer = new JLabel("", SwingConstants.CENTER);
        answer.setText(list.get(0).getAnswer());
        answer.setVisible(true);
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
        
        addListeners(easy, medium, hard, swap);
    }
    
    protected void addListeners(JButton easy, JButton medium, JButton hard, UISwapInterface swap) {
        ActionListener listener = new HideListener(easy, medium, hard, swap);
        easy.addActionListener(listener);
        medium.addActionListener(listener);
        hard.addActionListener(listener);
    }
}
