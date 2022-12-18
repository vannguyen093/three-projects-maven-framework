package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.UserProductPageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserProductPO extends BasePage {
    WebDriver driver;

    public UserProductPO(WebDriver driver) {
        this.driver = driver;
    }

    public UserProductDetailPO clickToProductTitleByText(String productTitleText) {
        waitForElementClickable(driver, UserProductPageUI.PRODUCT_TITLE_FOR_CLICK_TEXT, productTitleText);
        clickToElement(driver, UserProductPageUI.PRODUCT_TITLE_FOR_CLICK_TEXT, productTitleText);
        return PageGenerateManager.getUserProductDetailPage(driver);
    }

    public void selectItemAtDropdownById(String dropdownId, String value) {
        waitForElementClickable(driver, UserProductPageUI.PRODUCT_DROPDOWN_BY_ID, dropdownId);
        selectItemInDefaultDropdown(driver, UserProductPageUI.PRODUCT_DROPDOWN_BY_ID, value, dropdownId);
    }

    public boolean isProductNameSortByAsc() {
        waitLoadingIconInvisible(driver);
        List<String> productUIList = new ArrayList<String>();
        List<WebElement> productNameText = getListWebElements(driver, UserProductPageUI.PRODUCT_TITLE_TEXT);

        for (WebElement productName : productNameText) {
            productUIList.add(productName.getText());
        }

        ArrayList<String> productSortedList = new ArrayList<String>();
        for (String product : productUIList) {
            productSortedList.add(product);
        }

        Collections.sort(productSortedList);
        return productSortedList.equals(productUIList);
    }

    public boolean isProductNameSortByDesc() {
        waitLoadingIconInvisible(driver);
        List<String> productUIList = new ArrayList<String>();
        List<WebElement> productNameText = getListWebElements(driver, UserProductPageUI.PRODUCT_TITLE_TEXT);

        for (WebElement productName : productNameText) {
            productUIList.add(productName.getText());
        }

        ArrayList<String> productSortedList = new ArrayList<String>();
        for (String product : productUIList) {
            productSortedList.add(product);
        }

        Collections.sort(productSortedList);
        Collections.reverse(productSortedList);
        return productSortedList.equals(productUIList);
    }

    public boolean isProductPriceSortByAsc() {
        waitLoadingIconInvisible(driver);
        List<Float> productUIList = new ArrayList<Float>();
        List<WebElement> productPriceText = getListWebElements(driver, UserProductPageUI.PRODUCT_PRICE_TEXT);

        for (WebElement productPrice : productPriceText) {
            productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "").replace(",", "")));
        }

        ArrayList<Float> productSortedList = new ArrayList<Float>();
        for (Float product : productUIList) {
            productSortedList.add(product);
        }

        Collections.sort(productSortedList);
        return productSortedList.equals(productUIList);
    }

    public boolean isProductPriceSortByDesc() {
        waitLoadingIconInvisible(driver);
        List<Float> productUIList = new ArrayList<Float>();
        List<WebElement> productPriceText = getListWebElements(driver, UserProductPageUI.PRODUCT_PRICE_TEXT);

        for (WebElement productPrice : productPriceText) {
            productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "").replace(",", "")));
        }

        ArrayList<Float> productSortedList = new ArrayList<Float>();
        for (Float product : productUIList) {
            productSortedList.add(product);
        }

        Collections.sort(productSortedList);
        Collections.reverse(productSortedList);
        return productSortedList.equals(productUIList);
    }

    public int getProductSize() {
        waitLoadingIconInvisible(driver);
        waitForElementVisible(driver, UserProductPageUI.PRODUCT_TITLE_TEXT);
        return getElementSize(driver, UserProductPageUI.PRODUCT_TITLE_TEXT);
    }

    public boolean isPaginationButtonDisplayed(String paginationClass) {
        waitForElementVisible(driver, UserProductPageUI.PRODUCT_PAGINATION_BY_CLASS, paginationClass);
        return isElementDisplayed(driver, UserProductPageUI.PRODUCT_PAGINATION_BY_CLASS, paginationClass);
    }

    public void clickToPaginationButtonByButtonClass(String paginationClass) {
        waitForElementClickable(driver, UserProductPageUI.PRODUCT_PAGINATION_BY_CLASS, paginationClass);
        clickToElement(driver, UserProductPageUI.PRODUCT_PAGINATION_BY_CLASS, paginationClass);
    }

    public boolean isPaginationUndisplayed() {
        waitForElementUndisplayed(driver, UserProductPageUI.PRODUCT_PAGINATION);
        return isElementUndisplayed(driver, UserProductPageUI.PRODUCT_PAGINATION);
    }

    public void clickToButtonByProductTitle(String productTitleText, String classText) {
        waitForElementClickable(driver, UserProductPageUI.PRODUCT_BUTTON_BY_PRODUCT_TITLE, productTitleText, classText);
        clickToElement(driver, UserProductPageUI.PRODUCT_BUTTON_BY_PRODUCT_TITLE, productTitleText, classText);
    }

}
