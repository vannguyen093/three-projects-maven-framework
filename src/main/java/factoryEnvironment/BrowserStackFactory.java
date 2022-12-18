package factoryEnvironment;

import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackFactory {
    private WebDriver driver;
    private String browserName;
    private String osName;
    private String osVersion;

    public BrowserStackFactory(String browserName, String osName, String osVersion) {
        this.browserName = browserName;
        this.osName = osName;
        this.osVersion = osVersion;
    }

    public WebDriver createDriver() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", osName);
        caps.setCapability("os_version", osVersion);
        caps.setCapability("browser", browserName);
        caps.setCapability("project", "NopCommerce");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("name", "Run on " + osName + " | " + osVersion + " | " + browserName);
        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.BROWSER_STACK_URL), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
