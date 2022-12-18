package pageObjects.liveGuru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveGuru.UserProductDetailPageUI;

public class UserProductDetailPageObject extends BasePage {
    WebDriver driver;

    public UserProductDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductPriceAtProductDetailPage() {
        waitForElementVisible(driver, UserProductDetailPageUI.PRODUCT_PRICE_AT_PDETAIL_PAGE);
        return getElementText(driver, UserProductDetailPageUI.PRODUCT_PRICE_AT_PDETAIL_PAGE);
    }

    public UserReviewPageObject clickToAddYourReviewLink() {
        waitForElementClickable(driver, UserProductDetailPageUI.ADD_REVIEW_LINK);
        clickToElement(driver, UserProductDetailPageUI.ADD_REVIEW_LINK);
        return PageGenerateManager.getUserReviewPage(driver);
    }

    public void clickToProductDetaiTabByTabTitle(String productDetailTabTitle) {
        waitForElementClickable(driver, UserProductDetailPageUI.PRODUCT_DETAIL_TAB_BY_TAB_TITLE_TEXT, productDetailTabTitle);
        clickToElement(driver, UserProductDetailPageUI.PRODUCT_DETAIL_TAB_BY_TAB_TITLE_TEXT, productDetailTabTitle);
    }

    public boolean isEditPendingReviewDisplayed(String reviewText) {
        waitForElementVisible(driver, UserProductDetailPageUI.MY_PENDING_REVIEW_TEXT, reviewText);
        return isElementDisplayed(driver, UserProductDetailPageUI.MY_PENDING_REVIEW_TEXT, reviewText);
    }
}
