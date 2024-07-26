package org.rntgroup.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.rntgroup.framework.business.User;
import org.rntgroup.framework.patterns.WebDriverSingleton;
import org.rntgroup.framework.utils.PropertyReader;
import org.rntgroup.framework.listeners.FailedTestListener;
import org.rntgroup.framework.logger.AllureLogger;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static org.rntgroup.framework.pages.LoginPage.authorization;
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

        webDriver = WebDriverSingleton.getDriver();
        context.setAttribute("WebDriver", webDriver);
        webDriver.manage().window().maximize();
        webDriver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        Properties appProps = PropertyReader.readProperties();
        User user = new User(appProps.getProperty("login"), appProps.getProperty("password"));
        authorization(webDriver, user.getLogin(), user.getPassword());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        AllureLogger.info("Clean Up");
        webDriver.quit();
    }

}
