package test.authentication;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import model.pages.LoginPage;
import org.testng.annotations.Test;
import test.LoginCred;
import test.testing.BaseTest;
import test_flow.authen.LoginFlow;
import ultils.data.DataObjectBuilder;

public class LoginTestWithBaseTest02 extends BaseTest {
    @Test
    public void loginWithValidCreds(){
        String jsonLoc = "/src/main/resources/test-data/ValidLoginCred.json";
        LoginCred loginCreData = DataObjectBuilder.buildDataObject(jsonLoc, LoginCred.class);
        AppiumDriver<MobileElement> androidDriver = getAndroidDriver();
        LoginPage loginPage = new LoginPage(androidDriver);
        LoginFlow loginFlow = new LoginFlow(androidDriver);
        loginFlow.setData(loginCreData).login().verifyLogin();

    }

}
