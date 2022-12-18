package pageObjects;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageUIs.UserCartPageUI;

public class UserCartPageObject extends BasePage {
    WebDriver driver;

    public UserCartPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getCartMessage() {
        waitForElementVisible(driver, UserCartPageUI.CART_MESSAGE_TEXT);
        return getElementText(driver, UserCartPageUI.CART_MESSAGE_TEXT);
    }

    public void inputToDiscountCodeTextBox(String couponText) {
        waitForElementVisible(driver, UserCartPageUI.DISCOUNT_CODES_TEXTBOX);
        sendkeysToElement(driver, UserCartPageUI.DISCOUNT_CODES_TEXTBOX, couponText);
        pressKeyToElement(driver, UserCartPageUI.DISCOUNT_CODES_TEXTBOX, Keys.ENTER);
    }

    public String getAddedDiscountText() {
        waitForElementVisible(driver, UserCartPageUI.DISCOUNT_CODES_ADDED_TEXT);
        return getElementText(driver, UserCartPageUI.DISCOUNT_CODES_ADDED_TEXT);
    }

    public String getGrandTotalText() {
        waitForElementVisible(driver, UserCartPageUI.GRAND_TOTAL);
        return getElementText(driver, UserCartPageUI.GRAND_TOTAL);
    }

    public void clickToRemoveItemIcon() {
        waitForElementClickable(driver, UserCartPageUI.REMOVE_ITEM_ICON);
        clickToElement(driver, UserCartPageUI.REMOVE_ITEM_ICON);
    }

    public void inputToQuantityTextBox(String value) {
        waitForElementClickable(driver, UserCartPageUI.QUANTITY_TEXTBOX);
        clickToElement(driver, UserCartPageUI.QUANTITY_TEXTBOX);

        waitForElementVisible(driver, UserCartPageUI.QUANTITY_TEXTBOX);
        sendkeysToElement(driver, UserCartPageUI.QUANTITY_TEXTBOX, value);
    }

    public void clickToButtonAtAdminSiteByButtonTitle(String buttonTitle) {
        waitForElementClickable(driver, UserCartPageUI.BUTTON_BY_TITLE_TEXT, buttonTitle);
        clickToElement(driver, UserCartPageUI.BUTTON_BY_TITLE_TEXT, buttonTitle);
    }

    public String getProductQtyErrMessage() {
        waitForElementVisible(driver, UserCartPageUI.PRODUCT_QUANTITY_ERR_MESSAGE_TEXT);
        return getElementText(driver, UserCartPageUI.PRODUCT_QUANTITY_ERR_MESSAGE_TEXT);
    }

    public boolean isEmptyCartHeaderDisplayed() {
        waitForElementVisible(driver, UserCartPageUI.EMPTY_CART_HEADER_TEXT);
        return isElementDisplayed(driver, UserCartPageUI.EMPTY_CART_HEADER_TEXT);
    }

    public boolean isNoItemMessageDisplayed() {
        waitForElementVisible(driver, UserCartPageUI.NO_ITEM_IN_CART_TEXT);
        return isElementDisplayed(driver, UserCartPageUI.NO_ITEM_IN_CART_TEXT);
    }

    public void selectItemAtEstimateDropdownByDropdownID(String dropdownText, String value) {
        waitForElementClickable(driver, UserCartPageUI.ESTIMATE_SHIPPING_RADIO_BY_RADIO_ID, dropdownText);
        selectItemInDefaultDropdown(driver, UserCartPageUI.ESTIMATE_SHIPPING_RADIO_BY_RADIO_ID, value, dropdownText);
    }

    public void inputToZipTextBox(String value) {
        waitForElementVisible(driver, UserCartPageUI.ZIP_TEXTBOX);
        sendkeysToElement(driver, UserCartPageUI.ZIP_TEXTBOX, value);
    }

    public String getFixedFlatRateText() {
        waitForElementVisible(driver, UserCartPageUI.FIXED_FLAT_RATE_TEXT);
        return getElementText(driver, UserCartPageUI.FIXED_FLAT_RATE_TEXT);
    }

    public Object getShippingHandlingText() {
        waitForElementVisible(driver, UserCartPageUI.SHIPPING_HANDLING_PRICE_TEXT);
        return getElementText(driver, UserCartPageUI.SHIPPING_HANDLING_PRICE_TEXT);
    }

    public void checkToFixedRadio() {
        waitForElementClickable(driver,UserCartPageUI.FIXED_FLAT_RATE_TEXT);
        checkToDefaultCheckboxRadio(driver, UserCartPageUI.FIXED_FLAT_RATE_TEXT);
    }
}
