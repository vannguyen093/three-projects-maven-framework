package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGenerateManager {
    public static UserHomePO getUserHomePage(WebDriver driver) {
        return new UserHomePO(driver);
    }

    public static UserLoginPO getUserLoginPage(WebDriver driver) {
        return new UserLoginPO(driver);
    }

    public static UserRegisterPO getUserRegisterPage(WebDriver driver) {
        return new UserRegisterPO(driver);
    }

    public static UserCustomerInfoPO getUserCustomerInfoPage(WebDriver driver) {
        return new UserCustomerInfoPO(driver);
    }

    public static UserAddressesPO getUserAddressesPage(WebDriver driver) {
        return new UserAddressesPO(driver);
    }

    public static UserChangePassPO getUserChangePassPage(WebDriver driver) {
        return new UserChangePassPO(driver);
    }

    public static UserProductPO getUserProductPage(WebDriver driver) {
        return new UserProductPO(driver);
    }

    public static UserProductDetailPO getUserProductDetailPage(WebDriver driver) {
        return new UserProductDetailPO(driver);
    }

    public static UserProductReviewPO getUserProductReviewPage(WebDriver driver) {
        return new UserProductReviewPO(driver);
    }

    public static UserMyProductReviewsPO getUserMyProductReviewsPage(WebDriver driver) {
        return new UserMyProductReviewsPO(driver);
    }

    public static UserSearchPO getUserSearchPage(WebDriver driver) {
        return new UserSearchPO(driver);
    }

    public static UserWishlistPO getUserWishlistPage(WebDriver driver) {
        return new UserWishlistPO(driver);
    }

    public static UserCartPO getUserCartPage(WebDriver driver) {
        return new UserCartPO(driver);
    }

    public static UserComparePO getUserComparePage(WebDriver driver) {
        return new UserComparePO(driver);
    }

    public static UserRecentViewPO getUserRecentViewPage(WebDriver driver) {
        return new UserRecentViewPO(driver);
    }

    public static UserCheckOutPO getUserCheckOutPage(WebDriver driver) {
        return new UserCheckOutPO(driver);
    }

    public static UserOrdersPO getUserOrdersPage(WebDriver driver) {
        return new UserOrdersPO(driver);
    }

    public static UserOrdersDetailPO getUserOrdersDetailPage(WebDriver driver) {
        return new UserOrdersDetailPO(driver);
    }

    public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPO(driver);
    }

    public static AdminDashboardPO getAdminDashboardPage(WebDriver driver) {
        return new AdminDashboardPO(driver);
    }

    public static AdminProductsPO getAdminProductsPage(WebDriver driver) {
        return new AdminProductsPO(driver);
    }
    public static AdminProductsDetailPO getAdminProductsDetailPage(WebDriver driver) {
        return new AdminProductsDetailPO(driver);
    }
    public static AdminCustomersPO getAdminCustomersPage(WebDriver driver) {
        return new AdminCustomersPO(driver);
    }
}
