package pageObjects.bankGuru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.bankGuru.PreEditCustomerPageUI;

public class PreEditCustomerPageObject extends BasePage {
    WebDriver driver;

    public PreEditCustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToCustomerIDTextBox(String customerID) {
        waitForElementVisible(driver, PreEditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
        sendkeysToElement(driver, PreEditCustomerPageUI.CUSTOMER_ID_TEXTBOX, customerID);
    }
}
