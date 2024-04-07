package org.rntgroup.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{

    @FindBy(xpath = "//div[starts-with(@class,'ProfileView_personName')]")
    private WebElement nameElement;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getName(){
       return nameElement;
    }

}
