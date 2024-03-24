package org.rntgroup;

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
   @Test(description ="Check_title")
    public void test1 () {
       String title = webDriver.getTitle();
       Assert.assertTrue(title.contains("HR Portal"), "Title is incorrect");
   }

   @Test(description ="Check_name")
   public void test2 () {
      Properties appProps = PropertyReader.readProperties();
      String fullName = appProps.getProperty("fullName");
      System.out.println(fullName);

      MainPage mainPage = new MainPage(webDriver);
      mainPage.clickProfileButton();

      ProfilePage profilePage = new ProfilePage(webDriver);
      profilePage.validateName(fullName);
   }

   @Test(description ="Logout")
   public void test3 () {

      MainPage mainPage = new MainPage(webDriver);
      mainPage.clickUserInfoButton()
              .clickLogoutLine();

      LogoutWindow logoutWindow = new LogoutWindow(webDriver);
      logoutWindow.clickLogoutButtonViaActions();

      LoginPage loginPage = new LoginPage(webDriver);
      loginPage.validateSignIn("SIGN IN");
   }


}
