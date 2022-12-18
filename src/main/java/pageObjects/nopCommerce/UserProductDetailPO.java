package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserProductDetailPageUI;

public class UserProductDetailPO extends BasePage {
    WebDriver driver;

    public UserProductDetailPO(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductTitleText() {
        waitForElementVisible(driver, UserProductDetailPageUI.PRODUCT_DETAIL_TITLE_TEXT);
        return getElementText(driver, UserProductDetailPageUI.PRODUCT_DETAIL_TITLE_TEXT);
    }

    public UserProductReviewPO clickToAddReviewLink() {
        waitForElementClickable(driver, UserProductDetailPageUI.ADD_REVIEW_LINK);
        clickToElement(driver, UserProductDetailPageUI.ADD_REVIEW_LINK);
        return PageGenerateManager.getUserProductReviewPage(driver);
    }

    public void clickToProductDetailButtonByText(String productDetailButtonText) {
        waitForElementClickable(driver, UserProductDetailPageUI.PRODUCT_DETAIL_BUTTON_BY_TEXT, productDetailButtonText);
        clickToElement(driver, UserProductDetailPageUI.PRODUCT_DETAIL_BUTTON_BY_TEXT, productDetailButtonText);
    }

    public void waitLoadingIconInvisible() {
        waitForElementInvisible(driver, UserProductDetailPageUI.LOADING_ICON);
    }

    public void selectItemAtDropdownbyText(String dropdownID, String value) {
        waitForElementClickable(driver, UserProductDetailPageUI.PRODUCT_DROPDOWN_BY_ID, dropdownID);
        selectItemInDefaultDropdown(driver, UserProductDetailPageUI.PRODUCT_DROPDOWN_BY_ID, value, dropdownID);
    }

    public void selectItemAtRadioCheckboxbyText(String value) {
        waitForElementClickable(driver, UserProductDetailPageUI.PRODUCT_RADIO_CHECKBOX_BY_TEXT, value);
        checkToDefaultCheckboxRadio(driver, UserProductDetailPageUI.PRODUCT_RADIO_CHECKBOX_BY_TEXT, value);
    }

    public String getProductPriceText() {
        waitForElementVisible(driver, UserProductDetailPageUI.PRODUCT_PRICE_TEXT);
        sleepInSecond(2);
        return getElementText(driver, UserProductDetailPageUI.PRODUCT_PRICE_TEXT);
    }

    public void clickToAddToCartUpdateButton() {
        waitForElementClickable(driver, UserProductDetailPageUI.ADD_TO_CART_BUTTON);
        clickToElement(driver, UserProductDetailPageUI.ADD_TO_CART_BUTTON);
    }

    public boolean isProductCartTitleDisplayed(String productCartTitle) {
        waitForElementVisible(driver, UserProductDetailPageUI.PRODUCT_TITLE_AT_MINI_CART_TEXT, productCartTitle);
        return isElementDisplayed(driver, UserProductDetailPageUI.PRODUCT_TITLE_AT_MINI_CART_TEXT, productCartTitle);
    }

    public String isProductCartAttributeDisplayed() {
        waitForElementVisible(driver, UserProductDetailPageUI.PRODUCT_ATTRIBUTE_AT_MINI_CART_TEXT);
        return getElementText(driver, UserProductDetailPageUI.PRODUCT_ATTRIBUTE_AT_MINI_CART_TEXT);
    }

    public String getProductPriceAtMiniCart() {
        waitForElementVisible(driver, UserProductDetailPageUI.PRODUCT_PRICE_AT_MINI_CART_TEXT);
        return getElementText(driver, UserProductDetailPageUI.PRODUCT_PRICE_AT_MINI_CART_TEXT);
    }

    public void unSelectItemAtRadioCheckboxbyText(String desktopSoftware) {
        waitForElementClickable(driver, UserProductDetailPageUI.PRODUCT_RADIO_CHECKBOX_BY_TEXT, desktopSoftware);
        uncheckToDefaultCheckboxRadio(driver, UserProductDetailPageUI.PRODUCT_RADIO_CHECKBOX_BY_TEXT, desktopSoftware);
    }

    public void inputToQuantityTextbox(String value) {
        waitForElementVisible(driver, UserProductDetailPageUI.QUANTITY_TEXTBOX);
        sendkeysToElement(driver, UserProductDetailPageUI.QUANTITY_TEXTBOX, value);
    }

    public boolean getProductQuantityAtMiniCartText(String quantityText) {
        waitForElementVisible(driver, UserProductDetailPageUI.NUMBER_PRODUCT_AT_MINI_CART_TEXT, quantityText);
        return isElementDisplayed(driver, UserProductDetailPageUI.NUMBER_PRODUCT_AT_MINI_CART_TEXT, quantityText);
    }
}
