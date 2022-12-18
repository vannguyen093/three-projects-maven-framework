package pageObjects.liveGuru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveGuru.UserMobilePageUI;

public class UserMobilePageObject extends BasePage {
    WebDriver driver;

    public UserMobilePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductPriceByProductTextAtMobilePage(String productName) {
        waitForElementVisible(driver, UserMobilePageUI.PRODUCT_PRICE_AT_MOBILE_PAGE_BY_PRODUCT_NAME, productName);
        return getElementText(driver, UserMobilePageUI.PRODUCT_PRICE_AT_MOBILE_PAGE_BY_PRODUCT_NAME, productName);
    }

    public UserProductDetailPageObject clickToImgByProductText(String productName) {
        waitForElementClickable(driver, UserMobilePageUI.PRODUCT_IMAGE_AT_MOBILE_PAGE_BY_PRODUCT_NAME, productName);
        clickToElement(driver, UserMobilePageUI.PRODUCT_IMAGE_AT_MOBILE_PAGE_BY_PRODUCT_NAME, productName);
        return PageGenerateManager.getUserProductDetailPage(driver);
    }

    public UserCartPageObject clickToAddToCartButtonByProductName(String productName) {
        waitForElementClickable(driver, UserMobilePageUI.ADD_TO_CART_BUTTON_BY_PRODUCT_NAME, productName);
        clickToElement(driver, UserMobilePageUI.ADD_TO_CART_BUTTON_BY_PRODUCT_NAME, productName);
        return PageGenerateManager.getUserCartPage(driver);
    }

    public void clickToAddToCompareLinkByProdName(String productName) {
        waitForElementClickable(driver, UserMobilePageUI.ADD_TO_COMPARE_LINK_BY_PRODUCT_NAME, productName);
        clickToElement(driver, UserMobilePageUI.ADD_TO_COMPARE_LINK_BY_PRODUCT_NAME, productName);
    }

    public String getProductAddedCompareMessage() {
        waitForElementVisible(driver, UserMobilePageUI.PRODUCT_ADDED_COMPARE_MESSAGE_TEXT);
        return getElementText(driver, UserMobilePageUI.PRODUCT_ADDED_COMPARE_MESSAGE_TEXT);
    }

    public void clickToCompareButton() {
        waitForElementClickable(driver, UserMobilePageUI.COMPARE_BUTTON);
        clickToElement(driver, UserMobilePageUI.COMPARE_BUTTON);
    }

    public UserProductDetailPageObject clickToProductTitleByProductName(String productName) {
        waitForElementClickable(driver, UserMobilePageUI.PRODUCT_NAME_TITLE, productName);
        clickToElement(driver, UserMobilePageUI.PRODUCT_NAME_TITLE, productName);
        return PageGenerateManager.getUserProductDetailPage(driver);
    }

    public UserCompareWindowPageObject switchToCompareWindow(String windowTitle) {
        switchToWindowByTitle(driver, windowTitle);
        return PageGenerateManager.getUserCompareWindowPage(driver);
    }
}
