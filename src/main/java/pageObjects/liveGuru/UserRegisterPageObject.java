package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserMyDashboardPageUI;
import pageUIs.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
    WebDriver driver;

    public UserRegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToTextboxById(String textboxID, String value) {
        waitForElementVisible(driver, UserRegisterPageUI.ACCOUNT_INFO_BY_ID, textboxID);
        sendkeysToElement(driver, UserRegisterPageUI.ACCOUNT_INFO_BY_ID, value, textboxID);
    }

    public UserMyDashboardPageObject clickToRegisterButton() {
        waitForElementClickable(driver, UserMyDashboardPageUI.REGISTER_BUTTON);
        clickToElement(driver, UserMyDashboardPageUI.REGISTER_BUTTON);
        return PageGenerateManager.getUserMyDashboardPage(driver);
    }
}
