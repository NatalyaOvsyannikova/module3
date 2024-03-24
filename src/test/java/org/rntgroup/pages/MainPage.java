package org.rntgroup.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.testng.Assert;

public class MainPage extends BasePage{

    @FindBy (css = "div[class^='AppHeader_mobile__navigation']>button:nth-child(3)")
    private WebElement profileButton;

    @FindBy (xpath = "//div[starts-with(@class,'UserInfo_dropdown')]")
    private WebElement userInfoButton;

    @FindBy (css = "div[class^='UserInfo_dropdownLine']")
    private WebElement logoutLine;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage clickProfileButton(){
        waitForElementDisplayed(profileButton);
        profileButton.click();
        return this;
    }

    public MainPage clickUserInfoButton(){
        waitForElementDisplayed(userInfoButton);
        Assert.assertTrue(userInfoButton.isDisplayed(), "User info button not found");
        userInfoButton.click();
        return this;
    }

    public MainPage clickLogoutLine(){
        waitForElementDisplayed(logoutLine);
        Assert.assertTrue(logoutLine.isDisplayed(), "Logout not found");
        logoutLine.click();
        return this;
    }
}
