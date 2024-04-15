package org.rntgroup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import static org.rntgroup.pages.LoginPage.authorization;

public abstract class BaseAppTest {
    WebDriver webDriver;
    private static final Logger logger= LogManager.getLogger(BaseAppTest.class);
    @BeforeClass(alwaysRun = true)
    public void setUp() throws IOException {
        logger.info("Set Up");
        // Установка удаленного URL-адреса удаленного сервера Selenium Grid или облачного провайдера
        URL remoteUrl = new URL("http://localhost:4444");

        // Установка желаемых capabilities для нужного браузера
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.ANY);
        desiredCapabilities.setBrowserName("chrome");
        ChromeOptions options = new ChromeOptions();
        options.merge(desiredCapabilities);

        // Создание экземпляра RemoteWebDriver с указанными удаленным URL-адресом и capabilities
        webDriver = new RemoteWebDriver(remoteUrl, desiredCapabilities);

        //webDriver = new ChromeDriver();
        webDriver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
        authorization(webDriver);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        logger.info("Clean Up");
        webDriver.quit();
    }



}
