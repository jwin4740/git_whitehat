package com.winkle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class Configuration {
    private Properties prop = new Properties();
    private InputStream input = null;
    private HashMap<String, String> map = new HashMap<String, String>();

    private void setProperties() {
        try {

            input = new FileInputStream("config.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out

            map.put("repoDiv", prop.getProperty("repoDiv"));

            map.put("baseUrl", prop.getProperty("baseUrl"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public HashMap<String, String> getProperties (){
        setProperties();
        return this.map;
    }

}
