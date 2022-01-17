package driver;
import caps.MobileCapabilityTypeEx;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactoryEx {
    private static AppiumDriverLocalService appiumService;
    private static AppiumDriver<MobileElement> appiumDriver;

  public AppiumDriver<MobileElement> getAndroidDriver(String udid, String systemPort ){
      initAppiumDriver(udid, systemPort);
      return  appiumDriver;
  }
    public AppiumDriver<MobileElement> getAndroidDriver(){
        return  appiumDriver;
    }


    private static void initAppiumDriver(String udid, String systemPort){
      try {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "Pixe4a");
        desiredCapabilities.setCapability("uid", udid);
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.APP_PAKAGE, "com.wdiodemoapp");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.APP_ACTIVITY, "com.wdiodemoapp.MainActivity");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.SYSTEM_PORT, systemPort);
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);

          URL appiumServer = new URL("http://127.0.0.1:4723/wd/hub");
          appiumDriver = new AndroidDriver<>(appiumServer, desiredCapabilities);
          appiumDriver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);

    }
    catch(Exception e) {
          e.printStackTrace();

    }

    }
    public  void quitAppiumSession() {
        if(appiumDriver != null) {
            appiumDriver.quit();
            appiumDriver = null;
        }


    }
}
