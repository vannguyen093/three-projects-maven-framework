package commons;

import java.io.File;

public class GlobalConstants {
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("osName");
    public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
    public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
    public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
    public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "reportNGImage" + File.separator;

    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 30;
    public static final long RETRY_TEST_FAIL = 3;
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String BROWSER_NAME = "vannguyen_fXcelZ";
    public static final String BROWSER_ACCESS_KEY = "rg7tBFkEazjzz2kqmJoh";
    public static final String BROWSER_STACK_URL = "https://" + BROWSER_NAME + ":" + BROWSER_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public static final String USER_URL = "https://demo.nopcommerce.com/";
    public static final String ADMIN_URL = "https://admin-demo.nopcommerce.com/login";
}
