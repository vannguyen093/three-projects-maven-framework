package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserWishlistPageUI;

public class UserWishlistPO extends BasePage {
    WebDriver driver;

    public UserWishlistPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isWishlistProductDisplayed(String wishlistProductTitle) {
        waitForElementVisible(driver, UserWishlistPageUI.PRODUCT_WISHLIST_NAME, wishlistProductTitle);
        return isElementDisplayed(driver, UserWishlistPageUI.PRODUCT_WISHLIST_NAME, wishlistProductTitle);
    }

    public void clickToAddToCartCheckbox() {
        waitForElementClickable(driver, UserWishlistPageUI.ADD_TO_CART_CHECKBOX);
        clickToElement(driver, UserWishlistPageUI.ADD_TO_CART_CHECKBOX);
    }

    public UserCartPO clickToAddToCartButton() {
        waitForElementClickable(driver, UserWishlistPageUI.ADD_TO_CART_BUTTON);
        clickToElement(driver, UserWishlistPageUI.ADD_TO_CART_BUTTON);
        return PageGenerateManager.getUserCartPage(driver);
    }

    public boolean isWishlistProductUnDisplayed(String wishlistProductTitle) {
        waitForElementUndisplayed(driver, UserWishlistPageUI.PRODUCT_WISHLIST_NAME, wishlistProductTitle);
        return isElementUndisplayed(driver, UserWishlistPageUI.PRODUCT_WISHLIST_NAME, wishlistProductTitle);
    }

    public void clickRemoveIcon() {
        waitForElementClickable(driver, UserWishlistPageUI.REMOVE_ICON);
        clickToElement(driver, UserWishlistPageUI.REMOVE_ICON);
    }

    public boolean isEmptyWishlistMessageDisplayed() {
        waitForElementVisible(driver, UserWishlistPageUI.NO_WISHLIST_PRODUCT_TEXT);
        return isElementDisplayed(driver, UserWishlistPageUI.NO_WISHLIST_PRODUCT_TEXT);
    }
}
