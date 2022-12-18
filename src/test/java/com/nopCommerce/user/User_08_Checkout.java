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

public class User_08_Checkout extends BaseTest {

    UserDataMapper userData;
    Environment env;
    UserHomePO userHomePage;
    UserRegisterPO userRegisterPage;
    UserProductPO userProductPage;
    UserCartPO userCartPage;
    UserCheckOutPO userCheckOutPage;
    UserCustomerInfoPO userCustomerInfoPage;
    UserOrdersPO userOrdersPage;
    UserOrdersDetailPO userOrdersDetailPage;
    private WebDriver driver;
    private String emailAddress, notebooksName, estimateCountry, estimateState, estimateZip, totalPrice, orderNumber;
    private String firstName, lastName, country, state, city, addressStreet, zipCode, phoneNumber, paymentMethod, shippingMethod;

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
        notebooksName = "Asus N551JK-XO076H Laptop";
        estimateCountry = "United States";
        estimateState = "Alaska";
        estimateZip = "23454";
        firstName = userData.getAddressFirstName();
        lastName = userData.getAddressLastName();
        country = userData.getAddressCountry();
        state = userData.getAddressState();
        city = userData.getAddressCity();
        zipCode = userData.getAddressZip();
        addressStreet = userData.getAddressStreet();
        phoneNumber = userData.getAddressPhone();
        shippingMethod = "Ground";
        paymentMethod = "Check / Money Order";

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
    public void TC_01_Checkout(Method method) {
        ExtentTestManager.startTest(method.getName(), "Checkout");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 01: Click the 'Notebooks' link at Header Menu");
        userHomePage.clickToSubHeaderMenuByText(driver, "Computers", "Notebooks");
        userProductPage = PageGenerateManager.getUserProductPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 02: Click the 'Add to Cart' button at product named '" + notebooksName + "'");
        userProductPage.clickToButtonByProductTitle(notebooksName, "product-box-add-to-cart-button");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 03: Verify the add to cart success message is displayed");
        userProductPage.waitLoadingIconInvisible(driver);
        Assert.assertEquals(userProductPage.getSuccessMessageText(driver), "The product has been added to your shopping cart");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 04: Close the success message");
        userProductPage.clickToCloseMessageButton(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 05: Click the 'Shopping cart' link at Header link");
        userProductPage.clickToHeaderLinkByText(driver, "ico-cart");
        userCartPage = PageGenerateManager.getUserCartPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 06: Click the 'Estimate shipping' button");
        userCartPage.clickToEstimateShippingButton();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 07: Select the '" + estimateCountry + "' at 'Country' dropdown");
        userCartPage.selectItemAtEstimateDropdownById("CountryId", estimateCountry);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout  - Step 08: Select the '" + estimateState + "' at 'Country' dropdown");
        userCartPage.selectItemAtEstimateDropdownById("StateProvinceId", estimateState);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 09: Input the '" + estimateZip + "' in 'Zip' text box");
        userCartPage.inputToEstimateZipTextbox(estimateZip);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 10: Click the 'Apply' button");
        userCartPage.clickToEstimateApplyButton();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 11: Save the 'Total' price with value ");
        totalPrice = userCartPage.getTotalPriceText();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 12: Check the 'Term' checkbox");
        userCartPage.checkToTermCheckbox();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 13: Click the 'Checkout' button");
        userCartPage.clickToCartButtonByID("checkout");
        userCheckOutPage = PageGenerateManager.getUserCheckOutPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 14: Uncheck the 'Ship to the same address' checkbox");
        userCheckOutPage.unCheckToSameAddressCheckbox();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 15: Input the '" + firstName + "' in 'First Name' text box at Billing Address tab");
        userCheckOutPage.inputToCheckoutTextboxByTextboxId("BillingNewAddress_FirstName", firstName);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 16: Input the '" + lastName + "' in 'Last Name' text box at Billing Address tab");
        userCheckOutPage.inputToCheckoutTextboxByTextboxId("BillingNewAddress_LastName", lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 17: Input the '" + emailAddress + "' in 'Email' text box at Billing Address tab");
        userCheckOutPage.inputToCheckoutTextboxByTextboxId("BillingNewAddress_Email", emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 18: Select the '" + country + "' option in 'Country' dropdown at Billing Address tab");
        userCheckOutPage.selectItemAtDropDownByDropdownId("BillingNewAddress_CountryId", country);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 19: Select the '" + state + "' option in 'State' dropdown at Billing Address tab");
        userCheckOutPage.selectItemAtDropDownByDropdownId("BillingNewAddress_StateProvinceId", state);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 20: Input the '" + city + "' in 'City' text box at Billing Address tab");
        userCheckOutPage.inputToCheckoutTextboxByTextboxId("BillingNewAddress_City", city);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 21: Input the '" + addressStreet + "' in 'Address 1' text box at Billing Address tab");
        userCheckOutPage.inputToCheckoutTextboxByTextboxId("BillingNewAddress_Address1", addressStreet);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 22: Input the '" + zipCode + "' in 'Zip/ Postal Code' text box at Billing Address tab");
        userCheckOutPage.inputToCheckoutTextboxByTextboxId("BillingNewAddress_ZipPostalCode", zipCode);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 23: Input the '" + phoneNumber + "' in 'Phone Number' text box at Billing Address tab");
        userCheckOutPage.inputToCheckoutTextboxByTextboxId("BillingNewAddress_PhoneNumber", phoneNumber);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 24: Click the 'Continue' button at Billing Address tab");
        userCheckOutPage.clickCheckOutButtonByName("Billing");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 25: Select the '" + "New Address" + "' option in 'Select a shipping address' dropdown at Shipping Address tab");
        userCheckOutPage.selectItemAtDropDownByDropdownId("shipping-address-select", "New Address");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 26: Input the '" + firstName + "' in 'First Name' text box at Shipping Address tab");
        userCheckOutPage.inputToCheckoutTextboxByTextboxId("ShippingNewAddress_FirstName", firstName);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 27: Input the '" + lastName + "' in 'Last Name' text box at Shipping Address tab");
        userCheckOutPage.inputToCheckoutTextboxByTextboxId("ShippingNewAddress_LastName", lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 28: Input the '" + emailAddress + "' in 'Email' text box at Shipping Address tab");
        userCheckOutPage.inputToCheckoutTextboxByTextboxId("ShippingNewAddress_Email", emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 29: Select the '" + country + "' option in 'Country' dropdown at Shipping Address tab");
        userCheckOutPage.selectItemAtDropDownByDropdownId("ShippingNewAddress_CountryId", country);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 30: Select the '" + state + "' option in 'State' dropdown at Shipping Address tab");
        userCheckOutPage.selectItemAtDropDownByDropdownId("ShippingNewAddress_StateProvinceId", state);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 31: Input the '" + city + "' in 'City' text box at Shipping Address tab");
        userCheckOutPage.inputToCheckoutTextboxByTextboxId("ShippingNewAddress_City", city);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 32: Input the '" + addressStreet + "' in 'Address 1' text box at Shipping Address tab");
        userCheckOutPage.inputToCheckoutTextboxByTextboxId("ShippingNewAddress_Address1", addressStreet);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 33: Input the '" + zipCode + "' in 'Zip/ Postal Code' text box at Shipping Address tab");
        userCheckOutPage.inputToCheckoutTextboxByTextboxId("ShippingNewAddress_ZipPostalCode", zipCode);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 34: Input the '" + phoneNumber + "' in 'Phone Number' text box at Shipping Address tab");
        userCheckOutPage.inputToCheckoutTextboxByTextboxId("ShippingNewAddress_PhoneNumber", phoneNumber);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 35: Click the 'Continue' button at Shipping Address tab");
        userCheckOutPage.clickCheckOutButtonByName("Shipping");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 36: Click the 'Continue' button at Shipping Method tab");
        userCheckOutPage.clickCheckOutButtonByName("ShippingMethod");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 37: Select the '" + paymentMethod + "' option radio at Payment Method tab");
        userCheckOutPage.checkToRadioByRadioText(paymentMethod);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 38: Click the 'Continue' button at Payment Method tab");
        userCheckOutPage.clickCheckOutButtonByName("PaymentMethod");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 39: Click the 'Continue' button at Payment Info tab");
        userCheckOutPage.clickCheckOutButtonByName("PaymentInfo");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 40: Verify the '" + firstName + " " + lastName + "' is displayed at Billing Address column");
        Assert.assertEquals(userCheckOutPage.getCheckOutInfoTextByClass("billing-info", "name"), firstName + " " + lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 41: Verify the '" + emailAddress + "' is displayed at Billing Address column");
        Assert.assertEquals(userCheckOutPage.getCheckOutInfoTextByClass("billing-info", "email"), "Email: " + emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 42: Verify the '" + phoneNumber + "' is displayed at Billing Address column");
        Assert.assertEquals(userCheckOutPage.getCheckOutInfoTextByClass("billing-info", "phone"), "Phone: " + phoneNumber);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 43: Verify the '" + addressStreet + "' is displayed at Billing Address column");
        Assert.assertEquals(userCheckOutPage.getCheckOutInfoTextByClass("billing-info", "address1"), addressStreet);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 44: Verify the '" + city + " " + state + " " + zipCode + "' is displayed at Billing Address column");
        Assert.assertEquals(userCheckOutPage.getCheckOutInfoTextByClass("billing-info", "city-state-zip"), city + "," + state + "," + zipCode);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 45: Verify the '" + country + "' is displayed at Billing Address column");
        Assert.assertEquals(userCheckOutPage.getCheckOutInfoTextByClass("billing-info", "country"), country);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 46: Verify the '" + paymentMethod + "' is displayed at Billing Method row");
        Assert.assertTrue(userCheckOutPage.isCheckOutMethodDisplayed(paymentMethod));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 47: Verify the '" + firstName + " " + lastName + "' is displayed at Shipping Address column");
        Assert.assertEquals(userCheckOutPage.getCheckOutInfoTextByClass("shipping-info", "name"), firstName + " " + lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 48: Verify the '" + emailAddress + "' is displayed at Shipping Address column");
        Assert.assertEquals(userCheckOutPage.getCheckOutInfoTextByClass("shipping-info", "email"), "Email: " + emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 49: Verify the '" + phoneNumber + "' is displayed at Shipping Address column");
        Assert.assertEquals(userCheckOutPage.getCheckOutInfoTextByClass("shipping-info", "phone"), "Phone: " + phoneNumber);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 50: Verify the '" + addressStreet + "' is displayed at Shipping Address column");
        Assert.assertEquals(userCheckOutPage.getCheckOutInfoTextByClass("shipping-info", "address1"), addressStreet);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 51: Verify the '" + city + " " + state + " " + zipCode + "' is displayed at Shipping Address column");
        Assert.assertEquals(userCheckOutPage.getCheckOutInfoTextByClass("shipping-info", "city-state-zip"), city + "," + state + "," + zipCode);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 52: Verify the '" + country + "' is displayed at Shipping Address column");
        Assert.assertEquals(userCheckOutPage.getCheckOutInfoTextByClass("shipping-info", "country"), country);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 53: Verify the '" + paymentMethod + "' is displayed at Shipping Method row");
        Assert.assertTrue(userCheckOutPage.isCheckOutMethodDisplayed(shippingMethod));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 54: Verify the '" + notebooksName + "' is displayed correctly at Product table");
        Assert.assertEquals(userCheckOutPage.getCheckOutProductTitleText(), notebooksName);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 55: Verify the '" + totalPrice + "' is displayed correctly at Total Info");
        Assert.assertEquals(userCheckOutPage.getCheckOutProductPriceText(), totalPrice);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 56: Click the 'Confirm' button");
        userCheckOutPage.clickCheckOutButtonByName("ConfirmOrder");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 57: Verify the checkout process successful message is displayed");
        Assert.assertEquals(userCheckOutPage.getCheckOutSuccessMessageText(), "Your order has been successfully processed!");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 58: Save the order number");
        orderNumber = userCheckOutPage.getOrderNumberTextAtCheckOutPage();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 59: Click the 'Continue' button at Checkout Success Page");
        userHomePage = userCheckOutPage.clickToContinueButtonAtSuccessPage();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 60: Click the 'My account' link at Header Menu Link");
        userHomePage.clickToHeaderLinkByText(driver, "ico-account");
        userCustomerInfoPage = PageGenerateManager.getUserCustomerInfoPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 61: Click the 'Orders' link at Sidebar Menu Link");
        userCustomerInfoPage.clickToMenuLinkAtSidebarMenuByMenuText(driver, "Orders");
        userOrdersPage = PageGenerateManager.getUserOrdersPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 62: Verify the '" + orderNumber + "' is displayed correctly at Orders page");
        Assert.assertEquals(userOrdersPage.getOrderNumberTextAtOrdersPage(), orderNumber);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 63: Click the 'Details' link at Orders Page");
        userOrdersDetailPage = userOrdersPage.clickToDetailLink();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 64: Verify the '" + orderNumber + "' is displayed correctly at Orders Detail page");
        Assert.assertEquals(userOrdersDetailPage.getOrderNumberTextAtOrdersDetailPage(), orderNumber);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 65: Verify the '" + totalPrice + "' is displayed correctly at Orders Detail page");
        Assert.assertTrue(userOrdersDetailPage.isTotalPriceDisplayedCorrectly(totalPrice));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 66: Verify the '" + firstName + " " + lastName + "' is displayed at Billing Address column");
        Assert.assertEquals(userOrdersDetailPage.getCheckOutInfoTextByClass("billing-info", "name"), firstName + " " + lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 67: Verify the '" + emailAddress + "' is displayed at Billing Address column");
        Assert.assertEquals(userOrdersDetailPage.getCheckOutInfoTextByClass("billing-info", "email"), "Email: " + emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 68: Verify the '" + phoneNumber + "' is displayed at Billing Address column");
        Assert.assertEquals(userOrdersDetailPage.getCheckOutInfoTextByClass("billing-info", "phone"), "Phone: " + phoneNumber);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 69: Verify the '" + addressStreet + "' is displayed at Billing Address column");
        Assert.assertEquals(userOrdersDetailPage.getCheckOutInfoTextByClass("billing-info", "address1"), addressStreet);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 70: Verify the '" + city + " " + state + " " + zipCode + "' is displayed at Billing Address column");
        Assert.assertEquals(userOrdersDetailPage.getCheckOutInfoTextByClass("billing-info", "city-state-zip"), city + "," + state + "," + zipCode);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 71: Verify the '" + country + "' is displayed at Billing Address column");
        Assert.assertEquals(userOrdersDetailPage.getCheckOutInfoTextByClass("billing-info", "country"), country);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 72: Verify the '" + paymentMethod + "' is displayed at Billing Method row");
        Assert.assertTrue(userOrdersDetailPage.isCheckOutMethodDisplayed(paymentMethod));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 73: Verify the '" + firstName + " " + lastName + "' is displayed at Shipping Address column");
        Assert.assertEquals(userOrdersDetailPage.getCheckOutInfoTextByClass("shipping-info", "name"), firstName + " " + lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 74: Verify the '" + emailAddress + "' is displayed at Shipping Address column");
        Assert.assertEquals(userOrdersDetailPage.getCheckOutInfoTextByClass("shipping-info", "email"), "Email: " + emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 75: Verify the '" + phoneNumber + "' is displayed at Shipping Address column");
        Assert.assertEquals(userOrdersDetailPage.getCheckOutInfoTextByClass("shipping-info", "phone"), "Phone: " + phoneNumber);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 76: Verify the '" + addressStreet + "' is displayed at Shipping Address column");
        Assert.assertEquals(userOrdersDetailPage.getCheckOutInfoTextByClass("shipping-info", "address1"), addressStreet);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 77: Verify the '" + city + " " + state + " " + zipCode + "' is displayed at Shipping Address column");
        Assert.assertEquals(userOrdersDetailPage.getCheckOutInfoTextByClass("shipping-info", "city-state-zip"), city + "," + state + "," + zipCode);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 78: Verify the '" + country + "' is displayed at Shipping Address column");
        Assert.assertEquals(userOrdersDetailPage.getCheckOutInfoTextByClass("shipping-info", "country"), country);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 79: Verify the '" + paymentMethod + "' is displayed at Shipping Method row");
        Assert.assertTrue(userOrdersDetailPage.isCheckOutMethodDisplayed(shippingMethod));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 80: Verify the '" + notebooksName + "' is displayed correctly at Product table");
        Assert.assertEquals(userOrdersDetailPage.getCheckOutProductTitleText(), notebooksName);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 81: Verify the '" + totalPrice + "' is displayed correctly at Total Info");
        Assert.assertEquals(userOrdersDetailPage.getCheckOutProductPriceText(), totalPrice);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }

}
