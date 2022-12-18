package com.nopCommerce.admin;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import data.nopCommerce.NopCommerceAdminDataMapper;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.nopCommerce.AdminCustomersPO;
import pageObjects.nopCommerce.AdminDashboardPO;
import pageObjects.nopCommerce.AdminLoginPO;
import pageObjects.nopCommerce.PageGenerateManager;
import reportConfig.ExtentTestManager;
import ultilities.Environment;

import java.lang.reflect.Method;

public class Admin_02_Create_New_Customer extends BaseTest {

    NopCommerceAdminDataMapper adminData;
    Environment env;
    AdminLoginPO adminLoginPage;
    AdminDashboardPO adminDashboardPage;
    AdminCustomersPO adminCustomersPage;
    private WebDriver driver;
    private String userName, password;
    private String email, editEmail, lastName, editLastName;

    @Parameters({"browser", "evnName", "ipAddress", "portNumber", "osName", "osVersion"})
    @BeforeClass
    public void beforeClass(@Optional("firefox") String browserName, @Optional("local") String evnName, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
        String environmentName = System.getProperty("evn");
        ConfigFactory.setProperty("env", environmentName);
        env = ConfigFactory.create(Environment.class);

        driver = getBrowserDriver(browserName, env.adminNopCommerceUrl(), evnName, osName, osVersion, ipAddress, portNumber);
        adminData = NopCommerceAdminDataMapper.getAdminData();

        adminLoginPage = PageGenerateManager.getAdminLoginPage(driver);

        userName = "admin@yourstore.com";
        password = "admin";
        lastName = adminData.getLastName() + " " + generateFakeNumber();
        editLastName = adminData.getEditLastName() + " " + generateFakeNumber();
        email = adminData.getEmail() + generateFakeNumber() + "@gmail.com";
        editEmail = adminData.getEditEmail() + generateFakeNumber() + "@gmail.com";
    }

