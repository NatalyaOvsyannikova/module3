package org.rntgroup.framework.patterns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;

public class PropertyReaderSingleton {
    private static Properties Properties;

    private PropertyReaderSingleton() {
        // Приватный конструктор для предотвращения создания других экземпляров
    }

    public static Properties getProperties() {
        if (Properties == null) {
            Properties = new Properties();
        }
        return Properties;
    }
}
