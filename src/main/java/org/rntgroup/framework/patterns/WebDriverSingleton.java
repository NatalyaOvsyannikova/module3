package org.rntgroup.framework.patterns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {
    private static WebDriver driver;

    private WebDriverSingleton() {
        // Приватный конструктор для предотвращения создания других экземпляров
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver(); // Инициализация веб-драйвера (может быть любой другой драйвер)
        }
        return driver;
    }
}
