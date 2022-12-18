package pageObjects;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageUIs.AdminCustomersPageUI;

public class AdminCustomersPO extends BasePage {
    WebDriver driver;

    public AdminCustomersPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToAddNewButton() {
        waitForElementClickable(driver, AdminCustomersPageUI.ADD_NEW_BUTTON);
        clickToElement(driver, AdminCustomersPageUI.ADD_NEW_BUTTON);
    }

    public void inputToCustomerTextboxByTextboxId(String textboxId, String value) {
        waitForElementVisible(driver, AdminCustomersPageUI.CUSTOMER_TEXTBOX_BY_TEBOX_ID, textboxId);
        sendkeysToElement(driver, AdminCustomersPageUI.CUSTOMER_TEXTBOX_BY_TEBOX_ID, value, textboxId);
    }

    public void selectGenderByGenderText(String genderText) {
        waitForElementClickable(driver, AdminCustomersPageUI.NEW_CUSTOMER_GENDER_RADIO_BY_GENDER_TEXT, genderText);
        checkToDefaultCheckboxRadio(driver, AdminCustomersPageUI.NEW_CUSTOMER_GENDER_RADIO_BY_GENDER_TEXT, genderText);
    }

    public void selectNewCustomerRoleDropdown(String customerRoleText) {
        waitForElementVisible(driver, AdminCustomersPageUI.NEW_CUSTOMER_ROLE_TEXTBOX);
        sendkeysToElement(driver, AdminCustomersPageUI.NEW_CUSTOMER_ROLE_TEXTBOX, customerRoleText);
        pressKeyToElement(driver, AdminCustomersPageUI.NEW_CUSTOMER_ROLE_TEXTBOX, Keys.ENTER);
    }

    public void inputToNewCustomerAdminCommentTextarea(String value) {
        waitForElementVisible(driver, AdminCustomersPageUI.NEW_CUSTOMER_ADMIN_TEXTAREA);
        sendkeysToElement(driver, AdminCustomersPageUI.NEW_CUSTOMER_ADMIN_TEXTAREA, value);
    }

    public void clickToNewCustomerButtonByButtonText(String buttonText) {
        waitForElementClickable(driver, AdminCustomersPageUI.NEW_CUSTOMER_BUTTON_BY_BUTTON_TEXT, buttonText);
        clickToElement(driver, AdminCustomersPageUI.NEW_CUSTOMER_BUTTON_BY_BUTTON_TEXT, buttonText);
    }

    public String getCustomerSuccessMessageText() {
        waitForElementVisible(driver, AdminCustomersPageUI.CUSTOMER_MESSAGE_TEXT);
        return getElementText(driver, AdminCustomersPageUI.CUSTOMER_MESSAGE_TEXT);
    }

    public String getCustomerAttributeByTextboxId(String textboxId) {
        waitForElementVisible(driver, AdminCustomersPageUI.CUSTOMER_TEXTBOX_BY_TEBOX_ID, textboxId);
        return getElementAttribute(driver, AdminCustomersPageUI.CUSTOMER_TEXTBOX_BY_TEBOX_ID, "value",textboxId);
    }

    public boolean isGenderSelectedByGenderText(String genderText) {
        waitForElementVisible(driver, AdminCustomersPageUI.NEW_CUSTOMER_GENDER_RADIO_BY_GENDER_TEXT, genderText);
        return isElementSelected(driver, AdminCustomersPageUI.NEW_CUSTOMER_GENDER_RADIO_BY_GENDER_TEXT, genderText);
    }

    public String getNewCustomerAttributeByDropdown() {
        waitForElementVisible(driver, AdminCustomersPageUI.NEW_CUSTOMER_PARENT_ROLE_DROPDOWN);
        return getElementAttribute(driver, AdminCustomersPageUI.NEW_CUSTOMER_PARENT_ROLE_DROPDOWN, "textContent");
    }

    public String getNewCustomerAttributeAtAdminCommentTextarea() {
        waitForElementVisible(driver, AdminCustomersPageUI.NEW_CUSTOMER_ADMIN_TEXTAREA);
        return getElementAttribute(driver, AdminCustomersPageUI.NEW_CUSTOMER_ADMIN_TEXTAREA, "value");
    }

    public void clickToBackToCustomerLinkByText(String linkText) {
        waitForElementClickable(driver, AdminCustomersPageUI.BACK_TO_CUSTOMER_LINK, linkText);
        clickToElement(driver, AdminCustomersPageUI.BACK_TO_CUSTOMER_LINK, linkText);
    }

    public void unSelectCustomerRoleByText(String customerRoleText) {
        waitForElementClickable(driver, AdminCustomersPageUI.NEW_CUSTOMER_CLOSE_BUTTON_BY_CUSTOMER_ROLE_TEXT, customerRoleText);
        clickToElement(driver, AdminCustomersPageUI.NEW_CUSTOMER_CLOSE_BUTTON_BY_CUSTOMER_ROLE_TEXT, customerRoleText);
    }

