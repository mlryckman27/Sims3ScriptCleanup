package gui;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
        Button updateButton = new Button();
        updateButton.setBounds(252, 50, 50, 25);
        updateButton.setLabel("Update");

        add(cleanButton); add(updateButton); add(textField1);
        setLayout(null);
        setTitle("NRAAS ErrorTrap ErrorScript Cleanup Tool");

        setSize(600, 480);
        textField1.setVisible(true); cleanButton.setVisible(true); updateButton.setVisible(true);
        setVisible(true);

        config = new ConfigReader();
        textField1.setText(getConfig().getSims3DocsLocation());


        cleanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: implement clean action to remove all ErrorScript XML files and condense into one file
                File directory = new File(config.getSims3DocsLocation());
                File[] fileList = directory.listFiles();

                for (File file : fileList) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                        if (file.getName().contains("delete")) {
                            System.out.println("Delete File:" + file.getName());
                            file.delete();
                        }
                    }
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    config.saveConfig(textField1.getText());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }


    // Getters/Setters

    public ConfigReader getConfig() {
        return config;
    }

    public void setConfig(ConfigReader config) {
        this.config = config;
    }


    // WindowListener methods

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
