package com.admin;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import data.AdminDataMapper;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.nopCommerce.AdminCustomersPO;
import pageObjects.nopCommerce.AdminDashboardPO;
import pageObjects.nopCommerce.AdminLoginPO;
import pageObjects.nopCommerce.PageGenerateManager;
import reportConfig.ExtentTestManager;
import ultilities.Environment;

import java.lang.reflect.Method;

public class Admin_03_Add_Update_Delete_Address extends BaseTest {

    AdminDataMapper adminData;
    Environment env;
    AdminLoginPO adminLoginPage;
    AdminDashboardPO adminDashboardPage;
    AdminCustomersPO adminCustomersPage;
    private WebDriver driver;
    private String userName, password;
    private String editAddrLastName, addrEmail, editAddrEmail, addrLastName;

    @Parameters({"browser", "evnName", "ipAddress", "portNumber", "osName", "osVersion"})
    @BeforeClass
    public void beforeClass(@Optional("firefox") String browserName, @Optional("local") String evnName, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
        String environmentName = System.getProperty("evn");
        ConfigFactory.setProperty("env", environmentName);
        env = ConfigFactory.create(Environment.class);

        driver = getBrowserDriver(browserName, env.adminUrl(), evnName, osName, osVersion, ipAddress, portNumber);
        adminData = AdminDataMapper.getAdminData();

        adminLoginPage = PageGenerateManager.getAdminLoginPage(driver);

        userName = "admin@yourstore.com";
        password = "admin";
        addrLastName = adminData.getAddrLastName() + " " + generateFakeNumber();
        editAddrLastName = adminData.getEditAddrLastName() + " " + generateFakeNumber();
        addrEmail = adminData.getAddrEmail() + generateFakeNumber() + "@gmail.com";
        editAddrEmail = adminData.getEditAddrEmail() + generateFakeNumber() + "@gmail.com";

        adminLoginPage.inputToLoginTextboxByTextboxId("Email", userName);
        adminLoginPage.inputToLoginTextboxByTextboxId("Password", password);
        adminDashboardPage = adminLoginPage.clickToLoginButton();
        adminDashboardPage.clickToAdminSubSidebarMenuByMenuText(driver, "Customers", "Customers");
        adminCustomersPage = PageGenerateManager.getAdminCustomersPage(driver);
        adminCustomersPage.clickToAddNewButton();
        adminCustomersPage.inputToCustomerTextboxByTextboxId("Email", addrEmail);
        adminCustomersPage.inputToCustomerTextboxByTextboxId("Password", adminData.getPassword());
        adminCustomersPage.inputToCustomerTextboxByTextboxId("FirstName", adminData.getAddrFirstName());
        adminCustomersPage.inputToCustomerTextboxByTextboxId("LastName", addrLastName);
        adminCustomersPage.selectGenderByGenderText(adminData.getGender());
        adminCustomersPage.inputToCustomerTextboxByTextboxId("DateOfBirth", adminData.getDateOfBirth());
        adminCustomersPage.inputToCustomerTextboxByTextboxId("Company", adminData.getCompany());
        adminCustomersPage.unSelectCustomerRoleByText("Registered");
        adminCustomersPage.selectNewCustomerRoleDropdown(adminData.getCustomerRole());
        adminCustomersPage.inputToNewCustomerAdminCommentTextarea(adminData.getAdminComment());
        adminCustomersPage.clickToNewCustomerButtonByButtonText("Save");
    }

