package pageUIs;

public class UserCompareWindowPageUI {
    public static final String COMPARE_WINDOW_HEADER = "css=div.page-title>h1";
    public static final String PRODUCT_TITLE_TEXT = "xpath=//a[text()='%s']";
    public static final String PRODUCT_PRICE_TEXT = "xpath=//a[text()='%s']/parent::h2/following-sibling::div[@class='price-box']//span[@class='price']";
    public static final String PRODUCT_IMG_TEXT = "xpath=//a[text()='%s']/parent::h2/preceding-sibling::a/img[contains(@src, '%s')]";
    public static final String PRODUCT_SKU_TEXT = "xpath=//div[@class='std' and contains(text(), '%s')]";
}
