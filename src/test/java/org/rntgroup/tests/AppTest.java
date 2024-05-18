package org.rntgroup.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rntgroup.framework.business.Employee;
import org.rntgroup.framework.business.User;
import org.rntgroup.framework.listeners.FailedTestListener;
import org.rntgroup.framework.logger.AllureLogger;
import org.rntgroup.framework.pages.LoginPage;
import org.rntgroup.framework.pages.LogoutWindow;
import org.rntgroup.framework.pages.MainPage;
import org.rntgroup.framework.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.rntgroup.framework.utils.PropertyReader;

import java.util.Properties;
@Listeners ({FailedTestListener.class})
public class AppTest extends BaseAppTest
{
   private static final Logger logger= LogManager.getLogger(AppTest.class);
   @Test(description ="Check_title")
    public void test1 () {
       AllureLogger.debug("Test 1");
       String title = webDriver.getTitle();
       Assert.assertTrue(title.contains("HR портал"), "Title is incorrect");
   }

   @Test(description ="Check_name")
   public void test2 () {
      AllureLogger.debug("Test 2");
      Properties appProps = PropertyReader.readProperties();
      Employee employee = new Employee(appProps.getProperty("fullName"), "На работе", appProps.getProperty("birthday"));

      MainPage mainPage = new MainPage(webDriver);
      mainPage.clickProfileButton();

      ProfilePage profilePage = new ProfilePage(webDriver);

      Assert.assertTrue(profilePage.getNameElement().isDisplayed(), "Full name not found");
      Assert.assertTrue(profilePage.getNameElement().getText().contains(employee.getFullName()), "Incorrect name:" + profilePage.getNameElement().getText());

      Assert.assertTrue(profilePage.getStatusField().isDisplayed(), "Status not found");
      Assert.assertTrue(profilePage.getStatusField().getText().contains(employee.getFullName()), "Incorrect status:" + profilePage.getStatusField().getText());

      Assert.assertTrue(profilePage.getBirthdayField().isDisplayed(), "Birthday not found");
      Assert.assertTrue(profilePage.getBirthdayField().getText().contains(employee.getFullName()), "Incorrect birthday:" + profilePage.getBirthdayField().getText());

   }

   @Test(description ="Logout")
   public void test3 () {
      AllureLogger.debug("Test 3");
      MainPage mainPage = new MainPage(webDriver);
      mainPage.clickLogoutButton();

      LogoutWindow logoutWindow = new LogoutWindow(webDriver);
      logoutWindow.clickLogoutButtonViaActions();

      LoginPage loginPage = new LoginPage(webDriver);
      Assert.assertTrue(loginPage.getSignInText().contains("SIGN IN"), "Sign in is not displayed");
   }


}
