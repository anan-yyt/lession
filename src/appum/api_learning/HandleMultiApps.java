package api_learning;

import context.AppContexts;
import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.time.Duration;

public class HandleMultiApps implements AppContexts {
    public static void main(String[] args) {
        DriverFactory.startAppiumServer();
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getAppiumDriver();

        try {
            appiumDriver.findElementByAccessibilityId("Login").click();

            MobileElement usernameElm = appiumDriver.findElementByXPath("//android.widget.EditText[@content-desc='input-email']");
            MobileElement passwordElm = appiumDriver.findElementByXPath("//android.widget.EditText[@content-desc='input-password']");
            MobileElement loginBtnElm = appiumDriver.findElementByXPath("//android.view.ViewGroup[@content-desc='button-LOGIN']/android.view.ViewGroup");
            usernameElm.sendKeys("dtthuyan116@gmail.com");
            passwordElm.sendKeys("66666666");
            loginBtnElm.click();

            appiumDriver.runAppInBackground(Duration.ofSeconds(-1));
            appiumDriver.activateApp(SETTINGS);
            appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView[1]").click();
            appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView[1]").click();
            MobileElement wifiSwitchBtnElm = appiumDriver.findElement(By.id("android:id/switch_widget"));
//            boolean isWifiOn = wifiSwitchBtnElm.getAttribute("index").equals("1");
//            wifiSwitchBtnElm.click();
//            if(isWifiOn) {
//                wifiSwitchBtnElm.click();
//        }
            appiumDriver.activateApp(DEMO_APP);
            appiumDriver.findElementByXPath("//*[@text='OK']");

        }    catch (Exception e){
            e.printStackTrace();
        }
            finally {
            appiumDriver.quit();
            DriverFactory.stopAppiumServer();
        }

        }

}
