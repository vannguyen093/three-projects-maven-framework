package pageObjects.liveGuru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveGuru.AdminEditPendingReviewPageUI;

public class AdminEditPendingReviewPageObject extends BasePage {
    WebDriver driver;

    public AdminEditPendingReviewPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void selectItemAtStatusPendingReviewDropdown(String statusItemText) {
        waitForElementClickable(driver, AdminEditPendingReviewPageUI.STATUS_DROPDOWN_BY_SELECT_ITEM_TITLE);
        selectItemInDefaultDropdown(driver, AdminEditPendingReviewPageUI.STATUS_DROPDOWN_BY_SELECT_ITEM_TITLE, statusItemText);
    }

    public AdminPendingReviewPageObject clickToButtonByButtonTitle(String buttonTitle) {
        waitForElementClickable(driver, AdminEditPendingReviewPageUI.EDIT_PENDING_REVIEW_BUTTON_BY_BUTTON_TITLE, buttonTitle);
        clickToElement(driver, AdminEditPendingReviewPageUI.EDIT_PENDING_REVIEW_BUTTON_BY_BUTTON_TITLE, buttonTitle);
        return PageGenerateManager.getAdminPendingReviewPage(driver);
    }
}
