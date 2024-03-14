package org.rntgroup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.PropertyReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import java.util.Properties;

public abstract class BaseAppTest {
    WebDriver webDriver;
    @BeforeClass(alwaysRun = true)
    public void setUp() throws IOException {
        webDriver = new ChromeDriver();
        webDriver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
        authorization(webDriver);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {

        webDriver.quit();
    }

    private static void authorization(WebDriver webDriver) throws IOException {
        Properties appProps = PropertyReader.readProperties();
        String loginName = appProps.getProperty("login");
        String passwordValue = appProps.getProperty("password");

        webDriver.get("https://hrp-test.app-test-001.nlmk.com/");

        WebElement login = webDriver.findElement(new By.ById("login"));
        login.sendKeys(loginName);
        WebElement password = webDriver.findElement(new By.ById("password"));
        password.sendKeys(passwordValue);
        WebElement button = webDriver.findElement(new By.ById("bind"));
        button.click();
    }

//    private static Properties getAppProps() throws IOException {
//        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
//        String appConfigPath = rootPath + "resources.properties";
//        Properties appProps = new Properties();
//        appProps.load(new FileInputStream(appConfigPath));
//        //   File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("resources.properties")).getFile());
//        // Properties appProps = new Properties();
//        //  appProps.load(new FileInputStream(file));
//        return appProps;
//    }
}
