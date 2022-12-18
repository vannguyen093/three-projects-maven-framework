package pageUIs.liveGuru;

public class UserReviewPageUI {
    public static final String RATING_RADIO_BUTTON_BY_NUMBER = "xpath=//input[@type='radio' and @value='3']";
    public static final String ERROR_MESSAGE_BY_LABEL_TEXT = "xpath=//label[contains(text(),'%s')]/following-sibling::div/div[@class='validation-advice']";
    public static final String ERROR_MESSAGE_AT_RATING_RADIO = "css=div#advice-validate-rating-validate_rating";
    public static final String YOUR_THOUGHT_TEXTAREA = "css=textarea#review_field";
    public static final String YOUR_REVIEW_TEXTBOX = "css=input#summary_field";
    public static final String YOUR_NICKNAME_TEXTBOX = "css=input#nickname_field";
    public static final String SUBMIT_REVIEW_BUTTON = "xpath=//button[@title='Submit Review']";
    public static final String ADDED_REVIEW_MESSAGE_TEXT = "css=ul.messages span";
}
