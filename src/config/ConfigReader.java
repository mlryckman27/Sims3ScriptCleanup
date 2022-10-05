package config;

import java.io.File;
import java.io.IOException;

public class ConfigReader {
    private String Sims3DocsLocation;

    public ConfigReader() throws IOException {
        checkConfigExists();
    }

    public String getSims3DocsLocation() {
        return Sims3DocsLocation;
    }

    public void setSims3DocsLocation(String sims3DocsLocation) {
        Sims3DocsLocation = sims3DocsLocation;
    }

    private void checkConfigExists() throws IOException {
        File configFile = new File("config.ini");
        boolean exists;
        if (!(exists = configFile.createNewFile()))
            System.out.println("Config file found.");
        else
            System.out.println("Config file not found.  Created config.ini.");
    }

    private void readConfig() {

    }
}
