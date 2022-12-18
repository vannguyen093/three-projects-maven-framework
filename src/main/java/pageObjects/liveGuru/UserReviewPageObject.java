package pageObjects.liveGuru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveGuru.UserReviewPageUI;

public class UserReviewPageObject extends BasePage {
    WebDriver driver;

    public UserReviewPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToSubmitReviewButton() {
        waitForElementClickable(driver, UserReviewPageUI.SUBMIT_REVIEW_BUTTON);
        clickToElement(driver, UserReviewPageUI.SUBMIT_REVIEW_BUTTON);
    }

    public boolean isErrorMessageByLabelTextDisplayed(String labelText) {
        waitForElementVisible(driver, UserReviewPageUI.ERROR_MESSAGE_BY_LABEL_TEXT, labelText);
        return isElementDisplayed(driver, UserReviewPageUI.ERROR_MESSAGE_BY_LABEL_TEXT, labelText);
    }

    public void inputToThoughtTextArea(String value) {
        waitForElementVisible(driver, UserReviewPageUI.YOUR_THOUGHT_TEXTAREA);
        sendkeysToElement(driver, UserReviewPageUI.YOUR_THOUGHT_TEXTAREA, value);
    }

    public void inputToReviewTextbox(String value) {
        waitForElementVisible(driver, UserReviewPageUI.YOUR_REVIEW_TEXTBOX);
        sendkeysToElement(driver, UserReviewPageUI.YOUR_REVIEW_TEXTBOX, value);
    }

    public void inputToNickNameTextbox(String value) {
        waitForElementVisible(driver, UserReviewPageUI.YOUR_NICKNAME_TEXTBOX);
        sendkeysToElement(driver, UserReviewPageUI.YOUR_NICKNAME_TEXTBOX, value);
    }

    public boolean isSuccessfullReviewMessageDisplayed() {
        waitForElementVisible(driver, UserReviewPageUI.ADDED_REVIEW_MESSAGE_TEXT);
        return isElementDisplayed(driver, UserReviewPageUI.ADDED_REVIEW_MESSAGE_TEXT);
    }

    public boolean isErrorMessageAtRatingRadioDisplayed() {
        waitForElementVisible(driver, UserReviewPageUI.ERROR_MESSAGE_AT_RATING_RADIO);
        return isElementDisplayed(driver, UserReviewPageUI.ERROR_MESSAGE_AT_RATING_RADIO);
    }

    public void selectRatingStarRadioByNumber(String ratingNumber) {
        waitForElementClickable(driver, UserReviewPageUI.RATING_RADIO_BUTTON_BY_NUMBER, ratingNumber);
        checkToDefaultCheckboxRadio(driver, UserReviewPageUI.RATING_RADIO_BUTTON_BY_NUMBER, ratingNumber);
    }
}