    @Test
    public void TC_13_Add_New_Address(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add new address in customer detail");

        ExtentTestManager.getTest().log(Status.INFO, "Add New Address - Step 01: Input '" + adminData.getAddrFirstName() + "' into 'First name' text box at Customers page");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("SearchFirstName", adminData.getAddrFirstName());

        ExtentTestManager.getTest().log(Status.INFO, "Add New Address - Step 02: Input '" + addrLastName + "' into 'Last name' text box at Customers page");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("SearchLastName", addrLastName);

        ExtentTestManager.getTest().log(Status.INFO, "Add New Address - Step 03: Unselect '" + "Registered" + "' option at 'Customer role' dropdown at Customers page");
        adminCustomersPage.unSelectCustomerRoleByText("Registered");

        ExtentTestManager.getTest().log(Status.INFO, "Add New Address - Step 04: Select '" + adminData.getCustomerRole() + "' option at 'Customer role' dropdown at Customers page");
        adminCustomersPage.selectCustomerRoleDropdown(adminData.getCustomerRole());

        ExtentTestManager.getTest().log(Status.INFO, "Add New Address - Step 05: Click the 'Search' button at Customers page");
        adminCustomersPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Add New Address - Step 06: Click the 'Edit' button by customer full name at Customers page");
        adminCustomersPage.clickToEditButtonByCustomerFullNameText(adminData.getAddrFirstName() + " " + addrLastName);

        ExtentTestManager.getTest().log(Status.INFO, "Add New Address - Step 07: Click the 'Address' tab");
        adminCustomersPage.clickToCustomerTabByTabName("Address");

        ExtentTestManager.getTest().log(Status.INFO, "Add New Address - Step 08: Click the 'Add new address' button");
        adminCustomersPage.clickToNewCustomerButtonByButtonText("Add new address");

        ExtentTestManager.getTest().log(Status.INFO, "Add New Address - Step 09: Input '" + adminData.getAddrFirstName() + "' into 'First name' text box at Add Address page");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("Address_FirstName", adminData.getAddrFirstName());

        ExtentTestManager.getTest().log(Status.INFO, "Add New Address - Step 10: Input '" + addrLastName + "' into 'Last name' text box at Add Address page");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("Address_LastName", addrLastName);

        ExtentTestManager.getTest().log(Status.INFO, "Add New Address - Step 11: Input '" + addrEmail + "' into 'Email' text box at Add Address page");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("Address_Email", addrEmail);

        ExtentTestManager.getTest().log(Status.INFO, "Add New Address - Step 12: Select '" + adminData.getAddrCountry() + "' option in 'Country' dropdown at Add Address page");
        adminCustomersPage.selectItemAtAddressDropdownByDropdownId("Address_CountryId", adminData.getAddrCountry());

        ExtentTestManager.getTest().log(Status.INFO, "Add New Address - Step 13: Select '" + adminData.getAddrState() + "' option in 'State' dropdown at Add Address page");
        adminCustomersPage.selectItemAtAddressDropdownByDropdownId("Address_StateProvinceId", adminData.getAddrState());

        ExtentTestManager.getTest().log(Status.INFO, "Add New Address - Step 14: Input '" + adminData.getAddrCity() + "' into 'City' text box at Add Address page");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("Address_City", adminData.getAddrCity());

        ExtentTestManager.getTest().log(Status.INFO, "Add New Address - Step 15: Input '" + adminData.getAddressStreet() + "' into 'Address 1' text box at Add Address page");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("Address_Address1", adminData.getAddressStreet());

        ExtentTestManager.getTest().log(Status.INFO, "Add New Address - Step 16: Input '" + adminData.getAddrZipCode() + "' into 'Zip code' text box at Add Address page");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("Address_ZipPostalCode", adminData.getAddrZipCode());

        ExtentTestManager.getTest().log(Status.INFO, "Add New Address - Step 17: Input '" + adminData.getAddrPhoneNumber() + "' into 'Phone number' text box at Add Address page");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("Address_PhoneNumber", adminData.getAddrPhoneNumber());

        ExtentTestManager.getTest().log(Status.INFO, "Add New Address - Step 18: Click the 'Save' button at Add Address page");
        adminCustomersPage.clickToNewCustomerButtonByButtonText("Save");

        ExtentTestManager.getTest().log(Status.INFO, "Add New Address - Step 19: Verify that the system is displayed a success message at Add Address page");
        Assert.assertEquals(adminCustomersPage.getCustomerSuccessMessageText(), "×\nThe new address has been added successfully.");

        ExtentTestManager.getTest().log(Status.INFO, "Add New Address - Step 20: Verify '" + adminData.getAddrFirstName() + "' is displayed at 'First Name' text box at Add Address page");
        Assert.assertEquals(adminCustomersPage.getCustomerAttributeByTextboxId("Address_FirstName"), adminData.getAddrFirstName());

        ExtentTestManager.getTest().log(Status.INFO, "Add New Address - Step 21: Verify '" + addrLastName + "' is displayed at 'Last Name' text box at Add Address page");
        Assert.assertEquals(adminCustomersPage.getCustomerAttributeByTextboxId("Address_LastName"), addrLastName);

        ExtentTestManager.getTest().log(Status.INFO, "Add New Address - Step 22: Verify '" + addrEmail + "' is displayed at 'Email' text box at Add Address page");
        Assert.assertEquals(adminCustomersPage.getCustomerAttributeByTextboxId("Address_Email"), addrEmail);

        ExtentTestManager.getTest().log(Status.INFO, "Add New Address - Step 23: Verify '" + adminData.getAddrCountry() + "' is displayed at 'Country' dropdown at Add Address page");
        Assert.assertEquals(adminCustomersPage.getAddressDropdownTextByDropdownId("Address_CountryId"), adminData.getAddrCountry());

        ExtentTestManager.getTest().log(Status.INFO, "Add New Address - Step 24: Verify '" + adminData.getAddrState() + "' is displayed at 'State' dropdown at Add Address page");
        Assert.assertEquals(adminCustomersPage.getAddressDropdownTextByDropdownId("Address_StateProvinceId"), adminData.getAddrState());

        ExtentTestManager.getTest().log(Status.INFO, "Add New Address - Step 25: Verify '" + adminData.getAddrCity() + "' is displayed at 'City' text box at Add Address page");
        Assert.assertEquals(adminCustomersPage.getCustomerAttributeByTextboxId("Address_City"), adminData.getAddrCity());

        ExtentTestManager.getTest().log(Status.INFO, "Add New Address - Step 26: Verify '" + adminData.getAddressStreet() + "' is displayed at 'Address 1' text box at Add Address page");
        Assert.assertEquals(adminCustomersPage.getCustomerAttributeByTextboxId("Address_Address1"), adminData.getAddressStreet());

        ExtentTestManager.getTest().log(Status.INFO, "Add New Address - Step 27: Verify '" + adminData.getAddrZipCode() + "' is displayed at 'Zip' text box at Add Address page");
        Assert.assertEquals(adminCustomersPage.getCustomerAttributeByTextboxId("Address_ZipPostalCode"), adminData.getAddrZipCode());

        ExtentTestManager.getTest().log(Status.INFO, "Add New Address - Step 28: Verify '" + adminData.getAddrPhoneNumber() + "' is displayed at 'Phone number' text box at Add Address page");
        Assert.assertEquals(adminCustomersPage.getCustomerAttributeByTextboxId("Address_PhoneNumber"), adminData.getAddrPhoneNumber());
    }

