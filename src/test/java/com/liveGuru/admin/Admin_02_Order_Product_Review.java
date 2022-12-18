package com.admin;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.GlobalConstants;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.*;
import reportConfig.ExtentTestManager;
import ultilities.Environment;

import java.lang.reflect.Method;

public class Admin_02_Order_Product_Review extends BaseTest{
    private WebDriver driver;
    private String adminUserName, adminPassword;
    private String yourThoughtText, yourReviewText, yourNickName;
    Environment env;
    UserHomePageObject userHomePage;
    UserMobilePageObject userMobilePage;
    UserProductDetailPageObject userProductDetailPage;
    UserReviewPageObject userReviewPage;
    AdminLoginPageObject adminLoginPage;
    AdminHomePageObject adminHomePage;
    AdminOrderPageObject adminOrderPage;
    AdminDownloadedOrderTabPageObject adminDownloadedOrderTabPage;
    AdminPendingReviewPageObject adminPendingReviewsPage;
    AdminEditPendingReviewPageObject adminEditPendingReviewPage;

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

        yourThoughtText = "My thoughts " +generateFakeNumber();
        yourReviewText = "My review " +generateFakeNumber();
        yourNickName = "VanNL";
    }

    @Test
    public void TC_06_Order(Method method) {
        ExtentTestManager.startTest(method.getName(), "Verify Order can be print");

        ExtentTestManager.getTest().log(Status.INFO, "Order - Step 01: Input to 'User Name' text box with value '" + adminUserName + "'");
        adminLoginPage.inputToTextboxById("username", adminUserName);

        ExtentTestManager.getTest().log(Status.INFO, "Order - Step 02: Input to 'Password' text box with value '" + adminPassword + "'");
        adminLoginPage.inputToTextboxById("login", adminPassword);

        ExtentTestManager.getTest().log(Status.INFO, "Order - Step 03: Click to 'Login' button");
        adminHomePage = adminLoginPage.clickToLoginButton();
        adminHomePage.closeAdminPopup();

        ExtentTestManager.getTest().log(Status.INFO, "Order - Step 04: Move to 'Orders' from 'Sales' menu");
        adminHomePage.clickToSubMenuLevel1BySubMenuText(driver,"Sales","Orders");
        adminOrderPage = PageGenerateManager.getAdminOrderPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Order - Step 05: Select 'Canceled' in 'Status' dropdown");
        adminOrderPage.selectItemAtStatusDropdown("Canceled");

        ExtentTestManager.getTest().log(Status.INFO, "Order - Step 06: Click to 'Search' button");
        adminOrderPage.clickToButtonAtAdminSiteByButtonTitle(driver,"Search");

        ExtentTestManager.getTest().log(Status.INFO, "Order - Step 07: Select the first order with the checkbox");
        adminOrderPage.selectFirstOrderByCheckbox();

        ExtentTestManager.getTest().log(Status.INFO, "Order - Step 08: Select 'Print Orders' at 'Actions' dropdown");
        adminOrderPage.selectItemAtOrderActionDropdownByName(driver,"Print Orders");

        ExtentTestManager.getTest().log(Status.INFO, "Order - Step 09: Click to 'Submit' button");
        adminOrderPage.clickToButtonAtAdminSiteByButtonTitle(driver,"Submit");

        ExtentTestManager.getTest().log(Status.INFO, "Order - Step 10: Verify the error message is displayed");
        verifyTrue(adminOrderPage.isMessageAtAdminSiteDisplayed(driver));

        ExtentTestManager.getTest().log(Status.INFO, "Order - Step 11: Select 'Complete' in 'Status' dropdown");
        adminOrderPage.selectItemAtStatusDropdown("Complete");

        ExtentTestManager.getTest().log(Status.INFO, "Order - Step 12: Click to 'Search' button");
        adminOrderPage.clickToButtonAtAdminSiteByButtonTitle(driver,"Search");

        ExtentTestManager.getTest().log(Status.INFO, "Order - Step 13: Select the first order with the checkbox");
        adminOrderPage.selectFirstOrderByCheckbox();

        ExtentTestManager.getTest().log(Status.INFO, "Order - Step 14: Select 'Print Orders' at 'Actions' dropdown");
        adminOrderPage.selectItemAtOrderActionDropdownByName(driver,"Print Orders");
        adminDownloadedOrderTabPage = PageGenerateManager.getAdminDownloadedOrderTabPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Order - Step 15: Click to 'Submit' button");
        adminOrderPage.clickToButtonAtAdminSiteByButtonTitle(driver,"Submit");

        ExtentTestManager.getTest().log(Status.INFO, "Order - Step 16: Verify the new tab downloaded Order is displayed");
        verifyTrue(adminDownloadedOrderTabPage.isDownloadedOrderTabDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Order - Step 17: Close the downloaded Order tab");
        adminOrderPage = adminDownloadedOrderTabPage.closeDownloadedOrderTab();

        ExtentTestManager.getTest().log(Status.INFO, "Order - Step 18: Click to 'Log Out' link");
        adminLoginPage = adminOrderPage.clickToLogoutLinkAtAdminSite(driver);
    }

    @Test
    public void TC_07_Product_Review(Method method) {
        ExtentTestManager.startTest(method.getName(), "Verify Product Review Mechanism At Admin Site");

        ExtentTestManager.getTest().log(Status.INFO, "Product Review At Admin Site - Step 01: Navigate to User Site");
        adminLoginPage.openPageUrl(driver, GlobalConstants.USER_URL);
        userHomePage = PageGenerateManager.getUserHomePage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Product Review At Admin Site - Step 02: Navigate to 'Sony Xperia' review page");
        userHomePage.openPageUrl(driver, "http://live.techpanda.org/index.php/review/product/list/id/1");
        userReviewPage = PageGenerateManager.getUserReviewPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Product Review At Admin Site - Step 03: Select product rate star");
        userReviewPage.selectRatingStarRadioByNumber("3");

        ExtentTestManager.getTest().log(Status.INFO, "Product Review At Admin Site - Step 04: Input to 'Thought' text box with value '" + yourThoughtText + "'");
        userReviewPage.inputToThoughtTextArea(yourThoughtText);

        ExtentTestManager.getTest().log(Status.INFO, "Product Review At Admin Site - Step 05: Input to 'Your review' text box with value '" + yourReviewText + "'");
        userReviewPage.inputToReviewTextbox(yourReviewText);

        ExtentTestManager.getTest().log(Status.INFO, "Product Review At Admin Site - Step 06: Input to 'Your nickname' text box with value '" + yourNickName + "'");
        userReviewPage.inputToNickNameTextbox(yourNickName);

        ExtentTestManager.getTest().log(Status.INFO, "Product Review At Admin Site - Step 07: Click the 'Submit Review' button");
        userReviewPage.clickToSubmitReviewButton();

        ExtentTestManager.getTest().log(Status.INFO, "Product Review At Admin Site - Step 08: Verify the successfully added review message is displayed");
        verifyTrue(userReviewPage.isSuccessfullReviewMessageDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Product Review At Admin Site - Step 09: Navigate to Admin Site");
        userReviewPage.openPageUrl(driver, GlobalConstants.ADMIN_URL);
        adminHomePage = PageGenerateManager.getAdminHomePage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Product Review At Admin Site - Step 10: Input to 'User Name' text box with value '" + adminUserName + "'");
        adminLoginPage.inputToTextboxById("username", adminUserName);

        ExtentTestManager.getTest().log(Status.INFO, "Product Review At Admin Site - Step 11: Input to 'Password' text box with value '" + adminPassword + "'");
        adminLoginPage.inputToTextboxById("login", adminPassword);

        ExtentTestManager.getTest().log(Status.INFO, "Product Review At Admin Site - Step 12: Click to 'Login' button");
        adminHomePage = adminLoginPage.clickToLoginButton();
        adminHomePage.closeAdminPopup();

        ExtentTestManager.getTest().log(Status.INFO, "Product Review At Admin Site - Step 13: Navigate to 'Pending Reviews' Page");
        adminHomePage.clickToSubMenuLevel3BySubMenuText(driver,"Catalog", "Reviews and Ratings","Customer Reviews","Pending Reviews");
        adminPendingReviewsPage = PageGenerateManager.getAdminPendingReviewPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Product Review At Admin Site - Step 14: Click the 'ID' tab on table header to sort review ascending");
        adminPendingReviewsPage.clickToTabByTabName("review_id");
        adminPendingReviewsPage.clickToTabByTabName("review_id");

        ExtentTestManager.getTest().log(Status.INFO, "Product Review At Admin Site - Step 15: Select the latest review by checkbox with value '" + yourThoughtText + "'");
        adminPendingReviewsPage.selectPendingReviewByCheckbox(yourThoughtText);

        ExtentTestManager.getTest().log(Status.INFO, "Product Review At Admin Site - Step 16: Click the 'Edit' link next to the currently selected review");
        adminEditPendingReviewPage = adminPendingReviewsPage.clickToEditLink(yourThoughtText);

        ExtentTestManager.getTest().log(Status.INFO, "Product Review At Admin Site - Step 17: Change into 'Approved' at 'Status' dropdown");
        adminEditPendingReviewPage.selectItemAtStatusPendingReviewDropdown("Approved");

        ExtentTestManager.getTest().log(Status.INFO, "Product Review At Admin Site - Step 18: Click the 'Save Review' button");
        adminPendingReviewsPage = adminEditPendingReviewPage.clickToButtonByButtonTitle("Save Review");

        ExtentTestManager.getTest().log(Status.INFO, "Product Review At Admin Site - Step 19: Navigate to User Site");
        adminPendingReviewsPage.openPageUrl(driver, GlobalConstants.USER_URL);
        userHomePage = PageGenerateManager.getUserHomePage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Product Review At Admin Site - Step 20: Click the 'Mobile' link");
        userHomePage.clickToHeaderMenuLinkByMenuText(driver, "Mobile");
        userMobilePage = PageGenerateManager.getUserMobilePage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Product Review At Admin Site - Step 21: Click the 'Sony Xperia' title");
        userProductDetailPage = userMobilePage.clickToProductTitleByProductName("Sony Xperia");

        ExtentTestManager.getTest().log(Status.INFO, "Product Review At Admin Site - Step 22: Click the 'Review' tab");
        userProductDetailPage.clickToProductDetaiTabByTabTitle("Reviews");

        ExtentTestManager.getTest().log(Status.INFO, "Product Review At Admin Site - Step 23: Verify the review with value '" + yourThoughtText + "' is displayed");
        verifyTrue(userProductDetailPage.isEditPendingReviewDisplayed(yourThoughtText));
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }
}
