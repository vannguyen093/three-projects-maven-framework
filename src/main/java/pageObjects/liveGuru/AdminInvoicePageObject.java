package pageObjects.liveGuru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.liveGuru.AdminInvoicePageUI;
import pageUIs.liveGuru.LiveGuruBasePageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdminInvoicePageObject extends BasePage {
    WebDriver driver;

    public AdminInvoicePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToSortInvoiceTabByName(String tabName) {
        waitForElementInvisible(driver, LiveGuruBasePageUI.LOADING_MASK);
        waitForElementClickable(driver, AdminInvoicePageUI.INVOICE_TAB_BY_TAB_NAME, tabName);
        clickToElement(driver, AdminInvoicePageUI.INVOICE_TAB_BY_TAB_NAME, tabName);
        sleepInSecond(1);
    }

    public boolean isInvoiceSortedByAsc(String tabName, String indexNumber) {
        List<String> invoiceUIList = new ArrayList<String>();

        List<WebElement> invoiceRowText = getListWebElements(driver, AdminInvoicePageUI.ROW_TEXT_BY_TAB_NAME_AND_INDEX, tabName, indexNumber);

        for (WebElement invoiceText : invoiceRowText) {
            invoiceUIList.add(invoiceText.getText());
        }

        ArrayList<String> invoiceSortedList = new ArrayList<String>();
        for (String invoice : invoiceUIList) {
            invoiceSortedList.add(invoice);
        }

        Collections.sort(invoiceSortedList);

        return invoiceSortedList.equals(invoiceUIList);
    }

    public boolean isInvoiceSortedByDesc(String tabName, String indexNumber) {
        List<String> invoiceUIList = new ArrayList<String>();

        List<WebElement> invoiceRowText = getListWebElements(driver, AdminInvoicePageUI.ROW_TEXT_BY_TAB_NAME_AND_INDEX, tabName, indexNumber);

        for (WebElement invoiceText : invoiceRowText) {
            invoiceUIList.add(invoiceText.getText());
        }

        ArrayList<String> invoiceSortList = new ArrayList<String>();
        for (String invoice : invoiceUIList) {
            invoiceSortList.add(invoice);
        }

        Collections.sort(invoiceSortList);
        Collections.reverse(invoiceSortList);

        return invoiceSortList.equals(invoiceUIList);
    }

    public boolean isGrandTotalSortedByAsc() {
        List<Float> invoiceUIList = new ArrayList<Float>();

        List<WebElement> invoiceRowText = getListWebElements(driver, AdminInvoicePageUI.GRAND_TOTAL_TEXT);

        for (WebElement invoiceText : invoiceRowText) {
            invoiceUIList.add(Float.parseFloat(invoiceText.getText().replace("$", "").replace(",","")));
        }

        ArrayList<Float> invoiceSortedList = new ArrayList<Float>();
        for (Float invoice : invoiceUIList) {
            invoiceSortedList.add(invoice);
        }

        Collections.sort(invoiceSortedList);

        return invoiceSortedList.equals(invoiceUIList);
    }

    public boolean isGrandTotalSortedByDesc() {
        List<Float> invoiceUIList = new ArrayList<Float>();

        List<WebElement> invoiceRowText = getListWebElements(driver, AdminInvoicePageUI.GRAND_TOTAL_TEXT);

        for (WebElement invoiceText : invoiceRowText) {
            invoiceUIList.add(Float.parseFloat(invoiceText.getText().replace("$", "").replace(",","")));
        }

        ArrayList<Float> invoiceSortedList = new ArrayList<Float>();
        for (Float invoice : invoiceUIList) {
            invoiceSortedList.add(invoice);
        }

        Collections.sort(invoiceSortedList);
        Collections.reverse(invoiceSortedList);

        return invoiceSortedList.equals(invoiceUIList);
    }

    public boolean isBillingNameSortedByAsc() {
        List<String> invoiceUIList = new ArrayList<String>();

        List<WebElement> invoiceRowText = getListWebElements(driver, AdminInvoicePageUI.BILLING_NAME_TEXT);

        for (WebElement invoiceText : invoiceRowText) {
            invoiceUIList.add(invoiceText.getText().toLowerCase());
        }

        ArrayList<String> invoiceSortedList = new ArrayList<String>();
        for (String invoice : invoiceUIList) {
            invoiceSortedList.add(invoice);
        }

        Collections.sort(invoiceSortedList);

        return invoiceSortedList.equals(invoiceUIList);
    }

    public boolean isBillingNameSortedByDesc() {
        List<String> invoiceUIList = new ArrayList<String>();

        List<WebElement> invoiceRowText = getListWebElements(driver, AdminInvoicePageUI.BILLING_NAME_TEXT);

        for (WebElement invoiceText : invoiceRowText) {
            invoiceUIList.add(invoiceText.getText().toLowerCase());
        }

        ArrayList<String> invoiceSortedList = new ArrayList<String>();
        for (String invoice : invoiceUIList) {
            invoiceSortedList.add(invoice);
        }

        Collections.sort(invoiceSortedList);
        Collections.reverse(invoiceSortedList);

        return invoiceSortedList.equals(invoiceUIList);
    }
}
