package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class NewAccountPageObject extends BasePage {
    WebDriver driver;

    public NewAccountPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
