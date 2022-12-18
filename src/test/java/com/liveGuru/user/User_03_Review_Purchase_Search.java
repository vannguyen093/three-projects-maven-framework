package com.liveGuru.user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.liveGuru.*;
import reportConfig.ExtentTestManager;
import ultilities.Environment;
import ultilities.LiveGuruDataHelper;

import java.lang.reflect.Method;

public class User_03_Review_Purchase_Search extends BaseTest {
    Environment env;
    LiveGuruDataHelper liveGuruDataHelper;
    UserHomePageObject userHomePage;
    UserProductDetailPageObject userProductDetailPage;
    UserCartPageObject userCartPage;
    UserLoginPageObject userLoginPage;
    UserRegisterPageObject userRegisterPage;
    UserMyDashboardPageObject userMyDashboardPage;
    UserTVPageObject userTVPage;
    UserReviewPageObject userReviewPage;
    UserCheckOutPageObject userCheckOutPage;
    UserSuccessCheckOutPageObject userSuccessCheckOutPage;
    UserAdvancedSearchPageObject userAdvancedSearchPage;
    UserSearchResultPageObject userSearchResultPage;
    private WebDriver driver;
    private String firstName, lastName, emailAddress, password;
    private String address, country, state, city, zip, telephone;
    private String yourThoughtText, yourReviewText;

    @Parameters({"browser", "evnName", "ipAddress", "portNumber", "osName", "osVersion"})
    @BeforeClass
    public void beforeClass(@Optional("firefox") String browserName, @Optional("local") String evnName, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
        String environmentName = System.getProperty("evn");
        ConfigFactory.setProperty("env", environmentName);
        env = ConfigFactory.create(Environment.class);

        driver = getBrowserDriver(browserName, env.userLiveGuruUrl(), evnName, osName, osVersion, ipAddress, portNumber);
        liveGuruDataHelper = LiveGuruDataHelper.getDataHelper();

        userHomePage = PageGenerateManager.getUserHomePage(driver);

        firstName = liveGuruDataHelper.getFirstName();
        lastName = liveGuruDataHelper.getLastName();
        emailAddress = liveGuruDataHelper.getEmail();
        password = liveGuruDataHelper.getPassword();
        address = liveGuruDataHelper.getAddress();
        country = "United States";
        state = "California";
        city = liveGuruDataHelper.getCity();
        zip = "23";
        telephone = liveGuruDataHelper.getTelephone();

        yourThoughtText = "This is my review " + generateFakeNumber();
        yourReviewText = "Review " + generateFakeNumber();

        userHomePage.clickToFooterMenuLinkLiveGuruByMenuText(driver, "My Account");
        userLoginPage = PageGenerateManager.getUserLoginPage(driver);

        userRegisterPage = userLoginPage.clickToCreateAccountButton();
        userRegisterPage.inputToTextboxById("firstname", firstName);
        userRegisterPage.inputToTextboxById("lastname", lastName);
        userRegisterPage.inputToTextboxById("email_address", emailAddress);
        userRegisterPage.inputToTextboxById("password", password);
        userRegisterPage.inputToTextboxById("confirmation", password);
        userMyDashboardPage = userRegisterPage.clickToRegisterButton();
    }

