package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.AdminProductsPageUI;

import java.util.List;

public class AdminProductsPO extends BasePage {
    WebDriver driver;

    public AdminProductsPO(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToProductTextboxByTextboxId(String textboxId, String value) {
        waitForElementVisible(driver, AdminProductsPageUI.PRODUCTS_TEXTBOX_BY_TEXTBOX_ID, textboxId);
        sendkeysToElement(driver, AdminProductsPageUI.PRODUCTS_TEXTBOX_BY_TEXTBOX_ID, value, textboxId);
    }

    public void clickToButtonByButtonText(String buttonText) {
        waitForElementClickable(driver, AdminProductsPageUI.PRODUCTS_BUTTON_BY_BUTTON_TEXT, buttonText);
        clickToElement(driver, AdminProductsPageUI.PRODUCTS_BUTTON_BY_BUTTON_TEXT, buttonText);
        sleepInSecond(1);
    }

    public int getProductTableSize(String productNameText) {
        waitForElementVisible(driver, AdminProductsPageUI.PRODUCT_TITLE_TEXT, productNameText);
        return getElementSize(driver, AdminProductsPageUI.PRODUCT_TITLE_TEXT, productNameText);
    }

    public void selectItemAtDropdownbyDropdownId(String dropdownId, String value) {
        waitForElementClickable(driver, AdminProductsPageUI.PRODUCTS_DROPDOWN_BY_DROPDOWN_ID, dropdownId);
        selectItemInDefaultDropdown(driver, AdminProductsPageUI.PRODUCTS_DROPDOWN_BY_DROPDOWN_ID, value, dropdownId);
    }

    public void checkToSearchSubCategoriesCheckbox() {
        waitForElementClickable(driver, AdminProductsPageUI.PRODUCTS_CHECKBOX);
        checkToDefaultCheckboxRadio(driver, AdminProductsPageUI.PRODUCTS_CHECKBOX);
    }

    public boolean isNoDataMessageDisplayed() {
        waitForElementVisible(driver, AdminProductsPageUI.NO_DATA_MESSAGE_TEXT);
        return isElementDisplayed(driver, AdminProductsPageUI.NO_DATA_MESSAGE_TEXT);
    }
}
