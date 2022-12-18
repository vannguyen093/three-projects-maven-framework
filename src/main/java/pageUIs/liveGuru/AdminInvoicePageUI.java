package pageUIs.liveGuru;

public class AdminInvoicePageUI {
    public static final String INVOICE_TAB_BY_TAB_NAME = "xpath=//tr[@class='headings']//a[@name='%s']";
    public static final String ROW_TEXT_BY_TAB_NAME_AND_INDEX = "xpath=//a[@name='%s']/ancestor::thead/following-sibling::tbody//td[%s]";
    public static final String BILLING_NAME_TEXT = "xpath=//a[@name='billing_name']/ancestor::thead/following-sibling::tbody//td[6]";
    public static final String GRAND_TOTAL_TEXT = "xpath=//a[@name='grand_total']/ancestor::thead/following-sibling::tbody//td[8]";
}
