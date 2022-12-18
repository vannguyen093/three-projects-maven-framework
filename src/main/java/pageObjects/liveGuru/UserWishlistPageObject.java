package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserWishlistPageUI;

public class UserWishlistPageObject extends BasePage {
    WebDriver driver;

    public UserWishlistPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSuccessfullyAddedToWishlistDisplayed() {
        waitForElementVisible(driver, UserWishlistPageUI.PRODUCT_ADDED_WISHLIST_MESSAGE_TEXT);
        return isElementDisplayed(driver, UserWishlistPageUI.PRODUCT_ADDED_WISHLIST_MESSAGE_TEXT);
    }

    public int getWishlistTableSize() {
        waitForElementVisible(driver, UserWishlistPageUI.WISHLIST_TABLE);
        return getElementSize(driver, UserWishlistPageUI.WISHLIST_TABLE);
    }
}
