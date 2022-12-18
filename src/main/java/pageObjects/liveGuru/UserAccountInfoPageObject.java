package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserAccountInfoPageUI;

public class UserAccountInfoPageObject extends BasePage {
    WebDriver driver;

    public UserAccountInfoPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextboxValueByID(String textboxID) {
        waitForElementVisible(driver, UserAccountInfoPageUI.REGISTERED_ACCOUNT_INFO_BY_ID, textboxID);
        return getElementAttribute(driver, UserAccountInfoPageUI.REGISTERED_ACCOUNT_INFO_BY_ID, "value", textboxID);
    }

    public void inputToTextboxById(String textboxID, String value) {
        waitForElementVisible(driver, UserAccountInfoPageUI.REGISTERED_ACCOUNT_INFO_BY_ID, textboxID);
        sendkeysToElement(driver, UserAccountInfoPageUI.REGISTERED_ACCOUNT_INFO_BY_ID, value, textboxID);
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, UserAccountInfoPageUI.SAVE_BUTTON);
        clickToElement(driver, UserAccountInfoPageUI.SAVE_BUTTON);
    }
}
