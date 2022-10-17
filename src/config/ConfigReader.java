package config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Scanner;

public class ConfigReader {
    private String Sims3DocsLocation;
    private File configFile;

    public ConfigReader() throws IOException {
        init();

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
    private void init() throws IOException {
        configFile = new File("config.ini");
        boolean exists;
        if (!(exists = configFile.createNewFile()))
            System.out.println("Config file found.");
        else {
            System.out.println("Config file not found.  Created config.ini.");
            Files.write(Paths.get("config.ini"), Collections.singleton(""), StandardCharsets.UTF_8);
        }

        readConfig();
    }

    private String readConfig() throws FileNotFoundException {
        String path = "";
        Scanner configScan = new Scanner(getConfigFile());
        configScan.delimiter().split("=");

        if (configScan.hasNext()) {
            String line = configScan.next();
            int index = line.indexOf("=") + 1;
            path = line.substring(index);
        }
        else {
            path = "";
        }

        setSims3DocsLocation(path);

        return path;
    }

    public void saveConfig(String path) throws IOException {
        Files.write(Paths.get("config.ini"), Collections.singleton("Sims3Path=" + path), StandardCharsets.UTF_8);
    }

    // TEST METHODS
//    public String readConfigTest() throws FileNotFoundException {
//        String path = "";
//        Scanner configScan = new Scanner(getConfigFile());
//        configScan.delimiter().split("=");
//        path = configScan.next();
//        return path;
//    }
}
