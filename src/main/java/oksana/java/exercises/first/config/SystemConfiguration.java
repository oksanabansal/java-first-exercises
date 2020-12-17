package oksana.java.exercises.first.config;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SystemConfiguration {
    private final Properties properties;

    public SystemConfiguration() {
        this.properties = new Properties();
        this.loadProperties();
    }

    public void loadProperties() {
        String envProfile = System.getProperty("environment-profile");
        if (StringUtils.isBlank(envProfile)) {
            envProfile = "prod";
        }
        InputStream environmentFileStream = getClass().getClassLoader().getResourceAsStream("system_" + envProfile + ".properties");
        try {
            properties.load(environmentFileStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String name) {
        return properties.getProperty(name);

    }


}
