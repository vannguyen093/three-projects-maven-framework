package pageObjects.liveGuru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveGuru.UserSearchResultPageUI;

public class UserSearchResultPageObject extends BasePage {
    WebDriver driver;

    public UserSearchResultPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public int getSearchResultSize() {
        waitForElementVisible(driver, UserSearchResultPageUI.SEARCH_RESULT_GRID);
        return getElementSize(driver, UserSearchResultPageUI.SEARCH_RESULT_GRID);
    }
}
