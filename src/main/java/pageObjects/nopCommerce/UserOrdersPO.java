package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserOrdersPageUI;

public class UserOrdersPO extends BasePage {
    WebDriver driver;

    public UserOrdersPO(WebDriver driver) {
        this.driver = driver;
    }

    public String getOrderNumberTextAtOrdersPage() {
        waitForElementVisible(driver, UserOrdersPageUI.ORDER_NUMBER_TEXT);
        String orderNumber = getElementText(driver, UserOrdersPageUI.ORDER_NUMBER_TEXT).substring(15, 18);
        return orderNumber;
    }

    public UserOrdersDetailPO clickToDetailLink() {
        waitForElementClickable(driver, UserOrdersPageUI.DETAIL_LINK);
        clickToElement(driver, UserOrdersPageUI.DETAIL_LINK);
        return PageGenerateManager.getUserOrdersDetailPage(driver);
    }
}
