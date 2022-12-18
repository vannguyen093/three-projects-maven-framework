package com.admin;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.nopCommerce.*;
import reportConfig.ExtentTestManager;
import ultilities.Environment;

import java.lang.reflect.Method;

public class Admin_01_Search_Product_Name extends BaseTest {

    private WebDriver driver;
    private String userName, password, productName, skuNumber;
    Environment env;
    AdminLoginPO adminLoginPage;
    AdminDashboardPO adminDashboardPage;
    AdminProductsPO adminProductsPage;
    AdminProductsDetailPO adminProductsDetailPage;

    @Parameters({"browser", "evnName", "ipAddress", "portNumber", "osName", "osVersion"})
    @BeforeClass
    public void beforeClass(@Optional("firefox") String browserName, @Optional("local") String evnName, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
        String environmentName = System.getProperty("evn");
        ConfigFactory.setProperty("env", environmentName);
        env = ConfigFactory.create(Environment.class);

        driver = getBrowserDriver(browserName, env.adminUrl(), evnName, osName, osVersion, ipAddress, portNumber);

        adminLoginPage = PageGenerateManager.getAdminLoginPage(driver);

        userName = "admin@yourstore.com";
        password = "admin";
        productName = "Lenovo IdeaCentre 600 All-in-One PC";
        skuNumber = "LE_IC_600";
    }

    @Test
    public void TC_01_Search_With_Product_Name(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search with product name");

        ExtentTestManager.getTest().log(Status.INFO, "Search With Product Name - Step 01: Input '" + userName + "' in 'Email' text box");
        adminLoginPage.inputToLoginTextboxByTextboxId("Email", userName);

        ExtentTestManager.getTest().log(Status.INFO, "Search With Product Name - Step 02: Input '" + password + "' in 'Password' text box");
        adminLoginPage.inputToLoginTextboxByTextboxId("Password", password);

        ExtentTestManager.getTest().log(Status.INFO, "Search With Product Name - Step 03: Click the 'Login' button");
        adminDashboardPage = adminLoginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(Status.INFO, "Search With Product Name - Step 04: Click the 'Products' link at Sidebar menu");
        adminDashboardPage.clickToAdminSubSidebarMenuByMenuText(driver, "Catalog", "Products");
        adminProductsPage = PageGenerateManager.getAdminProductsPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Search With Product Name - Step 05: Input '" + productName + "' in 'Product name' text box");
        adminProductsPage.inputToProductTextboxByTextboxId("SearchProductName", productName);

        ExtentTestManager.getTest().log(Status.INFO, "Search With Product Name - Step 06: Click the 'Search' button");
        adminProductsPage.clickToButtonByButtonText("Search");

        ExtentTestManager.getTest().log(Status.INFO, "Search With Product Name - Step 07: Verify that the search process is only displayed as one item in the table");
        Assert.assertEquals(adminProductsPage.getProductTableSize(productName), 1);
    }

    @Test
    public void TC_02_Search_With_Product_Name_Parent_Category_Unchecked(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search with product name + parent category + Unchecked subcategory");

        ExtentTestManager.getTest().log(Status.INFO, "Search With Parent Category - Step 01: Click the 'Products' link at Sidebar menu");
        adminProductsPage.clickToAdminSubSidebarMenuByMenuText(driver, "Catalog", "Products");
        adminProductsPage = PageGenerateManager.getAdminProductsPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Search With Parent Category - Step 02: Input '" + productName + "' in 'Product name' text box");
        adminProductsPage.inputToProductTextboxByTextboxId("SearchProductName", productName);

        ExtentTestManager.getTest().log(Status.INFO, "Search With Parent Category - Step 03: Select '" + "Computers" + "' option in 'Category' dropdown");
        adminProductsPage.selectItemAtDropdownbyDropdownId("SearchCategoryId", "Computers");

        ExtentTestManager.getTest().log(Status.INFO, "Search With Parent Category - Step 04: Click the 'Search' button");
        adminProductsPage.clickToButtonByButtonText("Search");

        ExtentTestManager.getTest().log(Status.INFO, "Search With Parent Category - Step 05: Verify that the search process is displayed a no data message");
        Assert.assertTrue(adminProductsPage.isNoDataMessageDisplayed());
    }

    @Test
    public void TC_03_Search_With_Product_Name_Parent_Category_Checked(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search with product name + parent category + checked subcategory");

        ExtentTestManager.getTest().log(Status.INFO, "Search With Parent Category - Step 01: Click the 'Products' link at Sidebar menu");
        adminProductsPage.clickToAdminSubSidebarMenuByMenuText(driver, "Catalog", "Products");
        adminProductsPage = PageGenerateManager.getAdminProductsPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Search With Parent Category - Step 02: Input '" + productName + "' in 'Product name' text box");
        adminProductsPage.inputToProductTextboxByTextboxId("SearchProductName", productName);

        ExtentTestManager.getTest().log(Status.INFO, "Search With Parent Category - Step 03: Select '" + "Computers" + "' option in 'Category' dropdown");
        adminProductsPage.selectItemAtDropdownbyDropdownId("SearchCategoryId", "Computers");

        ExtentTestManager.getTest().log(Status.INFO, "Search With Parent Category - Step 04: Check the 'Search subcategories' checkbox");
        adminProductsPage.checkToSearchSubCategoriesCheckbox();

        ExtentTestManager.getTest().log(Status.INFO, "Search With Parent Category - Step 04: Click the 'Search' button");
        adminProductsPage.clickToButtonByButtonText("Search");

        ExtentTestManager.getTest().log(Status.INFO, "Search With Product Name - Step 07: Verify that the search process is only displayed as one item in the table");
        Assert.assertEquals(adminProductsPage.getProductTableSize(productName), 1);
    }

