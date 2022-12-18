package pageObjects.liveGuru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveGuru.UserAdvancedSearchPageUI;

public class UserAdvancedSearchPageObject extends BasePage {
    WebDriver driver;

    public UserAdvancedSearchPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToSearchSettingTextboxById(String textboxId, String value) {
        waitForElementVisible(driver, UserAdvancedSearchPageUI.SEARCH_SETTING_TEXTBOX_BY_ID, textboxId);
        sendkeysToElement(driver, UserAdvancedSearchPageUI.SEARCH_SETTING_TEXTBOX_BY_ID, value, textboxId);
    }

    public UserSearchResultPageObject clickToSearchButton() {
        waitForElementClickable(driver, UserAdvancedSearchPageUI.SEARCH_BUTTON);
        clickToElement(driver, UserAdvancedSearchPageUI.SEARCH_BUTTON);
        return PageGenerateManager.getUserSearchResultPage(driver);
    }
}
