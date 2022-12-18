package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.EditCustomerPageUI;

public class EditCustomerPageObject extends BasePage {
    WebDriver driver;

    public EditCustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToTextboxByName(String textboxName, String value) {
        waitForElementVisible(driver, EditCustomerPageUI.DYNAMIC_ELEMENT_BY_ELEMENT_NAME, textboxName);
        sendkeysToElement(driver, EditCustomerPageUI.DYNAMIC_ELEMENT_BY_ELEMENT_NAME, value, textboxName);
    }

    public void inputToEditAddressTextArea(String value) {
        waitForElementVisible(driver, EditCustomerPageUI.ADDRESS_TEXT_AREA);
        sendkeysToElement(driver, EditCustomerPageUI.ADDRESS_TEXT_AREA, value);
    }
}
