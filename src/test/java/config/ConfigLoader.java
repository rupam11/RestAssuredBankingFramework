package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    public static Properties loadProperties(String filePath) {
        Properties props = new Properties();
        try {
            FileInputStream input = new FileInputStream(filePath);
            props.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }
}