    @Test
    public void TC_04_Search_With_Product_Name_Child_Category_Unchecked(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search with product name + child category + Unchecked subcategory");

        ExtentTestManager.getTest().log(Status.INFO, "Search With Child Category - Step 01: Click the 'Products' link at Sidebar menu");
        adminProductsPage.clickToAdminSubSidebarMenuByMenuText(driver, "Catalog", "Products");
        adminProductsPage = PageGenerateManager.getAdminProductsPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Search With Child Category - Step 02: Input '" + productName + "' in 'Product name' text box");
        adminProductsPage.inputToProductTextboxByTextboxId("SearchProductName", productName);

        ExtentTestManager.getTest().log(Status.INFO, "Search With Child Category - Step 03: Select '" + "Computers >> Desktops" + "' option in 'Category' dropdown");
        adminProductsPage.selectItemAtDropdownbyDropdownId("SearchCategoryId", "Computers >> Desktops");

        ExtentTestManager.getTest().log(Status.INFO, "Search With Child Category - Step 04: Click the 'Search' button");
        adminProductsPage.clickToButtonByButtonText("Search");

        ExtentTestManager.getTest().log(Status.INFO, "Search With Child Category - Step 05: Verify that the search process is only displayed as one item in the table");
        Assert.assertEquals(adminProductsPage.getProductTableSize(productName), 1);
    }

    @Test
    public void TC_05_Search_With_Product_Name_Manufacturer_Unchecked(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search with product name + manufacturer + Unchecked subcategory");

        ExtentTestManager.getTest().log(Status.INFO, "Search With Manufacturer - Step 01: Click the 'Products' link at Sidebar menu");
        adminProductsPage.clickToAdminSubSidebarMenuByMenuText(driver, "Catalog", "Products");
        adminProductsPage = PageGenerateManager.getAdminProductsPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Search With Manufacturer - Step 02: Input '" + productName + "' in 'Product name' text box");
        adminProductsPage.inputToProductTextboxByTextboxId("SearchProductName", productName);

        ExtentTestManager.getTest().log(Status.INFO, "Search With Manufacturer - Step 03: Select '" + "Computers >> Desktops" + "' option in 'Category' dropdown");
        adminProductsPage.selectItemAtDropdownbyDropdownId("SearchCategoryId", "All");

        ExtentTestManager.getTest().log(Status.INFO, "Search With Manufacturer - Step 03: Select '" + "Apple" + "' option in 'Manufacturer' dropdown");
        adminProductsPage.selectItemAtDropdownbyDropdownId("SearchManufacturerId", "Apple");

        ExtentTestManager.getTest().log(Status.INFO, "Search With Manufacturer - Step 04: Click the 'Search' button");
        adminProductsPage.clickToButtonByButtonText("Search");

        ExtentTestManager.getTest().log(Status.INFO, "Search With Manufacturer - Step 05: Verify that the search process is displayed a no data message");
        Assert.assertTrue(adminProductsPage.isNoDataMessageDisplayed());
    }

    @Test
    public void TC_06_Search_With_SKU(Method method) {
        ExtentTestManager.startTest(method.getName(), "Go directly to product SKU");

        ExtentTestManager.getTest().log(Status.INFO, "SKU - Step 01: Click the 'Products' link at Sidebar menu");
        adminProductsPage.clickToAdminSubSidebarMenuByMenuText(driver, "Catalog", "Products");
        adminProductsPage = PageGenerateManager.getAdminProductsPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "SKU - Step 02: Input '" + skuNumber + "' in 'SKU' text box");
        adminProductsPage.inputToProductTextboxByTextboxId("GoDirectlyToSku", skuNumber);

        ExtentTestManager.getTest().log(Status.INFO, "SKU - Step 03: Click the 'Go' button");
        adminProductsPage.clickToButtonByButtonText("Go");
        adminProductsDetailPage = PageGenerateManager.getAdminProductsDetailPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "SKU - Step 04: Verify '" + productName + "' is displayed at 'Product Name' text box");
        Assert.assertEquals(adminProductsDetailPage.getTextboxAttributeByTextboxId("Name"), productName);

        ExtentTestManager.getTest().log(Status.INFO, "SKU - Step 05: Verify '" + skuNumber + "' is displayed at 'SKU' text box");
        Assert.assertEquals(adminProductsDetailPage.getTextboxAttributeByTextboxId("Sku"), skuNumber);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }

}
