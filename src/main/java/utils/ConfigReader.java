package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigReader {
    private static Properties props = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream("src/main/resources/config.properties");
            props.load(file);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static int getInt(String key) {
        String value = get(key);
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("The value for key '" + key + "' is not a valid integer: " + value);
        }
    }

    public static String getPath(String key) {
        String relativePath = get(key);
        Path absolutePath = Paths.get(relativePath).toAbsolutePath();
        return absolutePath.toString();
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
