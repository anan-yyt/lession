package model.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;


import java.time.Duration;


public class SwipePage {
    private final AppiumDriver<MobileElement> appiumDriver;

    public SwipePage(AppiumDriver<MobileElement> appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public boolean clickOnSwipeBtn(){
        
       MobileElement swipeBtnElm = appiumDriver.findElement(By.xpath("//android.widget.Button[@content-desc='Swipe']"));
        if(swipeBtnElm!=null){
            swipeBtnElm.click();
        }
        return false;
    }

    public boolean wait_SWIPE_HORIZONTAL_TEXT_dislay(){
      Boolean isDisplayed = appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='Swipe horizontal']")).isDisplayed();
        return isDisplayed;

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
            String TITLE_CONTAINER_TEXT = appiumDriver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='slideTextContainer'][1]/android.widget.TextView[1]")).getText();
            if(TITLE_CONTAINER_TEXT.equals("SUPPORT VIDEOS")){
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