    @Test
    public void TC_10_Review_Product(Method method) {
        ExtentTestManager.startTest(method.getName(), "Review a product");

        ExtentTestManager.getTest().log(Status.INFO, "Review Product - Step 01: Click to 'TV' link");
        userMyDashboardPage.clickToHeaderMenuLinkByMenuText(driver, "TV");
        userTVPage = PageGenerateManager.getUserTVPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Review Product - Step 02: Click to 'Samsung LCD' title");
        userProductDetailPage = userTVPage.clickToProductTitleByProductName("Samsung LCD");

        ExtentTestManager.getTest().log(Status.INFO, "Review Product - Step 03: Click to 'Add Your Review' link");
        userReviewPage = userProductDetailPage.clickToAddYourReviewLink();

        ExtentTestManager.getTest().log(Status.INFO, "Review Product - Step 04: Leave required fields blank and click to 'Submit Review' button");
        userReviewPage.clickToSubmitReviewButton();

        ExtentTestManager.getTest().log(Status.INFO, "Review Product - Step 05: Verify error messages are displayed");
        verifyTrue(userReviewPage.isErrorMessageAtRatingRadioDisplayed());
        verifyTrue(userReviewPage.isErrorMessageByLabelTextDisplayed("Let us know your thoughts"));
        verifyTrue(userReviewPage.isErrorMessageByLabelTextDisplayed("Summary of Your Review"));

        ExtentTestManager.getTest().log(Status.INFO, "Review Product - Step 06: Select product rate star");
        userReviewPage.selectRatingStarRadioByNumber("3");

        ExtentTestManager.getTest().log(Status.INFO, "Review Product - Step 07: Input to 'Thought' text box with value '" + yourThoughtText + "'");
        userReviewPage.inputToThoughtTextArea(yourThoughtText);

        ExtentTestManager.getTest().log(Status.INFO, "Review Product - Step 08: Input to 'Your review' text box with value '" + yourReviewText + "'");
        userReviewPage.inputToReviewTextbox(yourReviewText);

        ExtentTestManager.getTest().log(Status.INFO, "Review Product - Step 09: Input to 'Your nickname' text box with value '" + firstName + "'");
        userReviewPage.inputToNickNameTextbox(firstName);

        ExtentTestManager.getTest().log(Status.INFO, "Review Product - Step 10: Click to 'Submit Review' button");
        userReviewPage.clickToSubmitReviewButton();

        ExtentTestManager.getTest().log(Status.INFO, "Review Product - Step 11: Verify the successfully added review message is displayed");
        verifyTrue(userReviewPage.isSuccessfullReviewMessageDisplayed());
    }

    @Test
    public void TC_11_Purchase_Product(Method method) {
        ExtentTestManager.startTest(method.getName(), "Purchase Product");

        ExtentTestManager.getTest().log(Status.INFO, "Purchase Product - Step 01: Click to 'TV' link");
        userReviewPage.clickToHeaderMenuLinkByMenuText(driver, "TV");
        userTVPage = PageGenerateManager.getUserTVPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Purchase Product - Step 02: Click to 'Add to cart' button at product named 'Samsung LCD'");
        userCartPage = userTVPage.clickToAddToCartButtonByProductName("Samsung LCD");

        ExtentTestManager.getTest().log(Status.INFO, "Purchase Product - Step 03: Select value at 'Country' dropdown with value '" + country + "'");
        userCartPage.selectItemAtEstimateDropdownByDropdownID("Country", country);

        ExtentTestManager.getTest().log(Status.INFO, "Purchase Product - Step 04: Select value at 'State/Province' dropdown with value '" + state + "'");
        userCartPage.selectItemAtEstimateDropdownByDropdownID("State/Province", state);

        ExtentTestManager.getTest().log(Status.INFO, "Purchase Product - Step 05: Input to 'Zip' text box with value '" + zip + "'");
        userCartPage.inputToZipTextBox(zip);

        ExtentTestManager.getTest().log(Status.INFO, "Purchase Product - Step 06: Click to 'Estimate' link");
        userCartPage.clickToButtonAtAdminSiteByButtonTitle("Estimate");

        ExtentTestManager.getTest().log(Status.INFO, "Purchase Product - Step 07: Verify 'Flat Rate' is displayed with value 'Fixed - $5.00'");
        verifyEquals(userCartPage.getFixedFlatRateText(), "$5.00");

        ExtentTestManager.getTest().log(Status.INFO, "Purchase Product - Step 08: Select' Fixed cost' radio at 'Flat Rate' field");
        userCartPage.checkToFixedRadio();

        ExtentTestManager.getTest().log(Status.INFO, "Purchase Product - Step 09: Click to 'Update Total' button");
        userCartPage.clickToButtonAtAdminSiteByButtonTitle("Update Total");

        ExtentTestManager.getTest().log(Status.INFO, "Purchase Product - Step 10: Verify 'Shipping & Handling' is displayed");
        verifyEquals(userCartPage.getShippingHandlingText(), "$5.00");

        ExtentTestManager.getTest().log(Status.INFO, "Purchase Product - Step 11: Verify shipping cost is added to total with value '$705'");
        verifyEquals(userCartPage.getGrandTotalText(), "$705.00");

        ExtentTestManager.getTest().log(Status.INFO, "Purchase Product - Step 12: Click to 'Proceed To Checkout' button");
        userCartPage.clickToButtonAtAdminSiteByButtonTitle("Proceed to Checkout");
        userCheckOutPage = PageGenerateManager.getUserCheckOutPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Purchase Product - Step 13: Input to 'Address' text box with value '" + address + "'");
        userCheckOutPage.inputToTextboxByTitle("Street Address", address);

        ExtentTestManager.getTest().log(Status.INFO, "Purchase Product - Step 14: Input to 'City' text box with value '" + city + "'");
        userCheckOutPage.inputToTextboxByTitle("City", city);

        ExtentTestManager.getTest().log(Status.INFO, "Purchase Product - Step 15: Select value at 'State/Province' dropdown with value '" + state + "'");
        userCheckOutPage.selectItemInDropdownAtBillingInfoTab("State/Province", state);

        ExtentTestManager.getTest().log(Status.INFO, "Purchase Product - Step 16: Input to 'Zip' text box with value '" + zip + "'");
        userCheckOutPage.inputToTextboxByTitle("Zip", zip);

        ExtentTestManager.getTest().log(Status.INFO, "Purchase Product - Step 17: Input to 'Telephone' text box with value '" + telephone + "'");
        userCheckOutPage.inputToTextboxByTitle("Telephone", telephone);

        ExtentTestManager.getTest().log(Status.INFO, "Purchase Product - Step 18: Click to 'Continue' button at 'Billing Information' tab");
        userCheckOutPage.clickToContinueAtBillingInfoTab();

        ExtentTestManager.getTest().log(Status.INFO, "Purchase Product - Step 19: Click to 'Continue' button at 'Shipping Method' tab");
        userCheckOutPage.clickToContinueAtShippingMethodTab();

        ExtentTestManager.getTest().log(Status.INFO, "Purchase Product - Step 20: Click to 'Check/ Money order' radio at 'Payment Information' tab");
        userCheckOutPage.checkToRadioPaymentInfoByRadioTitle("Check / Money order");

        ExtentTestManager.getTest().log(Status.INFO, "Purchase Product - Step 21: Click to 'Continue' button at 'Payment Information' tab");
        userCheckOutPage.clickToContinueAtPaymentInfoTab();

        ExtentTestManager.getTest().log(Status.INFO, "Purchase Product - Step 22: Click to 'Place Order' button");
        userSuccessCheckOutPage = userCheckOutPage.clickToPlaceOrderButton();


        ExtentTestManager.getTest().log(Status.INFO, "Purchase Product - Step 23: Verify the successfully purchase product message is displayed");
        verifyTrue(userSuccessCheckOutPage.isSuccessfullPurchaseMessageDisplayed());
    }

