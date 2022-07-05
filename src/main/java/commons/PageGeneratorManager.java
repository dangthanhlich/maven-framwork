package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.USerAddressPageObject;
import pageObjects.nopCommerce.user.USerCustomerInforPageObject;
import pageObjects.nopCommerce.user.USerHomePageObject;
import pageObjects.nopCommerce.user.USerLoginPageObject;
import pageObjects.nopCommerce.user.USerMyProductReviewPageObject;
import pageObjects.nopCommerce.user.USerRegisterPageObject;
import pageObjects.nopCommerce.user.USerRewardPointPageObject;

public class PageGeneratorManager {
	public static USerHomePageObject getUserHomePage(WebDriver driver) {
		return new USerHomePageObject(driver);
	}

	public static USerLoginPageObject getUserLoginPage(WebDriver driver) {
		return new USerLoginPageObject(driver);
	}

	public static USerRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new USerRegisterPageObject(driver);
	}

	public static USerCustomerInforPageObject getUserCustomerInforPage(WebDriver driver) {
		return new USerCustomerInforPageObject(driver);
	}

	public static USerAddressPageObject getUserAddressPage(WebDriver driver) {
		return new USerAddressPageObject(driver);
	}

	public static USerMyProductReviewPageObject getUserMyProductReviewPage(WebDriver driver) {
		return new USerMyProductReviewPageObject(driver);
	}

	public static USerCustomerInforPageObject getUserMyAccountPage(WebDriver driver) {
		return new USerCustomerInforPageObject(driver);
	}

	public static USerRewardPointPageObject getUserRewardPointPage(WebDriver driver) {
		return new USerRewardPointPageObject(driver);
	}

	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}

}
