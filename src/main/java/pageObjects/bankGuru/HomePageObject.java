package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isWelcomeMessageDisplayed() {
        waitForElementVisible(driver, HomePageUI.WELCOME_HEADER);
        return isElementDisplayed(driver, HomePageUI.WELCOME_HEADER);
    }

}
