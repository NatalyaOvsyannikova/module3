package org.rntgroup.framework.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rntgroup.framework.logger.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{
    private static final Logger logger= LogManager.getLogger(ProfilePage.class);
    @FindBy(xpath = "//div[starts-with(@class,'ProfileView_personName')]")
    private WebElement nameElement;

    @FindBy(xpath = "div[class*='InfoPanel_infoPanel']>div:nth-child(2)>div:nth-child(2)")
    private WebElement statusField;

    @FindBy(xpath = "div[class*='InfoPanel_infoPanel']>div:nth-child(3)>div:nth-child(2)")
    private WebElement birthdayField;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getNameElement(){
       AllureLogger.debug("Get Full name");
       return nameElement;
    }

    public WebElement getStatusField(){
        AllureLogger.debug("Get status");
        return nameElement;
    }

    public WebElement getBirthdayField(){
        AllureLogger.debug("Get birthday");
        return nameElement;
    }

}
