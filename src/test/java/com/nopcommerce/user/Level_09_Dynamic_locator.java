package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.USerAddressPageObject;
import pageObjects.nopCommerce.user.USerCustomerInforPageObject;
import pageObjects.nopCommerce.user.USerHomePageObject;
import pageObjects.nopCommerce.user.USerLoginPageObject;
import pageObjects.nopCommerce.user.USerMyProductReviewPageObject;
import pageObjects.nopCommerce.user.USerRegisterPageObject;
import pageObjects.nopCommerce.user.USerRewardPointPageObject;

public class Level_09_Dynamic_locator extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.vn";
		validPassword = "123456";

	}

	@Test
	public void User_01_Register_Login() {
		registerPage = homePage.openRegisterPage();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToLogoutLink();

		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(validPassword);

		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		customerInforPage = homePage.openMyAccountPage();
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
	}

	@Test
	public void User_02_Dynamic_page_01() {
		// Customer Infor -> Address
		addressPage = customerInforPage.openAddressPage(driver);

		// Address->My Product review
		myProductReviewPage = addressPage.openMyProductReviewPage(driver);

		// reward point -> address
		// addressPage = rewardPointPage.openAddressPage(driver);

		// Address -> reward point
		rewardPointPage = addressPage.openRewardPointPage(driver);

		// reward point -> My product review
		myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);

		// My Product Review ->Address
		addressPage = myProductReviewPage.openAddressPage(driver);

		customerInforPage = addressPage.openCustomerInforPage(driver);

		myProductReviewPage = customerInforPage.openMyProductReviewPage(driver);

	}

	@Test
	public void User_02_Dynamic_page_02() {
		// Address -> reward point
		rewardPointPage = (USerRewardPointPageObject) myProductReviewPage.openPageAtMyAccountByName(driver, "Reward points");

		addressPage = (USerAddressPageObject) rewardPointPage.openPageAtMyAccountByName(driver, "Addresses");

		rewardPointPage = (USerRewardPointPageObject) addressPage.openPageAtMyAccountByName(driver, "Reward points");

		myProductReviewPage = (USerMyProductReviewPageObject) rewardPointPage.openPageAtMyAccountByName(driver, "My product reviews");

		customerInforPage = (USerCustomerInforPageObject) myProductReviewPage.openPageAtMyAccountByName(driver, "Customer info");

	}

	@Test
	public void User_02_Dynamic_page_03() {
		// customerInforPage->myProductReviewPage
		customerInforPage.openPageAtMyAccountByPageName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);

		// customerInforPage->myProductReviewPage
		myProductReviewPage.openPageAtMyAccountByPageName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);

		rewardPointPage.openPageAtMyAccountByPageName(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);

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
	private USerHomePageObject homePage;
	private USerRegisterPageObject registerPage;
	private USerLoginPageObject loginPage;
	private USerCustomerInforPageObject customerInforPage;
	private USerAddressPageObject addressPage;
	private USerMyProductReviewPageObject myProductReviewPage;
	private USerRewardPointPageObject rewardPointPage;
	private String firstName, lastName, emailAddress, validPassword;

}