    @Test
    public void TC_07_Create_New_Customer(Method method) {
        ExtentTestManager.startTest(method.getName(), "Create new customer at admin site");

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 01: Input '" + userName + "' in 'Email' text box");
        adminLoginPage.inputToLoginTextboxByTextboxId("Email", userName);

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 02: Input '" + password + "' in 'Password' text box");
        adminLoginPage.inputToLoginTextboxByTextboxId("Password", password);

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 03: Click the 'Login' button");
        adminDashboardPage = adminLoginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 04: Click the 'Customers' link at Sidebar menu");
        adminDashboardPage.clickToAdminSubSidebarMenuByMenuText(driver, "Customers", "Customers");
        adminCustomersPage = PageGenerateManager.getAdminCustomersPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 05: Click the 'Add new' button");
        adminCustomersPage.clickToAddNewButton();

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 06: Input '" + email + "' into 'Email' text box");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("Email", email);

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 07: Input '" + adminData.getPassword() + "' into 'Password' text box");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("Password", adminData.getPassword());

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 08: Input '" + adminData.getFirstName() + "' into 'First Name' text box");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("FirstName", adminData.getFirstName());

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 09: Input '" + lastName + "' into 'Last Name' text box");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("LastName", lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 10: Select '" + adminData.getGender() + "' at 'Gender' radio");
        adminCustomersPage.selectGenderByGenderText(adminData.getGender());

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 11: Input '" + adminData.getDateOfBirth() + "' into 'Date of birth' text box");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("DateOfBirth", adminData.getDateOfBirth());

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 12: Input '" + adminData.getCompany() + "' into 'Company' text box");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("Company", adminData.getCompany());

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 13: Unselect '" + "Registered" + "' option at 'Customer role' dropdown");
        adminCustomersPage.unSelectCustomerRoleByText("Registered");

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 14: Select '" + adminData.getCustomerRole() + "' option at 'Customer role' dropdown");
        adminCustomersPage.selectNewCustomerRoleDropdown(adminData.getCustomerRole());

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 15: Input '" + adminData.getAdminComment() + "' into 'Admin comment' text box");
        adminCustomersPage.inputToNewCustomerAdminCommentTextarea(adminData.getAdminComment());

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 16: Click the 'Save and Continue Edit' button");
        adminCustomersPage.clickToNewCustomerButtonByButtonText("Save and Continue Edit");

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 17: Verify that the system is displayed a success message");
        Assert.assertEquals(adminCustomersPage.getCustomerSuccessMessageText(), "×\nThe new customer has been added successfully.");

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 18: Verify '" + email + "' is displayed at 'Email' text box");
        Assert.assertEquals(adminCustomersPage.getCustomerAttributeByTextboxId("Email"), email);

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 19: Verify '" + adminData.getFirstName() + "' is displayed at 'First Name' text box");
        Assert.assertEquals(adminCustomersPage.getCustomerAttributeByTextboxId("FirstName"), adminData.getFirstName());

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 20: Verify '" + lastName + "' is displayed at 'Last Name' text box");
        Assert.assertEquals(adminCustomersPage.getCustomerAttributeByTextboxId("LastName"), lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 21: Verify '" + adminData.getGender() + "' is displayed at 'Last Name' text box");
        Assert.assertTrue(adminCustomersPage.isGenderSelectedByGenderText(adminData.getGender()));

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 22: Verify '" + adminData.getCompany() + "' is displayed at 'Last Name' text box");
        Assert.assertEquals(adminCustomersPage.getCustomerAttributeByTextboxId("Company"), adminData.getCompany());

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 23: Verify '" + adminData.getCustomerRole() + "' is displayed at 'Customer role' dropdown");
        Assert.assertEquals(adminCustomersPage.getNewCustomerAttributeByDropdown(), adminData.getCustomerRole());

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 24: Verify '" + adminData.getAdminComment() + "' is displayed at 'Admin Comment' text box");
        Assert.assertEquals(adminCustomersPage.getNewCustomerAttributeAtAdminCommentTextarea(), adminData.getAdminComment());

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 25: Click the 'back to customer list' link");
        adminCustomersPage.clickToBackToCustomerLinkByText("back to customer list");

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 26: Unselect '" + "Registered" + "' option at 'Customer role' dropdown");
        adminCustomersPage.unSelectCustomerRoleByText("Registered");

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 27: Select '" + adminData.getCustomerRole() + "' option at 'Customer role' dropdown");
        adminCustomersPage.selectCustomerRoleDropdown(adminData.getCustomerRole());

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 28: Click the 'Search' button");
        adminCustomersPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Create New Customer - Step 29: Verify '" + adminData.getFirstName() + " " + lastName + "' is displayed at customer table list");
        Assert.assertTrue(adminCustomersPage.isCustomerFullNameDisplayedAtTable(adminData.getFirstName() + " " + lastName));
    }

    @Test
    public void TC_08_Search_Customer_With_Email(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search a new customer with email");

        ExtentTestManager.getTest().log(Status.INFO, "Search Customer With Email - Step 01: Input '" + email + "' into 'Email' text box");
        adminCustomersPage.refreshCurrentPage(driver);
        adminCustomersPage.inputToCustomerTextboxByTextboxId("SearchEmail", email);

        ExtentTestManager.getTest().log(Status.INFO, "Search Customer With Email - Step 02: Unselect '" + "Registered" + "' option at 'Customer role' dropdown");
        adminCustomersPage.unSelectCustomerRoleByText("Registered");

        ExtentTestManager.getTest().log(Status.INFO, "Search Customer With Email - Step 03: Select '" + adminData.getCustomerRole() + "' option at 'Customer role' dropdown");
        adminCustomersPage.selectCustomerRoleDropdown(adminData.getCustomerRole());

        ExtentTestManager.getTest().log(Status.INFO, "Search Customer With Email - Step 04: Click the 'Search' button");
        adminCustomersPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Search Customer With Email - Step 05: Verify the customer table list is displayed 1 result");
        Assert.assertEquals(adminCustomersPage.getCustomerTableSize(adminData.getFirstName() + " " + lastName), 1);
    }

