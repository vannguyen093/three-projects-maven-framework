package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserMyDashboardPageUI;

public class UserMyDashboardPageObject extends BasePage {
    WebDriver driver;

    public UserMyDashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isRegisterdSuccessMessageDisplayed() {
        waitForElementVisible(driver, UserMyDashboardPageUI.REGISTERED_SUCCESSFULLY_MESSAGE_TEXT);
        return isElementDisplayed(driver, UserMyDashboardPageUI.REGISTERED_SUCCESSFULLY_MESSAGE_TEXT);
    }

    public boolean isMyDashboardTitleDisplayed() {
        waitForElementVisible(driver, UserMyDashboardPageUI.MY_DASHBOARD_TITLE_TEXT);
        return isElementDisplayed(driver, UserMyDashboardPageUI.MY_DASHBOARD_TITLE_TEXT);
    }
}
