package gui;

import javax.swing.*;
import java.awt.*;

public class GUI extends Frame {

    public GUI() {
        // panel = new JPanel();
        // panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        //panel.setLayout(new GridLayout(0, 1));

        TextField textField1 = new TextField();
        textField1.setBounds(50, 50, 150, 25);
        textField1.setEditable(true);

        //private JPanel panel = null;
        Button cleanButton = new Button();
        cleanButton.setBounds(200, 200, 50, 25);

        //add(panel);
        add(cleanButton); add(textField1);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("test0");

        setSize(600, 480);
        textField1.setVisible(true);
        cleanButton.setVisible(true);
        setVisible(true);
    }
}
