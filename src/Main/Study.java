package Main;

import ActionListeners.StudyListener;
import Elements.Element;
import Files.FileParser;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

public class Study {
    
    protected static final int WINDOW_WIDTH = 500;
    protected static final int WINDOW_HEIGHT = 500;
    protected static final String ICONPATH = "./Files/Icons/main.jpg";
       
    public JButton check;
    public JButton next;
    public JLabel question;
    public JLabel answer;
    public JTextField userInput;
    public JSeparator separator;
    public JMenuItem menuAdd;
    public JMenuItem menuDel;
    public JMenuItem menuExit;
    public JMenuBar menuBar;
    public JMenu menu;
    
    public int index = 0;
    
    public String fName;
    public ArrayList<Element> list;

    public Study(String fName) {
        this.fName = fName;
    }

    public void init() {
        
        // file validity start
        FileParser parse = new FileParser(fName);
        try {
            list = parse.loadFile();
            
        } catch (IOException ex) {
            Logger.getLogger(Study.class.getName()).log(Level.SEVERE, null, ex);
        }
        // file validity end
        
        JFrame frame = new JFrame(fName);
        frame.setLayout(null);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        ImageIcon icon = new ImageIcon(ICONPATH);
        frame.setIconImage(icon.getImage());
        
        // fonts
        
        Font font = new Font(Font.SERIF, Font.PLAIN, 30);
        
        // elements
        
        check = new JButton("Check");
        next = new JButton("Next");
        question = new JLabel("", SwingConstants.HORIZONTAL);
        answer = new JLabel("", SwingConstants.CENTER);
        userInput = new JTextField();
        separator = new JSeparator(SwingConstants.HORIZONTAL);
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        

        // settings
        
        check.setBounds(140, 400, 221, 35);
        next.setBounds(140, 400, 221, 35);
        question.setBounds(140, 80, 221, 50);
        answer.setBounds(140, 250, 221, 35);
        userInput.setBounds(140, 320, 221, 50);
        separator.setBounds(20, 220, 450, 20);
        question.setFont(font);
        answer.setFont(font);
        answer.setHorizontalAlignment(JTextField.CENTER);
        userInput.setFont(font);
        userInput.setActionCommand("Check");
        userInput.setHorizontalAlignment(JTextField.CENTER);
        
        
        
        next.setVisible(false);
        
        
        // add to frame
        
        frame.add(check);
        frame.add(next);
        frame.add(question);
        frame.add(answer);
        frame.add(userInput);
        frame.add(separator);
        
        // menu
        
        menuAdd = new JMenuItem("Add");
        menuAdd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
        menuAdd.setEnabled(false);
        menuDel = new JMenuItem("Delete", KeyEvent.VK_DELETE);
        menuDel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));
        menuExit = new JMenuItem("Exit", KeyEvent.VK_E);
        menuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
        
        menuBar.add(menu);
        menu.add(menuAdd);
        menu.add(menuDel);
        menu.add(menuExit);
        frame.setJMenuBar(menuBar);

        // actions
        
        ActionListener listener = new StudyListener(check, next, question, answer, userInput, list, index, fName);
        check.addActionListener(listener);
        next.addActionListener(listener);
        userInput.addActionListener(listener);
        menuAdd.addActionListener(listener);
        menuDel.addActionListener(listener);
        menuExit.addActionListener(listener);
        
        // Next can be invoked with "ENTER"
        InputMap im = next.getInputMap();
        im.put(KeyStroke.getKeyStroke("ENTER" ), "pressed" );
        im.put(KeyStroke.getKeyStroke("released ENTER" ), "released");
        
        
        frame.setVisible(true);
    }
}
