package pageObjects.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.UserMyProductReviewsPageUI;

public class UserMyProductReviewsPO extends BasePage {
    WebDriver driver;

    public UserMyProductReviewsPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductReviewTitleDisplayed(String reviewTitle) {
        waitForElementVisible(driver, UserMyProductReviewsPageUI.MY_PRODUCT_REVIEW_TITLE_TEXT);
        return isElementDisplayed(driver, UserMyProductReviewsPageUI.MY_PRODUCT_REVIEW_TITLE_TEXT);
    }
}
