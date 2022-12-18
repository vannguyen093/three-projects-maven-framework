package pageUIs;

public class UserRegisterPageUI {
    public static final String GENDER_RADIO_BY_TEXT = "xpath=//label[normalize-space()='%s']//preceding-sibling::input";
    public static final String REGISTER_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
    public static final String BIRTHDAY_SELECT_BOX_BY_NAME = "xpath=//select[@name='%s']";
    public static final String REGISTER_BUTTON = "xpath=//button[@id='register-button']";
    public static final String CONTINUE_BUTTON = "xpath=//a[normalize-space()='Continue']";
    public static final String ERROR_MESSAGE_BY_TEXTBOX_ID = "xpath=//span[@id='%s-error']";
    public static final String EXISTING_EMAIL_ERROR_MESSAGE_TEXT = "xpath=//div[@class='message-error validation-summary-errors']";
    public static final String REGISTER_SUCCESSFUL_MESSAGE_TEXT = "xpath=//div[@class='result']";
}