    @Test
    public void TC_12_Search_Product(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search Product");

        ExtentTestManager.getTest().log(Status.INFO, "Search Product - Step 01: Click to 'Advanced Search' link");
        userSuccessCheckOutPage.clickToFooterMenuLinkLiveGuruByMenuText(driver, "Advanced Search");
        userAdvancedSearchPage = PageGenerateManager.getUserAdvancedSearchPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Search Product - Step 02: Input 'Price' text box with value range: '0 - 150'");
        userAdvancedSearchPage.inputToSearchSettingTextboxById("price", "0");
        userAdvancedSearchPage.inputToSearchSettingTextboxById("price_to", "150");

        ExtentTestManager.getTest().log(Status.INFO, "Search Product - Step 03: Click to 'Search' button");
        userSearchResultPage = userAdvancedSearchPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Search Product - Step 04: Verify that the search result contains two items");
        verifyEquals(userSearchResultPage.getSearchResultSize(), 2);

        ExtentTestManager.getTest().log(Status.INFO, "Search Product - Step 05: Click to 'Advanced Search' link");
        userSearchResultPage.clickToFooterMenuLinkLiveGuruByMenuText(driver, "Advanced Search");
        userAdvancedSearchPage = PageGenerateManager.getUserAdvancedSearchPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Search Product - Step 06: Input 'Price' text box with value range: '151 - 1000'");
        userAdvancedSearchPage.inputToSearchSettingTextboxById("price", "151");
        userAdvancedSearchPage.inputToSearchSettingTextboxById("price_to", "1000");

        ExtentTestManager.getTest().log(Status.INFO, "Search Product - Step 07: Click to 'Search' button");
        userSearchResultPage = userAdvancedSearchPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Search Product - Step 08: Verify that the search result contains three items");
        verifyEquals(userSearchResultPage.getSearchResultSize(), 3);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }


}
