package pageUIs.liveGuru;

public class UserMobilePageUI {
    public static final String PRODUCT_PRICE_AT_MOBILE_PAGE_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/parent::h2/following-sibling::div[@class='price-box']//span[@class='price']";
    public static final String ADD_TO_CART_BUTTON_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/parent::h2/following-sibling::div[@class='actions']/button";
    public static final String PRODUCT_IMAGE_AT_MOBILE_PAGE_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/ancestor::div[@class='product-info']/preceding-sibling::a[@class='product-image']";
    public static final String ADD_TO_COMPARE_LINK_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']";
    public static final String PRODUCT_ADDED_COMPARE_MESSAGE_TEXT = "xpath=//ul[@class='messages']//span";
    public static final String COMPARE_BUTTON = "xpath=//div[@class='actions']/button[@title='Compare']";
    public static final String PRODUCT_NAME_TITLE = "xpath=//a[text()='%s']";
}
