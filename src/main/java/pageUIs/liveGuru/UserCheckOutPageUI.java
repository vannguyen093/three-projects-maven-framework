package pageUIs;

public class UserCheckOutPageUI {
    public static final String BILLING_INFO_TEXTBOX_BY_TEXTBOX_ID = "xpath=//input[contains(@title,'%s')]";
    public static final String BILLING_INFO_RADIO_BY_RADIO_ID = "xpath= //li[@id='billing-new-address-form']//select[@title='%s']";
    public static final String CONTINUE_BUTTON_AT_BILLING_INFO_TAB = "xpath=//div[@id='billing-buttons-container']//button[@title='Continue']";
    public static final String CONTINUE_BUTTON_AT_SHIPPING_METHOD_TAB = "xpath=//div[@id='shipping-method-buttons-container']//button";
    public static final String CONTINUE_BUTTON_AT_PAYMENT_INFO_TAB = "xpath=//div[@id='payment-buttons-container']/button";
    public static final String PAYMENT_INFO_RADIO_BY_TITLE_TEXT = "xpath=//input[@title='%s']";
    public static final String PLACE_ORDER_BUTTON = "xpath=//div[@id='review-buttons-container']/button";
}
