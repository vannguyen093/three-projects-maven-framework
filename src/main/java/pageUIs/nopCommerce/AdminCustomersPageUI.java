package pageUIs;

public class AdminCustomersPageUI {
    public static final String NEW_CUSTOMER_GENDER_RADIO_BY_GENDER_TEXT = "xpath=//label[normalize-space()='%s']/preceding-sibling::input";
    public static final String NEW_CUSTOMER_PARENT_ROLE_DROPDOWN = "xpath=//div[@class='input-group-append input-group-required']//div[@role='listbox']";
    public static final String NEW_CUSTOMER_ROLE_TEXTBOX = "xpath=//div[@class='input-group-append input-group-required']//input[@role='listbox']";
    public static final String CUSTOMER_ROLE_TEXTBOX = "xpath=//input[@role='listbox']";
    public static final String NEW_CUSTOMER_CLOSE_BUTTON_BY_CUSTOMER_ROLE_TEXT = "xpath=//span[text()='%s']/following-sibling::span[@title='delete']";
    public static final String NEW_CUSTOMER_BUTTON_BY_BUTTON_TEXT = "xpath=//button[normalize-space()='%s']";
    public static final String CUSTOMER_TEXTBOX_BY_TEBOX_ID = "xpath=//input[@id='%s']";
    public static final String NEW_CUSTOMER_ADMIN_TEXTAREA = "xpath=//textarea[@id='AdminComment']";
    public static final String CUSTOMER_MESSAGE_TEXT = "xpath=//div[@class='alert alert-success alert-dismissable']";
    public static final String BACK_TO_CUSTOMER_LINK = "xpath=//a[normalize-space()='%s']";
    public static final String ADD_NEW_BUTTON = "xpath=//a[normalize-space()='Add new']";
    public static final String CUSTOMER_SEARCH_BUTTON = "xpath=//button[@id='search-customers']";
    public static final String CUSTOMER_FULL_NAME_TEXT = "xpath=//table[@id='customers-grid']/tbody//td[text()='%s']";
    public static final String CUSTOMER_EDIT_BUTTON_BY_FULL_NAME_TEXT = "xpath=//table/tbody//td[text()='%s']/following-sibling::td[@class=' button-column']/a";
    public static final String CUSTOMER_TAB_BY_TAB_NAME = "xpath=//div[contains(text(),'%s')]";
    public static final String CUSTOMER_ADDRESS_DROPDOWN_BY_DROPDOWN_ID = "xpath=//select[@id='%s']";
    public static final String CUSTOMER_DETAIL_ADDRESS_BUTTON_LINK_BY_TEXT = "xpath=//table[@id='customer-addresses-grid']/tbody//td[text()='%s']/following-sibling::td[@class=' button-column']/a[text()='%s']";
    public static final String CUSTOMER_DETAIL_ADDRESS_INFO_TEXT = "xpath=//table[@id='customer-addresses-grid']/tbody//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']";
    public static final String CUSTOMER_DETAIL_ADDRESS_NO_DATA_TEXT = "xpath=//table[@id='customer-addresses-grid']/tbody//td[@class='dataTables_empty']";
}
