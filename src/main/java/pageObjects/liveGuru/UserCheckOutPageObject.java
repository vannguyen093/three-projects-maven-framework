package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserCheckOutPageUI;

public class UserCheckOutPageObject extends BasePage {
    WebDriver driver;

    public UserCheckOutPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToTextboxByTitle(String textboxTitle, String value) {
        waitForElementVisible(driver, UserCheckOutPageUI.BILLING_INFO_TEXTBOX_BY_TEXTBOX_ID, textboxTitle);
        sendkeysToElement(driver, UserCheckOutPageUI.BILLING_INFO_TEXTBOX_BY_TEXTBOX_ID, value, textboxTitle);
    }

    public void clickToContinueAtBillingInfoTab() {
        waitForElementClickable(driver, UserCheckOutPageUI.CONTINUE_BUTTON_AT_BILLING_INFO_TAB);
        clickToElement(driver, UserCheckOutPageUI.CONTINUE_BUTTON_AT_BILLING_INFO_TAB);
    }

    public void clickToContinueAtShippingMethodTab() {
        waitForElementClickable(driver, UserCheckOutPageUI.CONTINUE_BUTTON_AT_SHIPPING_METHOD_TAB);
        clickToElement(driver, UserCheckOutPageUI.CONTINUE_BUTTON_AT_SHIPPING_METHOD_TAB);
    }

    public void checkToRadioPaymentInfoByRadioTitle(String radioTitle) {
        waitForElementClickable(driver, UserCheckOutPageUI.PAYMENT_INFO_RADIO_BY_TITLE_TEXT, radioTitle);
        checkToDefaultCheckboxRadio(driver, UserCheckOutPageUI.PAYMENT_INFO_RADIO_BY_TITLE_TEXT, radioTitle);
    }

    public UserSuccessCheckOutPageObject clickToPlaceOrderButton() {
        waitForElementClickable(driver, UserCheckOutPageUI.PLACE_ORDER_BUTTON);
        clickToElement(driver, UserCheckOutPageUI.PLACE_ORDER_BUTTON);
        return new UserSuccessCheckOutPageObject(driver);
    }

    public void selectItemInDropdownAtBillingInfoTab(String radioTitle, String value) {
        waitForElementClickable(driver, UserCheckOutPageUI.BILLING_INFO_RADIO_BY_RADIO_ID, radioTitle);
        selectItemInDefaultDropdown(driver, UserCheckOutPageUI.BILLING_INFO_RADIO_BY_RADIO_ID, value, radioTitle);
    }

    public void clickToContinueAtPaymentInfoTab() {
        waitForElementClickable(driver, UserCheckOutPageUI.CONTINUE_BUTTON_AT_PAYMENT_INFO_TAB);
        clickToElement(driver, UserCheckOutPageUI.CONTINUE_BUTTON_AT_PAYMENT_INFO_TAB);
    }
}
