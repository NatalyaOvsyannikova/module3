package org.rntgroup.framework.patterns;

import org.openqa.selenium.WebDriver;
import org.rntgroup.framework.pages.*;

public class PageFactory {
    public static <PageObject> PageObject createPage(String pageName, WebDriver driver) {
        if (pageName.equalsIgnoreCase("LoginPage")) {
            return (PageObject) new LoginPage(driver);
        } else if (pageName.equalsIgnoreCase("LogoutWindow")) {
            return (PageObject) new LogoutWindow(driver);
        } else if (pageName.equalsIgnoreCase("MainPage")) {
            return (PageObject) new MainPage(driver);
        } else if (pageName.equalsIgnoreCase("ProfilePage")) {
            return (PageObject) new ProfilePage(driver);
        }
        // Другие страницы
        return null;
    }
}
