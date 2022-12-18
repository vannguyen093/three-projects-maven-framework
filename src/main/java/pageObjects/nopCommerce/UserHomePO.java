package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserHomePageUI;

public class UserHomePO extends BasePage {
    WebDriver driver;

    public UserHomePO(WebDriver driver) {
        this.driver = driver;
    }

    public String getHomePageTitle() {
        waitForElementVisible(driver, UserHomePageUI.HOME_PAGE_TITLE_TEXT);
        return getElementText(driver, UserHomePageUI.HOME_PAGE_TITLE_TEXT);
    }
}
