package pageUIs;

public class UserCartPageUI {
    public static final String CART_MESSAGE_TEXT = "xpath=//ul[@class='messages']//span";
    public static final String DISCOUNT_CODES_TEXTBOX = "css=input#coupon_code";
    public static final String DISCOUNT_CODES_ADDED_TEXT = "xpath=//table[@id='shopping-cart-totals-table']/tbody//td[contains(text(), 'Discount')]/following-sibling::td/span";
    public static final String GRAND_TOTAL = "xpath=//table[@id='shopping-cart-totals-table']/tfoot/tr//strong[contains(text(),'Grand Total')]/parent::td/following-sibling::td/strong/span";
    public static final String REMOVE_ITEM_ICON = "xpath=//table[@id='shopping-cart-table']//td[@class='a-center product-cart-remove last']/a[@class='btn-remove btn-remove2']";
    public static final String QUANTITY_TEXTBOX = "xpath=//table[@id='shopping-cart-table']//td[@class='product-cart-actions']/input[@class='input-text qty']";
    public static final String BUTTON_BY_TITLE_TEXT = "xpath=//button[@title='%s']";
    public static final String PRODUCT_QUANTITY_ERR_MESSAGE_TEXT = "xpath=//table[@id='shopping-cart-table']//td[@class='product-cart-info']/p";
    public static final String EMPTY_CART_HEADER_TEXT = "xpath=//div[@class='page-title']/h1";
    public static final String NO_ITEM_IN_CART_TEXT = "xpath=//div[@class='cart-empty']//a/parent::p/preceding-sibling::p";
    public static final String ESTIMATE_SHIPPING_RADIO_BY_RADIO_ID = "xpath=//select[contains(@title,'%s')]";
    public static final String ZIP_TEXTBOX = "xpath=//input[@id='postcode']";
    public static final String FIXED_FLAT_RATE_TEXT = "xpath=//label[contains(text(),'Fixed')]/span[@class='price']";
    public static final String SHIPPING_HANDLING_PRICE_TEXT = "xpath=//td[contains(text(),'Shipping & Handling (Flat Rate - Fixed)')]/following-sibling::td/span";
}
