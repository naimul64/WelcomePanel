package propertyReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyReader {
    public static String getProperty(String propertyKey, Object defaultValue) {

        Properties prop = new Properties();
        InputStream input = null;

        try {
            Path configFilePath = Paths.get(System.getProperty("user.dir"), "assets", "config", "config.property");
            input = new FileInputStream(configFilePath.toString());

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            return prop.getProperty(propertyKey);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return defaultValue.toString();
    }
}