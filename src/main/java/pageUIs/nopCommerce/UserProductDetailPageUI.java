package pageUIs;

public class UserProductDetailPageUI {
    public static final String PRODUCT_DETAIL_TITLE_TEXT = "css=div.product-name>h1";
    public static final String ADD_REVIEW_LINK = "xpath=//a[text()='Add your review']";
    public static final String PRODUCT_DETAIL_BUTTON_BY_TEXT = "xpath=//div[@class='overview-buttons']//button[text()='%s']";
    public static final String ADD_TO_CART_BUTTON = "xpath=//button[@id='add-to-cart-button-1']";
    public static final String LOADING_ICON = "xpath=//div[@class='ajax-loading-block-window']";
    public static final String PRODUCT_DROPDOWN_BY_ID = "xpath=//select[@id='%s']";
    public static final String PRODUCT_PRICE_TEXT = "xpath=//span[@id='price-value-1']";
    public static final String PRODUCT_TITLE_AT_MINI_CART_TEXT = "xpath=//div[@class='mini-shopping-cart']//a[normalize-space()='%s']";
    public static final String PRODUCT_PRICE_AT_MINI_CART_TEXT = "xpath=//div[@class='totals']/strong";
    public static final String PRODUCT_ATTRIBUTE_AT_MINI_CART_TEXT = "xpath=//div[@class='product']//div[@class='attributes']";
    public static final String PRODUCT_RADIO_CHECKBOX_BY_TEXT = "xpath=//label[normalize-space()='%s']//preceding-sibling::input";
    public static final String NUMBER_PRODUCT_AT_MINI_CART_TEXT = "xpath=//div[@class='count']//a[normalize-space()='%s']";
    public static final String QUANTITY_TEXTBOX = "xpath=//input[@id='product_enteredQuantity_1']";
}
