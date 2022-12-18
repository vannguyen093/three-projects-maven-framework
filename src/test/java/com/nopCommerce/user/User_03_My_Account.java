package com.nopCommerce.user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import data.nopCommerce.NopCommerceUserDataMapper;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.nopCommerce.*;
import reportConfig.ExtentTestManager;
import ultilities.Environment;

import java.lang.reflect.Method;

public class User_03_My_Account extends BaseTest {

    NopCommerceUserDataMapper userData;
    Environment env;
    UserHomePO userHomePage;
    UserLoginPO userLoginPage;
    UserRegisterPO userRegisterPage;
    UserCustomerInfoPO userCustomerInfoPage;
    UserAddressesPO userAddressesPage;
    UserChangePassPO userChangePassPage;
    UserProductPO userProductPage;
    UserProductDetailPO userProductDetailPage;
    UserProductReviewPO userProductReviewPage;
    UserMyProductReviewsPO userMyProductReviewsPage;
    private WebDriver driver;
    private String emailAddress, addressessEmailAddress, reviewTitle, reviewText;

    @Parameters({"browser", "evnName", "ipAddress", "portNumber", "osName", "osVersion"})
    @BeforeClass
    public void beforeClass(@Optional("firefox") String browserName, @Optional("local") String evnName, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
        String environmentName = System.getProperty("evn");
        ConfigFactory.setProperty("env", environmentName);
        env = ConfigFactory.create(Environment.class);

        driver = getBrowserDriver(browserName, env.userNopCommerceUrl(), evnName, osName, osVersion, ipAddress, portNumber);
        userData = NopCommerceUserDataMapper.getUserData();

        userHomePage = PageGenerateManager.getUserHomePage(driver);

        emailAddress = userData.getEditEmail() + generateFakeNumber() + "@gmail.com";
        addressessEmailAddress = userData.getAddressEmail() + generateFakeNumber() + "@gmail.com";
        reviewTitle = "My Review Title " + generateFakeNumber();
        reviewText = "My Review Text " + generateFakeNumber();

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
    public void TC_01_Update_Info(Method method) {
        ExtentTestManager.startTest(method.getName(), "Update Info");

        ExtentTestManager.getTest().log(Status.INFO, "Update Info - Step 01: Click to 'My account' link");
        userHomePage.clickToHeaderLinkByText(driver, "ico-account");
        userCustomerInfoPage = PageGenerateManager.getUserCustomerInfoPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Update Info - Step 02: Select '" + userData.getEditGender() + "' at the 'Gender' radio");
        userCustomerInfoPage.selectGenderRadioByText(userData.getEditGender());

        ExtentTestManager.getTest().log(Status.INFO, "Update Info - Step 03: Input '" + userData.getEditFirstName() + "' into the 'First Name' text box");
        userCustomerInfoPage.inputToRegisterTextboxByTextboxID("FirstName", userData.getEditFirstName());

        ExtentTestManager.getTest().log(Status.INFO, "Update Info - Step 04: Input '" + userData.getEditLastName() + "' into the 'Last Name' text box");
        userCustomerInfoPage.inputToRegisterTextboxByTextboxID("LastName", userData.getEditLastName());

        ExtentTestManager.getTest().log(Status.INFO, "Update Info- Step 05: Select '" + userData.getEditDate() + "' in the 'Date' dropbox");
        userCustomerInfoPage.selectItemInDOBDropbox("DateOfBirthDay", userData.getEditDate());

        ExtentTestManager.getTest().log(Status.INFO, "Update Info - Step 06: Select '" + userData.getEditMonth() + "' in the 'Month' dropbox");
        userCustomerInfoPage.selectItemInDOBDropbox("DateOfBirthMonth", userData.getEditMonth());

        ExtentTestManager.getTest().log(Status.INFO, "Update Info - Step 07: Select '" + userData.getEditYear() + "' in the 'Year' dropbox");
        userCustomerInfoPage.selectItemInDOBDropbox("DateOfBirthYear", userData.getEditYear());

        ExtentTestManager.getTest().log(Status.INFO, "Update Info - Step 08: Input '" + emailAddress + "' into the 'Email' text box");
        userCustomerInfoPage.inputToRegisterTextboxByTextboxID("Email", emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Update Info - Step 09: Click the 'Save' button");
        userCustomerInfoPage.clickToSaveButton();

        ExtentTestManager.getTest().log(Status.INFO, "Update Info - Step 10: Verify the 'Gender' edit correctly with value '" + userData.getEditGender() + "'");
        Assert.assertTrue(userCustomerInfoPage.isGenderSelectedByRadioText("Female"));

        ExtentTestManager.getTest().log(Status.INFO, "Update Info - Step 11: Verify the 'First Name' edit correctly with value '" + userData.getEditFirstName() + "'");
        Assert.assertEquals(userCustomerInfoPage.getCustomerInfoTextboxAttribute("FirstName"), userData.getEditFirstName());

        ExtentTestManager.getTest().log(Status.INFO, "Update Info - Step 12: Verify the 'Last Name' edit correctly with value '" + userData.getEditLastName() + "'");
        Assert.assertEquals(userCustomerInfoPage.getCustomerInfoTextboxAttribute("LastName"), userData.getEditLastName());

        ExtentTestManager.getTest().log(Status.INFO, "Update Info - Step 13: Verify the 'Date' edit correctly with value '" + userData.getEditDate() + "'");
        Assert.assertEquals(userCustomerInfoPage.getCustomerInfoDropdownAttribute("DateOfBirthDay"), userData.getEditDate());

        ExtentTestManager.getTest().log(Status.INFO, "Update Info - Step 14: Verify the 'Month' edit correctly with value '" + userData.getEditMonth() + "'");
        Assert.assertEquals(userCustomerInfoPage.getEditMonthAttribute("DateOfBirthMonth"), userData.getEditMonth());

        ExtentTestManager.getTest().log(Status.INFO, "Update Info - Step 15: Verify the 'Year' edit correctly with value '" + userData.getEditYear() + "'");
        Assert.assertEquals(userCustomerInfoPage.getCustomerInfoDropdownAttribute("DateOfBirthYear"), userData.getEditYear());

        ExtentTestManager.getTest().log(Status.INFO, "Update Info - Step 16: Verify the 'Email' edit correctly with value '" + emailAddress + "'");
        Assert.assertEquals(userCustomerInfoPage.getCustomerInfoTextboxAttribute("Email"), emailAddress);
    }

    @Test
    public void TC_02_Add_Address(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Address");

        ExtentTestManager.getTest().log(Status.INFO, "Add Address - Step 01: Click to 'Addresses' link at sidebar menu");
        userCustomerInfoPage.clickToMenuLinkAtSidebarMenuByMenuText(driver, "Addresses");
        userAddressesPage = PageGenerateManager.getUserAddressesPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Add Address - Step 02: Click to 'Add New' button");
        userAddressesPage.clickToButtonByButtonText("Add new");

        ExtentTestManager.getTest().log(Status.INFO, "Add Address - Step 03: Input '" + userData.getAddressFirstName() + "' into 'First Name' text box");
        userAddressesPage.inputToAddressesTextboxByTextboxId("FirstName", userData.getAddressFirstName());

        ExtentTestManager.getTest().log(Status.INFO, "Add Address - Step 04: Input '" + userData.getAddressLastName() + "' into 'Last Name' text box");
        userAddressesPage.inputToAddressesTextboxByTextboxId("LastName", userData.getAddressLastName());

        ExtentTestManager.getTest().log(Status.INFO, "Add Address - Step 05: Input '" + addressessEmailAddress + "' into 'Email' text box");
        userAddressesPage.inputToAddressesTextboxByTextboxId("Email", addressessEmailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Add Address - Step 06: Input '" + userData.getAddressCompany() + "' into 'Company' text box");
        userAddressesPage.inputToAddressesTextboxByTextboxId("Company", userData.getAddressCompany());

        ExtentTestManager.getTest().log(Status.INFO, "Add Address - Step 07: Select '" + userData.getAddressCountry() + "' in 'Country' dropbox");
        userAddressesPage.selectItemInDropboxByDropboxId("CountryId", userData.getAddressCountry());

        ExtentTestManager.getTest().log(Status.INFO, "Add Address - Step 08: Select '" + userData.getAddressState() + "' in 'State' dropbox");
        userAddressesPage.selectItemInDropboxByDropboxId("StateProvinceId", userData.getAddressState());

        ExtentTestManager.getTest().log(Status.INFO, "Add Address - Step 09: Input '" + userData.getAddressCity() + "' into 'City' text box");
        userAddressesPage.inputToAddressesTextboxByTextboxId("City", userData.getAddressCity());

        ExtentTestManager.getTest().log(Status.INFO, "Add Address - Step 10: Input '" + userData.getAddressStreet() + "' into 'Address 1' text box");
        userAddressesPage.inputToAddressesTextboxByTextboxId("Address1", userData.getAddressStreet());

        ExtentTestManager.getTest().log(Status.INFO, "Add Address - Step 11: Input '" + userData.getAddressZip() + "' into 'Zip/ Postal Code' text box");
        userAddressesPage.inputToAddressesTextboxByTextboxId("ZipPostalCode", userData.getAddressZip());

        ExtentTestManager.getTest().log(Status.INFO, "Add Address - Step 12: Input '" + userData.getAddressPhone() + "' into 'Phone number' text box");
        userAddressesPage.inputToAddressesTextboxByTextboxId("PhoneNumber", userData.getAddressPhone());

        ExtentTestManager.getTest().log(Status.INFO, "Add Address - Step 13: Click the 'Save' button");
        userAddressesPage.clickToButtonByButtonText("Save");

        ExtentTestManager.getTest().log(Status.INFO, "Add Address - Step 14: Verify the info in the 'Full Name' row containing '" + userData.getAddressFirstName() + " " + userData.getAddressLastName() + "'");
        Assert.assertEquals(userAddressesPage.getAddressesTextByClass("name"), userData.getAddressFirstName() + " " + userData.getAddressLastName());

        ExtentTestManager.getTest().log(Status.INFO, "Add Address - Step 15: Verify the info in the 'Email' row containing '" + addressessEmailAddress + "'");
        Assert.assertEquals(userAddressesPage.getAddressesTextByClass("email"), "Email: " + addressessEmailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Add Address - Step 16: Verify the info in the 'Company' row containing '" + userData.getAddressCompany() + "'");
        Assert.assertEquals(userAddressesPage.getAddressesTextByClass("company"), userData.getAddressCompany());

        ExtentTestManager.getTest().log(Status.INFO, "Add Address - Step 17: Verify the info in the 'Phone number' row containing '" + userData.getAddressPhone() + "'");
        Assert.assertEquals(userAddressesPage.getAddressesTextByClass("phone"), "Phone number: " + userData.getAddressPhone());

        ExtentTestManager.getTest().log(Status.INFO, "Add Address - Step 18: Verify the info in the 'Address 1' row containing '" + userData.getAddressStreet() + "'");
        Assert.assertEquals(userAddressesPage.getAddressesTextByClass("address1"), userData.getAddressStreet());

        ExtentTestManager.getTest().log(Status.INFO, "Add Address - Step 19: Verify the info in the 'City' row containing '" + userData.getAddressCity() + ", " + userData.getAddressState() + ", " + userData.getAddressZip() + "'");
        Assert.assertEquals(userAddressesPage.getAddressesTextByClass("city-state-zip"), userData.getAddressCity() + ", " + userData.getAddressState() + ", " + userData.getAddressZip());

        ExtentTestManager.getTest().log(Status.INFO, "Add Address - Step 20: Verify the info in the 'Country' row containing '" + userData.getAddressCountry() + "'");
        Assert.assertEquals(userAddressesPage.getAddressesTextByClass("country"), userData.getAddressCountry());

        ExtentTestManager.getTest().log(Status.INFO, "Add Address - Step 21: Click the 'Log out' link");
        userAddressesPage.clickToHeaderLinkByText(driver, "ico-logout");
        userHomePage = PageGenerateManager.getUserHomePage(driver);
    }

    @Test
    public void TC_03_Change_Password(Method method) {
        ExtentTestManager.startTest(method.getName(), "Change Password");

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 01: Click to 'Log in' link");
        userHomePage.clickToHeaderLinkByText(driver, "ico-login");
        userLoginPage = PageGenerateManager.getUserLoginPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Change Password- Step 02: Input '" + emailAddress + "' into the 'Email' text box");
        userLoginPage.inputToLoginTextboxByTextboxId("Email", emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 03: Input '" + userData.getPassword() + "' into the 'Password' text box");
        userLoginPage.inputToLoginTextboxByTextboxId("Password", userData.getPassword());

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 04: Click to 'Login' button");
        userLoginPage.clickToButtonByButtonText("Log in");
        userHomePage = PageGenerateManager.getUserHomePage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 05: Click to 'My account' link");
        userHomePage.clickToHeaderLinkByText(driver, "ico-account");
        userCustomerInfoPage = PageGenerateManager.getUserCustomerInfoPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 06: Click to 'Change password' link at sidebar menu");
        userCustomerInfoPage.clickToMenuLinkAtSidebarMenuByMenuText(driver, "Change password");
        userChangePassPage = PageGenerateManager.getUserChangePassPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Change Password  - Step 07: Input '" + userData.getPassword() + "' into 'Old Password' text box");
        userChangePassPage.inputToChangePassTextboxByTextboxId("OldPassword", userData.getPassword());

        ExtentTestManager.getTest().log(Status.INFO, "Change Password  - Step 08: Input '" + userData.getEditPassword() + "' into 'New Password' text box");
        userChangePassPage.inputToChangePassTextboxByTextboxId("NewPassword", userData.getEditPassword());

        ExtentTestManager.getTest().log(Status.INFO, "Change Password  - Step 09: Input '" + userData.getEditPassword() + "' into 'Confirm Password' text box");
        userChangePassPage.inputToChangePassTextboxByTextboxId("ConfirmNewPassword", userData.getEditPassword());

        ExtentTestManager.getTest().log(Status.INFO, "Change Password  - Step 10: Click the 'Change password' button");
        userChangePassPage.clickToChangePassButton();

        ExtentTestManager.getTest().log(Status.INFO, "Change Password  - Step 11: Verify the change password successful is displayed");
        Assert.assertEquals(userChangePassPage.getSuccessMessageText(driver), "Password was changed");

        ExtentTestManager.getTest().log(Status.INFO, "Change Password  - Step 12: Click the 'Close' button at success message row");
        userChangePassPage.clickToCloseMessageButton(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 13: Click the 'Log out' link");
        userChangePassPage.clickToHeaderLinkByText(driver, "ico-logout");
        userHomePage = PageGenerateManager.getUserHomePage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 14: Click to 'Login' link");
        userHomePage.clickToHeaderLinkByText(driver, "ico-login");
        userLoginPage = PageGenerateManager.getUserLoginPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 15: Input '" + emailAddress + "' into the 'Email' text box");
        userLoginPage.inputToLoginTextboxByTextboxId("Email", emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 16: Input the old password '" + userData.getPassword() + "' into the 'Password' text box");
        userLoginPage.inputToLoginTextboxByTextboxId("Password", userData.getPassword());

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 17: Click to 'Login' button");
        userLoginPage.clickToButtonByButtonText("Log in");

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 18: Verify that the error message is displayed");
        Assert.assertEquals(userLoginPage.getUnsuccessfulErrorMessageText(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 19: Click to 'Login' link");
        userLoginPage.clickToHeaderLinkByText(driver, "ico-login");

        ExtentTestManager.getTest().log(Status.INFO, "Change Password- Step 20: Input '" + emailAddress + "' into the 'Email' text box");
        userLoginPage.inputToLoginTextboxByTextboxId("Email", emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 21: Input the new password '" + userData.getEditPassword() + "' into the 'Password' text box");
        userLoginPage.inputToLoginTextboxByTextboxId("Password", userData.getEditPassword());

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 22: Click to 'Login' button");
        userLoginPage.clickToButtonByButtonText("Log in");
        userHomePage = PageGenerateManager.getUserHomePage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 23: Verify that the homepage title is displayed");
        Assert.assertEquals(userHomePage.getHomePageTitle(), "Welcome to our store");
    }

    @Test
    public void TC_04_Produc_review(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add a prodcut review and verify it displayed at My Account Review");

        ExtentTestManager.getTest().log(Status.INFO, "Product Review - Step 01: Click to 'Desktops' sub-menu at header menu");
        userHomePage.clickToSubHeaderMenuByText(driver, "Computers", "Desktops");
        userProductPage = PageGenerateManager.getUserProductPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Product Review - Step 02: Click to Product title named 'Build your own computer'");
        userProductDetailPage = userProductPage.clickToProductTitleByText("Build your own computer");

        ExtentTestManager.getTest().log(Status.INFO, "Product Review - Step 03: Verify that Product Detail title named containing 'Build your own computer'");
        Assert.assertEquals(userProductDetailPage.getProductTitleText(), "Build your own computer");

        ExtentTestManager.getTest().log(Status.INFO, "Product Review - Step 04: Click to Product title named 'Build your own computer'");
        userProductReviewPage = userProductDetailPage.clickToAddReviewLink();

        ExtentTestManager.getTest().log(Status.INFO, "Product Review - Step 05: Input '" + reviewTitle + "' into 'Review Title' text box");
        userProductReviewPage.inputToReviewTextboxByTextboxId("input", "AddProductReview_Title", reviewTitle);

        ExtentTestManager.getTest().log(Status.INFO, "Product Review - Step 06: Input '" + reviewText + "' into 'Review Title' text box");
        userProductReviewPage.inputToReviewTextboxByTextboxId("textarea", "AddProductReview_ReviewText", reviewText);

        ExtentTestManager.getTest().log(Status.INFO, "Product Review - Step 07: Click the 'Submit Review' button");
        userProductReviewPage.clickToSubmitReviewButton();

        ExtentTestManager.getTest().log(Status.INFO, "Product Review - Step 08: Verify the successful message is displayed");
        Assert.assertEquals(userProductReviewPage.getSuccessMessageText(), "Product review is successfully added.");

        ExtentTestManager.getTest().log(Status.INFO, "Product Review - Step 09: Click to 'My account' link");
        userProductReviewPage.clickToHeaderLinkByText(driver, "ico-account");
        userCustomerInfoPage = PageGenerateManager.getUserCustomerInfoPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 10: Click to 'My product reviews' link at sidebar menu");
        userCustomerInfoPage.clickToMenuLinkAtSidebarMenuByMenuText(driver, "My product reviews");
        userMyProductReviewsPage = PageGenerateManager.getUserMyProductReviewsPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 10: Verify the title in the 'My product reviews' containing '" + reviewTitle + "'");
        Assert.assertTrue(userMyProductReviewsPage.isProductReviewTitleDisplayed(reviewTitle));
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }

}
