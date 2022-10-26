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
    - separate aggregateXML into its own class (AggregateXML) to manage parsing and separating aggregateXML log back into individual ScriptError logs.
    - make the viewPort update the text from aggregateXML.xml
    - comment and label code blocks for future expansion and maintenance.
 */