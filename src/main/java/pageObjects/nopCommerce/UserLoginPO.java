package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserLoginPageUI;

public class UserLoginPO extends BasePage {
    WebDriver driver;

    public UserLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToButtonByButtonText(String buttonText) {
        waitForElementClickable(driver, UserLoginPageUI.BUTTON_BY_BUTTON_TEXT, buttonText);
        clickToElement(driver, UserLoginPageUI.BUTTON_BY_BUTTON_TEXT, buttonText);
    }

    public String getErrorMessageTextByTextboxID(String textboxID) {
        waitForElementVisible(driver, UserLoginPageUI.ERROR_MESSAGE_BY_ID, textboxID);
        return getElementText(driver, UserLoginPageUI.ERROR_MESSAGE_BY_ID, textboxID);
    }

    public void inputToLoginTextboxByTextboxId(String textboxID, String value) {
        waitForElementVisible(driver, UserLoginPageUI.LOGIN_TEXTBOX_BY_TEXTBOX_ID, textboxID);
        sendkeysToElement(driver, UserLoginPageUI.LOGIN_TEXTBOX_BY_TEXTBOX_ID, value, textboxID);
    }

    public String getUnsuccessfulErrorMessageText() {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_NOT_REGISTERED_ERROR_MESSAGE_TEXT);
        return getElementText(driver, UserLoginPageUI.EMAIL_NOT_REGISTERED_ERROR_MESSAGE_TEXT);
    }

}
