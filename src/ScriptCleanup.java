import config.ConfigReader;
import gui.GUI;

import java.io.IOException;

public class ScriptCleanup {

    public static void main(String[] args) throws IOException {
        GUI testGUI = new GUI();
        ConfigReader testConfigReader = new ConfigReader();

        System.out.println("This is a test...");

    }
}


/*
TODO:
 - use ConfigReader class in GUI class to create a ConfigReader object as an attribute in GUI class.
 */