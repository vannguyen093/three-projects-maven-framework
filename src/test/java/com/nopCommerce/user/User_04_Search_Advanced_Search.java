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
import pageObjects.UserRegisterPO;
import pageObjects.UserSearchPO;
import reportConfig.ExtentTestManager;
import ultilities.Environment;

import java.lang.reflect.Method;

public class User_04_Search_Advanced_Search extends BaseTest {

    UserDataMapper userData;
    Environment env;
    UserHomePO userHomePage;
    UserRegisterPO userRegisterPage;
    UserSearchPO userSearchPage;
    private WebDriver driver;
    private String emailAddress, notExistData, relativeData, absoluteData, advancedSearchData;

    @Parameters({"browser", "evnName", "ipAddress", "portNumber", "osName", "osVersion"})
    @BeforeClass
    public void beforeClass(@Optional("firefox") String browserName, @Optional("local") String evnName, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
        String environmentName = System.getProperty("evn");
        ConfigFactory.setProperty("env", environmentName);
        env = ConfigFactory.create(Environment.class);

        driver = getBrowserDriver(browserName, env.userUrl(), evnName, osName, osVersion, ipAddress, portNumber);
        userData = UserDataMapper.getUserData();

        userHomePage = PageGenerateManager.getUserHomePage(driver);

        emailAddress = userData.getEditEmail() + generateFakeNumber() + "@gmail.com";
        absoluteData = "ThinkPad X1 Carbon";
        notExistData = "Macbook 2050";
        relativeData = "Lenovo";
        advancedSearchData = "Apple MacBook Pro";

        userHomePage.clickToHeaderLinkByText(driver, "ico-register");
        userRegisterPage = PageGenerateManager.getUserRegisterPage(driver);
        userRegisterPage.selectGenderRadioByText(userData.getGender());
        userRegisterPage.inputToRegisterTextboxByTextboxID("FirstName", userData.getFirstName());
        userRegisterPage.inputToRegisterTextboxByTextboxID("LastName", userData.getLastName());
        userRegisterPage.selectItemInDOBDropbox("DateOfBirthDay", userData.getDate());
        userRegisterPage.selectItemInDOBDropbox("DateOfBirthMonth", userData.getMonth());
        userRegisterPage.selectItemInDOBDropbox("DateOfBirthYear", userData.getYear());
        userRegisterPage.inputToRegisterTextboxByTextboxID("Email", emailAddress);
        userRegisterPage.inputToRegisterTextboxByTextboxID("Password", userData.getPassword());
        userRegisterPage.inputToRegisterTextboxByTextboxID("ConfirmPassword", userData.getPassword());
        userRegisterPage.clickToRegisterButton();
        userHomePage = userRegisterPage.clickToContinueLink();
    }

    @Test
    public void TC_01_Search_With_Empty_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search with empty data");

