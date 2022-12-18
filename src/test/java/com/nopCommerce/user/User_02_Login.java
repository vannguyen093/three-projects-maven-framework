package com.user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import data.UserDataMapper;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.PageGenerateManager;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserRegisterPO;
import reportConfig.ExtentTestManager;
import ultilities.Environment;

import java.lang.reflect.Method;

public class User_02_Login extends BaseTest {

    UserDataMapper userData;
    Environment env;
    UserHomePO userHomePage;
    UserLoginPO userLoginPage;
    UserRegisterPO userRegisterPage;
    private WebDriver driver;
    private String emailAddress, emailAddressNotRegistered;

    @Parameters({"browser", "evnName", "ipAddress", "portNumber", "osName", "osVersion"})
    @BeforeClass
    public void beforeClass(@Optional("firefox") String browserName, @Optional("local") String evnName, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
        String environmentName = System.getProperty("evn");
        ConfigFactory.setProperty("env", environmentName);
        env = ConfigFactory.create(Environment.class);

        driver = getBrowserDriver(browserName, env.userUrl(), evnName, osName, osVersion, ipAddress, portNumber);
        userData = UserDataMapper.getUserData();

        userHomePage = PageGenerateManager.getUserHomePage(driver);

        emailAddress = userData.getEmail() + generateFakeNumber() + "@gmail.com";
        emailAddressNotRegistered = "vanguyen3245@gmail.com";

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
        userHomePage.clickToHeaderLinkByText(driver, "ico-logout");
    }

    @Test
    public void TC_01_Login_With_Empty_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login With Empty Data");

        ExtentTestManager.getTest().log(Status.INFO, "Empty Data - Step 01: Click to 'Login' link");
        userHomePage.clickToHeaderLinkByText(driver, "ico-login");
        userLoginPage = PageGenerateManager.getUserLoginPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Empty Data - Step 02: Click to 'Login' button");
        userLoginPage.clickToButtonByButtonText("Log in");

        ExtentTestManager.getTest().log(Status.INFO, "Empty Data - Step 03: Verify that the error message is displayed under 'Email' text box");
        Assert.assertEquals(userLoginPage.getErrorMessageTextByTextboxID("Email"), "Please enter your email");
    }

    @Test
    public void TC_02_Login_With_Invalid_Email(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login With Invalid Email");

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Email - Step 01: Click to 'Login' link");
        userLoginPage.clickToHeaderLinkByText(driver, "ico-login");

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Email - Step 02: Input '123@123@123' into the 'Email' text box");
        userLoginPage.inputToLoginTextboxByTextboxId("Email", "123@123@123");

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Email - Step 03: Click to 'Login' button");
        userLoginPage.clickToButtonByButtonText("Log in");

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Email - Step 04: Verify that the error message is displayed under 'Email' text box");
        Assert.assertEquals(userLoginPage.getErrorMessageTextByTextboxID("Email"), "Wrong email");
    }

    @Test
    public void TC_03_Login_With_Email_Not_Registered(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login With Email Not Registered");

        ExtentTestManager.getTest().log(Status.INFO, "Email Not Registered - Step 01: Click to 'Login' link");
        userLoginPage.clickToHeaderLinkByText(driver, "ico-login");

        ExtentTestManager.getTest().log(Status.INFO, "Email Not Registered - Step 02: Input '" + emailAddressNotRegistered + "' into the 'Email' text box");
        userLoginPage.inputToLoginTextboxByTextboxId("Email", emailAddressNotRegistered);

        ExtentTestManager.getTest().log(Status.INFO, "Email Not Registered - Step 03: Input '" + userData.getPassword() + "' into the 'Password' text box");
        userLoginPage.inputToLoginTextboxByTextboxId("Password", userData.getPassword());

        ExtentTestManager.getTest().log(Status.INFO, "Email Not Registered - Step 04: Click to 'Login' button");
        userLoginPage.clickToButtonByButtonText("Log in");

        ExtentTestManager.getTest().log(Status.INFO, "Email Not Registered - Step 05: Verify that the error message is displayed");
        Assert.assertEquals(userLoginPage.getUnsuccessfulErrorMessageText(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
    }

    @Test
    public void TC_04_Login_With_Empty_Password(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login With Empty Password");

        ExtentTestManager.getTest().log(Status.INFO, "Empty Password - Step 01: Click to 'Login' link");
        userLoginPage.clickToHeaderLinkByText(driver, "ico-login");

        ExtentTestManager.getTest().log(Status.INFO, "Empty Password - Step 02: Input '" + emailAddress + "' into the 'Email' text box");
        userLoginPage.inputToLoginTextboxByTextboxId("Email", emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Empty Password - Step 03: Click to 'Login' button");
        userLoginPage.clickToButtonByButtonText("Log in");

        ExtentTestManager.getTest().log(Status.INFO, "Empty Password- Step 04: Verify that the error message is displayed");
        Assert.assertEquals(userLoginPage.getUnsuccessfulErrorMessageText(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

    @Test
    public void TC_05_Login_With_Invalid_Password(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login With Invalid Password");

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Password - Step 01: Click to 'Login' link");
        userLoginPage.clickToHeaderLinkByText(driver, "ico-login");

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Password - Step 02: Input '" + emailAddress + "' into the 'Email' text box");
        userLoginPage.inputToLoginTextboxByTextboxId("Email", emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Password - Step 03: Input '" + "123" + "' into the 'Password' text box");
        userLoginPage.inputToLoginTextboxByTextboxId("Password", "123");

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Password - Step 04: Click to 'Login' button");
        userLoginPage.clickToButtonByButtonText("Log in");

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Password - Step 05: Verify that the error message is displayed");
        Assert.assertEquals(userLoginPage.getUnsuccessfulErrorMessageText(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

    @Test
    public void TC_06_Login_Successful(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login Successful");

        ExtentTestManager.getTest().log(Status.INFO, "Login Successful - Step 01: Click to 'Login' link");
        userLoginPage.clickToHeaderLinkByText(driver, "ico-login");

        ExtentTestManager.getTest().log(Status.INFO, "Login Successful- Step 02: Input '" + emailAddress + "' into the 'Email' text box");
        userLoginPage.inputToLoginTextboxByTextboxId("Email", emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Login Successful - Step 03: Input '" + userData.getPassword() + "' into the 'Password' text box");
        userLoginPage.inputToLoginTextboxByTextboxId("Password", userData.getPassword());

        ExtentTestManager.getTest().log(Status.INFO, "Login Successful - Step 04: Click to 'Login' button");
        userLoginPage.clickToButtonByButtonText("Log in");
        userHomePage = PageGenerateManager.getUserHomePage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Login Successful - Step 05: Verify that the homepage title is displayed");
        Assert.assertEquals(userHomePage.getHomePageTitle(), "Welcome to our store");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }

}
