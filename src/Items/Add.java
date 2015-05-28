
package Items;

import Constants.C;
import Windows_Study.Study;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Add extends JFrame {
    
    public Add() {
        setSize(C.SUB_W, C.SUB_H);
        setTitle("Add item");
        setLocationRelativeTo(null);
        setResizable(true);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public void open() {
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridbag);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 1;
        
        c.gridx = 1;
        c.gridy = 1;
        JLabel questionLabel = new JLabel("Question", SwingConstants.CENTER);
        gridbag.setConstraints(questionLabel, c);
        add(questionLabel);
        
        c.insets = new Insets(0, 30, 0, 30);
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        final JTextField question = new JTextField();
        gridbag.setConstraints(question, c);
        add(question);

        c.insets = new Insets(0, 0, 0, 0);
        c.gridwidth = 0;
        JLabel answerLabel = new JLabel("Answer", SwingConstants.CENTER);
        c.gridx = 1;
        c.gridy = 3;
        gridbag.setConstraints(answerLabel, c);
        add(answerLabel);

        c.insets = new Insets(0, 30, 0, 30);
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 4;
        final JTextField answer = new JTextField();
        gridbag.setConstraints(answer, c);
        add(answer);
        

        c.insets = new Insets(0, 30, 30, 30);
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridx = 1;
        c.gridy = 5;
        JButton addButton = new JButton("Add");
        addButton.setBackground(Color.white);
        gridbag.setConstraints(addButton, c);
        add(addButton);
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!answer.getText().isEmpty()) {
                    if (!question.getText().isEmpty()) {
                        Element item = new Element(question.getText(), answer.getText(), LocalDate.now());
                        Study.list.add(item);
                        question.setText("");
                        answer.setText("");
                    } else System.out.println("Error1");
                }
                
                else System.out.println("Error2");
            }
        });
    }
}

