package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGenerateManager {
    public static UserHomePageObject getUserHomePage(WebDriver driver){
        return new UserHomePageObject(driver);
    }
    public static UserLoginPageObject getUserLoginPage(WebDriver driver){
        return new UserLoginPageObject(driver);
    }
    public static UserRegisterPageObject getUserRegisterPage(WebDriver driver){
        return new UserRegisterPageObject(driver);
    }
    public static UserMyDashboardPageObject getUserMyDashboardPage(WebDriver driver){
        return new UserMyDashboardPageObject(driver);
    }
    public static UserAccountInfoPageObject getUserAccountInfoPage(WebDriver driver){
        return new UserAccountInfoPageObject(driver);
    }
    public static UserMobilePageObject getUserMobilePage(WebDriver driver){
        return new UserMobilePageObject(driver);
    }
    public static UserProductDetailPageObject getUserProductDetailPage(WebDriver driver){
        return new UserProductDetailPageObject(driver);
    }
    public static UserCartPageObject getUserCartPage(WebDriver driver){
        return new UserCartPageObject(driver);
    }
    public static UserCompareWindowPageObject getUserCompareWindowPage(WebDriver driver){
        return new UserCompareWindowPageObject(driver);
    }
    public static UserTVPageObject getUserTVPage(WebDriver driver){
        return new UserTVPageObject(driver);
    }
    public static UserWishlistPageObject getUserWishlistPage(WebDriver driver){
        return new UserWishlistPageObject(driver);
    }
    public static UserReviewPageObject getUserReviewPage(WebDriver driver){
        return new UserReviewPageObject(driver);
    }
    public static UserCheckOutPageObject getUserCheckOutPage(WebDriver driver){
        return new UserCheckOutPageObject(driver);
    }
    public static UserSuccessCheckOutPageObject getUserSuccessCheckOutPage(WebDriver driver){
        return new UserSuccessCheckOutPageObject(driver);
    }
    public static UserAdvancedSearchPageObject getUserAdvancedSearchPage(WebDriver driver){
        return new UserAdvancedSearchPageObject(driver);
    }
    public static UserSearchResultPageObject getUserSearchResultPage(WebDriver driver){
        return new UserSearchResultPageObject(driver);
    }
    public static AdminLoginPageObject getAdminLoginPage(WebDriver driver){
        return new AdminLoginPageObject(driver);
    }
    public static AdminHomePageObject getAdminHomePage(WebDriver driver){
        return new AdminHomePageObject(driver);
    }
    public static AdminOrderPageObject getAdminOrderPage(WebDriver driver){
        return new AdminOrderPageObject(driver);
    }
    public static AdminDownloadedOrderTabPageObject getAdminDownloadedOrderTabPage(WebDriver driver){
        return new AdminDownloadedOrderTabPageObject(driver);
    }
    public static AdminPendingReviewPageObject getAdminPendingReviewPage(WebDriver driver){
        return new AdminPendingReviewPageObject(driver);
    }
    public static AdminEditPendingReviewPageObject getAdminEditPendingReviewPage(WebDriver driver){
        return new AdminEditPendingReviewPageObject(driver);
    }
    public static AdminInvoicePageObject getAdminInvoicePage(WebDriver driver){
        return new AdminInvoicePageObject(driver);
    }
}
