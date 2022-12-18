package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserAddressesPageUI;

public class UserAddressesPO extends BasePage {
    WebDriver driver;

    public UserAddressesPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToButtonByButtonText(String buttonText) {
        waitForElementClickable(driver, UserAddressesPageUI.ADDRESSES_BUTTON_BY_BUTTON_TEXT, buttonText);
        clickToElement(driver, UserAddressesPageUI.ADDRESSES_BUTTON_BY_BUTTON_TEXT, buttonText);
    }

    public void inputToAddressesTextboxByTextboxId(String textboxId, String value) {
        waitForElementVisible(driver, UserAddressesPageUI.ADDRESSES_TEXTBOX_BY_TEXTBOX_ID, textboxId);
        sendkeysToElement(driver, UserAddressesPageUI.ADDRESSES_TEXTBOX_BY_TEXTBOX_ID, value, textboxId);
    }

    public void selectItemInDropboxByDropboxId(String dropboxboxId, String value) {
        waitForElementVisible(driver, UserAddressesPageUI.ADDRESSES_DROPBOX_BY_DROPBOX_ID, dropboxboxId);
        selectItemInDefaultDropdown(driver, UserAddressesPageUI.ADDRESSES_DROPBOX_BY_DROPBOX_ID, value, dropboxboxId);
    }

    public String getAddressesTextByClass(String classText) {
        waitForElementVisible(driver, UserAddressesPageUI.ADDRESSES_INFO_AT_ROW_BY_CLASS_TEXT, classText);
        return getElementText(driver, UserAddressesPageUI.ADDRESSES_INFO_AT_ROW_BY_CLASS_TEXT, classText);
    }
}
