package com.liveGuru.admin;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.GlobalConstants;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.liveGuru.*;
import reportConfig.ExtentTestManager;
import ultilities.Environment;
import ultilities.LiveGuruDataHelper;

import java.lang.reflect.Method;

public class Admin_01_Create_Update_Delete_Account extends BaseTest {
    LiveGuruDataHelper liveGuruDataHelper;
    Environment env;
    UserHomePageObject userHomePage;
    UserLoginPageObject userLoginPage;
    UserRegisterPageObject userRegisterPage;
    UserMyDashboardPageObject userMyDashboardPage;
    UserAccountInfoPageObject userAccountInfoPage;
    AdminLoginPageObject adminLoginPage;
    AdminHomePageObject adminHomePage;
    private WebDriver driver;
    private String firstName, lastName, fullName, emailAddress, password;
    private String editFirstName, editLastName, editFullName, editEmailAddress;
    private String adminUserName, adminPassword;

    @Parameters({"browser", "evnName", "ipAddress", "portNumber", "osName", "osVersion"})
    @BeforeClass
    public void beforeClass(@Optional("firefox") String browserName, @Optional("local") String evnName, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
        String environmentName = System.getProperty("evn");
        ConfigFactory.setProperty("env", environmentName);
        env = ConfigFactory.create(Environment.class);

        driver = getBrowserDriver(browserName, env.userLiveGuruUrl(), evnName, osName, osVersion, ipAddress, portNumber);
        liveGuruDataHelper = LiveGuruDataHelper.getDataHelper();

        userHomePage = PageGenerateManager.getUserHomePage(driver);

        adminUserName = "user01";
        adminPassword = "guru99com";

        firstName = liveGuruDataHelper.getFirstName();
        lastName = liveGuruDataHelper.getLastName();
        fullName = firstName + " " + lastName;
        emailAddress = liveGuruDataHelper.getEmail();
        password = liveGuruDataHelper.getPassword();
        editFirstName = liveGuruDataHelper.getFirstName();
        editLastName = liveGuruDataHelper.getLastName();
        editFullName = editFirstName + " " + editLastName;
        editEmailAddress = liveGuruDataHelper.getEmail();
    }

