package org.rntgroup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import static org.rntgroup.pages.LoginPage.authorization;
@Listeners({FailedTestListener.class})
public abstract class BaseAppTest {
    WebDriver webDriver;
    private static final Logger logger= LogManager.getLogger(BaseAppTest.class);
    @BeforeClass(alwaysRun = true)
    public void setUp(ITestContext context) throws IOException {
        AllureLogger.info("Set Up");
        // Установка удаленного URL-адреса удаленного сервера Selenium Grid или облачного провайдера
        //URL remoteUrl = new URL("http://localhost:4444");

        // Установка желаемых capabilities для нужного браузера
        /*DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.ANY);
        desiredCapabilities.setBrowserName("chrome");
        ChromeOptions options = new ChromeOptions();
        options.merge(desiredCapabilities);*/

        // Создание экземпляра RemoteWebDriver с указанными удаленным URL-адресом и capabilities
        //webDriver = new RemoteWebDriver(remoteUrl, desiredCapabilities);

        webDriver = new ChromeDriver();
        context.setAttribute("WebDriver", webDriver);
        webDriver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        authorization(webDriver);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        AllureLogger.info("Clean Up");
        webDriver.quit();
    }

}
