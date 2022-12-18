package pageObjects.bankGuru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.bankGuru.NewCustomerPageUI;

public class NewCustomerPageObject extends BasePage {
    WebDriver driver;

    public NewCustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToTextboxByName(String elementName, String value) {
        waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_ELEMENT_BY_ELEMENT_NAME, elementName);
        sendkeysToElement(driver, NewCustomerPageUI.DYNAMIC_ELEMENT_BY_ELEMENT_NAME, value, elementName);
    }

    public void selectItemAtGenderRadioByElementName(String genderText) {
        waitForElementVisible(driver, NewCustomerPageUI.GENDER_RADIO, genderText);
        checkToDefaultCheckboxRadio(driver, NewCustomerPageUI.GENDER_RADIO, genderText);
    }

    public void inputToAddressTextArea(String address) {
        waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXT_AREA, address);
        sendkeysToElement(driver, NewCustomerPageUI.ADDRESS_TEXT_AREA, address);
    }

    public void inputToDateOfBirthDatePicker(String dateOfBirthText) {
        waitForElementVisible(driver, NewCustomerPageUI.DATE_OF_BIRTH_DATEPICKER);
        removeAttributeInDOMByJS(driver, NewCustomerPageUI.DATE_OF_BIRTH_DATEPICKER, "type");
        sendkeysToElement(driver, NewCustomerPageUI.DATE_OF_BIRTH_DATEPICKER, dateOfBirthText);
    }
}
