package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file");
        }
    }

    public static String getConfigValue(String key) {
        return properties.getProperty(key);
    }
}