    public void clickToSearchButton() {
        waitForElementClickable(driver, AdminCustomersPageUI.CUSTOMER_SEARCH_BUTTON);
        clickToElement(driver, AdminCustomersPageUI.CUSTOMER_SEARCH_BUTTON);
    }

    public boolean isCustomerFullNameDisplayedAtTable(String value) {
        waitForElementVisible(driver, AdminCustomersPageUI.CUSTOMER_FULL_NAME_TEXT, value);
        return isElementDisplayed(driver, AdminCustomersPageUI.CUSTOMER_FULL_NAME_TEXT, value);
    }

    public void selectCustomerRoleDropdown(String customerRoleText) {
        waitForElementVisible(driver, AdminCustomersPageUI.CUSTOMER_ROLE_TEXTBOX);
        sendkeysToElement(driver, AdminCustomersPageUI.CUSTOMER_ROLE_TEXTBOX, customerRoleText);
        pressKeyToElement(driver, AdminCustomersPageUI.CUSTOMER_ROLE_TEXTBOX, Keys.ENTER);
    }

    public int getCustomerTableSize(String value) {
        waitForElementVisible(driver, AdminCustomersPageUI.CUSTOMER_FULL_NAME_TEXT, value);
        return getElementSize(driver, AdminCustomersPageUI.CUSTOMER_FULL_NAME_TEXT, value);
    }

    public void clickToEditButtonByCustomerFullNameText(String fullNameText) {
        waitForElementClickable(driver, AdminCustomersPageUI.CUSTOMER_EDIT_BUTTON_BY_FULL_NAME_TEXT, fullNameText);
        clickToElement(driver, AdminCustomersPageUI.CUSTOMER_EDIT_BUTTON_BY_FULL_NAME_TEXT, fullNameText);
    }

    public void clickToCustomerTabByTabName(String addressTabText) {
        waitForElementClickable(driver, AdminCustomersPageUI.CUSTOMER_TAB_BY_TAB_NAME, addressTabText);
        clickToElement(driver, AdminCustomersPageUI.CUSTOMER_TAB_BY_TAB_NAME, addressTabText);
    }

    public void selectItemAtAddressDropdownByDropdownId(String dropdownId, String value) {
        waitForElementClickable(driver, AdminCustomersPageUI.CUSTOMER_ADDRESS_DROPDOWN_BY_DROPDOWN_ID, dropdownId);
        selectItemInDefaultDropdown(driver, AdminCustomersPageUI.CUSTOMER_ADDRESS_DROPDOWN_BY_DROPDOWN_ID, value, dropdownId);
    }

    public String getAddressDropdownTextByDropdownId(String dropdownId) {
        waitForElementVisible(driver, AdminCustomersPageUI.CUSTOMER_ADDRESS_DROPDOWN_BY_DROPDOWN_ID, dropdownId);
        return getFirstSelectedItemDefaultDropdown(driver, AdminCustomersPageUI.CUSTOMER_ADDRESS_DROPDOWN_BY_DROPDOWN_ID, dropdownId);
    }

    public void clickToCustomerAddressButtonLinkByEmailAndText(String emailText, String buttonLinkText) {
        waitForElementClickable(driver, AdminCustomersPageUI.CUSTOMER_DETAIL_ADDRESS_BUTTON_LINK_BY_TEXT, emailText, buttonLinkText);
        clickToElement(driver, AdminCustomersPageUI.CUSTOMER_DETAIL_ADDRESS_BUTTON_LINK_BY_TEXT, emailText, buttonLinkText);
    }

    public boolean isEditAddressDisplayed(String editAddrFirstName, String editAddrLastName, String editAddrEmail) {
        waitForElementVisible(driver, AdminCustomersPageUI.CUSTOMER_DETAIL_ADDRESS_INFO_TEXT, editAddrFirstName, editAddrLastName, editAddrEmail);
        return isElementDisplayed(driver, AdminCustomersPageUI.CUSTOMER_DETAIL_ADDRESS_INFO_TEXT, editAddrFirstName, editAddrLastName, editAddrEmail);
    }

    public void acceptDeleteAlert() {
        waitForAlertPresence(driver);
        acceptAlert(driver);
        sleepInSecond(1);
    }

    public String getNoDataMessageTextAtAddressTable() {
        waitForElementVisible(driver, AdminCustomersPageUI.CUSTOMER_DETAIL_ADDRESS_NO_DATA_TEXT);
        return getElementText(driver, AdminCustomersPageUI.CUSTOMER_DETAIL_ADDRESS_NO_DATA_TEXT);
    }
}
