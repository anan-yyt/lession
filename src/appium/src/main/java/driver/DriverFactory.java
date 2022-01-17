package driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static AppiumDriverLocalService appiumService;
    private static AppiumDriver<MobileElement> appiumDriver;

    public static void startAppiumServer() {
        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder();
        appiumServiceBuilder.withIPAddress("127.0.0.1").usingPort(4723);
        appiumService = AppiumDriverLocalService.buildService(appiumServiceBuilder);
        appiumService.start();
    }
    public static void stopAppiumServer(){
        String killNodeWindowsCommand = "taskk /F /IM node.exe";
        String killNodeLinuxCommand = "killall node";
        String killNodeCmd = System.getProperty("os.name").toLowerCase().startsWith("windows") ? killNodeWindowsCommand : killNodeLinuxCommand;
        Runtime runtime = Runtime.getRuntime();
        try{
            runtime.exec(killNodeCmd);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static AppiumDriver<MobileElement> getAppiumDriver(){
        initAppiumDriver();
        return appiumDriver;
    }

    private static void initAppiumDriver(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "Pixe4a");
        desiredCapabilities.setCapability("uid", "11031JEC203902");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "12");
        desiredCapabilities.setCapability("appPackage", "com.wdiodemoapp");
        desiredCapabilities.setCapability("appActivity", "com.wdiodemoapp.MainActivity");
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
        appiumDriver = new AndroidDriver<MobileElement>(appiumService.getUrl(), desiredCapabilities);



    }

    }
