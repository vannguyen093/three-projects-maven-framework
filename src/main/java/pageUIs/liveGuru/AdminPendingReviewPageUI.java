package pageUIs;

public class AdminPendingReviewPageUI {
    public static final String PENDING_REVIEW_TAB_BY_TAB_NAME = "xpath=//tr[@class='headings']//a[@name='%s']";
    public static final String PENDING_REVIEW_CHECKBOX_BY_REVIEW_TEXT = "xpath=//td[contains(text(),'%s')]/preceding-sibling::td[@class='a-center ']/input";
    public static final String PENDING_REVIEW_EDIT_LINK_BY_REVIEW_TEXT = "xpath=//td[contains(text(),'%s')]/following-sibling::td[@class=' last']/a";
}
