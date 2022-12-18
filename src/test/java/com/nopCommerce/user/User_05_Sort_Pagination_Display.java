package com.user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import data.UserDataMapper;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.PageGenerateManager;
import pageObjects.UserHomePO;
import pageObjects.UserProductPO;
import reportConfig.ExtentTestManager;
import ultilities.Environment;

import java.lang.reflect.Method;

public class User_05_Sort_Pagination_Display extends BaseTest {

    UserDataMapper userData;
    Environment env;
    UserHomePO userHomePage;
    UserProductPO userProductPage;
    private WebDriver driver;

    @Parameters({"browser", "evnName", "ipAddress", "portNumber", "osName", "osVersion"})
    @BeforeClass
    public void beforeClass(@Optional("firefox") String browserName, @Optional("local") String evnName, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
        String environmentName = System.getProperty("evn");
        ConfigFactory.setProperty("env", environmentName);
        env = ConfigFactory.create(Environment.class);

        driver = getBrowserDriver(browserName, env.userUrl(), evnName, osName, osVersion, ipAddress, portNumber);
        userData = UserDataMapper.getUserData();

        userHomePage = PageGenerateManager.getUserHomePage(driver);
    }

    @Test
    public void TC_01_Sort_With_Name_Ascending(Method method) {
        ExtentTestManager.startTest(method.getName(), "Sort with name: A - Z");

        ExtentTestManager.getTest().log(Status.INFO, "Sort Ascending - Step 01: Click to 'Notebooks' link at Header Menu");
        userHomePage.clickToSubHeaderMenuByText(driver, "Computers", "Notebooks");
        userProductPage = PageGenerateManager.getUserProductPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Sort Ascending - Step 02: Select 'Name: A - Z' option at 'Sort by' dropdown");
        userProductPage.selectItemAtDropdownById("products-orderby", "Name: A to Z");

        ExtentTestManager.getTest().log(Status.INFO, "Sort Ascending - Step 03: Verify the sort process is working correctly");
        Assert.assertTrue(userProductPage.isProductNameSortByAsc());
    }

    @Test
    public void TC_02_Sort_With_Name_Descending(Method method) {
        ExtentTestManager.startTest(method.getName(), "Sort with name: Z - A");

        ExtentTestManager.getTest().log(Status.INFO, "Sort Ascending - Step 01: Click to 'Notebooks' link at Header Menu");
        userProductPage.clickToSubHeaderMenuByText(driver, "Computers", "Notebooks");

        ExtentTestManager.getTest().log(Status.INFO, "Sort Ascending - Step 02: Select 'Name: Z - A' option at 'Sort by' dropdown");
        userProductPage.selectItemAtDropdownById("products-orderby", "Name: Z to A");

        ExtentTestManager.getTest().log(Status.INFO, "Sort Ascending - Step 03: Verify the sort process is working correctly");
        Assert.assertTrue(userProductPage.isProductNameSortByDesc());
    }

    @Test
    public void TC_03_Sort_With_Price_Ascending(Method method) {
        ExtentTestManager.startTest(method.getName(), "Sort with price: Low to High");

        ExtentTestManager.getTest().log(Status.INFO, "Sort Ascending - Step 01: Click to 'Notebooks' link at Header Menu");
        userProductPage.clickToSubHeaderMenuByText(driver, "Computers", "Notebooks");

        ExtentTestManager.getTest().log(Status.INFO, "Sort Ascending - Step 02: Select 'Price: Low to High' option at 'Sort by' dropdown");
        userProductPage.selectItemAtDropdownById("products-orderby", "Price: Low to High");

        ExtentTestManager.getTest().log(Status.INFO, "Sort Ascending - Step 03: Verify the sort process is working correctly");
        Assert.assertTrue(userProductPage.isProductPriceSortByAsc());
    }

