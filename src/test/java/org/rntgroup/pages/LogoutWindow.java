package org.rntgroup.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.rntgroup.AllureLogger;
import org.testng.Assert;

public class LogoutWindow extends BasePage{
    private static final Logger logger= LogManager.getLogger(LogoutWindow.class);
    @FindBy (css = "button[class^='_grey-outline']")
    private WebElement logoutButton;
    private Actions actions;
    public LogoutWindow(WebDriver driver) {
        super(driver);
        actions = new Actions(driver);
    }

    public LogoutWindow clickLogoutButtonViaActions(){
        AllureLogger.debug("Click Logout");
        waitForElementDisplayed(logoutButton);
        Assert.assertTrue(logoutButton.isDisplayed(), "Logout button not found");
        actions.moveToElement(logoutButton).click().perform();
        return this;
    }
}
