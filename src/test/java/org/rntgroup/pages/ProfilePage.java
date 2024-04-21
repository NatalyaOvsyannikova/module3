package org.rntgroup.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.rntgroup.AllureLogger;

public class ProfilePage extends BasePage{
    private static final Logger logger= LogManager.getLogger(ProfilePage.class);
    @FindBy(xpath = "//div[starts-with(@class,'ProfileView_personName')]")
    private WebElement nameElement;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getName(){
       AllureLogger.debug("Get Full name");
       return nameElement;
    }

}