    @Test
    public void TC_01_Create_Account_At_User_Site(Method method) {
        ExtentTestManager.startTest(method.getName(), "Create Account At User Site");

        ExtentTestManager.getTest().log(Status.INFO, "Create Account - Step 01: Click to 'My Account' link");
        userHomePage.clickToFooterMenuLinkLiveGuruByMenuText(driver, "My Account");
        userLoginPage = PageGenerateManager.getUserLoginPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Create Account - Step 02: Click to 'Create An Account' button");
        userRegisterPage = userLoginPage.clickToCreateAccountButton();

        ExtentTestManager.getTest().log(Status.INFO, "Create Account - Step 03: Input to 'First Name' text box with value is '" + firstName + "'");
        userRegisterPage.inputToTextboxById("firstname", firstName);

        ExtentTestManager.getTest().log(Status.INFO, "Create Account - Step 04: Input to 'Last Name' text box with value is '" + lastName + "'");
        userRegisterPage.inputToTextboxById("lastname", lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Create Account - Step 05: Input to 'Email Address' text box with value is '" + emailAddress + "'");
        userRegisterPage.inputToTextboxById("email_address", emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Create Account - Step 06: Input to 'Password' text box with value is '" + password + "'");
        userRegisterPage.inputToTextboxById("password", password);

        ExtentTestManager.getTest().log(Status.INFO, "Create Account - Step 07: Input to 'Confirm Password' text box with value is '" + password + "'");
        userRegisterPage.inputToTextboxById("confirmation", password);

        ExtentTestManager.getTest().log(Status.INFO, "Create Account - Step 08: Click to 'Register' button");
        userMyDashboardPage = userRegisterPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Create Account - Step 09: Verify text displayed after registered successfully");
        verifyTrue(userMyDashboardPage.isRegisterdSuccessMessageDisplayed());

    }

    @Test
    public void TC_02_Verify_Create_Account_At_Admin_Site(Method method) {
        ExtentTestManager.startTest(method.getName(), "Verify registered account at admin site");

        ExtentTestManager.getTest().log(Status.INFO, "Verify At Admin Site - Step 01: Open admin site");
        userMyDashboardPage.openPageUrl(driver, GlobalConstants.ADMIN_LIVE_GURU_URL);
        adminLoginPage = PageGenerateManager.getAdminLoginPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Verify At Admin Site - Step 02: Input to 'User Name' text box with value '" + adminUserName + "'");
        adminLoginPage.inputToTextboxById("username", adminUserName);

        ExtentTestManager.getTest().log(Status.INFO, "Verify At Admin Site - Step 03: Input to 'Password' text box with value '" + adminPassword + "'");
        adminLoginPage.inputToTextboxById("login", adminPassword);

        ExtentTestManager.getTest().log(Status.INFO, "Verify At Admin Site - Step 04: Click to 'Login' button");
        adminHomePage = adminLoginPage.clickToLoginButton();
        adminHomePage.closeAdminPopup();

        ExtentTestManager.getTest().log(Status.INFO, "Verify At Admin Site - Step 05: Input full name into Name filter with value '" + fullName + "'");
        adminHomePage.inputToFilterByFilterName("name", fullName);

        ExtentTestManager.getTest().log(Status.INFO, "Verify At Admin Site - Step 06: Verify the account name is displayed at admin site");
        verifyTrue(adminHomePage.isRegisteredAccountDisplayed(fullName, emailAddress));
    }

    @Test
    public void TC_03_Update_Account_At_User_Site(Method method) {
        ExtentTestManager.startTest(method.getName(), "Update Account At User Site");

        ExtentTestManager.getTest().log(Status.INFO, "Update Account - Step 01: Open User site");
        adminHomePage.openPageUrl(driver, GlobalConstants.USER_LIVE_GURU_URL);
        userHomePage = PageGenerateManager.getUserHomePage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Update Account - Step 02: Click to 'My Account' link");
        userHomePage.clickToFooterMenuLinkLiveGuruByMenuText(driver, "My Account");
        userMyDashboardPage = PageGenerateManager.getUserMyDashboardPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Update Account - Step 03: Click to 'Account Information' link at sidebar menu");
        userMyDashboardPage.clickToSidebarMenuLinkByMenuText(driver, "Account Information");
        userAccountInfoPage = PageGenerateManager.getUserAccountInfoPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Update Account - Step 04: Input '" + editFirstName + "' in the 'First Name' text box to edit");
        userAccountInfoPage.inputToTextboxById("firstname", editFirstName);

        ExtentTestManager.getTest().log(Status.INFO, "Update Account - Step 05: Input '" + editLastName + "' in the 'Last Name' text box to edit");
        userAccountInfoPage.inputToTextboxById("lastname", editLastName);

        ExtentTestManager.getTest().log(Status.INFO, "Update Account - Step 06: Input '" + editEmailAddress + "' in the 'Email' text box to edit");
        userAccountInfoPage.inputToTextboxById("email", editEmailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Update Account - Step 07: Input '" + password + "' in the 'Password' text box to confirm");
        userAccountInfoPage.inputToTextboxById("current_password", password);

        ExtentTestManager.getTest().log(Status.INFO, "Update Account - Step 08: Click to 'Save' button");
        userAccountInfoPage.clickToSaveButton();
    }

    @Test
    public void TC_04_Verify_Update_Account_At_Admin_Site(Method method) {
        ExtentTestManager.startTest(method.getName(), "Verify updated an existing account at admin site");

        ExtentTestManager.getTest().log(Status.INFO, "Verify Updated At Admin Site - Step 01: Open admin site");
        userMyDashboardPage.openPageUrl(driver, GlobalConstants.ADMIN_LIVE_GURU_URL);
        adminHomePage = PageGenerateManager.getAdminHomePage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Verify Updated At Admin Site - Step 02: Input '" + editFullName + "' in the 'Name' filter to search");
        adminHomePage.inputToFilterByFilterName("name", editFullName);

        ExtentTestManager.getTest().log(Status.INFO, "Verify Updated At Admin Site - Step 03: Verify the updated account name is displayed at admin site");
        verifyTrue(adminHomePage.isRegisteredAccountDisplayed(editFullName, editEmailAddress));
    }

    @Test
    public void TC_05_Delete_Account_At_Admin_Site(Method method) {
        ExtentTestManager.startTest(method.getName(), "Delete an account at admin site");

        ExtentTestManager.getTest().log(Status.INFO, "Delete Account At Admin Site - Step 01: Open admin site");
        adminHomePage.openPageUrl(driver, GlobalConstants.ADMIN_LIVE_GURU_URL);
        adminHomePage = PageGenerateManager.getAdminHomePage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Delete Account At Admin Site - Step 02: Select '" + editFullName + "' by checkbox");
        adminHomePage.selectAccountCheckboxByAccountFullName(editFullName);

        ExtentTestManager.getTest().log(Status.INFO, "Delete Account At Admin Site - Step 03: Select 'Delete' in 'Actions' dropdown");
        adminHomePage.selectItemAtCustomerActionDropdownByName("Delete");

        ExtentTestManager.getTest().log(Status.INFO, "Delete Account At Admin Site - Step 04: Click to 'Submit' button");
        adminHomePage.clickToButtonAtAdminSiteByButtonTitle(driver, "Submit");

        ExtentTestManager.getTest().log(Status.INFO, "Delete Account At Admin Site - Step 05: Accept alert");
        adminHomePage.acceptAlert(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Delete Account At Admin Site - Step 06: Verify that the account successfully deleted message is displayed");
        verifyTrue(adminHomePage.isMessageAtAdminSiteDisplayed(driver));

        ExtentTestManager.getTest().log(Status.INFO, "Delete Account At Admin Site - Step 07: Input '" + editFullName + "' in the 'Name' filter to search");
        adminHomePage.inputToFilterByFilterName("name", editFullName);

        ExtentTestManager.getTest().log(Status.INFO, "Delete Account At Admin Site - Step 08: Verify '" + editFullName + "' is undisplayed at admin site");
        verifyTrue(adminHomePage.isDeleteAccountUndisplayed(editFullName, emailAddress));
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }
}
