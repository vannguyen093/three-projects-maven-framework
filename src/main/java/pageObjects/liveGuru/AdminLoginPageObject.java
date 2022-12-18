package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.AdminHomePageUI;
import pageUIs.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
    WebDriver driver;

    public AdminLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToTextboxById(String textboxID, String value) {
        waitForElementVisible(driver, AdminLoginPageUI.LOGIN_TEXTBOX_BY_ID, textboxID);
        sendkeysToElement(driver, AdminLoginPageUI.LOGIN_TEXTBOX_BY_ID, value, textboxID);
    }

    public AdminHomePageObject clickToLoginButton() {
        waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
        return PageGenerateManager.getAdminHomePage(driver);
    }

}
