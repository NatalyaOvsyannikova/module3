package org.rntgroup.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.rntgroup.AllureLogger;
import org.rntgroup.AppTest;

import java.time.Duration;

public class BasePage {
    private static final Logger logger= LogManager.getLogger(BasePage.class);
    protected WebDriver driver;

    public BasePage (WebDriver driver){
        AllureLogger.info("Init driver");
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    protected void waitForElementDisplayed(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));
    }
}
