package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    // Static block to initialize the properties object
    static {
        try {
            // Load the properties file
            FileInputStream input = new FileInputStream("src\\main\\resources\\config.properties");
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            // Print the stack trace if an IOException occurs during loading
            e.printStackTrace();
        }
    }

    // Method to get the value of a property based on the key
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
