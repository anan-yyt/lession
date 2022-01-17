package model.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import model.components.global.BottomNavigation;
import org.openqa.selenium.By;

public class LoginPage {
    private final AppiumDriver<MobileElement> appiumDriver;
    private static final By usernameSel = MobileBy.AccessibilityId("input-email");
    private static final By passwordSel = MobileBy.AccessibilityId("input-password");
    private static final By loginSel = MobileBy.AccessibilityId("button-LOGIN");


    public LoginPage(AppiumDriver<MobileElement> appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public MobileElement usernameElm(){
        return  appiumDriver.findElement(usernameSel);
    }
    public MobileElement passwordElm(){
        return  appiumDriver.findElement(passwordSel);
    }
    public MobileElement loginBtnElm(){
        return  appiumDriver.findElement(loginSel);
    }

    public LoginPage inputPassword(String password) {
        appiumDriver.findElement(passwordSel).sendKeys(password);
        return this;
    }

    public LoginPage inputUsername(String username){
        appiumDriver.findElement(usernameSel).sendKeys(username);
        return this;
    }

    public void clickOnLoginBtn() {
        appiumDriver.findElement(loginSel).click();
    }

    public BottomNavigation bottomNavigationComp(){
        return new BottomNavigation(appiumDriver);
    }

}
