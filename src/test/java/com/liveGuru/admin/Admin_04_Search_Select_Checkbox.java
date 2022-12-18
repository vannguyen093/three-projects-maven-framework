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

public class Admin_04_Search_Select_Checkbox extends BaseTest{
    private WebDriver driver;
    private String adminUserName, adminPassword;
    private String customerID, fullName, emailAddress;
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

        customerID = "75652";
        fullName = "kandy k";
        emailAddress = "Kanthasami@gmail.com";
    }

//    @Test
    public void TC_10_Search(Method method) {
        ExtentTestManager.startTest(method.getName(), "Verify search functionality");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Input to 'User Name' text box with value '" + adminUserName + "'");
        adminLoginPage.inputToTextboxById("username", adminUserName);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Input to 'Password' text box with value '" + adminPassword + "'");
        adminLoginPage.inputToTextboxById("login", adminPassword);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Click to 'Login' button");
        adminHomePage = adminLoginPage.clickToLoginButton();
        adminHomePage.closeAdminPopup();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Input customer id into ID filter with value '" + customerID + "'");
        adminHomePage.inputToFilterByFilterName("entity_id[from]", customerID);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 05: Input full name into Name filter with value '" + fullName + "'");
        adminHomePage.inputToFilterByFilterName("name", fullName);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 06: Verify the account name is displayed at admin site");
        verifyTrue(adminHomePage.isRegisteredAccountDisplayed(fullName, emailAddress));

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 07: Click the 'Log Out' link");
        adminLoginPage = adminHomePage.clickToLogoutLinkAtAdminSite(driver);
    }

    @Test
    public void TC_11_Select_Checkbox(Method method) {
        ExtentTestManager.startTest(method.getName(), "Verify select checkbox functionality");

        ExtentTestManager.getTest().log(Status.INFO, "Select Checkbox - Step 01: Input to 'User Name' text box with value '" + adminUserName + "'");
        adminLoginPage.inputToTextboxById("username", adminUserName);

        ExtentTestManager.getTest().log(Status.INFO, "Select Checkbox - Step 02: Input to 'Password' text box with value '" + adminPassword + "'");
        adminLoginPage.inputToTextboxById("login", adminPassword);

        ExtentTestManager.getTest().log(Status.INFO, "Select Checkbox - Step 03: Click to 'Login' button");
        adminHomePage = adminLoginPage.clickToLoginButton();
        adminHomePage.closeAdminPopup();

        ExtentTestManager.getTest().log(Status.INFO, "Select Checkbox - Step 04: Navigate to the 'Orders' page");
        adminHomePage.clickToSubMenuLevel1BySubMenuText(driver, "Sales", "Orders");
        adminOrderPage = PageGenerateManager.getAdminOrderPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Select Checkbox - Step 05: Click the 'Select Visible' link");
        adminOrderPage.clickToSelectUnSelectLinkByText("Select Visible");

        ExtentTestManager.getTest().log(Status.INFO, "Select Checkbox - Step 06: Verify the '20 items selected' message is displayed");
        verifyTrue(adminOrderPage.getItemsSelectedText("20"));

        ExtentTestManager.getTest().log(Status.INFO, "Select Checkbox - Step 07: Verify 20 checkboxes in table is checked");
        verifyEquals(adminOrderPage.getTableSelectedCheckboxSize(), 20);

        ExtentTestManager.getTest().log(Status.INFO, "Select Checkbox - Step 08: Click the 'Unselect Visible' link");
        adminOrderPage.clickToSelectUnSelectLinkByText("Unselect Visible");

        ExtentTestManager.getTest().log(Status.INFO, "Select Checkbox - Step 09: Verify the '0 item selected' message is displayed");
        verifyTrue(adminOrderPage.getItemsSelectedText("0"));

        ExtentTestManager.getTest().log(Status.INFO, "Select Checkbox - Step 10: Verify 20 checkboxes in table is unchecked");
        verifyEquals(adminOrderPage.getTableUnselectedCheckboxSize(), 20);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }
}
