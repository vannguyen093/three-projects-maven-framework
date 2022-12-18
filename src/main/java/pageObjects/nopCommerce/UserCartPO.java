package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserCartPageUI;

public class UserCartPO extends BasePage {
    WebDriver driver;

    public UserCartPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCartProductDisplayed(String productName) {
        waitForElementVisible(driver, UserCartPageUI.PRODUCT_CART_NAME, productName);
        return isElementDisplayed(driver, UserCartPageUI.PRODUCT_CART_NAME, productName);
    }

    public UserProductDetailPO clickToEditLinkAtCartPage(String productName) {
        waitForElementClickable(driver, UserCartPageUI.EDIT_PRODUCT_CART_LINK_BY_PRODUCT_NAME, productName);
        clickToElement(driver, UserCartPageUI.EDIT_PRODUCT_CART_LINK_BY_PRODUCT_NAME, productName);
        return PageGenerateManager.getUserProductDetailPage(driver);
    }

    public void clickToRemoveButtonByProductName(String productName) {
        waitForElementClickable(driver, UserCartPageUI.REMOVE_PRODUCT_CART_BUTTON_BY_PRODUCT_NAME, productName);
        clickToElement(driver, UserCartPageUI.REMOVE_PRODUCT_CART_BUTTON_BY_PRODUCT_NAME, productName);
    }

    public String getNoDataMessageText() {
        waitForElementVisible(driver, UserCartPageUI.NO_DATA_MESSAGE_TEXT);
        return getElementText(driver, UserCartPageUI.NO_DATA_MESSAGE_TEXT);
    }

    public boolean isCartProductUndisplayed(String productName) {
        waitForElementUndisplayed(driver, UserCartPageUI.PRODUCT_CART_NAME, productName);
        return isElementUndisplayed(driver, UserCartPageUI.PRODUCT_CART_NAME, productName);
    }

    public void inputToQuantityTextboxByProductName(String productName, String value) {
        waitForElementVisible(driver, UserCartPageUI.QUANTITY_PRODUCT_CART_TEXTBOX_BY_PRODUCT_NAME, productName);
        sendkeysToElement(driver, UserCartPageUI.QUANTITY_PRODUCT_CART_TEXTBOX_BY_PRODUCT_NAME, value, productName);
    }

    public String getProductSubTotalByProductName(String notebooksName) {
        waitForElementVisible(driver, UserCartPageUI.TOTAL_PRODUCT_CART_TEXT_BY_PRODCUT_NAME, notebooksName);
        return getElementText(driver, UserCartPageUI.TOTAL_PRODUCT_CART_TEXT_BY_PRODCUT_NAME, notebooksName);
    }

    public void clickToCartButtonByID(String buttonID) {
        waitForElementClickable(driver, UserCartPageUI.CART_BUTTON_BY_ID, buttonID);
        clickToElement(driver, UserCartPageUI.CART_BUTTON_BY_ID, buttonID);
    }

    public void clickToEstimateShippingButton() {
        waitForElementClickable(driver, UserCartPageUI.ESTIMATE_SHIPPING_BUTTON);
        clickToElement(driver, UserCartPageUI.ESTIMATE_SHIPPING_BUTTON);
    }

    public void selectItemAtEstimateDropdownById(String dropdownId, String value) {
        waitForElementClickable(driver, UserCartPageUI.ESTIMATE_SHIPPING_DROPDOWN_BY_ID, dropdownId);
        selectItemInDefaultDropdown(driver, UserCartPageUI.ESTIMATE_SHIPPING_DROPDOWN_BY_ID, value, dropdownId);
    }

    public void inputToEstimateZipTextbox(String value) {
        waitForElementVisible(driver, UserCartPageUI.ESTIMATE_SHIPPING_ZIP_TEXTBOX);
        sendkeysToElement(driver, UserCartPageUI.ESTIMATE_SHIPPING_ZIP_TEXTBOX, value);
    }

    public void clickToEstimateApplyButton() {
        sleepInSecond(1);
        waitForElementClickable(driver, UserCartPageUI.ESTIMATE_SHIPPING_APPLY_BUTTON);
        clickToElement(driver, UserCartPageUI.ESTIMATE_SHIPPING_APPLY_BUTTON);
    }

    public String getTotalPriceText() {
        waitForElementVisible(driver, UserCartPageUI.TOTAL_PRICE_TEXT);
        return getElementAttribute(driver, UserCartPageUI.TOTAL_PRICE_TEXT, "innerText");
    }

    public void checkToTermCheckbox() {
        waitForElementClickable(driver, UserCartPageUI.TERM_CHECKBOX);
        clickToElement(driver, UserCartPageUI.TERM_CHECKBOX);
    }
}
