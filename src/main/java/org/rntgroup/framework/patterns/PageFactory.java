package org.rntgroup.framework.patterns;

import org.openqa.selenium.WebDriver;
import org.rntgroup.framework.pages.*;

public class PageFactory {
    public static <T extends BasePage> T createPage(Class<T> page, WebDriver driver) {
        if (page == LoginPage.class) {
            return (T) new LoginPage(driver);
        } else if (page == LogoutWindow.class) {
            return (T)  new LogoutWindow(driver);
        } else if (page == MainPage.class) {
            return (T)  new MainPage(driver);
        } else if (page == ProfilePage.class) {
            return (T)  new ProfilePage(driver);
        }
        // Другие страницы
        return null;
    }
}
