package pageUIs;

public class UserCartPageUI {
    public static final String PRODUCT_CART_NAME = "xpath=//table//a[normalize-space()='%s']";
    public static final String EDIT_PRODUCT_CART_LINK_BY_PRODUCT_NAME = "xpath=//table//a[text()='%s']/following-sibling::div[@class='edit-item']/a";
    public static final String QUANTITY_PRODUCT_CART_TEXTBOX_BY_PRODUCT_NAME = "xpath=//table//a[text()='%s']/parent::td/following-sibling::td[@class='quantity']/input";
    public static final String TOTAL_PRODUCT_CART_TEXT_BY_PRODCUT_NAME = "xpath=//table//a[text()='%s']/parent::td/following-sibling::td[@class='subtotal']/span[@class='product-subtotal']";
    public static final String REMOVE_PRODUCT_CART_BUTTON_BY_PRODUCT_NAME = "xpath=//table//a[text()='%s']/parent::td/following-sibling::td[@class='remove-from-cart']/button";
    public static final String NO_DATA_MESSAGE_TEXT = "xpath=//div[@class='no-data']";
    public static final String CART_BUTTON_BY_ID = "xpath=//button[@id='%s']";
    public static final String ESTIMATE_SHIPPING_BUTTON = "xpath=//a[@id='open-estimate-shipping-popup']";
    public static final String TERM_CHECKBOX = "xpath=//input[@id='termsofservice']";
    public static final String ESTIMATE_SHIPPING_DROPDOWN_BY_ID = "xpath=//select[@id='%s']";
    public static final String ESTIMATE_SHIPPING_ZIP_TEXTBOX = "xpath=//input[@id='ZipPostalCode']";
    public static final String ESTIMATE_SHIPPING_APPLY_BUTTON = "xpath=//button[normalize-space()='Apply']";
    public static final String TOTAL_PRICE_TEXT = "xpath=//tr[@class='order-subtotal']//span[@class='value-summary']";
}
