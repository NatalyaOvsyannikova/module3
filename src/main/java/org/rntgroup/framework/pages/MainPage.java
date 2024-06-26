package org.rntgroup.framework.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import org.rntgroup.framework.logger.AllureLogger;
import org.testng.Assert;

public class MainPage extends BasePage{
    private static final Logger logger= LogManager.getLogger(MainPage.class);
    @FindBy (css = "div[class^='AppHeader_profile__left']")
    private WebElement profileButton;

    @FindBy (xpath = "//button[starts-with(@class,'_grey-clear')]")
    private WebElement logout;
    private Actions actions;
    private JavascriptExecutor jsExecutor;

    public MainPage(WebDriver driver) {
        super(driver);
        actions = new Actions(driver);
        jsExecutor = (JavascriptExecutor) driver;
    }

    public MainPage clickProfileButton(){
        AllureLogger.debug("Go to Profile");
        waitForElementDisplayed(profileButton);
        jsExecutor.executeScript("arguments[0].click();", profileButton);
        //actions.moveToElement(profileButton).click().perform();
        return this;
    }


    public MainPage clickLogoutButton(){
        AllureLogger.debug("Click on Logout");
        waitForElementDisplayed(logout);
        Assert.assertTrue(logout.isDisplayed(), "Logout not found");
        logout.click();
        return this;
    }
}
