package actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobileAction {
    private final AppiumDriver<MobileElement> appiumDriver;
    public static final int SLEEP_IN_MILLIS = 2000;
    public MobileAction(AppiumDriver<MobileElement> appiumDriver){
        this.appiumDriver = appiumDriver;
    }
    public WebDriverWait getWait(int timeOutInSeconds) {
        return new WebDriverWait(appiumDriver, timeOutInSeconds, SLEEP_IN_MILLIS);
    }
    public MobileElement getElement(String elm) {
        try {
            System.out.println("Get Element with id: " +  elm);
            return  (MobileElement) getWait(30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elm)));
        }
        catch (Exception e) {
            System.out.println("Get Element failed with id:" + elm);
        }

        return null;
    }

    public boolean clickOnElm(String elm) {
        MobileElement mobileElement = getElement(elm);
        if(elm != null){
            System.out.println("Click on elm : " + elm + " successfully");
            mobileElement.click();
            return true;
        }else{
            System.out.println("Click on elm :" + elm + " failed");
            return false;
        }

    }

}
