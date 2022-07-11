package pageObjects.nopCommercemvn.usermvn;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static USerHomePageObject getUserHomePage(WebDriver driver) {
        return new USerHomePageObject(driver);
    }

    public static USerRegisterPageObject getUserRegisterPage(WebDriver driver) {
        return new USerRegisterPageObject(driver);
    }

    public static USerLoginPageObject getUserLogiPage(WebDriver driver) {
        return new USerLoginPageObject(driver);
    }

    public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
        return new MyAccountPageObject(driver);
    }
    public static CustomerInforPageObject getCustomerInforPage(WebDriver driver) {
        return new CustomerInforPageObject(driver);
    }
    public static AddressesPageObject getAddressesPage(WebDriver driver) {
        return new AddressesPageObject(driver);
    }

    public static ChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
        return new ChangePasswordPageObject(driver);
    }

    public static ProductBooksPageObject getProductBooksPage(WebDriver driver) {
        return new ProductBooksPageObject(driver);
    }

    public static MyProductReviewsPageObject getMyProductReviewsPage(WebDriver driver) {
        return new MyProductReviewsPageObject(driver);
    }

}
