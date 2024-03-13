package org.rntgroup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AppTest extends BaseAppTest
{
   @Test(description ="Check_title")
    public void test1 () {

       String title = webDriver.getTitle();
       Assert.assertTrue(title.contains("HR Portal"), "Title is incorrect");

   }

   @Test(description ="Check_name")
   public void test2 () {
      Wait<WebDriver> wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
      WebElement profileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button._text_1nnp8_152._button_1nnp8_1.AppHeader_navButton__MRJQD:nth-child(3)")));
      profileButton.click();
      WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(@class,'ProfileView_personName')]")));
      String name = nameElement.getText();
      Assert.assertTrue(nameElement.isDisplayed(), "Full name not found");
      Assert.assertTrue(name.contains("Овсянникова Наталья Николаевна"), "Incorrect name:" + nameElement.getText());

   }

   @Test(description ="Logout")
   public void test3 () {

      Wait<WebDriver> wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
      WebElement userInfoButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(@class,'UserInfo_dropdown')]")));
      Assert.assertTrue(userInfoButton.isDisplayed(), "User info button not found");

      userInfoButton.click();
      WebElement logoutLine = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.UserInfo_dropdownLine__96gf-")));
      Assert.assertTrue(logoutLine.isDisplayed(), "Logout not found");

      logoutLine.click();
      WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button._greyOutline_1nnp8_137._button_1nnp8_1")));
      Assert.assertTrue(logoutButton.isDisplayed(), "Logout button not found");

      logoutButton.click();
      WebElement signIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[starts-with(@class,'page-title')]")));
      Assert.assertTrue(signIn.getText().contains("SIGN IN"), "Sign in is not displayed");

   }


}
