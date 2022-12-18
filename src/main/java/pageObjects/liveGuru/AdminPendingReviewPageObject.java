package pageObjects.liveGuru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveGuru.AdminPendingReviewPageUI;
import pageUIs.liveGuru.LiveGuruBasePageUI;

public class AdminPendingReviewPageObject extends BasePage {
    WebDriver driver;

    public AdminPendingReviewPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToTabByTabName(String tabName) {
        waitForElementInvisible(driver, LiveGuruBasePageUI.LOADING_MASK);
        waitForElementClickable(driver, AdminPendingReviewPageUI.PENDING_REVIEW_TAB_BY_TAB_NAME, tabName);
        clickToElement(driver, AdminPendingReviewPageUI.PENDING_REVIEW_TAB_BY_TAB_NAME, tabName);
    }

    public void selectPendingReviewByCheckbox(String reviewText) {
        waitForElementClickable(driver, AdminPendingReviewPageUI.PENDING_REVIEW_CHECKBOX_BY_REVIEW_TEXT, reviewText);
        checkToDefaultCheckboxRadio(driver, AdminPendingReviewPageUI.PENDING_REVIEW_CHECKBOX_BY_REVIEW_TEXT, reviewText);
    }

    public AdminEditPendingReviewPageObject clickToEditLink(String reviewText) {
        waitForElementClickable(driver, AdminPendingReviewPageUI.PENDING_REVIEW_EDIT_LINK_BY_REVIEW_TEXT, reviewText);
        clickToElement(driver, AdminPendingReviewPageUI.PENDING_REVIEW_EDIT_LINK_BY_REVIEW_TEXT, reviewText);
        return PageGenerateManager.getAdminEditPendingReviewPage(driver);
    }
}
