package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserComparePageUI;
import pageUIs.UserProductPageUI;

public class UserComparePO extends BasePage {
    WebDriver driver;

    public UserComparePO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductTitleDisplayedAtComparePage(String compareProductTitle) {
        waitForElementVisible(driver, UserComparePageUI.PRODUCT_NAME_TEXT, compareProductTitle);
        return isElementDisplayed(driver, UserComparePageUI.PRODUCT_NAME_TEXT, compareProductTitle);
    }

    public boolean isProductPriceDisplayedAtComparePage(String compareProductTitle, String compareProductPrice) {
        waitForElementVisible(driver, UserComparePageUI.PRODUCT_PRICE_BY_PRODUCT_NAME_TEXT, compareProductTitle, compareProductPrice);
        return isElementDisplayed(driver, UserComparePageUI.PRODUCT_PRICE_BY_PRODUCT_NAME_TEXT, compareProductTitle, compareProductPrice);
    }

    public void clickToClearListButton() {
        waitForElementClickable(driver, UserComparePageUI.CLEAR_LIST_BUTTON);
        clickToElement(driver, UserComparePageUI.CLEAR_LIST_BUTTON);
    }

    public String getNoDataMessageText() {
        waitForElementVisible(driver, UserComparePageUI.NO_DATA_AT_COMPARE_PAGE_TEXT);
        return getElementText(driver, UserComparePageUI.NO_DATA_AT_COMPARE_PAGE_TEXT);
    }

    public int getCompareProductSize() {
        waitForElementUndisplayed(driver, UserProductPageUI.PRODUCT_TITLE_TEXT);
        return getElementSize(driver, UserProductPageUI.PRODUCT_TITLE_TEXT);
    }
}
