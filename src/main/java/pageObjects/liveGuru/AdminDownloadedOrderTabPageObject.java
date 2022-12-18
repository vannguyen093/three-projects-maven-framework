package pageObjects.liveGuru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveGuru.AdminDownloadedOrderTabPageUI;

public class AdminDownloadedOrderTabPageObject extends BasePage {
    WebDriver driver;

    public AdminDownloadedOrderTabPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDownloadedOrderTabDisplayed() {
        switchToWindowByTitle(driver, getPageTitle(driver));
        return isElementDisplayed(driver, AdminDownloadedOrderTabPageUI.ORDER_NUMBER);
    }

    public AdminOrderPageObject closeDownloadedOrderTab() {
        closeAllWindowsWithoutParent(driver, getPageID(driver));
        return PageGenerateManager.getAdminOrderPage(driver);
    }
}
