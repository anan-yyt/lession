package model.components.global;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class BottomNavigation {
    private final AppiumDriver<MobileElement> appiumDriver;
    private static final By loginSel = MobileBy.AccessibilityId("button-LOGIN");


    public BottomNavigation(AppiumDriver<MobileElement> appiumDriver){
        this.appiumDriver = appiumDriver;
    }

}
