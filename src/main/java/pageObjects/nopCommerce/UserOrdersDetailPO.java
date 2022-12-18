package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserOrdersDetailPageUI;

public class UserOrdersDetailPO extends BasePage {
    WebDriver driver;

    public UserOrdersDetailPO(WebDriver driver) {
        this.driver = driver;
    }

    public String getOrderNumberTextAtOrdersDetailPage() {
        waitForElementVisible(driver, UserOrdersDetailPageUI.ORDER_NUMBER_TEXT);
        String orderNumber = getElementText(driver, UserOrdersDetailPageUI.ORDER_NUMBER_TEXT).substring(8, 11);
        return orderNumber;
    }

    public boolean isTotalPriceDisplayedCorrectly(String totalPrice) {
        waitForElementVisible(driver, UserOrdersDetailPageUI.ORDER_TOTAL_PRICE_TEXT, totalPrice);
        return isElementDisplayed(driver, UserOrdersDetailPageUI.ORDER_TOTAL_PRICE_TEXT, totalPrice);
    }

    public String getCheckOutInfoTextByClass(String infoDivClass, String infoLiClass) {
        waitForElementVisible(driver, UserOrdersDetailPageUI.CHECK_OUT_INFO_BY_CLASS, infoDivClass, infoLiClass);
        return getElementText(driver, UserOrdersDetailPageUI.CHECK_OUT_INFO_BY_CLASS, infoDivClass, infoLiClass);
    }

    public boolean isCheckOutMethodDisplayed(String paymentMethod) {
        waitForElementVisible(driver, UserOrdersDetailPageUI.CHECK_OUT_METHOD_BY_TEXT, paymentMethod);
        return isElementDisplayed(driver, UserOrdersDetailPageUI.CHECK_OUT_METHOD_BY_TEXT, paymentMethod);
    }

    public String getCheckOutProductTitleText() {
        waitForElementVisible(driver, UserOrdersDetailPageUI.PRODUCT_TITLE_TEXT);
        return getElementText(driver, UserOrdersDetailPageUI.PRODUCT_TITLE_TEXT);
    }

    public String getCheckOutProductPriceText() {
        waitForElementVisible(driver, UserOrdersDetailPageUI.ORDER_TOTAL_PRICE_TEXT_AT_TOTAL_INFO_TABLE);
        return getElementText(driver, UserOrdersDetailPageUI.ORDER_TOTAL_PRICE_TEXT_AT_TOTAL_INFO_TABLE);
    }
}
