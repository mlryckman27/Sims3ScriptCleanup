package gui;


import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileWriter;
import java.io.IOException;

import config.ConfigReader;


public class GUI extends Frame implements WindowListener {


    // Attributes
    ConfigReader config;


    // Constructor method
    public GUI() throws IOException {

        addWindowListener(this);

        TextField textField1 = new TextField();
        textField1.setBounds(50, 50, 150, 25);
        textField1.setEditable(true);

        Button cleanButton = new Button();
        cleanButton.setBounds(200, 50, 50, 25);
        cleanButton.setLabel("Clean");

        add(cleanButton); add(textField1);
        setLayout(null);
        setTitle("test0");

        setSize(600, 480);
        textField1.setVisible(true);
        cleanButton.setVisible(true);
        setVisible(true);

        config = new ConfigReader();
        textField1.setText(getConfig().readConfigTest());

        //config = new ConfigReader();
        //textField1.setText(getConfig().readConfig());
        //textField1.setText("text");

    }


    // Getters/Setters

    public ConfigReader getConfig() {
        return config;
    }

    public void setConfig(ConfigReader config) {
        this.config = config;
    }


    // Methods

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Window opened");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Window closing");
        dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("Window closed");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("Window iconified");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("Window de-iconified");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("Window activated");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("Window deactivated");
    }
}
