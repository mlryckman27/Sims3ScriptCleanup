package gui;


import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class GUI extends Frame implements WindowListener {

    // Attributes

    // Constructor method
    public GUI() {

        addWindowListener(this);

        TextField textField1 = new TextField();
        textField1.setBounds(50, 50, 150, 25);
        textField1.setEditable(true);

        Button cleanButton = new Button();
        cleanButton.setBounds(200, 200, 50, 25);

        add(cleanButton); add(textField1);
        setLayout(null);
        setTitle("test0");

        setSize(600, 480);
        textField1.setVisible(true);
        cleanButton.setVisible(true);
        setVisible(true);
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
