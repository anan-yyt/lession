package testcases;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import model.pages.SwipePage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SwipeTestCase {
    SwipePage swipePage;
    DriverFactory driverFactory;
    @BeforeClass
    public void before() {
        DriverFactory.startAppiumServer();
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getAppiumDriver();
       swipePage = new SwipePage(appiumDriver);

    }

    @Test(priority = 1)
    public void swipeHorizontally(){
        swipePage.clickOnSwipeBtn();
        Assert.assertTrue(swipePage.wait_SWIPE_HORIZONTAL_TEXT_dislay());
        swipePage.swipeHorizontally();

    }
    @Test(priority = 2)
    public void swipeBaseOnConditions(){
        Assert.assertTrue(swipePage.wait_SWIPE_HORIZONTAL_TEXT_dislay());
        Assert.assertTrue(swipePage.swipeBaseOnConditions());
    }

    @AfterClass
    public  void after() {
        DriverFactory.stopAppiumServer();

    }







}
