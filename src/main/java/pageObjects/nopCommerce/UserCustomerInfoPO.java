package pageObjects;

import com.google.common.base.CaseFormat;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserCustomerInfoPageUI;

import java.time.Month;

public class UserCustomerInfoPO extends BasePage {
    WebDriver driver;

    public UserCustomerInfoPO(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToRegisterTextboxByTextboxID(String textboxId, String value) {
        waitForElementVisible(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_TEXTBOX_BY_ID, textboxId);
        sendkeysToElement(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_TEXTBOX_BY_ID, value, textboxId);
    }

    public void selectGenderRadioByText(String genderText) {
        waitForElementClickable(driver, UserCustomerInfoPageUI.GENDER_RADIO_BY_TEXT, genderText);
        checkToDefaultCheckboxRadio(driver, UserCustomerInfoPageUI.GENDER_RADIO_BY_TEXT, genderText);
    }

    public void selectItemInDOBDropbox(String dropboxName, String value) {
        waitForElementClickable(driver, UserCustomerInfoPageUI.BIRTHDAY_SELECT_BOX_BY_NAME, dropboxName);
        selectItemInDefaultDropdown(driver, UserCustomerInfoPageUI.BIRTHDAY_SELECT_BOX_BY_NAME, value, dropboxName);
    }

    public boolean isGenderSelectedByRadioText(String radioText) {
        waitForElementVisible(driver, UserCustomerInfoPageUI.GENDER_RADIO_BY_TEXT, radioText);
        return isElementSelected(driver, UserCustomerInfoPageUI.GENDER_RADIO_BY_TEXT, radioText);
    }

    public String getCustomerInfoTextboxAttribute(String textboxID) {
        waitForElementVisible(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_TEXTBOX_BY_ID, textboxID);
        return getElementAttribute(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_TEXTBOX_BY_ID, "value", textboxID);
    }

    public String getCustomerInfoDropdownAttribute(String dropdownName) {
        waitForElementVisible(driver, UserCustomerInfoPageUI.BIRTHDAY_SELECT_BOX_BY_NAME, dropdownName);
        return getElementAttribute(driver, UserCustomerInfoPageUI.BIRTHDAY_SELECT_BOX_BY_NAME, "value", dropdownName);
    }

    public String getEditMonthAttribute(String dropdownName) {
        waitForElementVisible(driver, UserCustomerInfoPageUI.BIRTHDAY_SELECT_BOX_BY_NAME, dropdownName);
        String month = getElementAttribute(driver, UserCustomerInfoPageUI.BIRTHDAY_SELECT_BOX_BY_NAME, "value", dropdownName);
        return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, Month.of(Integer.parseInt(month)).name());
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, UserCustomerInfoPageUI.SAVE_BUTTON);
        clickToElement(driver, UserCustomerInfoPageUI.SAVE_BUTTON);
    }
}
