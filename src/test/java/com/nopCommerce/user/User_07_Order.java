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

public class User_07_Order extends BaseTest {

    NopCommerceUserDataMapper userData;
    Environment env;
    UserHomePO userHomePage;
    UserRegisterPO userRegisterPage;
    UserProductPO userProductPage;
    UserProductDetailPO userProductDetailPage;
    UserCartPO userCartPage;
    private WebDriver driver;
    private String emailAddress, notebooksName, productCart, desktopRam, desktopHDD, desktopOs, desktopSoftware1, desktopSoftware2, desktopSoftware3, productPrice;
    private String editDesktopProcessor, editDesktopRam, editDesktopHDD, editDesktopOs;

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
        notebooksName = "Asus N551JK-XO076H Laptop";
        productCart = "Build your own computer";
        desktopRam = "8GB [+$60.00]";
        desktopHDD = "400 GB [+$100.00]";
        desktopOs = "Vista Premium [+$60.00]";
        desktopSoftware1 = "Microsoft Office [+$50.00]";
        desktopSoftware2 = "Acrobat Reader [+$10.00]";
        desktopSoftware3 = "Total Commander [+$5.00]";
        editDesktopProcessor = "2.2 GHz Intel Pentium Dual-Core E2200";
        editDesktopRam = "4GB [+$20.00]";
        editDesktopHDD = "320 GB";
        editDesktopOs = "Vista Home [+$50.00]";

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
    public void TC_01_Add_To_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add products to cart");

        ExtentTestManager.getTest().log(Status.INFO, "Add To Cart - Step 01: Click the 'Desktops' link at Header Menu");
        userHomePage.clickToSubHeaderMenuByText(driver, "Computers", "Desktops");
        userProductPage = PageGenerateManager.getUserProductPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Add To Cart - Step 02: Click the '" + productCart + "' title");
        userProductDetailPage = userProductPage.clickToProductTitleByText(productCart);

        ExtentTestManager.getTest().log(Status.INFO, "Add To Cart - Step 03: Select '" + desktopRam + "' option at 'Ram' dropdown");
        userProductDetailPage.selectItemAtDropdownbyText("product_attribute_2", desktopRam);

        ExtentTestManager.getTest().log(Status.INFO, "Add To Cart - Step 04: Select '" + desktopHDD + "' option at 'HDD' radio");
        userProductDetailPage.selectItemAtRadioCheckboxbyText(desktopHDD);

        ExtentTestManager.getTest().log(Status.INFO, "Add To Cart - Step 05: Select '" + desktopOs + "' option at 'OS' radio");
        userProductDetailPage.selectItemAtRadioCheckboxbyText(desktopOs);

        ExtentTestManager.getTest().log(Status.INFO, "Add To Cart - Step 06: Select '" + desktopSoftware1 + "' option at 'Software' radio");
        userProductDetailPage.selectItemAtRadioCheckboxbyText(desktopSoftware1);

        ExtentTestManager.getTest().log(Status.INFO, "Add To Cart - Step 07: Select '" + desktopSoftware2 + "' option at 'Software' radio");
        userProductDetailPage.selectItemAtRadioCheckboxbyText(desktopSoftware2);

        ExtentTestManager.getTest().log(Status.INFO, "Add To Cart - Step 08: Select '" + desktopSoftware3 + "' option at 'Software' radio");
        userProductDetailPage.selectItemAtRadioCheckboxbyText(desktopSoftware3);

        ExtentTestManager.getTest().log(Status.INFO, "Add To Cart - Step 09: Save the price text");
        productPrice = userProductDetailPage.getProductPriceText();

        ExtentTestManager.getTest().log(Status.INFO, "Add To Cart - Step 10: Click the 'Add to cart' button");
        userProductDetailPage.clickToAddToCartUpdateButton();
        userProductDetailPage.waitLoadingIconInvisible();

        ExtentTestManager.getTest().log(Status.INFO, "Add To Cart - Step 11: Verify the add to cart success message is displayed");
        Assert.assertEquals(userProductDetailPage.getSuccessMessageText(driver), "The product has been added to your shopping cart");

