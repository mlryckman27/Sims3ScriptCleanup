package config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ConfigReader {
    private String Sims3DocsLocation;
    private File configFile;

    public ConfigReader() throws IOException {
        checkConfigExists();

    }

    public String getSims3DocsLocation() {
        return Sims3DocsLocation;
    }

    public void setSims3DocsLocation(String sims3DocsLocation) {
        this.Sims3DocsLocation = sims3DocsLocation;
    }

    public File getConfigFile() {
        return configFile;
    }

    public void setConfigFile(File configFile) {
        this.configFile = configFile;
    }

    /*
    Check if config.ini exists and create it if it does not.
    config.ini always created in the same directory as .jar executable.
     */
    private void checkConfigExists() throws IOException {
        configFile = new File("config.ini");
        boolean exists;
        if (!(exists = configFile.createNewFile()))
            System.out.println("Config file found.");
        else
            System.out.println("Config file not found.  Created config.ini.");
    }

    private void updateConfig() throws IOException {
        FileWriter configFileWriter = new FileWriter(getConfigFile());
    }

    private String readConfig() throws FileNotFoundException {
        String path = "";
        Scanner configScan = new Scanner(getConfigFile());
        configScan.delimiter().split("=");
        if (configScan.hasNext()) {
            path = configScan.next();
        }
        return path;
    }
}
