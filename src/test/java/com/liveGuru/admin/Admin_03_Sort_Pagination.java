package com.admin;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.*;
import reportConfig.ExtentTestManager;
import ultilities.Environment;

import java.lang.reflect.Method;

public class Admin_03_Sort_Pagination extends BaseTest{
    private WebDriver driver;
    private String adminUserName, adminPassword;
    Environment env;
    AdminLoginPageObject adminLoginPage;
    AdminHomePageObject adminHomePage;
    AdminInvoicePageObject adminInvoicePage;
    AdminOrderPageObject adminOrderPage;

    @Parameters({"browser", "evnName", "ipAddress", "portNumber", "osName", "osVersion"})
    @BeforeClass
    public void beforeClass(@Optional("firefox") String browserName, @Optional("local") String evnName, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
        String environmentName = System.getProperty("evn");
        ConfigFactory.setProperty("env", environmentName);
        env = ConfigFactory.create(Environment.class);

        driver = getBrowserDriver(browserName, env.adminUrl(), evnName, osName, osVersion, ipAddress, portNumber);

        adminLoginPage = PageGenerateManager.getAdminLoginPage(driver);

        adminUserName = "user01";
        adminPassword = "guru99com";

    }

    @Test
    public void TC_08_Sort(Method method) {
        ExtentTestManager.startTest(method.getName(), "Verify sort is working correctly");

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 01: Input to 'User Name' text box with value '" + adminUserName + "'");
        adminLoginPage.inputToTextboxById("username", adminUserName);

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 02: Input to 'Password' text box with value '" + adminPassword + "'");
        adminLoginPage.inputToTextboxById("login", adminPassword);

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 03: Click to 'Login' button");
        adminHomePage = adminLoginPage.clickToLoginButton();
        adminHomePage.closeAdminPopup();

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 04: Navigate to the 'Invoice' page");
        adminHomePage.clickToSubMenuLevel1BySubMenuText(driver,"Sales","Invoices");
        adminInvoicePage = PageGenerateManager.getAdminInvoicePage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 05: Click the 'Invoice #' to arrange invoices in ascending order");
        adminInvoicePage.clickToSortInvoiceTabByName("increment_id");

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 06: Verify the 'Invoice #' organized invoices in ascending order");
        verifyTrue(adminInvoicePage.isInvoiceSortedByAsc("increment_id", "2"));

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 07: Click the 'Invoice #' to arrange invoices in descending order");
        adminInvoicePage.clickToSortInvoiceTabByName("increment_id");

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 08: Verify the 'Invoice #' organized invoices in descending order");
        verifyTrue(adminInvoicePage.isInvoiceSortedByDesc("increment_id", "2"));

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 09: Click the 'Invoice Date' to arrange invoices in ascending order");
        adminInvoicePage.clickToSortInvoiceTabByName("created_at");

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 10: Verify the 'Invoice Date' organized invoices in ascending order");
        verifyTrue(adminInvoicePage.isInvoiceSortedByAsc("created_at","3"));

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 11: Click the 'Invoice Date' to arrange invoices in descending order");
        adminInvoicePage.clickToSortInvoiceTabByName("created_at");

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 12: Verify the 'Invoice Date' organized invoices in descending order");
        verifyTrue(adminInvoicePage.isInvoiceSortedByDesc("created_at","3"));

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 13: Click the 'Order #' to arrange invoices in ascending order");
        adminInvoicePage.clickToSortInvoiceTabByName("order_increment_id");

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 14: Verify the 'Order #' organized invoices in ascending order");
        verifyTrue(adminInvoicePage.isInvoiceSortedByAsc("order_increment_id","4"));

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 15: Click the 'Order #' to arrange invoices in descending order");
        adminInvoicePage.clickToSortInvoiceTabByName("order_increment_id");

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 16: Verify the 'Order #' organized invoices in descending order");
        verifyTrue(adminInvoicePage.isInvoiceSortedByDesc("order_increment_id","4"));

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 17: Click the 'Order Date' to arrange invoices in ascending order");
        adminInvoicePage.clickToSortInvoiceTabByName("order_created_at");

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 18: Verify the 'Order Date' organized invoices in ascending order");
        verifyTrue(adminInvoicePage.isInvoiceSortedByAsc("order_created_at","5"));

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 19: Click the 'Order Date' to arrange invoices in descending order");
        adminInvoicePage.clickToSortInvoiceTabByName("order_created_at");

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 20: Verify the 'Order Date' organized invoices in descending order");
        verifyTrue(adminInvoicePage.isInvoiceSortedByDesc("order_created_at","5"));

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 21: Click the 'Bill to Name' to arrange invoices in ascending order");
        adminInvoicePage.clickToSortInvoiceTabByName("billing_name");

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 22: Verify the 'Bill to Name' organized invoices in ascending order");
        verifyTrue(adminInvoicePage.isBillingNameSortedByAsc());

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 23: Click the 'Bill to Name' to arrange invoices in descending order");
        adminInvoicePage.clickToSortInvoiceTabByName("billing_name");

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 24: Verify the 'Bill to Name' organized invoices in descending order");
        verifyTrue(adminInvoicePage.isBillingNameSortedByDesc());

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 25: Click the 'Amount' to arrange invoices in ascending order");
        adminInvoicePage.clickToSortInvoiceTabByName("grand_total");

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 26: Verify the 'Amount' organized invoices in ascending order");
        verifyTrue(adminInvoicePage.isGrandTotalSortedByAsc());

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 27: Click the 'Amount' to arrange invoices in descending order");
        adminInvoicePage.clickToSortInvoiceTabByName("grand_total");

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 28: Verify the 'Amount' organized invoices in descending order");
        verifyTrue(adminInvoicePage.isGrandTotalSortedByDesc());

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 29: Click the 'Log Out' link");
        adminLoginPage = adminInvoicePage.clickToLogoutLinkAtAdminSite(driver);

    }

//    @Test
    public void TC_09_Pagination(Method method) {
        ExtentTestManager.startTest(method.getName(), "Verify pagination functionality");

        ExtentTestManager.getTest().log(Status.INFO, "Pagination - Step 01: Input to 'User Name' text box with value '" + adminUserName + "'");
        adminLoginPage.inputToTextboxById("username", adminUserName);

        ExtentTestManager.getTest().log(Status.INFO, "Pagination - Step 02: Input to 'Password' text box with value '" + adminPassword + "'");
        adminLoginPage.inputToTextboxById("login", adminPassword);

        ExtentTestManager.getTest().log(Status.INFO, "Pagination - Step 03: Click to 'Login' button");
        adminHomePage = adminLoginPage.clickToLoginButton();
        adminHomePage.closeAdminPopup();

        ExtentTestManager.getTest().log(Status.INFO, "Pagination - Step 04: Navigate to the 'Orders' page");
        adminHomePage.clickToSubMenuLevel1BySubMenuText(driver, "Sales", "Orders");
        adminOrderPage = PageGenerateManager.getAdminOrderPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Pagination - Step 05: Select '20' items at 'View' dropdown menu");
        adminOrderPage.selectItemAtViewDropdown("20");

        ExtentTestManager.getTest().log(Status.INFO, "Pagination - Step 06: Verify that the table listed exactly 20 items");
        verifyEquals(adminOrderPage.getOrderTableSize(), 20);

        ExtentTestManager.getTest().log(Status.INFO, "Pagination - Step 07: Select '30' items at 'View' dropdown menu");
        adminOrderPage.selectItemAtViewDropdown("30");

        ExtentTestManager.getTest().log(Status.INFO, "Pagination - Step 08: Verify that the table listed exactly 30 items");
        verifyEquals(adminOrderPage.getOrderTableSize(), 30);

        ExtentTestManager.getTest().log(Status.INFO, "Pagination - Step 09: Select '50' items at 'View' dropdown menu");
        adminOrderPage.selectItemAtViewDropdown("50");

        ExtentTestManager.getTest().log(Status.INFO, "Pagination - Step 10: Verify that the table listed exactly 50 items");
        verifyEquals(adminOrderPage.getOrderTableSize(), 50);

        ExtentTestManager.getTest().log(Status.INFO, "Pagination - Step 11: Select '100' items at 'View' dropdown menu");
        adminOrderPage.selectItemAtViewDropdown("100");

        ExtentTestManager.getTest().log(Status.INFO, "Pagination - Step 12: Verify that the table listed exactly 100 items");
        verifyEquals(adminOrderPage.getOrderTableSize(), 100);

        ExtentTestManager.getTest().log(Status.INFO, "Pagination - Step 13: Select '200' items at 'View' dropdown menu");
        adminOrderPage.selectItemAtViewDropdown("200");

        ExtentTestManager.getTest().log(Status.INFO, "Pagination - Step 14: Verify that the table listed exactly 200 items");
        verifyEquals(adminOrderPage.getOrderTableSize(), 200);

        ExtentTestManager.getTest().log(Status.INFO, "Pagination - Step 15: Click the 'Log Out' link");
        adminLoginPage = adminOrderPage.clickToLogoutLinkAtAdminSite(driver);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }
}
