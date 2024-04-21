package org.rntgroup.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.rntgroup.AllureLogger;
import utils.PropertyReader;

import java.io.IOException;
import java.util.Properties;

public class LoginPage extends BasePage{
    private static final Logger logger= LogManager.getLogger(LoginPage.class);
    @FindBy (id = "login")
    private WebElement login;

    @FindBy (id = "password")
    private WebElement password;

    @FindBy (id = "bind")
    private WebElement clickLogin;

    @FindBy (xpath = "//h1[starts-with(@class,'page-title')]")
    private WebElement signIn;
    private JavascriptExecutor jsExecutor;
    private Actions actions;

    public LoginPage(WebDriver driver) {
        super(driver);
        jsExecutor = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    public LoginPage inputLoginViaJsExecutor(String value){
        AllureLogger.debug("Input Login " + value);
        waitForElementDisplayed(login);
        String script = "arguments[0].setAttribute('value',arguments[1])";
        jsExecutor.executeScript(script, login, value);
        return this;
    }

    public LoginPage inputPasswordViaActions (String value){
        AllureLogger.debug("Input Password");
        actions.sendKeys(password, value).perform();
        //password.sendKeys(value);
        return this;
    }

    public void clickLogin (){
        AllureLogger.debug("Click Login");
        clickLogin.click();
    }

    public String getSignInText (){
        AllureLogger.debug("get Sign In text");
        waitForElementDisplayed(signIn);
        return signIn.getText();
    }

    public static void authorization(WebDriver webDriver) throws IOException {
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
