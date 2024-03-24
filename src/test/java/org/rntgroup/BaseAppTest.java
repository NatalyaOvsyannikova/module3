package org.rntgroup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.rntgroup.pages.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.PropertyReader;

import java.io.IOException;
import java.time.Duration;
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

        LoginPage loginPage=new LoginPage(webDriver);
        loginPage.inputLoginViaJsExecutor(loginName)
                .inputPasswordViaActions(passwordValue)
                .clickLogin();
    }

}
