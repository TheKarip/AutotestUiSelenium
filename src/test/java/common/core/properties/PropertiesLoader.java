package common.core.properties;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public final class PropertiesLoader {
    private static final Logger LOG = Logger.getLogger(PropertiesLoader.class.getName());
    public static final Properties PROPERTIES = new Properties();

    private PropertiesLoader() {
    }
    
    static {
        loadProperties();
    }

    public static String get(String key) {
       return PROPERTIES.getProperty(key);
    }

    private static void loadProperties() {
        readProperties("global.properties");
        readProperties("user.properties");
    }

    private static void readProperties(String propertiesPath) {
        try(var inputStream = PropertiesLoader.class.getClassLoader().getResourceAsStream(propertiesPath)) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            LOG.warning("Properties not read " + e);
        }
    }
}
