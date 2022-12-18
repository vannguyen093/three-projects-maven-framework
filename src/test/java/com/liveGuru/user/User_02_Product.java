package com.user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.*;
import reportConfig.ExtentTestManager;
import ultilities.DataHelper;
import ultilities.Environment;

import java.lang.reflect.Method;

public class User_02_Product extends BaseTest {
    private WebDriver driver;
    Environment env;
    DataHelper dataHelper;
    private String firstName, lastName, emailAddress, password;
    private String sonyPriceAtList, sonyPriceAtDetail;
    UserHomePageObject userHomePage;
    UserMobilePageObject userMobilePage;
    UserProductDetailPageObject userProductDetailPage;
    UserCartPageObject userCartPage;
    UserCompareWindowPageObject userCompareWindowPage;
    UserLoginPageObject userLoginPage;
    UserRegisterPageObject userRegisterPage;
    UserMyDashboardPageObject userMyDashboardPage;
    UserTVPageObject userTVPage;
    UserWishlistPageObject userWishlistPage;
    @Parameters({"browser", "evnName", "ipAddress", "portNumber", "osName", "osVersion"})
    @BeforeClass
    public void beforeClass(@Optional("firefox") String browserName, @Optional("local") String evnName, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
        String environmentName = System.getProperty("evn");
        ConfigFactory.setProperty("env", environmentName);
        env = ConfigFactory.create(Environment.class);

        driver = getBrowserDriver(browserName, env.userUrl(), evnName, osName, osVersion, ipAddress, portNumber);
        dataHelper = DataHelper.getDataHelper();

        userHomePage = PageGenerateManager.getUserHomePage(driver);

        firstName = dataHelper.getFirstName();
        lastName = dataHelper.getLastName();
        emailAddress = dataHelper.getEmail();
        password = dataHelper.getPassword();

        userHomePage.clickToFooterMenuLinkByMenuText(driver, "My Account");
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
    public void TC_05_Compare_Price(Method method) {
        ExtentTestManager.startTest(method.getName(), "Compare price at list mobile and detail mobile");

        ExtentTestManager.getTest().log(Status.INFO, "Compare Price - Step 01: Click to 'Mobile' link");
        userMyDashboardPage.clickToHeaderMenuLinkByMenuText(driver, "Mobile");
        userMobilePage = PageGenerateManager.getUserMobilePage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Compare Price - Step 02: Get price of Sony Xperia at Mobile Page");
        sonyPriceAtList = userMobilePage.getProductPriceByProductTextAtMobilePage("Sony Xperia");

        ExtentTestManager.getTest().log(Status.INFO, "Compare Price - Step 03: Click to Sony Image");
        userProductDetailPage = userMobilePage.clickToImgByProductText("Sony Xperia");

        ExtentTestManager.getTest().log(Status.INFO, "Compare Price - Step 04: Get price of Sony Xperia at Product Detail Page");
        sonyPriceAtDetail = userProductDetailPage.getProductPriceAtProductDetailPage();

        ExtentTestManager.getTest().log(Status.INFO, "Compare Price - Step 05: Verify price of Sony Xperia at Mobile Page and Product Detail Page are equals");
        verifyEquals(sonyPriceAtList, sonyPriceAtDetail);
    }

    @Test
    public void TC_06_Verify_Discount_Coupon(Method method) {
        ExtentTestManager.startTest(method.getName(), "Verify discount coupon works correctly");

        ExtentTestManager.getTest().log(Status.INFO, "Verify Discount Coupon - Step 01: Click to 'Mobile' link");
        userProductDetailPage.clickToHeaderMenuLinkByMenuText(driver, "Mobile");
        userMobilePage = PageGenerateManager.getUserMobilePage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Verify Discount Coupon - Step 02: Click to 'Add To Cart' button");
        userCartPage = userMobilePage.clickToAddToCartButtonByProductName("Sony Xperia");

        ExtentTestManager.getTest().log(Status.INFO, "Verify Discount Coupon - Step 03: Verify the added successful message is displayed");
        verifyEquals(userCartPage.getCartMessage(),"Sony Xperia was added to your shopping cart.");

        ExtentTestManager.getTest().log(Status.INFO, "Verify Discount Coupon - Step 04: Input to 'Discount Codes' text box with value 'GURU50'");
        userCartPage.inputToDiscountCodeTextBox("GURU50");

        ExtentTestManager.getTest().log(Status.INFO, "Verify Discount Coupon - Step 05: Verify the discount added successful text is displayed");
        verifyEquals(userCartPage.getAddedDiscountText(),"-$5.00");

        ExtentTestManager.getTest().log(Status.INFO, "Verify Discount Coupon - Step 06: Verify the 'Grand Total' is change correct when added the coupon code");
        verifyEquals(userCartPage.getGrandTotalText(), "$95.00");

        ExtentTestManager.getTest().log(Status.INFO, "Verify Discount Coupon - Step 06: Click to 'Remove item' icon");
        userCartPage.clickToRemoveItemIcon();
    }

    @Test
    public void TC_07_Verify_Quantity_Item_In_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), "Verify that cannot add more 500 items of product");

        ExtentTestManager.getTest().log(Status.INFO, "Verify Quantity Item - Step 01: Click to 'Mobile' link");
        userCartPage.clickToHeaderMenuLinkByMenuText(driver, "Mobile");
        userMobilePage = PageGenerateManager.getUserMobilePage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Verify Discount Coupon - Step 02: Click to 'Add To Cart' button");
        userCartPage = userMobilePage.clickToAddToCartButtonByProductName("Sony Xperia");

        ExtentTestManager.getTest().log(Status.INFO, "Verify Discount Coupon - Step 03: Input to 'QTY' text box with value '501'");
        userCartPage.inputToQuantityTextBox("501");

        ExtentTestManager.getTest().log(Status.INFO, "Verify Discount Coupon - Step 04: Click to 'Update' button");
        userCartPage.clickToButtonAtAdminSiteByButtonTitle("Update");

        ExtentTestManager.getTest().log(Status.INFO, "Verify Discount Coupon - Step 05: Verify the error message is displayed");
        verifyEquals(userCartPage.getCartMessage(),"Some of the products cannot be ordered in requested quantity.");

        ExtentTestManager.getTest().log(Status.INFO, "Verify Discount Coupon - Step 06: Verify the error message of product's quantity is displayed");
        verifyEquals(userCartPage.getProductQtyErrMessage(),"* The maximum quantity allowed for purchase is 500.");

        ExtentTestManager.getTest().log(Status.INFO, "Verify Discount Coupon - Step 07: Click to 'Empty Cart' button");
        userCartPage.clickToButtonAtAdminSiteByButtonTitle("Empty Cart");

        ExtentTestManager.getTest().log(Status.INFO, "Verify Discount Coupon - Step 08: Verify empty cart header is displayed");
        verifyTrue(userCartPage.isEmptyCartHeaderDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Verify Discount Coupon - Step 09: Verify no items in cart");
        verifyTrue(userCartPage.isNoItemMessageDisplayed());
    }

    @Test
    public void TC_08_Compare_Two_Product(Method method) {
        ExtentTestManager.startTest(method.getName(), "Compare two products");

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 01: Click to 'Mobile' link");
        userCartPage.clickToHeaderMenuLinkByMenuText(driver, "Mobile");
        userMobilePage = PageGenerateManager.getUserMobilePage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 02: Click to 'Add To Compare' link of 'Sony Xperia'");
        userMobilePage.clickToAddToCompareLinkByProdName("Sony Xperia");

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 03: Verify 'Sony Xperia' has been added to comparison list");
        verifyEquals(userMobilePage.getProductAddedCompareMessage(), "The product Sony Xperia has been added to comparison list.");

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 04: Click to 'Add To Compare' link of 'iPhone'");
        userMobilePage.clickToAddToCompareLinkByProdName("IPhone");

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 05: Verify 'iPhone' has been added to comparison list");
        verifyEquals(userMobilePage.getProductAddedCompareMessage(), "The product IPhone has been added to comparison list.");

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 06: Click to 'Compare' button");
        userCompareWindowPage = userMobilePage.clickToCompareButton();

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 07: Verify the pop-up window with header 'Compare Products' is displayed");
        verifyTrue(userCompareWindowPage.isCompareWindowHeaderDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 08: Verify all infos of 'Sony Xperia' is displayed");
        verifyTrue(userCompareWindowPage.isProductTitleDisplayed("Sony Xperia"));
        verifyTrue(userCompareWindowPage.isProductImageDisplayed("Sony Xperia", "xperia.jpg"));
        verifyTrue(userCompareWindowPage.isProductPriceDisplayed("Sony Xperia"));
        verifyTrue(userCompareWindowPage.isProductSKUDisplayed("MOB001"));

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 09: Verify all infos of 'iPhone' is displayed");
        verifyTrue(userCompareWindowPage.isProductTitleDisplayed("IPhone"));
        verifyTrue(userCompareWindowPage.isProductImageDisplayed("IPhone", "iphone.png"));
        verifyTrue(userCompareWindowPage.isProductPriceDisplayed("IPhone"));
        verifyTrue(userCompareWindowPage.isProductSKUDisplayed("MOB0002"));

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 10: Close the popup window");
        userMobilePage = userCompareWindowPage.closeCompareWindow();
    }

    @Test
    public void TC_09_Add_To_Wishlist(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add to wishlist");

        ExtentTestManager.getTest().log(Status.INFO, "Add To Wishlist - Step 01: Click to 'TV' link");
        userMobilePage.clickToHeaderMenuLinkByMenuText(driver, "TV");
        userTVPage = PageGenerateManager.getUserTVPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Add To Wishlist - Step 02: Click to 'Add to Wishlist' link at product named 'LG LCD'");
        userWishlistPage = userTVPage.clickToAddToWishlistByProductName("LG LCD");

        ExtentTestManager.getTest().log(Status.INFO, "Add To Wishlist - Step 03: Verify successfully added to wishlist message is displayed");
        verifyTrue(userWishlistPage.isSuccessfullyAddedToWishlistDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Add To Wishlist - Step 04: Verify in Wishlist page have only 1 item");
        verifyEquals(userWishlistPage.getWishlistTableSize(), 1);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }


}
