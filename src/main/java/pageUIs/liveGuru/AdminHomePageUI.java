package pageUIs;

public class AdminHomePageUI {
    public static final String CLOSE_POPUP_BUTTON = "xpath=//div[@id='message-popup-window']//a[@title='close']";
    public static final String FILTER_TEXTBOX_BY_FILTER_NAME = "xpath=//input[@name='%s']";
    public static final String ACCOUNT_TEXT_AT_ROW = "xpath=//tbody/tr/td[contains(text(),'%s')]/following-sibling::td[contains(text(),'%s')]";
    public static final String ACCOUNT_CHECKBOX = "xpath=//td[contains(text(),'%s')]/preceding-sibling::td[@class='a-center ']/input";

}
