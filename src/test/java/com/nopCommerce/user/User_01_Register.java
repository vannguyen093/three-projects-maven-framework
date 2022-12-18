package com.user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import data.UserDataMapper;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.PageGenerateManager;
import pageObjects.UserHomePO;
import pageObjects.UserRegisterPO;
import reportConfig.ExtentTestManager;
import ultilities.Environment;

import java.lang.reflect.Method;

public class User_01_Register extends BaseTest {

    UserDataMapper userData;
    Environment env;
    UserHomePO userHomePage;
    UserRegisterPO userRegisterPage;
    private WebDriver driver;
    private String emailAddress, existingEmailAddress;

    @Parameters({"browser", "evnName", "ipAddress", "portNumber", "osName", "osVersion"})
    @BeforeClass
    public void beforeClass(@Optional("firefox") String browserName, @Optional("local") String evnName, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
        String environmentName = System.getProperty("evn");
        ConfigFactory.setProperty("env", environmentName);
        env = ConfigFactory.create(Environment.class);

        driver = getBrowserDriver(browserName, env.userUrl(), evnName, osName, osVersion, ipAddress, portNumber);
        userData = UserDataMapper.getUserData();

        userHomePage = PageGenerateManager.getUserHomePage(driver);

        existingEmailAddress = userData.getEmail() + generateFakeNumber() + "@gmail.com";
        emailAddress = userData.getEmail() + generateFakeNumber() + "@gmail.com";
    }

    @Test
    public void TC_01_Create_Account_With_Empty_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Create Account With Empty Data");

        ExtentTestManager.getTest().log(Status.INFO, "Empty Data - Step 01: Click to 'Register' link");
        userHomePage.clickToHeaderLinkByText(driver, "ico-register");
        userRegisterPage = PageGenerateManager.getUserRegisterPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Empty Data - Step 02: Click to 'Register' button");
        userRegisterPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Empty Data - Step 03: Verify that the error message is displayed under 'First Name' text box");
        verifyEquals(userRegisterPage.getErrorMessageTextByTextboxID("FirstName"), "First name is required.");

        ExtentTestManager.getTest().log(Status.INFO, "Empty Data - Step 04: Verify that the error message is displayed under 'Last Name' text box");
        verifyEquals(userRegisterPage.getErrorMessageTextByTextboxID("LastName"), "Last name is required.");

        ExtentTestManager.getTest().log(Status.INFO, "Empty Data - Step 05: Verify that the error message is displayed under 'Email' text box");
        verifyEquals(userRegisterPage.getErrorMessageTextByTextboxID("Email"), "Email is required.");

        ExtentTestManager.getTest().log(Status.INFO, "Empty Data - Step 06: Verify that the error message is displayed under 'Password' text box");
        verifyEquals(userRegisterPage.getErrorMessageTextByTextboxID("Password"), "Password is required.");

