package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserTVPageUI;

public class UserTVPageObject extends BasePage {
    WebDriver driver;

    public UserTVPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public UserWishlistPageObject clickToAddToWishlistByProductName(String productName) {
        waitForElementClickable(driver, UserTVPageUI.ADD_TO_WISHLIST_LINK_BY_PRODUCT_NAME, productName);
        clickToElement(driver, UserTVPageUI.ADD_TO_WISHLIST_LINK_BY_PRODUCT_NAME, productName);
        return PageGenerateManager.getUserWishlistPage(driver);
    }

    public UserProductDetailPageObject clickToProductTitleByProductName(String productName) {
        waitForElementClickable(driver, UserTVPageUI.PRODUCT_NAME_TITLE, productName);
        clickToElement(driver, UserTVPageUI.PRODUCT_NAME_TITLE, productName);
        return PageGenerateManager.getUserProductDetailPage(driver);
    }

    public UserCartPageObject clickToAddToCartButtonByProductName(String productName) {
        waitForElementClickable(driver, UserTVPageUI.ADD_TO_CART_LINK_BY_PRODUCT_NAME, productName);
        clickToElement(driver, UserTVPageUI.ADD_TO_CART_LINK_BY_PRODUCT_NAME, productName);
        return PageGenerateManager.getUserCartPage(driver);
    }
}
