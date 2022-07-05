package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.USerCustomerInforPageObject;
import pageObjects.nopCommerce.user.USerHomePageObject;
import pageObjects.nopCommerce.user.USerLoginPageObject;

public class Level_08_Switch_Page extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		userEmailAddress = "poi@gmail.com";
		userPassword = "123456";
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";

	}

	// @Test
	// public void Role_01_User_To_Admin() {
	// userLoginPage = userHomePage.openLoginPage();
	//
	// // Login as user role
	// userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
	//
	// Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	// }
	//
	// @Test
	// public void Role_02_Admin_To_User() {
	//
	// userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
	// adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
	// adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
	//
	// Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());
	// }

	@Test
	public void Role_01_User_To_Admin() {
		userLoginPage = userHomePage.openLoginPage();

		// Login as user role
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);

		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

		// home page -> customer Infor
		userCustomerInfoPage = userHomePage.openMyAccountPage();

		// customer Infor ->click logout -> Home Page
		userHomePage = userCustomerInfoPage.clickToLogoutLinkUserPage(driver);

		// user home page -> open admin page -> login page admin
		userHomePage.openPageUrl(driver, GlobalConstants.PORTAL_DEV_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		// login as admin role
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);

		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());

		// Dashboard page -> Click logout -> login page (admin)
		adminLoginPage = adminDashboardPage.clickToLogoutLinkAdminPage(driver);

	}

	@Test
	public void Role_02_Admin_To_User() {
		// Login page (admin) -> open user url -> home page(user)
		adminLoginPage.openPageUrl(driver, GlobalConstants.PORTAL_DEV_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		// Home page -> login page(user)
		userLoginPage = userHomePage.openLoginPage();

		// Login as user role
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	private WebDriver driver;
	private USerHomePageObject userHomePage;
	private USerLoginPageObject userLoginPage;
	private USerCustomerInforPageObject userCustomerInfoPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private String userEmailAddress, userPassword, adminEmailAddress, adminPassword;
}