        ExtentTestManager.getTest().log(Status.INFO, "Empty Data - Step 07: Verify that the error message is displayed under 'Confirm Password' text box");
        verifyEquals(userRegisterPage.getErrorMessageTextByTextboxID("ConfirmPassword"), "Password is required.");
    }

    @Test
    public void TC_02_Create_Account_With_Invalid_Email(Method method) {
        ExtentTestManager.startTest(method.getName(), "Create Account With Invalid Email");

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Email - Step 01: Click to 'Register' link");
        userRegisterPage.clickToHeaderLinkByText(driver, "ico-register");

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Email - Step 02: Select '" + userData.getGender() + "' at the 'Gender' radio");
        userRegisterPage.selectGenderRadioByText(userData.getGender());

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Email - Step 03: Input '" + userData.getFirstName() + "' into the 'First Name' text box");
        userRegisterPage.inputToRegisterTextboxByTextboxID("FirstName", userData.getFirstName());

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Email - Step 04: Input '" + userData.getLastName() + "' into the 'Last Name' text box");
        userRegisterPage.inputToRegisterTextboxByTextboxID("LastName", userData.getLastName());

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Email - Step 05: Select '" + userData.getDate() + "' in the 'Date' dropbox");
        userRegisterPage.selectItemInDOBDropbox("DateOfBirthDay", userData.getDate());

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Email - Step 06: Select '" + userData.getDate() + "' in the 'Date' dropbox");
        userRegisterPage.selectItemInDOBDropbox("DateOfBirthMonth", userData.getMonth());

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Email - Step 07: Select '" + userData.getDate() + "' in the 'Date' dropbox");
        userRegisterPage.selectItemInDOBDropbox("DateOfBirthYear", userData.getYear());

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Email - Step 08: Input '123@123@123' into the 'Email' text box");
        userRegisterPage.inputToRegisterTextboxByTextboxID("Email", "123@123@123");

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Email - Step 09: Input '" + userData.getPassword() + "' into the 'Password' text box");
        userRegisterPage.inputToRegisterTextboxByTextboxID("Password", userData.getPassword());

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Email - Step 10: Input '" + userData.getPassword() + "' into the 'Confirm Password' text box");
        userRegisterPage.inputToRegisterTextboxByTextboxID("ConfirmPassword", userData.getPassword());

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Email - Step 11: Click to 'Register' button");
        userRegisterPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Email - Step 12: Verify that the error message is displayed under 'Email' text box");
        verifyEquals(userRegisterPage.getErrorMessageTextByTextboxID("Email"), "Wrong email");
    }

    @Test
    public void TC_03_Create_Account_Successful(Method method) {
        ExtentTestManager.startTest(method.getName(), "Create Account Successful");

        ExtentTestManager.getTest().log(Status.INFO, "Successful - Step 01: Click to 'Register' link");
        userRegisterPage.clickToHeaderLinkByText(driver, "ico-register");

        ExtentTestManager.getTest().log(Status.INFO, "Successful - Step 02: Select '" + userData.getGender() + "' at the 'Gender' radio");
        userRegisterPage.selectGenderRadioByText(userData.getGender());

        ExtentTestManager.getTest().log(Status.INFO, "Successful - Step 03: Input '" + userData.getFirstName() + "' into the 'First Name' text box");
        userRegisterPage.inputToRegisterTextboxByTextboxID("FirstName", userData.getFirstName());

        ExtentTestManager.getTest().log(Status.INFO, "Successful - Step 04: Input '" + userData.getLastName() + "' into the 'Last Name' text box");
        userRegisterPage.inputToRegisterTextboxByTextboxID("LastName", userData.getLastName());

        ExtentTestManager.getTest().log(Status.INFO, "Successful- Step 05: Select '" + userData.getDate() + "' in the 'Date' dropbox");
        userRegisterPage.selectItemInDOBDropbox("DateOfBirthDay", userData.getDate());

        ExtentTestManager.getTest().log(Status.INFO, "Successful - Step 06: Select '" + userData.getDate() + "' in the 'Month' dropbox");
        userRegisterPage.selectItemInDOBDropbox("DateOfBirthMonth", userData.getMonth());

        ExtentTestManager.getTest().log(Status.INFO, "Successful - Step 07: Select '" + userData.getDate() + "' in the 'Year' dropbox");
        userRegisterPage.selectItemInDOBDropbox("DateOfBirthYear", userData.getYear());

        ExtentTestManager.getTest().log(Status.INFO, "Successful - Step 08: Input '" + existingEmailAddress + "' into the 'Email' text box");
        userRegisterPage.inputToRegisterTextboxByTextboxID("Email", existingEmailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Successful - Step 09: Input '" + userData.getPassword() + "' into the 'Password' text box");
        userRegisterPage.inputToRegisterTextboxByTextboxID("Password", userData.getPassword());

        ExtentTestManager.getTest().log(Status.INFO, "Successful - Step 10: Input '" + userData.getPassword() + "' into the 'Confirm Password' text box");
        userRegisterPage.inputToRegisterTextboxByTextboxID("ConfirmPassword", userData.getPassword());

        ExtentTestManager.getTest().log(Status.INFO, "Successful - Step 11: Click to 'Register' button");
        userRegisterPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Successful - Step 12: Verify that the register successful message is displayed");
        verifyTrue(userRegisterPage.isRegisterSuccessfulMessageDisplay());

        ExtentTestManager.getTest().log(Status.INFO, "Successful - Step 13: Click the 'Continue' link");
        userHomePage = userRegisterPage.clickToContinueLink();

        ExtentTestManager.getTest().log(Status.INFO, "Successful - Step 14: Click the 'Logout' link");
        userHomePage.clickToHeaderLinkByText(driver, "ico-logout");
    }

    @Test
    public void TC_04_Create_Account_With_Existing_Email(Method method) {
        ExtentTestManager.startTest(method.getName(), "Create Account With Existing Email");

        ExtentTestManager.getTest().log(Status.INFO, "Existing Email - Step 01: Click to 'Register' link");
        userHomePage.clickToHeaderLinkByText(driver, "ico-register");
        userRegisterPage = PageGenerateManager.getUserRegisterPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Existing Email - Step 02: Select '" + userData.getGender() + "' at the 'Gender' radio");
        userRegisterPage.selectGenderRadioByText(userData.getGender());

        ExtentTestManager.getTest().log(Status.INFO, "Existing Email - Step 03: Input '" + userData.getFirstName() + "' into the 'First Name' text box");
        userRegisterPage.inputToRegisterTextboxByTextboxID("FirstName", userData.getFirstName());

        ExtentTestManager.getTest().log(Status.INFO, "Existing Email - Step 04: Input '" + userData.getLastName() + "' into the 'Last Name' text box");
        userRegisterPage.inputToRegisterTextboxByTextboxID("LastName", userData.getLastName());

        ExtentTestManager.getTest().log(Status.INFO, "Existing Email- Step 05: Select '" + userData.getDate() + "' in the 'Date' dropbox");
        userRegisterPage.selectItemInDOBDropbox("DateOfBirthDay", userData.getDate());

        ExtentTestManager.getTest().log(Status.INFO, "Existing Email - Step 06: Select '" + userData.getDate() + "' in the 'Date' dropbox");
        userRegisterPage.selectItemInDOBDropbox("DateOfBirthMonth", userData.getMonth());

        ExtentTestManager.getTest().log(Status.INFO, "Existing Email - Step 07: Select '" + userData.getDate() + "' in the 'Date' dropbox");
        userRegisterPage.selectItemInDOBDropbox("DateOfBirthYear", userData.getYear());

        ExtentTestManager.getTest().log(Status.INFO, "Existing Email - Step 08: Input the existing email '" + existingEmailAddress + "' into the 'Email' text box");
        userRegisterPage.inputToRegisterTextboxByTextboxID("Email", existingEmailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Existing Email - Step 09: Input '" + userData.getPassword() + "' into the 'Password' text box");
        userRegisterPage.inputToRegisterTextboxByTextboxID("Password", userData.getPassword());

        ExtentTestManager.getTest().log(Status.INFO, "Existing Email - Step 10: Input '" + userData.getPassword() + "' into the 'Confirm Password' text box");
        userRegisterPage.inputToRegisterTextboxByTextboxID("ConfirmPassword", userData.getPassword());

        ExtentTestManager.getTest().log(Status.INFO, "Existing Email - Step 11: Click to 'Register' button");
        userRegisterPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Existing Email - Step 12: Verify that the error message is displayed");
        verifyEquals(userRegisterPage.getExistingEmailErrMessText(), "The specified email already exists");
    }

    @Test
    public void TC_05_Create_Account_With_Password_Less_Than_6(Method method) {
        ExtentTestManager.startTest(method.getName(), "Create Account With Password Less Than 6 Characters");

        ExtentTestManager.getTest().log(Status.INFO, "Password Less Than 6 - Step 01: Click to 'Register' link");
        userHomePage.clickToHeaderLinkByText(driver, "ico-register");
        userRegisterPage = PageGenerateManager.getUserRegisterPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Password Less Than 6 - Step 02: Select '" + userData.getGender() + "' at the 'Gender' radio");
        userRegisterPage.selectGenderRadioByText(userData.getGender());

        ExtentTestManager.getTest().log(Status.INFO, "Password Less Than 6 - Step 03: Input '" + userData.getFirstName() + "' into the 'First Name' text box");
        userRegisterPage.inputToRegisterTextboxByTextboxID("FirstName", userData.getFirstName());

        ExtentTestManager.getTest().log(Status.INFO, "Password Less Than 6 - Step 04: Input '" + userData.getLastName() + "' into the 'Last Name' text box");
        userRegisterPage.inputToRegisterTextboxByTextboxID("LastName", userData.getLastName());

        ExtentTestManager.getTest().log(Status.INFO, "Password Less Than 6- Step 05: Select '" + userData.getDate() + "' in the 'Date' dropbox");
        userRegisterPage.selectItemInDOBDropbox("DateOfBirthDay", userData.getDate());

        ExtentTestManager.getTest().log(Status.INFO, "Password Less Than 6 - Step 06: Select '" + userData.getDate() + "' in the 'Date' dropbox");
        userRegisterPage.selectItemInDOBDropbox("DateOfBirthMonth", userData.getMonth());

        ExtentTestManager.getTest().log(Status.INFO, "Password Less Than 6 - Step 07: Select '" + userData.getDate() + "' in the 'Date' dropbox");
        userRegisterPage.selectItemInDOBDropbox("DateOfBirthYear", userData.getYear());

        ExtentTestManager.getTest().log(Status.INFO, "Password Less Than 6 - Step 08: Input '" + emailAddress + "' into the 'Email' text box");
        userRegisterPage.inputToRegisterTextboxByTextboxID("Email", emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Password Less Than 6 - Step 09: Input '" + "123" + "' into the 'Password' text box");
        userRegisterPage.inputToRegisterTextboxByTextboxID("Password", "123");

        ExtentTestManager.getTest().log(Status.INFO, "Password Less Than 6 - Step 10: Input '" + userData.getPassword() + "' into the 'Confirm Password' text box");
        userRegisterPage.inputToRegisterTextboxByTextboxID("ConfirmPassword", userData.getPassword());

        ExtentTestManager.getTest().log(Status.INFO, "Password Less Than 6 - Step 11: Click to 'Register' button");
        userRegisterPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Password Less Than 6 - Step 12: Verify that the error message is displayed");
        verifyEquals(userRegisterPage.getErrorMessageTextByTextboxID("Password"), "Password must meet the following rules:\nmust have at least 6 characters");
    }

    @Test
    public void TC_06_Create_Account_With_Invalid_Confirm_Password(Method method) {
        ExtentTestManager.startTest(method.getName(), "Create Account With Invalid Confirm Password");

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Confirm Password - Step 01: Click to 'Register' link");
        userHomePage.clickToHeaderLinkByText(driver, "ico-register");
        userRegisterPage = PageGenerateManager.getUserRegisterPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Confirm Password - Step 02: Select '" + userData.getGender() + "' at the 'Gender' radio");
        userRegisterPage.selectGenderRadioByText(userData.getGender());

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Confirm Password - Step 03: Input '" + userData.getFirstName() + "' into the 'First Name' text box");
        userRegisterPage.inputToRegisterTextboxByTextboxID("FirstName", userData.getFirstName());

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Confirm Password - Step 04: Input '" + userData.getLastName() + "' into the 'Last Name' text box");
        userRegisterPage.inputToRegisterTextboxByTextboxID("LastName", userData.getLastName());

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Confirm Password- Step 05: Select '" + userData.getDate() + "' in the 'Date' dropbox");
        userRegisterPage.selectItemInDOBDropbox("DateOfBirthDay", userData.getDate());

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Confirm Password - Step 06: Select '" + userData.getDate() + "' in the 'Date' dropbox");
        userRegisterPage.selectItemInDOBDropbox("DateOfBirthMonth", userData.getMonth());

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Confirm Password - Step 07: Select '" + userData.getDate() + "' in the 'Date' dropbox");
        userRegisterPage.selectItemInDOBDropbox("DateOfBirthYear", userData.getYear());

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Confirm Password - Step 08: Input '" + emailAddress + "' into the 'Email' text box");
        userRegisterPage.inputToRegisterTextboxByTextboxID("Email", emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Confirm Password - Step 09: Input '" + userData.getPassword() + "' into the 'Password' text box");
        userRegisterPage.inputToRegisterTextboxByTextboxID("Password", userData.getPassword());

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Confirm Password - Step 10: Input '" + "123" + "' into the 'Confirm Password' text box");
        userRegisterPage.inputToRegisterTextboxByTextboxID("ConfirmPassword", "123");

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Confirm Password - Step 11: Click to 'Register' button");
        userRegisterPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Invalid Confirm Password - Step 12: Verify that the error message is displayed");
        verifyEquals(userRegisterPage.getErrorMessageTextByTextboxID("ConfirmPassword"), "The password and confirmation password do not match.");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }

}
