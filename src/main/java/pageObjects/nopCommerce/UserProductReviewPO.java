package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserProductReviewPageUI;

public class UserProductReviewPO extends BasePage {
    WebDriver driver;

    public UserProductReviewPO(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToReviewTextboxByTextboxId(String elementType, String textboxID, String value) {
        waitForElementVisible(driver, UserProductReviewPageUI.PRODUCT_REVIEW_TEXTBOX_BY_ID, elementType, textboxID);
        sendkeysToElement(driver, UserProductReviewPageUI.PRODUCT_REVIEW_TEXTBOX_BY_ID, value, elementType, textboxID);
    }

    public void clickToSubmitReviewButton() {
        waitForElementClickable(driver, UserProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
        clickToElement(driver, UserProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
    }

    public String getSuccessMessageText() {
        waitForElementVisible(driver, UserProductReviewPageUI.ADD_REVIEW_SUCCESSUL_MESSAGE_TEXT);
        return getElementText(driver, UserProductReviewPageUI.ADD_REVIEW_SUCCESSUL_MESSAGE_TEXT);
    }
}
