package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserCompareWindowPageUI;

public class UserCompareWindowPageObject extends BasePage {
    WebDriver driver;

    public UserCompareWindowPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCompareWindowHeaderDisplayed() {
        waitForElementVisible(driver, UserCompareWindowPageUI.COMPARE_WINDOW_HEADER);
        return isElementDisplayed(driver, UserCompareWindowPageUI.COMPARE_WINDOW_HEADER);
    }

    public boolean isProductTitleDisplayed(String productName) {
        waitForElementVisible(driver, UserCompareWindowPageUI.PRODUCT_TITLE_TEXT, productName);
        return isElementDisplayed(driver, UserCompareWindowPageUI.PRODUCT_TITLE_TEXT, productName);
    }

    public boolean isProductImageDisplayed(String productName, String imgName) {
        waitForElementVisible(driver, UserCompareWindowPageUI.PRODUCT_IMG_TEXT, productName, imgName);
        return isElementDisplayed(driver, UserCompareWindowPageUI.PRODUCT_IMG_TEXT, productName, imgName);
    }

    public boolean isProductPriceDisplayed(String productName) {
        waitForElementVisible(driver, UserCompareWindowPageUI.PRODUCT_PRICE_TEXT, productName);
        return isElementDisplayed(driver, UserCompareWindowPageUI.PRODUCT_PRICE_TEXT, productName);
    }

    public boolean isProductSKUDisplayed(String skuText) {
        waitForElementVisible(driver, UserCompareWindowPageUI.PRODUCT_SKU_TEXT, skuText);
        return isElementDisplayed(driver, UserCompareWindowPageUI.PRODUCT_SKU_TEXT, skuText);
    }

    public UserMobilePageObject closeCompareWindow() {
        closeAllWindowsWithoutParent(driver, getPageID(driver));
        return PageGenerateManager.getUserMobilePage(driver);
    }
}
