import gui.GUI;
import java.io.IOException;


public class ScriptCleanup {

    public static void main(String[] args) throws IOException {
        GUI testGUI = new GUI();

        // TEST SPACE
//        String testLine = "Sims3Path=";
//        Files.write(Paths.get("config.txt"), Collections.singleton(testLine), StandardCharsets.UTF_8);
    }
}


/*
TODO:
 - use ConfigReader class in GUI class to create a ConfigReader object as an attribute in GUI class.
 - finish implementing ConfigReader methods into GUI class.
 - Gui class should read path location from config file and set textbox in GUI accordingly.
 - GUI class should be able to update config file with text from textbox (path to Sims 3 docs).
 - comment applicable methods and attributes in GUI and ConfigReader class
 - comment main class as needed
 */