    @Test
    public void TC_04_Sort_With_Price_Descending(Method method) {
        ExtentTestManager.startTest(method.getName(), "Sort with price: High to Low");

        ExtentTestManager.getTest().log(Status.INFO, "Sort Ascending - Step 01: Click to 'Notebooks' link at Header Menu");
        userProductPage.clickToSubHeaderMenuByText(driver, "Computers", "Notebooks");

        ExtentTestManager.getTest().log(Status.INFO, "Sort Ascending - Step 02: Select 'Price: High to Low' option at 'Sort by' dropdown");
        userProductPage.selectItemAtDropdownById("products-orderby", "Price: High to Low");

        ExtentTestManager.getTest().log(Status.INFO, "Sort Ascending - Step 03: Verify the sort process is working correctly");
        Assert.assertTrue(userProductPage.isProductPriceSortByDesc());
    }

    @Test
    public void TC_05_Display_3_Products(Method method) {
        ExtentTestManager.startTest(method.getName(), "Display 3 products");

        ExtentTestManager.getTest().log(Status.INFO, "Display - Step 01: Click to 'Notebooks' link at Header Menu");
        userProductPage.clickToSubHeaderMenuByText(driver, "Computers", "Notebooks");

        ExtentTestManager.getTest().log(Status.INFO, "Display - Step 02: Select '3' option at 'Display' dropdown");
        userProductPage.selectItemAtDropdownById("products-pagesize", "3");

        ExtentTestManager.getTest().log(Status.INFO, "Display - Step 03: Verify that the system only displayed 3 products");
        Assert.assertEquals(userProductPage.getProductSize(), 3);

        ExtentTestManager.getTest().log(Status.INFO, "Display - Step 04: Verify that the 'Next Page' button is displayed when standing on the first page");
        Assert.assertTrue(userProductPage.isPaginationButtonDisplayed("next-page"));

        ExtentTestManager.getTest().log(Status.INFO, "Display - Step 05: Click the '2' button at pagination");
        userProductPage.clickToPaginationButtonByButtonClass("individual-page");

        ExtentTestManager.getTest().log(Status.INFO, "Display - Step 06: Verify that the 'Previous Page' button is displayed when standing on the second page");
        Assert.assertTrue(userProductPage.isPaginationButtonDisplayed("previous-page"));
    }

    @Test
    public void TC_05_Display_6_Products(Method method) {
        ExtentTestManager.startTest(method.getName(), "Display 6 products");

        ExtentTestManager.getTest().log(Status.INFO, "Display - Step 01: Click to 'Notebooks' link at Header Menu");
        userProductPage.clickToSubHeaderMenuByText(driver, "Computers", "Notebooks");

        ExtentTestManager.getTest().log(Status.INFO, "Display - Step 02: Select '6' option at 'Display' dropdown");
        userProductPage.selectItemAtDropdownById("products-pagesize", "6");

        ExtentTestManager.getTest().log(Status.INFO, "Display - Step 03: Verify that the system only displayed 3 products");
        Assert.assertEquals(userProductPage.getProductSize(), 6);

        ExtentTestManager.getTest().log(Status.INFO, "Display - Step 04: Verify that the pagination is undisplayed");
        Assert.assertTrue(userProductPage.isPaginationUndisplayed());
    }

    @Test
    public void TC_06_Display_9_Products(Method method) {
        ExtentTestManager.startTest(method.getName(), "Display 9 products");

        ExtentTestManager.getTest().log(Status.INFO, "Display - Step 01: Click to 'Notebooks' link at Header Menu");
        userProductPage.clickToSubHeaderMenuByText(driver, "Computers", "Notebooks");

        ExtentTestManager.getTest().log(Status.INFO, "Display - Step 02: Select '9' option at 'Display' dropdown");
        userProductPage.selectItemAtDropdownById("products-pagesize", "9");

        ExtentTestManager.getTest().log(Status.INFO, "Display - Step 03: Verify that the system only displayed less than 9 products");
        Assert.assertEquals(userProductPage.getProductSize(), 6);

        ExtentTestManager.getTest().log(Status.INFO, "Display - Step 04: Verify that the pagination is undisplayed");
        Assert.assertTrue(userProductPage.isPaginationUndisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }

}
