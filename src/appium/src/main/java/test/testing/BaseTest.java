package test.testing;

import driver.DriverFactoryEx;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class BaseTest {
    private DriverFactoryEx driverFactory;
    private AppiumDriver<MobileElement> appiumDriver;

    private final List<DriverFactoryEx> driverThreadPool = Collections.synchronizedList(new ArrayList<>());
    private ThreadLocal<DriverFactoryEx> driverThread;
    private String udid;
    private String systemPort;

    @BeforeClass(alwaysRun = true)
    @Parameters({"udid", "systemPort"})
    public void beforeClass(String udid, String systemPort){
        this.udid = udid;
        this.systemPort = systemPort;
        driverThread = ThreadLocal.withInitial(() -> {
            DriverFactoryEx driverThread = new DriverFactoryEx();
            driverThreadPool.add(driverThread);
            return driverThread;
        });

    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        driverFactory.quitAppiumSession();
    }

    protected  AppiumDriver<MobileElement> getAndroidDriver(){
        if(appiumDriver == null){
            appiumDriver = driverFactory.getAndroidDriver(udid, systemPort);
        }
        return  appiumDriver;
    }

    @AfterMethod
    public void afterMethod(ITestResult iTestResult){
        if (iTestResult.getStatus() == ITestResult.FAILURE & iTestResult.getStatus() == ITestResult.SKIP ){

            String testMethodName = iTestResult.getName();

            Calendar calendar = new GregorianCalendar();
            int y = calendar.get(Calendar.YEAR);
            int m = calendar.get(Calendar.MONTH);
            int d = calendar.get(Calendar.DATE);
            int hr = calendar.get(Calendar.HOUR_OF_DAY);
            int min = calendar.get(Calendar.MINUTE);
            int sec = calendar.get(Calendar.SECOND);
            String dateTaken = y + "-" + m + "-" + d + "-" +hr+ "-"+min+"-"+sec;

            //Location

            String fileLocation =
                    System.getProperty("user.dir") + "/screenshots/" + testMethodName + "_" + dateTaken + ".png";
            File screenshot = driverThread.get().getAndroidDriver().getScreenshotAs(OutputType.FILE);
            try{
                FileUtils.copyFile(screenshot, new File(fileLocation));
                Path content = Paths.get(fileLocation);
                InputStream inputStream = Files.newInputStream(content);
                Allure.addAttachment(testMethodName, inputStream);

            } catch (Exception e){
                e.printStackTrace();
            }

        }

    }
}
