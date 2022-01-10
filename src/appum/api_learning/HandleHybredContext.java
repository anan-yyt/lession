package api_learning;

import context.AppContexts;
import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static java.awt.SystemColor.text;

public class HandleHybredContext implements AppContexts {
    public static void main(String[] args) {
        DriverFactory.startAppiumServer();
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getAppiumDriver();

        try {
            MobileElement webviewLabelElm = appiumDriver.findElementByAccessibilityId("Webview");
            webviewLabelElm.click();

            WebDriverWait wait = new WebDriverWait(appiumDriver, 10L);
            wait.until(moreThanOneContext(appiumDriver));
            appiumDriver.getContextHandles().forEach(System.out::println);
            appiumDriver.context("WEBVIEW_com.wdiodemoapp");
            WebElement navToggleBtn = appiumDriver.findElementByCssSelector(".navbar__toggle");
            navToggleBtn.click();

            List<MobileElement> menuItems = appiumDriver.findElementsByCssSelector(".menu__list-item a");
            List<MenuItem> menuItemList = new ArrayList<>();
            if (menuItems.isEmpty())
                throw new RuntimeException("[Error] Menu items is empty");
            menuItems.forEach(menuItem -> {
                String itemText = menuItem.getText();
                String itemHyperlink = menuItem.getAttribute("href");

                if(StringUtils.isEmpty(itemText))
                    menuItemList.add(new MenuItem("Github",itemHyperlink));
                else
                    menuItemList.add(new MenuItem(itemText, itemHyperlink));
            });

            menuItemList.forEach(menuItemData -> {
                System.out.println(menuItemData);
            });
            appiumDriver.context(NATIVE);
            appiumDriver.findElementByAccessibilityId("Login");

            appiumDriver.runAppInBackground(Duration.ofSeconds(3));

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            appiumDriver.quit();
            DriverFactory.stopAppiumServer();
        }

    }

    private static ExpectedCondition<Boolean> moreThanOneContext(AppiumDriver<MobileElement> appiumDriver) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return appiumDriver.getContextHandles().size() > 1;
            }
        };
    }
    public static class MenuItem {
        private String text;
        private String hyperLink;

        public MenuItem(String text, String hyperLink) {
            this.text = text;
            this.hyperLink = hyperLink;
        }
    }
}