    @Test
    public void TC_14_Edit_Address(Method method) {
        ExtentTestManager.startTest(method.getName(), "Edit a new address in customer detail");

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 01: Click 'Customers' at sidebar menu");
        adminDashboardPage.clickToAdminSubSidebarMenuByMenuText(driver, "Customers", "Customers");

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 02: Input '" + adminData.getAddrFirstName() + "' into 'First name' text box at Customers page");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("SearchFirstName", adminData.getAddrFirstName());

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 03: Input '" + addrLastName + "' into 'Last name' text box at Customers page");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("SearchLastName", addrLastName);

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 04: Unselect '" + "Registered" + "' option at 'Customer role' dropdown at Customers page");
        adminCustomersPage.unSelectCustomerRoleByText("Registered");

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 05: Select '" + adminData.getCustomerRole() + "' option at 'Customer role' dropdown at Customers page");
        adminCustomersPage.selectCustomerRoleDropdown(adminData.getCustomerRole());

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 06: Click the 'Search' button at Customers page");
        adminCustomersPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 07: Click the 'Edit' button by customer full name at Customers page");
        adminCustomersPage.clickToEditButtonByCustomerFullNameText(adminData.getAddrFirstName() + " " + addrLastName);

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 08: Click the 'Address' tab at Customers Detail page");
        adminCustomersPage.clickToCustomerTabByTabName("Address");

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 08: Click the 'Edit' button link at Customers Detail page");
        adminCustomersPage.clickToCustomerAddressButtonLinkByEmailAndText(addrEmail, "Edit");

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 09: Input '" + adminData.getEditAddrFirstName() + "' into 'First name' text box at Edit Address page");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("Address_FirstName", adminData.getEditAddrFirstName());

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 10: Input '" + editAddrLastName + "' into 'Last name' text box at Edit Address page");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("Address_LastName", editAddrLastName);

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 11: Input '" + editAddrEmail + "' into 'Email' text box at Edit Address page");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("Address_Email", editAddrEmail);

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 12: Select '" + adminData.getEditAddrCountry() + "' option in 'Country' dropdown at Edit Address page");
        adminCustomersPage.selectItemAtAddressDropdownByDropdownId("Address_CountryId", adminData.getEditAddrCountry());

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 13: Select '" + adminData.getEditAddrState() + "' option in 'State' dropdown at Edit Address page");
        adminCustomersPage.selectItemAtAddressDropdownByDropdownId("Address_StateProvinceId", adminData.getEditAddrState());

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 14: Input '" + adminData.getEditAddrCity() + "' into 'City' text box at Edit Address page");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("Address_City", adminData.getEditAddrCity());

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 15: Input '" + adminData.getEditAddressStreet() + "' into 'Address 1' text box at Edit Address page");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("Address_Address1", adminData.getEditAddressStreet());

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 16: Input '" + adminData.getEditAddrZipCode() + "' into 'Zip code' text box at Edit Address page");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("Address_ZipPostalCode", adminData.getEditAddrZipCode());

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 17: Input '" + adminData.getEditAddrPhoneNumber() + "' into 'Phone number' text box at Edit Address page");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("Address_PhoneNumber", adminData.getEditAddrPhoneNumber());

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 18: Click the 'Save' button at Edit Address page");
        adminCustomersPage.clickToNewCustomerButtonByButtonText("Save");

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 19: Verify that the system is displayed a success message at Edit Address page");
        Assert.assertEquals(adminCustomersPage.getCustomerSuccessMessageText(), "×\nThe address has been updated successfully.");

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 20: Verify '" + adminData.getEditAddrFirstName() + "' is displayed at 'First Name' text box at Edit Address page");
        Assert.assertEquals(adminCustomersPage.getCustomerAttributeByTextboxId("Address_FirstName"), adminData.getEditAddrFirstName());

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 21: Verify '" + editAddrLastName + "' is displayed at 'Last Name' text box at Edit Address page");
        Assert.assertEquals(adminCustomersPage.getCustomerAttributeByTextboxId("Address_LastName"), editAddrLastName);

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 22: Verify '" + editAddrEmail + "' is displayed at 'Email' text box at Edit Address page");
        Assert.assertEquals(adminCustomersPage.getCustomerAttributeByTextboxId("Address_Email"), editAddrEmail);

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 23: Verify '" + adminData.getEditAddrCountry() + "' is displayed at 'Country' dropdown at Edit Address page");
        Assert.assertEquals(adminCustomersPage.getAddressDropdownTextByDropdownId("Address_CountryId"), adminData.getEditAddrCountry());

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 24: Verify '" + adminData.getEditAddrState() + "' is displayed at 'State' dropdown at Edit Address page");
        Assert.assertEquals(adminCustomersPage.getAddressDropdownTextByDropdownId("Address_StateProvinceId"), adminData.getEditAddrState());

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 25: Verify '" + adminData.getEditAddrCity() + "' is displayed at 'City' text box at Edit Address page");
        Assert.assertEquals(adminCustomersPage.getCustomerAttributeByTextboxId("Address_City"), adminData.getEditAddrCity());

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 26: Verify '" + adminData.getEditAddressStreet() + "' is displayed at 'Address 1' text box at Edit Address page");
        Assert.assertEquals(adminCustomersPage.getCustomerAttributeByTextboxId("Address_Address1"), adminData.getEditAddressStreet());

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 27: Verify '" + adminData.getEditAddrZipCode() + "' is displayed at 'Zip' text box at Edit Address page");
        Assert.assertEquals(adminCustomersPage.getCustomerAttributeByTextboxId("Address_ZipPostalCode"), adminData.getEditAddrZipCode());

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 28: Verify '" + adminData.getEditAddrPhoneNumber() + "' is displayed at 'Phone number' text box at Edit Address page");
        Assert.assertEquals(adminCustomersPage.getCustomerAttributeByTextboxId("Address_PhoneNumber"), adminData.getEditAddrPhoneNumber());

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 29: Click the 'back to customer details' link at Edit Address page");
        adminCustomersPage.clickToBackToCustomerLinkByText("back to customer details");

        ExtentTestManager.getTest().log(Status.INFO, "Edit New Address - Step 30: Verify '" + adminData.getEditAddrFirstName() + ", " + editAddrLastName + ", " + editAddrEmail + "' is displayed at Address Table at Customer Detail page");
        Assert.assertTrue(adminCustomersPage.isEditAddressDisplayed(adminData.getEditAddrFirstName(), editAddrLastName, editAddrEmail));
    }

