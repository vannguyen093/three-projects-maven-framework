package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserSearchPageUI;

public class UserSearchPO extends BasePage {
    WebDriver driver;

    public UserSearchPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToSearchButton() {
        waitForElementClickable(driver, UserSearchPageUI.SEARCH_BUTTON);
        clickToElement(driver, UserSearchPageUI.SEARCH_BUTTON);
    }

    public String getSearchErrMessageText() {
        waitForElementVisible(driver, UserSearchPageUI.SEARCH_ERROR_MESSAGE_TEXT);
        return getElementText(driver, UserSearchPageUI.SEARCH_ERROR_MESSAGE_TEXT);
    }

    public void inputToSearchTextbox(String searchText) {
        waitForElementVisible(driver, UserSearchPageUI.SEARCH_TEXTBOX);
        sendkeysToElement(driver, UserSearchPageUI.SEARCH_TEXTBOX, searchText);
    }

    public boolean isNoResutlMessageDisplayed() {
        waitForElementVisible(driver, UserSearchPageUI.NO_RESULT_MESSAGE_TEXT);
        return isElementDisplayed(driver, UserSearchPageUI.NO_RESULT_MESSAGE_TEXT);
    }

    public int getSearchResultSize() {
        waitForElementVisible(driver, UserSearchPageUI.SEARCH_PRODUCT_TITLE_TEXT);
        return getElementSize(driver, UserSearchPageUI.SEARCH_PRODUCT_TITLE_TEXT);
    }

    public void clickToCheckBoxById(String checkboxID) {
        waitForElementClickable(driver, UserSearchPageUI.SEARCH_CHECKBOX_BY_ID, checkboxID);
        checkToDefaultCheckboxRadio(driver, UserSearchPageUI.SEARCH_CHECKBOX_BY_ID, checkboxID);
    }

    public void selectItemAtDropdownById(String dropboxID, String value) {
        waitForElementClickable(driver, UserSearchPageUI.SEARCH_SELECT_DROPDOWN_BY_ID, dropboxID);
        selectItemInDefaultDropdown(driver, UserSearchPageUI.SEARCH_SELECT_DROPDOWN_BY_ID, value, dropboxID);
    }
}
