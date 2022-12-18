package pageUIs;

public class UserOrdersDetailPageUI {
    public static final String ORDER_TOTAL_PRICE_TEXT = "xpath=//li[@class='order-total']//strong[contains(text(),'%s')]";
    public static final String ORDER_NUMBER_TEXT = "xpath=//div[@class='order-number']/strong";
    public static final String CHECK_OUT_INFO_BY_CLASS = "xpath=//div[@class='%s']//li[@class='%s']";
    public static final String CHECK_OUT_METHOD_BY_TEXT = "xpath=//span[normalize-space()='%s']";
    public static final String PRODUCT_TITLE_TEXT = "xpath=//td[@class='product']//a";
    public static final String ORDER_TOTAL_PRICE_TEXT_AT_TOTAL_INFO_TABLE = "xpath=//td[@class='cart-total-right']//strong";
}
