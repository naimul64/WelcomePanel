package propertyReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyReader {
    public static String getProperty(String propertyKey, Object defaultValue) {

        Properties prop = new Properties();
        InputStream input = null;

        try {
            Path configFilePath = Paths.get("config.property");

            URL url = PropertyReader.class.getResource(configFilePath.toString());
            input = url.openStream();

            // load a properties file
            prop.load(input);
            input.close();

            // get the property value and print it out
            return prop.getProperty(propertyKey);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
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