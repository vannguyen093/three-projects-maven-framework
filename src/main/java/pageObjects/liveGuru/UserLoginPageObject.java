package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
    WebDriver driver;

    public UserLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToTextboxById(String textboxID, String value) {
        waitForElementVisible(driver, UserLoginPageUI.LOGIN_TEXTBOX_BY_ID, textboxID);
        sendkeysToElement(driver, UserLoginPageUI.LOGIN_TEXTBOX_BY_ID, value, textboxID);
    }

    public UserRegisterPageObject clickToCreateAccountButton() {
        waitForElementClickable(driver, UserLoginPageUI.CREATE_ACCOUNT_BUTTON);
        clickToElement(driver, UserLoginPageUI.CREATE_ACCOUNT_BUTTON);
        return PageGenerateManager.getUserRegisterPage(driver);
    }

    public UserMyDashboardPageObject clickToLoginButton() {
        waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
        return PageGenerateManager.getUserMyDashboardPage(driver);
    }
}
