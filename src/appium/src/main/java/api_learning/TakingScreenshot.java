package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class TakingScreenshot {
    public static void main(String[] args) {
        DriverFactory.startAppiumServer();
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getAppiumDriver();

        try {
            MobileElement loginLableElem = appiumDriver.findElementByAccessibilityId("Login");
            loginLableElem.click();

            WebDriverWait wait = new WebDriverWait(appiumDriver, 10L);
            wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("button-LOGIN")));


            File base64ScreenshotData = appiumDriver.getScreenshotAs(OutputType.FILE);
            String fileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("LoginForm.png");
            FileUtils.copyFile(base64ScreenshotData,new File(fileLocation));

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