        ExtentTestManager.getTest().log(Status.INFO, "Add To Cart - Step 12: Close the success message");
        userProductDetailPage.clickToCloseMessageButton(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Add To Cart - Step 13: Hover to 'Shopping cart' link at header link");
        userProductDetailPage.hoverToAddToCartButton(driver, "ico-cart");

        ExtentTestManager.getTest().log(Status.INFO, "Add To Cart - Step 14: Verify the product's quantity at Mini Cart popup is 1 item");
        Assert.assertTrue(userProductDetailPage.getProductQuantityAtMiniCartText("1 item(s)"));

        ExtentTestManager.getTest().log(Status.INFO, "Add To Cart - Step 15: Verify the '" + productCart + "' is displayed at Mini Cart popup");
        Assert.assertTrue(userProductDetailPage.isProductCartTitleDisplayed(productCart));

        ExtentTestManager.getTest().log(Status.INFO, "Add To Cart - Step 16: Verify the attribute is displayed at Mini Cart popup");
        Assert.assertEquals(userProductDetailPage.isProductCartAttributeDisplayed(), "Processor: 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]"
                + "\nRAM: " + desktopRam
                + "\nHDD: " + desktopHDD
                + "\nOS: " + desktopOs
                + "\nSoftware: " + desktopSoftware1
                + "\nSoftware: " + desktopSoftware2
                + "\nSoftware: " + desktopSoftware3);

        ExtentTestManager.getTest().log(Status.INFO, "Add To Cart - Step 17: Verify the '" + productPrice + "' is displayed at Mini Cart popup");
        Assert.assertEquals(userProductDetailPage.getProductPriceAtMiniCart(), productPrice);
    }

