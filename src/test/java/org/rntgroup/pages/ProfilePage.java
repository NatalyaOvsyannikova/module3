package org.rntgroup.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProfilePage extends BasePage{

    @FindBy(xpath = "//div[starts-with(@class,'ProfileView_personName')]")
    private WebElement nameElement;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public ProfilePage validateName(String value){
        Assert.assertTrue(nameElement.isDisplayed(), "Full name not found");
        Assert.assertTrue(nameElement.getText().contains(value), "Incorrect name:" + nameElement.getText());
        return this;
    }

}
