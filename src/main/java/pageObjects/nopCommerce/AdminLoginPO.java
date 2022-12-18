package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.AdminLoginPageUI;

public class AdminLoginPO extends BasePage {
    WebDriver driver;

    public AdminLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToLoginTextboxByTextboxId(String textboxId, String value) {
        waitForElementVisible(driver, AdminLoginPageUI.LOGIN_TEXTBOX_BY_TEXTBOX_ID, textboxId);
        sendkeysToElement(driver, AdminLoginPageUI.LOGIN_TEXTBOX_BY_TEXTBOX_ID, value, textboxId);
    }

    public AdminDashboardPO clickToLoginButton() {
        waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
        return PageGenerateManager.getAdminDashboardPage(driver);
    }
}
