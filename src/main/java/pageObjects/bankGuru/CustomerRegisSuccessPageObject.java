package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.CustomerRegisSuccessPageUI;

public class CustomerRegisSuccessPageObject extends BasePage {
    WebDriver driver;

    public CustomerRegisSuccessPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getCustomerSuccessValueByTextField(String customerSuccessText) {
        waitForElementVisible(driver, CustomerRegisSuccessPageUI.CUSTOMER_SUCCESS_VALUE_BY_TEXT_FIELD, customerSuccessText);
        return getElementText(driver, CustomerRegisSuccessPageUI.CUSTOMER_SUCCESS_VALUE_BY_TEXT_FIELD, customerSuccessText);
    }

    public boolean isRegisterSuccessMessageDisplayed() {
        waitForElementVisible(driver, CustomerRegisSuccessPageUI.SUCCESS_MESSAGE_HEADER);
        return isElementDisplayed(driver, CustomerRegisSuccessPageUI.SUCCESS_MESSAGE_HEADER);
    }

    public HomePageObject clickToContinueLink() {
        waitForElementClickable(driver, CustomerRegisSuccessPageUI.CONTINUE_LINK);
        clickToElement(driver, CustomerRegisSuccessPageUI.CONTINUE_LINK);
        return PageGenerateManager.getHomePage(driver);
    }

    public String getCustomerID() {
        waitForElementVisible(driver, CustomerRegisSuccessPageUI.CUSTOMER_ID_TEXT);
        return getElementAttribute(driver, CustomerRegisSuccessPageUI.CUSTOMER_ID_TEXT, "textContent");
    }
}
