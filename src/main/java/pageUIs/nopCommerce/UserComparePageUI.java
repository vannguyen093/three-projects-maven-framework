package pageUIs;

public class UserComparePageUI {
    public static final String PRODUCT_NAME_TEXT = "xpath=//tr[@class='product-name']//a[contains(text(),'%s')]";
    public static final String PRODUCT_PRICE_BY_PRODUCT_NAME_TEXT = "xpath=//tr[@class='product-name']//a[contains(text(),'%s')]//following::td[normalize-space()='%s']";
    public static final String CLEAR_LIST_BUTTON = "xpath=//a[normalize-space()='Clear list']";
    public static final String NO_DATA_AT_COMPARE_PAGE_TEXT = "xpath=//div[@class='no-data']";
}