    @Test
    public void TC_15_Delete_Address(Method method) {
        ExtentTestManager.startTest(method.getName(), "Delete a address in customer detail");

        ExtentTestManager.getTest().log(Status.INFO, "Delete Address - Step 01: Click 'Customers' at sidebar menu");
        adminDashboardPage.clickToAdminSubSidebarMenuByMenuText(driver, "Customers", "Customers");

        ExtentTestManager.getTest().log(Status.INFO, "Delete Address - Step 02: Input '" + adminData.getAddrFirstName() + "' into 'First name' text box at Customers page");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("SearchFirstName", adminData.getAddrFirstName());

        ExtentTestManager.getTest().log(Status.INFO, "Delete Address - Step 03: Input '" + addrLastName + "' into 'Last name' text box at Customers page");
        adminCustomersPage.inputToCustomerTextboxByTextboxId("SearchLastName", addrLastName);

        ExtentTestManager.getTest().log(Status.INFO, "Delete Address - Step 04: Unselect '" + "Registered" + "' option at 'Customer role' dropdown at Customers page");
        adminCustomersPage.unSelectCustomerRoleByText("Registered");

        ExtentTestManager.getTest().log(Status.INFO, "Delete Address - Step 05: Select '" + adminData.getCustomerRole() + "' option at 'Customer role' dropdown at Customers page");
        adminCustomersPage.selectCustomerRoleDropdown(adminData.getCustomerRole());

        ExtentTestManager.getTest().log(Status.INFO, "Delete Address - Step 06: Click the 'Search' button at Customers page");
        adminCustomersPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Delete Address - Step 07: Click the 'Edit' button by customer full name at Customers page");
        adminCustomersPage.clickToEditButtonByCustomerFullNameText(adminData.getAddrFirstName() + " " + addrLastName);

        ExtentTestManager.getTest().log(Status.INFO, "Delete Address - Step 08: Click the 'Address' tab at Customers Detail page");
        adminCustomersPage.clickToCustomerTabByTabName("Address");

        ExtentTestManager.getTest().log(Status.INFO, "Delete Address - Step 09: Click the 'Delete' button link at Customers Detail page");
        adminCustomersPage.clickToCustomerAddressButtonLinkByEmailAndText(editAddrEmail, "Delete");

        ExtentTestManager.getTest().log(Status.INFO, "Delete Address - Step 10: Click the 'OK' button to confirm delete process at alert");
        adminCustomersPage.acceptDeleteAlert();

        ExtentTestManager.getTest().log(Status.INFO, "Delete Address - Step 11: Click the 'Address' tab at Customers Detail page");
        adminCustomersPage.clickToCustomerTabByTabName("Address");

        ExtentTestManager.getTest().log(Status.INFO, "Delete Address - Step 12: Verify that the no data message is displayed");
        Assert.assertEquals(adminCustomersPage.getNoDataMessageTextAtAddressTable(), "No data available in table");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }

}
