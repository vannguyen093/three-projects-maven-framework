package pageObjects.liveGuru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class UserHomePageObject extends BasePage {
    WebDriver driver;

    public UserHomePageObject(WebDriver driver) {
        this.driver = driver;
    }

}
