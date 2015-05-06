package Main;

import ActionListeners.StudyListener;
import Elements.Element;
import Files.FileParser;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
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

public class StudyFrame extends JPanel {
    protected static int WINDOW_WIDTH = 500;
    protected static int WINDOW_HEIGHT = 500;
    protected static final String ICONPATH = "./Files/Icons/main.jpg";
    
    private String fName;
    private JFrame f = new JFrame(fName);
    private JPanel layoutPanel;
    
    public ArrayList<Element> list;

    public StudyFrame(String fName) {
        this.fName = fName;
        FileParser file = new FileParser(fName);
        try {
            list = file.loadFile();
        } catch (IOException | ParseException ex) {
            Logger.getLogger(StudyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void init() {
        layoutPanel = new StudyFrame(f, list);
        f.add(layoutPanel);
        ImageIcon icon = new ImageIcon(ICONPATH);
        f.setIconImage(icon.getImage());
        f.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
    public StudyFrame(JFrame f, ArrayList<Element> list) {
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridbag);
        
        c.weightx = 4;
        c.weighty = 4;
        c.anchor = GridBagConstraints.PAGE_END;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0; 
        c.gridy = 6;
        JButton check = buttonFactory("Check", gridbag, c);
        c.gridx = 1; 
        c.gridy = 6;
        JButton easy = buttonFactory("Easy", gridbag, c);
        c.gridx = 2; 
        c.gridy = 6;
        JButton medium = buttonFactory("Medium", gridbag, c);
        c.gridx = 3; 
        c.gridy = 6;
        JButton hard = buttonFactory("Hard", gridbag, c);

//        c.weightx = 2;
//        c.weighty = 2;
        c.gridx = 2;
        c.gridy = 4;
        c.anchor = GridBagConstraints.CENTER;
        JLabel question = labelFactory(gridbag, c);
        
        c.anchor = GridBagConstraints.CENTER;
        c.ipady = 30;
//        c.weightx = 1;
//        c.weightx = 1;
        c.gridwidth = 4;
        c.gridx = 0;
        c.gridy = 5;
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        gridbag.setConstraints(separator, c);
        add(separator);
        
//        c.weightx = 2;
//        c.weighty = 2;
        c.gridx = 2;
        c.gridy = 5;
        c.anchor = GridBagConstraints.PAGE_END;
        JLabel answer = labelFactory(gridbag, c);
        
        c.gridwidth = 2;
//        c.weightx = 2;
//        c.weighty = 2;
        c.gridx = 1;
        c.gridy = 6;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        JTextField userInput = new JTextField();
        gridbag.setConstraints(userInput, c);
        add(userInput); 
       

        
        // MENU START
        
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem menuAdd = new JMenuItem("Add");
        menuAdd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
        menuAdd.setEnabled(false);
        JMenuItem menuDel = new JMenuItem("Delete", KeyEvent.VK_DELETE);
        menuDel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));
        JMenuItem menuExit = new JMenuItem("Exit", KeyEvent.VK_E);
        menuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
        
        menuBar.add(menu);
        menu.add(menuAdd);
        menu.add(menuDel);
        menu.add(menuExit);
        f.setJMenuBar(menuBar);
        
        // MENU END
        
        addListeners(check, easy, medium, hard, question, answer, 
                       list, menuAdd, menuDel, menuExit); 
    }
    
    protected JButton buttonFactory(String name, GridBagLayout gridbag, GridBagConstraints c) {
        JButton button = new JButton(name);
        gridbag.setConstraints(button, c);
        add(button);
        return button;
    }
    
    protected JLabel labelFactory(GridBagLayout gridbag, GridBagConstraints c) {
        JLabel label = new JLabel();
        gridbag.setConstraints(label, c);
        add(label);
        return label;
    }
    
    protected void addListeners(JButton check, JButton easy, JButton medium, JButton hard,
                                JLabel question, JLabel answer, ArrayList<Element> list,
                                JMenuItem menuAdd, JMenuItem menuDel, JMenuItem menuExit) {
        
        ActionListener listener = new StudyListener(check, easy, medium, hard, question, answer, list);
        check.addActionListener(listener);
        easy.addActionListener(listener);
        medium.addActionListener(listener);
        hard.addActionListener(listener);
        menuAdd.addActionListener(listener);
        menuDel.addActionListener(listener);
        menuExit.addActionListener(listener);
    }
}