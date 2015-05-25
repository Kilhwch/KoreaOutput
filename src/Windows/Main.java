package Windows;

import Constants.C;
import Files.FileNames;
import SaveAndClose.SaveAndClose;
import Windows_Study.Study;
import Windows_Submenus.MainMenu;
import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Main extends JPanel {
    
    public static void main(String[] args) {
        final JFrame frame = new JFrame(C.TITLE);
        JPanel pane = new Main(frame);
        frame.add("Center", pane);
        
        JMenuBar menu = new MainMenu();
        frame.setJMenuBar(menu);
        ImageIcon icon = new ImageIcon(C.ICONPATH);
        frame.setIconImage(icon.getImage());
        frame.setSize(C.WINDOW_WIDTH, C.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
    }
    
    public Main(final JFrame frame) {
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridbag);
        
        c.insets = new Insets(0, 0, 30, 0);
        c.fill = GridBagConstraints.HORIZONTAL;
        JSeparator top = new JSeparator(JSeparator.HORIZONTAL);
        c.gridx = 1;
        c.gridy = 1;
        gridbag.setConstraints(top, c);
        add(top);
        
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.PAGE_START;
        c.gridx = 1;
        c.gridy = 2;
        JLabel label = new JLabel("Choose a file: ");
        gridbag.setConstraints(label, c);
        add(label);
        
        c.insets = new Insets(10, 0, 10, 0);
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 1;
        c.gridy = 3;

        DefaultListModel model = new DefaultListModel();
        final File[] files = new FileNames().getAll();
        
        for (File file : files) {
            model.addElement(file.getName().substring(0, file.getName().length() - C._TXT));
        }
        
        final JList list = new JList(model);
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
        start.setBackground(Color.white);
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 1;
        c.gridy = 4;
        gridbag.setConstraints(start, c);
        add(start);
        
        c.insets = new Insets(30, 0, 0, 0);
        c.anchor = GridBagConstraints.PAGE_END;
        c.fill = GridBagConstraints.HORIZONTAL;
        JSeparator bottom = new JSeparator(JSeparator.HORIZONTAL);
        c.gridx = 1;
        c.gridy = 5;
        gridbag.setConstraints(bottom, c);
        add(bottom);
        
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list.getSelectedIndex() != -1) {
                    Study study;
                    try {
                        study = new Study(files[list.getSelectedIndex()].getName());
                        frame.setVisible(false);
                        study.windowInit();
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
}