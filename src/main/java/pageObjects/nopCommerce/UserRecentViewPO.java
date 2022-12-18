package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserRecentViewPageUI;

public class UserRecentViewPO extends BasePage {
    WebDriver driver;

    public UserRecentViewPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductRecentUndisplayed(String recentProductTitle) {
        waitForElementUndisplayed(driver, UserRecentViewPageUI.RECENT_PRODUCT_NAME_TEXT, recentProductTitle);
        return isElementUndisplayed(driver, UserRecentViewPageUI.RECENT_PRODUCT_NAME_TEXT, recentProductTitle);
    }

    public boolean isProductRecentDisplayed(String recentProductTitle) {
        waitForElementVisible(driver, UserRecentViewPageUI.RECENT_PRODUCT_NAME_TEXT, recentProductTitle);
        return isElementDisplayed(driver, UserRecentViewPageUI.RECENT_PRODUCT_NAME_TEXT, recentProductTitle);
    }
}
