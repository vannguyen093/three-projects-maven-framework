package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserRegisterPageUI;

public class UserRegisterPO extends BasePage {
    WebDriver driver;

    public UserRegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
    }

    public String getErrorMessageTextByTextboxID(String textboxID) {
        waitForElementVisible(driver, UserRegisterPageUI.ERROR_MESSAGE_BY_TEXTBOX_ID, textboxID);
        return getElementText(driver, UserRegisterPageUI.ERROR_MESSAGE_BY_TEXTBOX_ID, textboxID);
    }

    public void inputToRegisterTextboxByTextboxID(String textboxId, String value) {
        waitForElementVisible(driver, UserRegisterPageUI.REGISTER_TEXTBOX_BY_ID, textboxId);
        sendkeysToElement(driver, UserRegisterPageUI.REGISTER_TEXTBOX_BY_ID, value, textboxId);
    }

    public void selectGenderRadioByText(String genderText) {
        waitForElementClickable(driver, UserRegisterPageUI.GENDER_RADIO_BY_TEXT, genderText);
        checkToDefaultCheckboxRadio(driver, UserRegisterPageUI.GENDER_RADIO_BY_TEXT, genderText);
    }

    public void selectItemInDOBDropbox(String dropboxName, String value) {
        waitForElementClickable(driver, UserRegisterPageUI.BIRTHDAY_SELECT_BOX_BY_NAME, dropboxName);
        selectItemInDefaultDropdown(driver, UserRegisterPageUI.BIRTHDAY_SELECT_BOX_BY_NAME, value, dropboxName);
    }

    public boolean isRegisterSuccessfulMessageDisplay() {
        waitForElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESSFUL_MESSAGE_TEXT);
        return isElementDisplayed(driver, UserRegisterPageUI.REGISTER_SUCCESSFUL_MESSAGE_TEXT);
    }

    public UserHomePO clickToContinueLink() {
        waitForElementClickable(driver, UserRegisterPageUI.CONTINUE_BUTTON);
        clickToElement(driver, UserRegisterPageUI.CONTINUE_BUTTON);
        return PageGenerateManager.getUserHomePage(driver);
    }

    public String getExistingEmailErrMessText() {
        waitForElementVisible(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE_TEXT);
        return getElementText(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE_TEXT);
    }
}
