package gui;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Scanner;

import config.ConfigReader;

import static java.nio.file.StandardOpenOption.APPEND;


public class GUI extends Frame implements WindowListener {


    // Attributes
    ConfigReader config;

    TextArea viewPort;


    // Constructor method
    public GUI() throws IOException {

        init();

        addWindowListener(this);

        TextField simsPath = new TextField();
        simsPath.setBounds(50, 50, 150, 25);
        simsPath.setEditable(true);

        viewPort = new TextArea();
        viewPort.setBounds(50, 100, 500, 300);
        viewPort.setEditable(false);

        Button cleanButton = new Button();
        cleanButton.setBounds(200, 50, 75, 25);
        cleanButton.setLabel("Clean Logs");
        Button updateButton = new Button();
        updateButton.setBounds(277, 50, 75, 25);
        updateButton.setLabel("Set Path");

        add(cleanButton); add(updateButton); add(simsPath); add(viewPort);
        setLayout(null);
        setTitle("NRAAS ErrorTrap ErrorScript Cleanup Tool");

        setSize(600, 480);
        simsPath.setVisible(true); viewPort.setVisible(true);
        cleanButton.setVisible(true); updateButton.setVisible(true);
        setVisible(true);

        config = new ConfigReader();
        simsPath.setText(getConfig().getSims3DocsLocation());

        viewAggregateXML(new File("aggregateXML.xml"));

        cleanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: implement clean action to remove all ErrorScript XML files and condense into one file
                File directory = new File(config.getSims3DocsLocation());
                File[] fileList = directory.listFiles();

                for (File file : fileList) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                        if (file.getName().contains("ScriptError") && file.getName().contains(".xml")) {
                            try {
                                updateAggregateXML(file);
                                //viewPort.setText();
                                viewAggregateXML(new File("aggregateXML.xml"));
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
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
                    config.saveConfig(simsPath.getText());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }


    // Helper methods

    private void init() throws IOException {
        File aggregateXML = new File("aggregateXML.xml");
        boolean exists = false;
        if (!(exists = aggregateXML.createNewFile())) {
            System.out.println("Aggregate XML log found.");
        }
        else {
            System.out.println("Aggregate XML log no found... creating log.");
            aggregateXML.createNewFile();
            Files.writeString(Paths.get(aggregateXML.toURI()), "", StandardCharsets.UTF_8, APPEND);
        }
    }

    private void updateAggregateXML(File file) throws IOException {
        File aggregateXML = new File("aggregateXML.xml");
        boolean exists;
        Path path = Paths.get("aggregateXML.xml");
        if (exists = aggregateXML.exists()) {
            aggregateXML.canWrite();
        }
        else {
            Files.write(path, Collections.singleton(""), StandardCharsets.UTF_8);
        }

        Scanner scan = new Scanner(file);
        String line;

        while (scan.hasNextLine()) {
            line = scan.nextLine();
            Files.writeString(path, line + '\n', StandardCharsets.UTF_8, APPEND);
        }
        scan.close();
    }

    private void viewAggregateXML(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        String viewPortText = "";
        while (scan.hasNextLine()) {
            viewPortText = viewPortText + scan.nextLine() + '\n';
            //viewPort.append(scan.nextLine());
            //viewPort.append("\n");
        }
        viewPort.setText(viewPortText);
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
