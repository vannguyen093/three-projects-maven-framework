package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserSuccessCheckOutPageUI;

public class UserSuccessCheckOutPageObject extends BasePage {
    WebDriver driver;

    public UserSuccessCheckOutPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSuccessfullPurchaseMessageDisplayed() {
        waitForElementVisible(driver, UserSuccessCheckOutPageUI.ORDER_ID_MESSAGE_TEXT);
        return isElementDisplayed(driver, UserSuccessCheckOutPageUI.ORDER_ID_MESSAGE_TEXT);
    }
}
