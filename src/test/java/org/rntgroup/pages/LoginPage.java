package org.rntgroup.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage{

    @FindBy (id = "login")
    private WebElement login;

    @FindBy (id = "password")
    private WebElement password;

    @FindBy (id = "bind")
    private WebElement clickLogin;

    @FindBy (xpath = "//h1[starts-with(@class,'page-title')]")
    private WebElement signIn;
    private JavascriptExecutor jsExecutor;

    public LoginPage(WebDriver driver) {
        super(driver);
        jsExecutor = (JavascriptExecutor) driver;
    }

    public LoginPage inputLoginViaJsExecutor(String value){
        waitForElementDisplayed(login);
        String script = "arguments[0].setAttribute('value',arguments[1])";
        jsExecutor.executeScript(script, login, value);
        return this;
    }

    public LoginPage inputPassword (String value){
        password.sendKeys(value);
        return this;
    }

    public void clickLogin (){
        clickLogin.click();
    }

    public LoginPage validateSignIn (String value){
        waitForElementDisplayed(signIn);
        Assert.assertTrue(signIn.getText().contains(value), "Sign in is not displayed");
        return this;
    }
}
