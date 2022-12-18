package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class PreNewAccountPageObject extends BasePage {
    WebDriver driver;

    public PreNewAccountPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
