package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

public class PageGenerateManager {
    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }

    public static NewCustomerPageObject getNewCustomerPage(WebDriver driver) {
        return new NewCustomerPageObject(driver);
    }

    public static CustomerRegisSuccessPageObject getCustomerRegisSuccessPage(WebDriver driver) {
        return new CustomerRegisSuccessPageObject(driver);
    }

    public static PreEditCustomerPageObject getPreEditCustomerPage(WebDriver driver) {
        return new PreEditCustomerPageObject(driver);
    }

    public static EditCustomerPageObject getEditCustomerPage(WebDriver driver) {
        return new EditCustomerPageObject(driver);
    }

    public static PreNewAccountPageObject getPreNewAccountPage(WebDriver driver) {
        return new PreNewAccountPageObject(driver);
    }

    public static NewAccountPageObject getNewAccountPage(WebDriver driver) {
        return new NewAccountPageObject(driver);
    }
}
