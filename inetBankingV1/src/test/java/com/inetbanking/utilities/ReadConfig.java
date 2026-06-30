package com.inetbanking.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    Properties prop;

    public ReadConfig() {
        try {
            FileInputStream fis = new FileInputStream("./Configuration/config.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (IOException e) {
            System.out.println("Error loading config.properties: " + e.getMessage());
        }
    }

    public String getApplicationURL() {
        return prop.getProperty("baseUrl");
    }

    public String getUsername() {
        return prop.getProperty("username");
    }

    public String getPassword() {
        return prop.getProperty("password");
    }

    public String getBrowser() {
        return prop.getProperty("browser");
    }

    public int getImplicitWait() {
        return Integer.parseInt(prop.getProperty("implicitWait"));
    }
}