    @Test
    public void TC_02_Edit_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), "Edit product in Shopping Cart");

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart - Step 01: Click the 'Shopping cart' link at Header link");
        userProductDetailPage.clickToHeaderLinkByText(driver, "ico-cart");
        userCartPage = PageGenerateManager.getUserCartPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart - Step 02: Click the 'Edit' link");
        userProductDetailPage = userCartPage.clickToEditLinkAtCartPage(productCart);

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart - Step 03: Select '" + editDesktopProcessor + "' option at 'Ram' dropdown");
        userProductDetailPage.selectItemAtDropdownbyText("product_attribute_1", editDesktopProcessor);

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart - Step 04: Select '" + editDesktopRam + "' option at 'Ram' dropdown");
        userProductDetailPage.selectItemAtDropdownbyText("product_attribute_2", editDesktopRam);

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart - Step 05: Select '" + editDesktopHDD + "' option at 'HDD' radio");
        userProductDetailPage.selectItemAtRadioCheckboxbyText(editDesktopHDD);

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart - Step 06: Select '" + editDesktopOs + "' option at 'OS' radio");
        userProductDetailPage.selectItemAtRadioCheckboxbyText(editDesktopOs);

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart - Step 07: Unselect '" + desktopSoftware2 + "' option at 'Software' radio");
        userProductDetailPage.unSelectItemAtRadioCheckboxbyText(desktopSoftware2);

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart- Step 08: Unselect '" + desktopSoftware3 + "' option at 'Software' radio");
        userProductDetailPage.unSelectItemAtRadioCheckboxbyText(desktopSoftware3);

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart - Step 09: Input '" + "2" + "' into 'Quantity' textbox");
        userProductDetailPage.inputToQuantityTextbox("2");

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart - Step 10: Verify the product price is changed");
        Assert.assertEquals(userProductDetailPage.getProductPriceText(), "$1,320.00");

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart - Step 11: Click the Update button");
        userProductDetailPage.clickToAddToCartUpdateButton();
        userProductDetailPage.waitLoadingIconInvisible();

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart - Step 12: Verify the add to cart success message is displayed");
        Assert.assertEquals(userProductDetailPage.getSuccessMessageText(driver), "The product has been added to your shopping cart");

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart - Step 13: Close the success message");
        userProductDetailPage.clickToCloseMessageButton(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart - Step 14: Hover to 'Shopping cart' link at header link");
        userProductDetailPage.hoverToAddToCartButton(driver, "ico-cart");

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart - Step 15: Verify the product's quantity at Mini Cart popup is 2 items");
        Assert.assertTrue(userProductDetailPage.getProductQuantityAtMiniCartText("2 item(s)"));

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart - Step 16: Verify the '" + productCart + "' is displayed at Mini Cart popup");
        Assert.assertTrue(userProductDetailPage.isProductCartTitleDisplayed(productCart));

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart - Step 17: Verify the attribute is displayed at Mini Cart popup");
        Assert.assertEquals(userProductDetailPage.isProductCartAttributeDisplayed(), "Processor: " + editDesktopProcessor
                + "\nRAM: " + editDesktopRam
                + "\nHDD: " + editDesktopHDD
                + "\nOS: " + editDesktopOs
                + "\nSoftware: " + desktopSoftware1);

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart - Step 18: Verify the '" + "$2,640.00" + "' is displayed at Mini Cart popup");
        Assert.assertEquals(userProductDetailPage.getProductPriceAtMiniCart(), "$2,640.00");
    }

    @Test
    public void TC_03_Remove_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), "Remove product from Shopping Cart");

        ExtentTestManager.getTest().log(Status.INFO, "Remove Cart - Step 01: Click the 'Shopping cart' link at Header link");
        userProductDetailPage.clickToHeaderLinkByText(driver, "ico-cart");
        userCartPage = PageGenerateManager.getUserCartPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Remove Cart - Step 02: Click the 'Remove' button");
        userCartPage.clickToRemoveButtonByProductName(productCart);

        ExtentTestManager.getTest().log(Status.INFO, "Remove Cart - Step 03: Verify the no data message is displayed");
        Assert.assertEquals(userCartPage.getNoDataMessageText(), "Your Shopping Cart is empty!");

        ExtentTestManager.getTest().log(Status.INFO, "Remove Cart - Step 04: Verify the no product is displayed");
        Assert.assertTrue(userCartPage.isCartProductUndisplayed(productCart));
    }


    @Test
    public void TC_04_Update_Shopping_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), "Update product's quantity at Shopping Cart");

        ExtentTestManager.getTest().log(Status.INFO, "Update Shopping Cart - Step 01: Click the 'Notebooks' link at Header Menu");
        userHomePage.clickToSubHeaderMenuByText(driver, "Computers", "Notebooks");
        userProductPage = PageGenerateManager.getUserProductPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Update Shopping Cart - Step 02: Click the 'Add to Cart' button at product named '" + notebooksName + "'");
        userProductPage.clickToButtonByProductTitle(notebooksName, "product-box-add-to-cart-button");

        ExtentTestManager.getTest().log(Status.INFO, "Update Shopping Cart  - Step 03: Verify the add to cart success message is displayed");
        Assert.assertEquals(userProductDetailPage.getSuccessMessageText(driver), "The product has been added to your shopping cart");

        ExtentTestManager.getTest().log(Status.INFO, "Update Shopping Cart  - Step 04: Close the success message");
        userProductDetailPage.clickToCloseMessageButton(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Update Shopping Cart  - Step 05: Click the 'Shopping cart' link at Header link");
        userProductDetailPage.clickToHeaderLinkByText(driver, "ico-cart");
        userCartPage = PageGenerateManager.getUserCartPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Update Shopping Cart  - Step 06: Input '5' into quantity text box");
        userCartPage.inputToQuantityTextboxByProductName(notebooksName, "5");

        ExtentTestManager.getTest().log(Status.INFO, "Update Shopping Cart  - Step 06: Click the 'Update shopping cart' button");
        userCartPage.clickToCartButtonByID("updatecart");

        ExtentTestManager.getTest().log(Status.INFO, "Update Shopping Cart  - Step 07: Verify the subtotal price is changed");
        Assert.assertEquals(userCartPage.getProductSubTotalByProductName(notebooksName), "$7,500.00");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }

}
