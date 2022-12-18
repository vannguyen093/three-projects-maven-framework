package pageUIs;

public class UserProductPageUI {
    public static final String PRODUCT_TITLE_TEXT = "xpath=//h2[@class='product-title']";
    public static final String PRODUCT_TITLE_FOR_CLICK_TEXT = "xpath=//h2[@class='product-title']//a[contains(text(),'%s')]";
    public static final String PRODUCT_PRICE_TEXT = "xpath=//span[@class='price actual-price']";
    public static final String PRODUCT_DROPDOWN_BY_ID = "xpath=//select[@id='%s']";
    public static final String PRODUCT_PAGINATION = "xpath=//div[@class='pager']";
    public static final String PRODUCT_PAGINATION_BY_CLASS = "xpath=//li[@class='%s']";
    public static final String PRODUCT_BUTTON_BY_PRODUCT_TITLE = "xpath=//div[@class='products-container']//a[text()='%s']/parent::h2/following-sibling::div[@class='add-info']//button[contains(@class,'%s')]";
}
