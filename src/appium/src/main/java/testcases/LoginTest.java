package testcases;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import model.pages.LoginPage;
import test.LoginCred;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test_flow.authen.LoginFlow;
import ultils.data.DataObjectBuilder;

import static org.testng.TestRunner.PriorityWeight.priority;

public class LoginTest {

    @Test(priority = 2 ,dataProvider = "invalidLoginData")
    public void loginWithInvalidCreds(LoginCred loginCreData){
        DriverFactory.startAppiumServer();
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getAppiumDriver();
        LoginPage loginPage = new LoginPage(appiumDriver);
        loginPage.bottomNavigationComp().clickOnLoginLbl();
        loginPage
                .inputUsername(loginCreData.getUsername())
                .inputPassword(loginCreData.getPassword())
                .clickOnLoginBtn();

    }

    @Test(priority = 1)
    public void loginWithValidCreds(){
        String jsonLoc = "/src/main/resources/test-data/ValidLoginCred.json";
        LoginCred loginCreData = DataObjectBuilder.buildDataObject(jsonLoc, LoginCred.class);
        DriverFactory.startAppiumServer();
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getAppiumDriver();
        LoginPage loginPage = new LoginPage(appiumDriver);

        LoginFlow loginFlow = new LoginFlow(appiumDriver);
        loginFlow.setData(loginCreData).login().verifyLogin();

    }


    @DataProvider()
    public LoginCred[] invalidLoginData(){
        String jsonLoc = "/src/main/resources/test-data/InvalidLoginCred.json";
        return DataObjectBuilder.buildDataObject(jsonLoc, LoginCred[].class);
    }

}
