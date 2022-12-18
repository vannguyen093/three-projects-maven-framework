package pageUIs;

public class UserCheckOutPageUI {
    public static final String CHECK_OUT_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
    public static final String SHIP_TO_SAME_ADDRESS_CHECKBOX = "xpath=//input[@id='ShipToSameAddress']";
    public static final String CHECK_OUT_DROPDOWN_BY_ID = "xpath=//select[@id='%s']";
    public static final String CHECK_OUT_BUTTON_BY_NAME = "xpath=//button[@onclick='%s.save()']";
    public static final String PAYMENT_METHOD_RADIO_BY_TEXT = "xpath=//label[text()='%s']/preceding-sibling::input";
    public static final String CHECK_OUT_INFO_BY_CLASS = "xpath=//div[@class='%s']//li[@class='%s']";
    public static final String CHECK_OUT_METHOD_BY_TEXT = "xpath=//span[normalize-space()='%s']";
    public static final String PRODUCT_TITLE_TEXT = "xpath=//table//a[@class='product-name']";
    public static final String PRODUCT_PRICE_TEXT = "xpath=//span[@class='value-summary']//strong";
    public static final String CHECK_OUT_SUCCESSFUL_MESSAGE_TEXT = "xpath=//div[@class='section order-completed']//div[@class='title']/strong";
    public static final String ORDER_NUMBER_TEXT = "xpath=//div[@class='order-number']/strong";
    public static final String CONTINUE_BUTTON_AT_SUCCESS_PAGE = "xpath=//button[normalize-space()='Continue']";
}
