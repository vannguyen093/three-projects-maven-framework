package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserCheckOutPageUI;

public class UserCheckOutPO extends BasePage {
    WebDriver driver;

    public UserCheckOutPO(WebDriver driver) {
        this.driver = driver;
    }

    public void unCheckToSameAddressCheckbox() {
        waitForElementClickable(driver, UserCheckOutPageUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);
        uncheckToDefaultCheckboxRadio(driver, UserCheckOutPageUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);
    }

    public void inputToCheckoutTextboxByTextboxId(String textboxId, String value) {
        waitForElementVisible(driver, UserCheckOutPageUI.CHECK_OUT_TEXTBOX_BY_ID, textboxId);
        sendkeysToElement(driver, UserCheckOutPageUI.CHECK_OUT_TEXTBOX_BY_ID, value, textboxId);
    }

    public void selectItemAtDropDownByDropdownId(String dropdownId, String value) {
        waitForElementClickable(driver, UserCheckOutPageUI.CHECK_OUT_DROPDOWN_BY_ID, dropdownId);
        selectItemInDefaultDropdown(driver, UserCheckOutPageUI.CHECK_OUT_DROPDOWN_BY_ID, value, dropdownId);
    }

    public void clickCheckOutButtonByName(String buttonName) {
        waitForElementClickable(driver, UserCheckOutPageUI.CHECK_OUT_BUTTON_BY_NAME, buttonName);
        clickToElement(driver, UserCheckOutPageUI.CHECK_OUT_BUTTON_BY_NAME, buttonName);
    }

    public void checkToRadioByRadioText(String radioText) {
        waitForElementClickable(driver, UserCheckOutPageUI.PAYMENT_METHOD_RADIO_BY_TEXT, radioText);
        checkToDefaultCheckboxRadio(driver, UserCheckOutPageUI.PAYMENT_METHOD_RADIO_BY_TEXT, radioText);
    }

    public String getCheckOutInfoTextByClass(String infoDivClass, String infoLiClass) {
        waitForElementVisible(driver, UserCheckOutPageUI.CHECK_OUT_INFO_BY_CLASS, infoDivClass, infoLiClass);
        return getElementText(driver, UserCheckOutPageUI.CHECK_OUT_INFO_BY_CLASS, infoDivClass, infoLiClass);
    }

    public boolean isCheckOutMethodDisplayed(String methodClass) {
        waitForElementVisible(driver, UserCheckOutPageUI.CHECK_OUT_METHOD_BY_TEXT, methodClass);
        return isElementDisplayed(driver, UserCheckOutPageUI.CHECK_OUT_METHOD_BY_TEXT, methodClass);
    }

    public String getCheckOutProductTitleText() {
        waitForElementVisible(driver, UserCheckOutPageUI.PRODUCT_TITLE_TEXT);
        return getElementText(driver, UserCheckOutPageUI.PRODUCT_TITLE_TEXT);
    }

    public String getCheckOutProductPriceText() {
        waitForElementVisible(driver, UserCheckOutPageUI.PRODUCT_PRICE_TEXT);
        return getElementText(driver, UserCheckOutPageUI.PRODUCT_PRICE_TEXT);
    }

    public String getCheckOutSuccessMessageText() {
        waitForElementVisible(driver, UserCheckOutPageUI.CHECK_OUT_SUCCESSFUL_MESSAGE_TEXT);
        return getElementText(driver, UserCheckOutPageUI.CHECK_OUT_SUCCESSFUL_MESSAGE_TEXT);
    }

    public String getOrderNumberTextAtCheckOutPage() {
        waitForElementVisible(driver, UserCheckOutPageUI.ORDER_NUMBER_TEXT);
        String orderNumber = getElementText(driver, UserCheckOutPageUI.ORDER_NUMBER_TEXT).substring(15, 18);
        return orderNumber;
    }

    public UserHomePO clickToContinueButtonAtSuccessPage() {
        waitForElementClickable(driver, UserCheckOutPageUI.CONTINUE_BUTTON_AT_SUCCESS_PAGE);
        clickToElement(driver, UserCheckOutPageUI.CONTINUE_BUTTON_AT_SUCCESS_PAGE);
        return PageGenerateManager.getUserHomePage(driver);
    }
}

