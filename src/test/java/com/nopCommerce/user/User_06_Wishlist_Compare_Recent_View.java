package com.user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import data.UserDataMapper;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import reportConfig.ExtentTestManager;
import ultilities.Environment;

import java.lang.reflect.Method;

public class User_06_Wishlist_Compare_Recent_View extends BaseTest {

    UserDataMapper userData;
    Environment env;
    UserHomePO userHomePage;
    UserRegisterPO userRegisterPage;
    UserProductPO userProductPage;
    UserProductDetailPO userProductDetailPage;
    UserWishlistPO userWishlistPage;
    UserCartPO userCartPage;
    UserComparePO userComparePage;
    UserRecentViewPO userRecentViewPage;
    private WebDriver driver;
    private String emailAddress, wishlistProductTitle, compareProductTitle1, compareProductTitle2, compareProductPrice1, compareProductPrice2;
    private String recentProductTitle1, recentProductTitle2, recentProductTitle3, recentProductTitle4, recentProductTitle5;

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
        wishlistProductTitle = "Asus N551JK-XO076H Laptop";
        compareProductTitle1 = "Apple MacBook Pro 13-inch";
        compareProductTitle2 = "Asus N551JK-XO076H Laptop";
        compareProductPrice1 = "$1,800.00";
        compareProductPrice2 = "$1,500.00";
        recentProductTitle1 = "Apple MacBook Pro 13-inch";
        recentProductTitle2 = "Asus N551JK-XO076H Laptop";
        recentProductTitle3 = "HP Envy 6-1180ca 15.6-Inch Sleekbook";
        recentProductTitle4 = "HP Spectre XT Pro UltraBook";
        recentProductTitle5 = "Lenovo Thinkpad X1 Carbon Laptop";

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
    public void TC_01_Wishlist(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add to wishlist");

        ExtentTestManager.getTest().log(Status.INFO, "Add To Wishlist - Step 01: Click to 'Desktops' link at Header Menu");
        userHomePage.clickToSubHeaderMenuByText(driver, "Computers", "Notebooks");
        userProductPage = PageGenerateManager.getUserProductPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Add To Wishlist - Step 02: Click the '" + wishlistProductTitle + "' title");
        userProductDetailPage = userProductPage.clickToProductTitleByText(wishlistProductTitle);

        ExtentTestManager.getTest().log(Status.INFO, "Add To Wishlist - Step 03: Click the 'Add to wishlist' button");
        userProductDetailPage.clickToProductDetailButtonByText("Add to wishlist");

        ExtentTestManager.getTest().log(Status.INFO, "Add To Wishlist - Step 04: Verify the add to wishlist success message is displayed");
        Assert.assertEquals(userProductDetailPage.getSuccessMessageText(driver), "The product has been added to your wishlist");

        ExtentTestManager.getTest().log(Status.INFO, "Add To Wishlist - Step 05: Close the success message");
        userProductDetailPage.clickToCloseMessageButton(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Add To Wishlist - Step 06: Click to 'Wishlist' link at header link");
        userProductDetailPage.clickToHeaderLinkByText(driver, "ico-wishlist");
        userWishlistPage = PageGenerateManager.getUserWishlistPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Add To Wishlist - Step 07: Verify the '" + wishlistProductTitle + "' title is displayed at Wishlist page");
        Assert.assertTrue(userWishlistPage.isWishlistProductDisplayed(wishlistProductTitle));
    }

    @Test
    public void TC_02_Add_To_Car_From_Wishlist(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add product to cart from wishlist page");

        ExtentTestManager.getTest().log(Status.INFO, "Add To Cart From Wishlist - Step 01: Click the 'Add to cart' checkbox");
        userWishlistPage.clickToAddToCartCheckbox();

        ExtentTestManager.getTest().log(Status.INFO, "Add To Cart From Wishlist - Step 02: Click the 'Add to cart' button");
        userCartPage = userWishlistPage.clickToAddToCartButton();

        ExtentTestManager.getTest().log(Status.INFO, "Add To Cart From Wishlist - Step 03: Verify the '" + wishlistProductTitle + "' title is displayed at Cart page");
        Assert.assertTrue(userCartPage.isCartProductDisplayed(wishlistProductTitle));

        ExtentTestManager.getTest().log(Status.INFO, "Add To Cart From Wishlist - Step 04: Click to 'Wishlist' link at header link");
        userCartPage.clickToHeaderLinkByText(driver, "ico-wishlist");
        userWishlistPage = PageGenerateManager.getUserWishlistPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Add To Cart From Wishlist - Step 05: Verify the '" + wishlistProductTitle + "' title is undisplayed at Wishlist page");
        Assert.assertTrue(userWishlistPage.isWishlistProductUnDisplayed(wishlistProductTitle));
    }

    @Test
    public void TC_03_Remove_Product_From_Wishlist(Method method) {
        ExtentTestManager.startTest(method.getName(), "Remove products from wishlist page");

        ExtentTestManager.getTest().log(Status.INFO, "Remove From Wishlist - Step 01: Click to 'Notebooks' link at Header Menu");
        userWishlistPage.clickToSubHeaderMenuByText(driver, "Computers", "Notebooks");
        userProductPage = PageGenerateManager.getUserProductPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Remove From Wishlist - Step 02: Click the '" + wishlistProductTitle + "' title");
        userProductDetailPage = userProductPage.clickToProductTitleByText(wishlistProductTitle);

        ExtentTestManager.getTest().log(Status.INFO, "Remove From Wishlist - Step 03: Click the 'Add to wishlist' button");
        userProductDetailPage.clickToProductDetailButtonByText("Add to wishlist");

        ExtentTestManager.getTest().log(Status.INFO, "Remove From Wishlist - Step 04: Verify the add to wishlist success message is displayed");
        Assert.assertEquals(userProductDetailPage.getSuccessMessageText(driver), "The product has been added to your wishlist");

        ExtentTestManager.getTest().log(Status.INFO, "Remove From Wishlist - Step 05: Close the success message");
        userProductDetailPage.clickToCloseMessageButton(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Remove From Wishlist - Step 06: Click to 'Wishlist' link at header link");
        userProductDetailPage.clickToHeaderLinkByText(driver, "ico-wishlist");
        userWishlistPage = PageGenerateManager.getUserWishlistPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Remove From Wishlist - Step 07: Verify the '" + wishlistProductTitle + "' title is displayed at Wishlist page");
        Assert.assertTrue(userWishlistPage.isWishlistProductDisplayed(wishlistProductTitle));

        ExtentTestManager.getTest().log(Status.INFO, "Remove From Wishlist - Step 07: Click the 'Remove' icon");
        userWishlistPage.clickRemoveIcon();

        ExtentTestManager.getTest().log(Status.INFO, "Remove From Wishlist  - Step 08: Verify the '" + wishlistProductTitle + "' title is undisplayed at Wishlist page");
        Assert.assertTrue(userWishlistPage.isWishlistProductUnDisplayed(wishlistProductTitle));

        ExtentTestManager.getTest().log(Status.INFO, "Remove From Wishlist - Step 09: Verify the wishlist page is empty");
        Assert.assertTrue(userWishlistPage.isEmptyWishlistMessageDisplayed());
    }

    @Test
    public void TC_04_Compare_Product(Method method) {
        ExtentTestManager.startTest(method.getName(), "Compare 2 products");

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 01: Click to 'Notebooks' link at Header Menu");
        userWishlistPage.clickToSubHeaderMenuByText(driver, "Computers", "Notebooks");
        userProductPage = PageGenerateManager.getUserProductPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 02: Click to Compare button at product named '" + compareProductTitle1 + "'");
        userProductPage.clickToButtonByProductTitle(compareProductTitle1, "add-to-compare-list-button");

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 03: Verify the add to compare success message is displayed");
        Assert.assertEquals(userProductPage.getSuccessMessageText(driver), "The product has been added to your product comparison");
        userProductPage.clickToCloseMessageButton(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 04: Click to Compare button at product named '" + compareProductTitle2 + "'");
        userProductPage.clickToButtonByProductTitle(compareProductTitle2, "add-to-compare-list-button");

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 05: Verify the add to compare success message is displayed");
        Assert.assertEquals(userProductPage.getSuccessMessageText(driver), "The product has been added to your product comparison");
        userProductPage.clickToCloseMessageButton(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 06: Click the 'Compare products list' link at footer menu");
        userCartPage.clickToFooterMenuLinkByMenuText(driver, "Compare products list");
        userComparePage = PageGenerateManager.getUserComparePage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 07: Verify the '" + compareProductTitle1 + "' is displayed at Compare page");
        Assert.assertTrue(userComparePage.isProductTitleDisplayedAtComparePage(compareProductTitle1));

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 08: Verify the '" + compareProductPrice1 + "' is displayed at Compare page");
        Assert.assertTrue(userComparePage.isProductPriceDisplayedAtComparePage(compareProductTitle1, compareProductPrice1));

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 09: Verify the '" + compareProductTitle2 + "' is displayed at Compare page");
        Assert.assertTrue(userComparePage.isProductTitleDisplayedAtComparePage(compareProductTitle2));

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 10: Verify the '" + compareProductPrice2 + "' is displayed at Compare page");
        Assert.assertTrue(userComparePage.isProductPriceDisplayedAtComparePage(compareProductTitle2, compareProductPrice2));

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 11: Click the 'Clear list' button");
        userComparePage.clickToClearListButton();

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 12: Verify the no data message is displayed");
        Assert.assertEquals(userComparePage.getNoDataMessageText(), "You have no items to compare.");

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 13: Verify the no products is displayed");
        Assert.assertEquals(userComparePage.getCompareProductSize(), 0);
    }

    @Test
    public void TC_05_Recent_View(Method method) {
        ExtentTestManager.startTest(method.getName(), "View 5 products and go to Recent View page to verify 5 products are displayed");

        ExtentTestManager.getTest().log(Status.INFO, "Recent View - Step 01: Click to 'Notebooks' link at Header Menu");
        userComparePage.clickToSubHeaderMenuByText(driver, "Computers", "Notebooks");
        userProductPage = PageGenerateManager.getUserProductPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Recent View - Step 02: Click the '" + recentProductTitle1 + "' title");
        userProductDetailPage = userProductPage.clickToProductTitleByText(recentProductTitle1);

        ExtentTestManager.getTest().log(Status.INFO, "Recent View - Step 03: Click to 'Notebooks' link at Header Menu");
        userProductDetailPage.clickToSubHeaderMenuByText(driver, "Computers", "Notebooks");
        userProductPage = PageGenerateManager.getUserProductPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Recent View - Step 04: Click the '" + recentProductTitle2 + "' title");
        userProductDetailPage = userProductPage.clickToProductTitleByText(recentProductTitle2);

        ExtentTestManager.getTest().log(Status.INFO, "Recent View - Step 05: Click to 'Notebooks' link at Header Menu");
        userProductDetailPage.clickToSubHeaderMenuByText(driver, "Computers", "Notebooks");
        userProductPage = PageGenerateManager.getUserProductPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Recent View - Step 06: Click the '" + recentProductTitle3 + "' title");
        userProductDetailPage = userProductPage.clickToProductTitleByText(recentProductTitle3);

        ExtentTestManager.getTest().log(Status.INFO, "Recent View - Step 07: Click to 'Notebooks' link at Header Menu");
        userProductDetailPage.clickToSubHeaderMenuByText(driver, "Computers", "Notebooks");
        userProductPage = PageGenerateManager.getUserProductPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Recent View - Step 08: Click the '" + recentProductTitle4 + "' title");
        userProductDetailPage = userProductPage.clickToProductTitleByText(recentProductTitle4);

        ExtentTestManager.getTest().log(Status.INFO, "Recent View - Step 09: Click to 'Notebooks' link at Header Menu");
        userProductDetailPage.clickToSubHeaderMenuByText(driver, "Computers", "Notebooks");
        userProductPage = PageGenerateManager.getUserProductPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Recent View - Step 10: Click the '" + recentProductTitle5 + "' title");
        userProductDetailPage = userProductPage.clickToProductTitleByText(recentProductTitle5);

        ExtentTestManager.getTest().log(Status.INFO, "Recent View - Step 11: Click the 'Recently viewed products' link at footer menu");
        userProductDetailPage.clickToFooterMenuLinkByMenuText(driver, "Recently viewed products");
        userRecentViewPage = PageGenerateManager.getUserRecentViewPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Recent View - Step 12: Verify the '" + recentProductTitle1 + "' is undisplayed");
        Assert.assertTrue(userRecentViewPage.isProductRecentUndisplayed(recentProductTitle1));

        ExtentTestManager.getTest().log(Status.INFO, "Recent View - Step 13: Verify the '" + recentProductTitle2 + "' is undisplayed");
        Assert.assertTrue(userRecentViewPage.isProductRecentUndisplayed(recentProductTitle2));

        ExtentTestManager.getTest().log(Status.INFO, "Recent View - Step 14: Verify the '" + recentProductTitle3 + "' is displayed");
        Assert.assertTrue(userRecentViewPage.isProductRecentDisplayed(recentProductTitle3));

        ExtentTestManager.getTest().log(Status.INFO, "Recent View - Step 15: Verify the '" + recentProductTitle4 + "' is displayed");
        Assert.assertTrue(userRecentViewPage.isProductRecentDisplayed(recentProductTitle4));

        ExtentTestManager.getTest().log(Status.INFO, "Recent View - Step 16: Verify the '" + recentProductTitle5 + "' is displayed");
        Assert.assertTrue(userRecentViewPage.isProductRecentDisplayed(recentProductTitle5));
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }

}
