package pageObjects.liveGuru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveGuru.AdminOrderPageUI;
import pageUIs.liveGuru.LiveGuruBasePageUI;

public class AdminOrderPageObject extends BasePage {
    WebDriver driver;

    public AdminOrderPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void selectItemAtOrderActionDropdownByName(String actionName) {
        waitForElementClickable(driver, AdminOrderPageUI.ACTIONS_AT_ORDER_PAGE_DROPDOWN);
        selectItemInDefaultDropdown(driver, AdminOrderPageUI.ACTIONS_AT_ORDER_PAGE_DROPDOWN, actionName);
    }

    public void selectItemAtStatusDropdown(String statusItemText) {
        waitForElementClickable(driver, AdminOrderPageUI.STATUS_ITEM_AT_STATUS_DROPDOWN_BY_NAME, statusItemText);
        selectItemInDefaultDropdown(driver,AdminOrderPageUI.STATUS_ITEM_AT_STATUS_DROPDOWN_BY_NAME, statusItemText);
    }

    public void selectFirstOrderByCheckbox() {
        waitForElementInvisible(driver, LiveGuruBasePageUI.LOADING_MASK);
        waitForElementClickable(driver, AdminOrderPageUI.FIRST_ORDER_CHECKBOX);
        checkToDefaultCheckboxRadio(driver, AdminOrderPageUI.FIRST_ORDER_CHECKBOX);
    }

    public void selectItemAtViewDropdown(String itemText) {
        waitForElementInvisible(driver, LiveGuruBasePageUI.LOADING_MASK);
        waitForElementClickable(driver, AdminOrderPageUI.ORDER_VIEW_DROPDOWN);
        selectItemInDefaultDropdown(driver, AdminOrderPageUI.ORDER_VIEW_DROPDOWN, itemText);
        sleepInSecond(1);
    }

    public int getOrderTableSize() {
        waitForElementVisible(driver, AdminOrderPageUI.ORDER_TABLE);
        return getElementSize(driver, AdminOrderPageUI.ORDER_TABLE);
    }

    public void clickToSelectUnSelectLinkByText(String selectLinkText) {
        waitForElementClickable(driver, AdminOrderPageUI.ORDER_SELECT_UNSELECT_LINK_BY_TEXT, selectLinkText);
        clickToElement(driver, AdminOrderPageUI.ORDER_SELECT_UNSELECT_LINK_BY_TEXT, selectLinkText);
        sleepInSecond(1);
    }

    public boolean getItemsSelectedText(String numberItemsSelectedText) {
        waitForElementVisible(driver, AdminOrderPageUI.NUMBER_ITEMS_SELECTED_TEXT, numberItemsSelectedText);
        return isElementDisplayed(driver, AdminOrderPageUI.NUMBER_ITEMS_SELECTED_TEXT, numberItemsSelectedText);
    }

    public int getTableSelectedCheckboxSize() {
        waitForElementVisible(driver, AdminOrderPageUI.TABLE_SELECTED_CHECKBOX);
        return getElementSize(driver, AdminOrderPageUI.TABLE_SELECTED_CHECKBOX);
    }

    public int getTableUnselectedCheckboxSize() {
        waitForElementVisible(driver, AdminOrderPageUI.TABLE_UNSELECTED_CHECKBOX);
        return getElementSize(driver, AdminOrderPageUI.TABLE_UNSELECTED_CHECKBOX);
    }
}
