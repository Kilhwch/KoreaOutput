package Windows;

import Files.FileNames;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class MainF extends JPanel {

    protected static final int WINDOW_WIDTH = 500;
    protected static final int WINDOW_HEIGHT = 500;
    protected static final String ICONPATH = "./Files/Icons/main.jpg";
    protected static final String TITLE = "KoreaOutput";
    
    
    public static void main(String[] args) {
        JFrame f = new JFrame(TITLE);
        JPanel pane = new MainF(f);
        f.add("Center", pane);
        
        ImageIcon icon = new ImageIcon(ICONPATH);
        f.setIconImage(icon.getImage());
        f.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setResizable(true);
        f.setVisible(true);
    }
    
    public MainF(JFrame f) {
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridbag);
        
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 1;
        c.gridy = 1;
        DefaultListModel model = new DefaultListModel();
        
        
        File[] files = new FileNames().getAll();
        
        for (File file : files) {
            model.addElement(file.getName().substring(0, file.getName().length() - 4));
        }
        
        JList list = new JList(model);
        DefaultListCellRenderer renderer =  (DefaultListCellRenderer)list.getCellRenderer();  
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(-1);
        list.setFixedCellWidth(200);
        list.setBorder(new LineBorder(Color.BLACK));
        gridbag.setConstraints(list, c);
        add(list);
        
        JButton start = new JButton("Start");
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridx = 1;
        c.gridy = 2;
        gridbag.setConstraints(start, c);
        add(start);
    }
}

// Next time: 1. Make the main menu with dropdown submenus (import file, exit)
//            2. Make a list of all the items @ /Files and load them when the
//               program is launched