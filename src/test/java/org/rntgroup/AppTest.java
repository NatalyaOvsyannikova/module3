package org.rntgroup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rntgroup.pages.LoginPage;
import org.rntgroup.pages.LogoutWindow;
import org.rntgroup.pages.MainPage;
import org.rntgroup.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

import java.util.Properties;

public class AppTest extends BaseAppTest
{
   private static final Logger logger= LogManager.getLogger(AppTest.class);
   @Test(description ="Check_title")
    public void test1 () {
       logger.debug("Test 1");
       String title = webDriver.getTitle();
       Assert.assertTrue(title.contains("HR Portal"), "Title is incorrect");
   }

   @Test(description ="Check_name")
   public void test2 () {
      logger.debug("Test 2");
      Properties appProps = PropertyReader.readProperties();
      String fullName = appProps.getProperty("fullName");
      System.out.println(fullName);

      MainPage mainPage = new MainPage(webDriver);
      mainPage.clickProfileButton();

      ProfilePage profilePage = new ProfilePage(webDriver);

      Assert.assertTrue(profilePage.getName().isDisplayed(), "Full name not found");
      Assert.assertTrue(profilePage.getName().getText().contains(fullName), "Incorrect name:" + profilePage.getName().getText());
   }

   @Test(description ="Logout")
   public void test3 () {
      logger.debug("Test 3");
      MainPage mainPage = new MainPage(webDriver);
      mainPage.clickUserInfoButton()
              .clickLogoutLine();

      LogoutWindow logoutWindow = new LogoutWindow(webDriver);
      logoutWindow.clickLogoutButtonViaActions();

      LoginPage loginPage = new LoginPage(webDriver);
      Assert.assertTrue(loginPage.getSignInText().contains("SIGN IN"), "Sign in is not displayed");
   }


}
