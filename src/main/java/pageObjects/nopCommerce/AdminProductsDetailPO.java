package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.AdminProductsDetailPageUI;

public class AdminProductsDetailPO extends BasePage {
    WebDriver driver;

    public AdminProductsDetailPO(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextboxAttributeByTextboxId(String textboxId) {
        waitForElementVisible(driver, AdminProductsDetailPageUI.PRODUCTS_DETAIL_TEXTBOX_BY_TEXTBOX_ID, textboxId);
        return getElementAttribute(driver, AdminProductsDetailPageUI.PRODUCTS_DETAIL_TEXTBOX_BY_TEXTBOX_ID, "value", textboxId);
    }
}
