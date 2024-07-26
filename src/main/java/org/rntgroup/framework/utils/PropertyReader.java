package org.rntgroup.framework.utils;

import org.rntgroup.framework.patterns.PropertyReaderSingleton;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private final static String defPropFile = "resources.properties";

    public static Properties readProperties(String fileName) {
        Properties p = PropertyReaderSingleton.getProperties();
        try(InputStream inputStream = PropertyReader.class.getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream == null) {
                return null;
            }
            p.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }
    public static Properties readProperties() {
        return readProperties(defPropFile);
    }
}
