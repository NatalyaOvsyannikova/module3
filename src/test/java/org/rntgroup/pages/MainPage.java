package org.rntgroup.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import org.rntgroup.AllureLogger;
import org.rntgroup.AppTest;
import org.testng.Assert;

public class MainPage extends BasePage{
    private static final Logger logger= LogManager.getLogger(MainPage.class);
    @FindBy (css = "div[class^='AppHeader_profile__left']")
    private WebElement profileButton;

    @FindBy (xpath = "//div[starts-with(@class,'UserInfo_dropdown')]")
    private WebElement userInfoButton;

    @FindBy (css = "div[class^='UserInfo_dropdownLine']")
    private WebElement logoutLine;
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

    public MainPage clickUserInfoButton(){
        AllureLogger.debug("Open User info menu");
        waitForElementDisplayed(userInfoButton);
        Assert.assertTrue(userInfoButton.isDisplayed(), "User info button not found");
        actions.click(userInfoButton).perform();
        return this;
    }

    public MainPage clickLogoutLine(){
        AllureLogger.debug("Click on Logout");
        waitForElementDisplayed(logoutLine);
        Assert.assertTrue(logoutLine.isDisplayed(), "Logout not found");
        logoutLine.click();
        return this;
    }
}
