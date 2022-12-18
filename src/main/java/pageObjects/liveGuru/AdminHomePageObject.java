package pageObjects;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageUIs.AdminHomePageUI;
import pageUIs.BasePageUI;

public class AdminHomePageObject extends BasePage {
    WebDriver driver;

    public AdminHomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void closeAdminPopup() {
        waitForElementClickable(driver, AdminHomePageUI.CLOSE_POPUP_BUTTON);
        clickToElement(driver, AdminHomePageUI.CLOSE_POPUP_BUTTON);
    }

    public void inputToFilterByFilterName(String filterName, String value) {
        waitForElementVisible(driver, AdminHomePageUI.FILTER_TEXTBOX_BY_FILTER_NAME, filterName);
        sendkeysToElement(driver, AdminHomePageUI.FILTER_TEXTBOX_BY_FILTER_NAME, value, filterName);
        pressKeyToElement(driver, AdminHomePageUI.FILTER_TEXTBOX_BY_FILTER_NAME, Keys.ENTER, filterName);
        sleepInSecond(1);
    }

    public boolean isRegisteredAccountDisplayed(String fullNameText, String emailAddressText) {
        waitForElementVisible(driver, AdminHomePageUI.ACCOUNT_TEXT_AT_ROW, fullNameText, emailAddressText);
        return isElementDisplayed(driver, AdminHomePageUI.ACCOUNT_TEXT_AT_ROW, fullNameText, emailAddressText);
    }

    public void selectAccountCheckboxByAccountFullName(String accountName) {
        waitForElementClickable(driver, AdminHomePageUI.ACCOUNT_CHECKBOX, accountName);
        checkToDefaultCheckboxRadio(driver, AdminHomePageUI.ACCOUNT_CHECKBOX, accountName);
    }

    public boolean isDeleteAccountUndisplayed(String accountName, String email) {
        waitForElementUndisplayed(driver, AdminHomePageUI.ACCOUNT_TEXT_AT_ROW, accountName, email);
        return isElementUndisplayed(driver, AdminHomePageUI.ACCOUNT_TEXT_AT_ROW, accountName, email);
    }

    public void selectItemAtCustomerActionDropdownByName(WebDriver driver, String actionName) {
        waitForElementClickable(driver, BasePageUI.ACTIONS_AT_CUSTOMER_DROPDOWN);
        selectItemInDefaultDropdown(driver, BasePageUI.ACTIONS_AT_CUSTOMER_DROPDOWN, actionName);
    }
}