    @Test
    public void TC_09_Search_Customer_With_FirstName_LastName(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search a new customer with first name and last name");

        ExtentTestManager.getTest().log(Status.INFO, "Search Customer With Firstname Lastname - Step 01: Input '" + adminData.getFirstName() + "' into 'First name' text box");
        adminCustomersPage.refreshCurrentPage(driver);
        adminCustomersPage.inputToCustomerTextboxByTextboxId("SearchFirstName", adminData.getFirstName());

        ExtentTestManager.getTest().log(Status.INFO, "Search Customer With Firstname Lastname - Step 02: Input '" + lastName + "' into 'First name' text box");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("SearchLastName", lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Search Customer With Firstname Lastname - Step 03: Unselect '" + "Registered" + "' option at 'Customer role' dropdown");
        adminCustomersPage.unSelectCustomerRoleByText("Registered");

        ExtentTestManager.getTest().log(Status.INFO, "Search Customer With Firstname Lastname - Step 04: Select '" + adminData.getCustomerRole() + "' option at 'Customer role' dropdown");
        adminCustomersPage.selectCustomerRoleDropdown(adminData.getCustomerRole());

        ExtentTestManager.getTest().log(Status.INFO, "Search Customer With Firstname Lastname - Step 05: Click the 'Search' button");
        adminCustomersPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Search Customer With Firstname Lastname - Step 06: Verify the customer table list is displayed 1 result");
        Assert.assertEquals(adminCustomersPage.getCustomerTableSize(adminData.getFirstName() + " " + lastName), 1);
    }

    @Test
    public void TC_10_Search_Customer_With_Company(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search a new customer with company");

        ExtentTestManager.getTest().log(Status.INFO, "Search Customer With Company - Step 01: Input '" + adminData.getCompany() + "' into 'First name' text box");
        adminCustomersPage.refreshCurrentPage(driver);
        adminCustomersPage.inputToCustomerTextboxByTextboxId("SearchCompany", adminData.getCompany());

        ExtentTestManager.getTest().log(Status.INFO, "Search Customer With Company - Step 02: Unselect '" + "Registered" + "' option at 'Customer role' dropdown");
        adminCustomersPage.unSelectCustomerRoleByText("Registered");

        ExtentTestManager.getTest().log(Status.INFO, "Search Customer With Company - Step 03: Select '" + adminData.getCustomerRole() + "' option at 'Customer role' dropdown");
        adminCustomersPage.selectCustomerRoleDropdown(adminData.getCustomerRole());

        ExtentTestManager.getTest().log(Status.INFO, "Search Customer With Company - Step 04: Click the 'Search' button");
        adminCustomersPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Search Customer With Company - Step 05: Verify the customer table list is displayed 1 result");
        Assert.assertEquals(adminCustomersPage.getCustomerTableSize(adminData.getFirstName() + " " + lastName), 1);
    }

    @Test
    public void TC_11_Search_Customer_With_Full_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search a new customer with full data");

        ExtentTestManager.getTest().log(Status.INFO, "Search Customer With Full Data - Step 01: Input '" + email + "' into 'Email' text box");
        adminCustomersPage.refreshCurrentPage(driver);
        adminCustomersPage.inputToCustomerTextboxByTextboxId("SearchEmail", email);

        ExtentTestManager.getTest().log(Status.INFO, "Search Customer With Full Data - Step 02: Input '" + adminData.getFirstName() + "' into 'First name' text box");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("SearchFirstName", adminData.getFirstName());

        ExtentTestManager.getTest().log(Status.INFO, "Search Customer With Full Data - Step 03: Input '" + lastName + "' into 'Last name' text box");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("SearchLastName", lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Search Customer With Full Data - Step 04: Input '" + adminData.getCompany() + "' into 'Company' text box");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("SearchCompany", adminData.getCompany());

        ExtentTestManager.getTest().log(Status.INFO, "Search Customer With Full Data - Step 05: Unselect '" + "Registered" + "' option at 'Customer role' dropdown");
        adminCustomersPage.unSelectCustomerRoleByText("Registered");

        ExtentTestManager.getTest().log(Status.INFO, "Search Customer With Full Data - Step 06: Select '" + adminData.getCustomerRole() + "' option at 'Customer role' dropdown");
        adminCustomersPage.selectCustomerRoleDropdown(adminData.getCustomerRole());

        ExtentTestManager.getTest().log(Status.INFO, "Search Customer With Full Data - Step 07: Click the 'Search' button");
        adminCustomersPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Search Customer With Full Data - Step 08: Verify the customer table list is displayed 1 result");
        Assert.assertEquals(adminCustomersPage.getCustomerTableSize(adminData.getFirstName() + " " + lastName), 1);
    }

    @Test
    public void TC_12_Edit_Customer(Method method) {
        ExtentTestManager.startTest(method.getName(), "Edit a new customer at admin site");

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Customer - Step 01: Input '" + email + "' into 'Email' text box");
        adminCustomersPage.refreshCurrentPage(driver);
        adminCustomersPage.inputToCustomerTextboxByTextboxId("SearchEmail", email);

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Customer - Step 02: Input '" + adminData.getFirstName() + "' into 'First name' text box");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("SearchFirstName", adminData.getFirstName());

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Customer - Step 03: Input '" + lastName + "' into 'Last name' text box");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("SearchLastName", lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Customer - Step 04: Input '" + adminData.getCompany() + "' into 'Company' text box");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("SearchCompany", adminData.getCompany());

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Customer - Step 05: Unselect '" + "Registered" + "' option at 'Customer role' dropdown");
        adminCustomersPage.unSelectCustomerRoleByText("Registered");

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Customer - Step 06: Select '" + adminData.getCustomerRole() + "' option at 'Customer role' dropdown");
        adminCustomersPage.selectCustomerRoleDropdown(adminData.getCustomerRole());

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Customer - Step 07: Click the 'Search' button");
        adminCustomersPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Customer - Step 08: Click the 'Edit' button by customer full name");
        adminCustomersPage.clickToEditButtonByCustomerFullNameText(adminData.getFirstName() + " " + lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Customer - Step 09: Input '" + editEmail + "' into 'Email' text box");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("Email", editEmail);

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Customer - Step 10: Input '" + adminData.getEditFirstName() + "' into 'First Name' text box");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("FirstName", adminData.getEditFirstName());

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Customer - Step 11: Input '" + editLastName + "' into 'Last Name' text box");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("LastName", editLastName);

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Customer - Step 12: Select '" + adminData.getEditGender() + "' at 'Gender' radio");
        adminCustomersPage.selectGenderByGenderText(adminData.getEditGender());

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Customer - Step 13: Input '" + adminData.getEditDateOfBirth() + "' into 'Date of birth' text box");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("DateOfBirth", adminData.getEditDateOfBirth());

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Customer - Step 14: Input '" + adminData.getEditCompany() + "' into 'Company' text box");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("Company", adminData.getEditCompany());

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Customer - Step 15: Input '" + adminData.getEditAdminComment() + "' into 'Admin comment' text box");
        adminCustomersPage.inputToNewCustomerAdminCommentTextarea(adminData.getEditAdminComment());

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Customer - Step 16: Click the 'Save' button");
        adminCustomersPage.clickToNewCustomerButtonByButtonText("Save");

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Customer - Step 17: Verify that the system is displayed a success message");
        Assert.assertEquals(adminCustomersPage.getCustomerSuccessMessageText(), "×\nThe customer has been updated successfully.");

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Customer - Step 18: Input '" + adminData.getEditFirstName() + "' into 'First name' text box");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("SearchFirstName", adminData.getEditFirstName());

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Customer - Step 19: Input '" + editLastName + "' into 'Last name' text box");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("SearchLastName", editLastName);

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Customer - Step 20: Input '" + adminData.getEditCompany() + "' into 'Company' text box");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("SearchCompany", adminData.getEditCompany());

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Customer - Step 21: Unselect '" + "Registered" + "' option at 'Customer role' dropdown");
        adminCustomersPage.unSelectCustomerRoleByText("Registered");

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Customer - Step 22: Select '" + adminData.getCustomerRole() + "' option at 'Customer role' dropdown");
        adminCustomersPage.selectCustomerRoleDropdown(adminData.getCustomerRole());

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Customer - Step 23: Click the 'Search' button");
        adminCustomersPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Customer - Step 24: Verify the customer table list is displayed 1 result");
        Assert.assertEquals(adminCustomersPage.getCustomerTableSize(adminData.getEditFirstName() + " " + editLastName), 1);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }

}
