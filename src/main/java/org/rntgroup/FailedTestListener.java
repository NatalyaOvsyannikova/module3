package org.rntgroup;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class FailedTestListener implements ITestListener {

    @Override
    public void onTestFailure (ITestResult result) {
        ITestContext context = result.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("WebDriver");
        makePicture(driver);
        String methodName = result.getMethod().getConstructorOrMethod().getName();
        saveTextLog(methodName + " failed and screenshot attached to the report!");
    }
    @Attachment (value = "ScreenShot", type = "image/png")
    public static byte[] makePicture (WebDriver driver){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment (value = "{0}", type = "text/plain")
    public static String saveTextLog(String message){
        return message;
    }
}
