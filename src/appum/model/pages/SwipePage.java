package model.pages;

import actions.MobileAction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import selectors.NavigationSelector;
import selectors.SwipePageSelector;

import java.time.Duration;


public class SwipePage {
    private final AppiumDriver<MobileElement> appiumDriver;
    MobileAction mobileAction;
    NavigationSelector navigationSelector;
    public SwipePage(AppiumDriver<MobileElement> appiumDriver){
        this.appiumDriver = appiumDriver;
        this.mobileAction = new MobileAction(appiumDriver);
    }

    public boolean clickOnSwipeBtn(){
        return mobileAction.clickOnElm(navigationSelector.swipeElm);
    }

    public boolean wait_SWIPE_HORIZONTAL_TEXT_dislay(){
        String text = mobileAction.getElement(SwipePageSelector.SWIPE_HORIZONTAL_TEXT).getText();
        System.out.println("Text : " + text);
        if(text!=null){
            return true;
        }
        return false;

    }
    public void swipeHorizontally() {
        Dimension windowSize = appiumDriver.manage().window().getSize();
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        int xStartPoint = (90 * screenWidth)/100;
        int xEndPoint = (10 * screenWidth)/100;
        int yStartPoint = (50 * screenHeight)/100;
        int yEndPoint = yStartPoint;

        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);

        TouchAction touchAction = new TouchAction<>(appiumDriver);
        touchAction
                .press(startPoint)
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .moveTo(endPoint)
                .release()
                .perform();
    }
    public boolean swipeBaseOnConditions() {
        final int MAX_SWIPE_TIME = 10;
        int swipeTime = 0;
        while (swipeTime < MAX_SWIPE_TIME) {
            String text = mobileAction.getElement(SwipePageSelector.TITLE_CONTAINER).getText();
            System.out.println("TITLE_CONTAINER : " + text);
            if(text.equals("SUPPORT VIDEOS")){
                return true;
            }else {
                swipeHorizontally();
            }
        }

        if(swipeTime ==10) {
            throw new RuntimeException("Icon not found");
        }
        return false;
    }

}