        ExtentTestManager.getTest().log(Status.INFO, "Empty Data - Step 01: Click to 'Search' link at Footer Menu");
        userHomePage.clickToFooterMenuLinkByMenuText(driver, "Search");
        userSearchPage = PageGenerateManager.getUserSearchPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Empty Data - Step 02: Click the 'Search' button");
        userSearchPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Empty Data - Step 03: Verify the error message is displayed containing 'Search term minimum length is 3 characters'");
        Assert.assertEquals(userSearchPage.getSearchErrMessageText(), "Search term minimum length is 3 characters");
    }

    @Test
    public void TC_02_Search_With_Data_Not_Exist(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search with data not exist");

        ExtentTestManager.getTest().log(Status.INFO, "Data Not Exist - Step 01: Click to 'Search' link at Footer Menu");
        userHomePage.clickToFooterMenuLinkByMenuText(driver, "Search");
        userSearchPage = PageGenerateManager.getUserSearchPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Data Not Exist - Step 02: Input '" + notExistData + "' into 'Search' text box");
        userSearchPage.inputToSearchTextbox(notExistData);

        ExtentTestManager.getTest().log(Status.INFO, "Data Not Exist - Step 03: Click the 'Search' button");
        userSearchPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Data Not Exist - Step 04: Verify the no results message is displayed");
        Assert.assertTrue(userSearchPage.isNoResutlMessageDisplayed());
    }

    @Test
    public void TC_03_Search_With_Relative(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search with relative data");

        ExtentTestManager.getTest().log(Status.INFO, "Relative Data - Step 01: Click to 'Search' link at Footer Menu");
        userHomePage.clickToFooterMenuLinkByMenuText(driver, "Search");
        userSearchPage = PageGenerateManager.getUserSearchPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Relative Data - Step 02: Input '" + relativeData + "' into 'Search' text box");
        userSearchPage.inputToSearchTextbox(relativeData);

        ExtentTestManager.getTest().log(Status.INFO, "Relative Data - Step 03: Click the 'Search' button");
        userSearchPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Relative Data - Step 04: Verify search result have 2 items");
        Assert.assertEquals(userSearchPage.getSearchResultSize(), 2);
    }

    @Test
    public void TC_04_Search_With_Absolute(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search with relative data");

        ExtentTestManager.getTest().log(Status.INFO, "Relative Data - Step 01: Click to 'Search' link at Footer Menu");
        userHomePage.clickToFooterMenuLinkByMenuText(driver, "Search");
        userSearchPage = PageGenerateManager.getUserSearchPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Relative Data - Step 02: Input '" + absoluteData + "' into 'Search' text box");
        userSearchPage.inputToSearchTextbox(absoluteData);

        ExtentTestManager.getTest().log(Status.INFO, "Relative Data - Step 03: Click the 'Search' button");
        userSearchPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Relative Data - Step 04: Verify search result have 1 item");
        Assert.assertEquals(userSearchPage.getSearchResultSize(), 1);
    }

    @Test
    public void TC_05_Advanced_Search_With_Parent_Categories(Method method) {
        ExtentTestManager.startTest(method.getName(), "Advanced Search with parent categories");

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Parent Categories - Step 01: Click to 'Search' link at Footer Menu");
        userHomePage.clickToFooterMenuLinkByMenuText(driver, "Search");
        userSearchPage = PageGenerateManager.getUserSearchPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Parent Categories - Step 02: Input '" + advancedSearchData + "' into 'Search' text box");
        userSearchPage.inputToSearchTextbox(advancedSearchData);

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Parent Categories - Step 03: Click to 'Advanced Search' checkbox");
        userSearchPage.clickToCheckBoxById("advs");

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Parent Categories - Step 04: Select item named 'Computers' at 'Category' dropdown");
        userSearchPage.selectItemAtDropdownById("cid", "Computers");

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Parent Categories - Step 05: Click the 'Search' button");
        userSearchPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Parent Categories - Step 06: Verify the no results message is displayed");
        Assert.assertTrue(userSearchPage.isNoResutlMessageDisplayed());
    }

    @Test
    public void TC_06_Advanced_Search_With_Sub_Categories(Method method) {
        ExtentTestManager.startTest(method.getName(), "Advanced Search with sub categories");

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Sub Categories - Step 01: Click to 'Search' link at Footer Menu");
        userHomePage.clickToFooterMenuLinkByMenuText(driver, "Search");
        userSearchPage = PageGenerateManager.getUserSearchPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Sub Categories - Step 02: Input '" + advancedSearchData + "' into 'Search' text box");
        userSearchPage.inputToSearchTextbox(advancedSearchData);

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Sub Categories - Step 03: Click to 'Advanced Search' checkbox");
        userSearchPage.clickToCheckBoxById("advs");

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Sub Categories - Step 04: Select item named 'Computers' at 'Category' dropdown");
        userSearchPage.selectItemAtDropdownById("cid", "Computers");

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Sub Categories - Step 05: Click to 'Automatically search sub categories' checkbox");
        userSearchPage.clickToCheckBoxById("isc");

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Sub Categories - Step 06: Click the 'Search' button");
        userSearchPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Sub Categories - Step 07: Verify search result have 1 item");
        Assert.assertEquals(userSearchPage.getSearchResultSize(), 1);
    }

    @Test
    public void TC_07_Advanced_Search_With_Incorrect_Manufacturer(Method method) {
        ExtentTestManager.startTest(method.getName(), "Advanced Search with incorrect manufacturer");

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Incorrect Manufacturer - Step 01: Click to 'Search' link at Footer Menu");
        userHomePage.clickToFooterMenuLinkByMenuText(driver, "Search");
        userSearchPage = PageGenerateManager.getUserSearchPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Incorrect Manufacturer - Step 02: Input '" + advancedSearchData + "' into 'Search' text box");
        userSearchPage.inputToSearchTextbox(advancedSearchData);

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Incorrect Manufacturer - Step 03: Click to 'Advanced Search' checkbox");
        userSearchPage.clickToCheckBoxById("advs");

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Incorrect Manufacturer - Step 04: Select item named 'Computers' at 'Category' dropdown");
        userSearchPage.selectItemAtDropdownById("cid", "Computers");

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Incorrect Manufacturer - Step 05: Click to 'Advanced Search' checkbox");
        userSearchPage.clickToCheckBoxById("isc");

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Incorrect Manufacturer - Step 06: Select item named 'Computers' at 'Category' dropdown");
        userSearchPage.selectItemAtDropdownById("mid", "HP");

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Incorrect Manufacturer - Step 07: Click the 'Search' button");
        userSearchPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Incorrect Manufacturer - Step 08: Verify the no results message is displayed");
        Assert.assertTrue(userSearchPage.isNoResutlMessageDisplayed());
    }

    @Test
    public void TC_08_Advanced_Search_With_Correct_Manufacturer(Method method) {
        ExtentTestManager.startTest(method.getName(), "Advanced Search with correct manufacturer");

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Correct Manufacturer - Step 01: Click to 'Search' link at Footer Menu");
        userHomePage.clickToFooterMenuLinkByMenuText(driver, "Search");
        userSearchPage = PageGenerateManager.getUserSearchPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Correct Manufacturer - Step 02: Input '" + advancedSearchData + "' into 'Search' text box");
        userSearchPage.inputToSearchTextbox(advancedSearchData);

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Correct Manufacturer - Step 03: Click to 'Advanced Search' checkbox");
        userSearchPage.clickToCheckBoxById("advs");

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Correct Manufacturer - Step 04: Select item named 'Computers' at 'Category' dropdown");
        userSearchPage.selectItemAtDropdownById("cid", "Computers");

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Correct Manufacturer - Step 05: Click to 'Advanced Search' checkbox");
        userSearchPage.clickToCheckBoxById("isc");

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Correct Manufacturer - Step 06: Select item named 'Computers' at 'Category' dropdown");
        userSearchPage.selectItemAtDropdownById("mid", "Apple");

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Correct Manufacturer - Step 07: Click the 'Search' button");
        userSearchPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Advanced Search With Correct Manufacturer - Step 08: Verify search result have 1 item");
        Assert.assertEquals(userSearchPage.getSearchResultSize(), 1);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }

}
