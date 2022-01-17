package test_flow.authen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import model.pages.LoginPage;
import test.LoginCred;

public class LoginFlow {
    private final AppiumDriver<MobileElement> appiumDriver;
    private  LoginCred loginCredData;

    public LoginFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }
    public LoginFlow setData(LoginCred loginCredData) {
        this.loginCredData = loginCredData;
        return this;
    }
    public LoginFlow login(){
        if(loginCredData == null)
            throw new RuntimeException("Please call setData method first");
        LoginPage loginPage = new LoginPage(appiumDriver);
        loginPage.bottomNavigationComp().clickOnLoginLbl();
        loginPage
                .inputUsername(loginCredData.getUsername())
                .inputPassword(loginCredData.getPassword())
                .clickOnLoginBtn();
        return this;
    }

    public void verifyLogin(){
        boolean isEmailInvalid = isEmailInvalid(loginCredData.getUsername());
        boolean isPasswordInvalid = isPasswordInvalid(loginCredData.getPassword());
        if(isEmailInvalid)
            verifyInvalidEmailFomat();
        if(isPasswordInvalid)
            verifyInvalidPasswordFormat();
        if(!isEmailInvalid && !isPasswordInvalid)
            verifyLoginSuccess();
    }

    private boolean isPasswordInvalid(String password) {
        return true;
    }

    private boolean isEmailInvalid(String username) {
        return true;
    }

    private void verifyLoginSuccess() {
    }

    private void verifyInvalidPasswordFormat() {
    }

    private void verifyInvalidEmailFomat() {
    }

}
