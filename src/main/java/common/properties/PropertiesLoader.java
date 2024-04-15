package common.properties;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Logger;

public final class PropertiesLoader {
    private static final Logger LOG = Logger.getLogger(PropertiesLoader.class.getName());
    private static PropertiesLoader propertiesLoader;

    private PropertiesLoader() {
    }

    public static PropertiesLoader getInstance() {
        if (Objects.isNull(propertiesLoader)) {
            propertiesLoader = new PropertiesLoader();
        }
        return propertiesLoader;
    }

    public void loadProperties() {
        Properties global = readProperties(new Properties(), "global.properties");
        Properties user = readProperties(global, "user.properties");
        saveToSystem(user);
    }

    private Properties readProperties(Properties properties, String propertiesPath) {
        try (var inputStream = PropertiesLoader.class.getClassLoader().getResourceAsStream(propertiesPath)) {
            properties.load(inputStream);
        } catch (IOException e) {
            LOG.warning("Properties not read " + e);
        }
        return properties;
    }

    private void saveToSystem(Properties properties) {
        properties.stringPropertyNames().forEach(propertyName -> {
            boolean propertyIsInSystemVariables = System.getProperties().containsKey(propertyName);
            if (!propertyIsInSystemVariables) {
                System.setProperty(propertyName, properties.getProperty(propertyName));
            }
        });
    }
}
