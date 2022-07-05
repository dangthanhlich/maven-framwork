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

public class Level_07_Switch_Page extends BaseTest {

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
	public void User_01_Register() {
		registerPage = homePage.openRegisterPage();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void User_02_Login() {
		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(validPassword);

		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void User_03_Customer_Infor() {
		customerInforPage = homePage.openMyAccountPage();
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
	}

	@Test
	public void User_04_Switch_page() {
		// knowledge của page object
		// một page A khi chuyển qua page B thì phải viết 1 hàm
		// (action : open /click/....: link /button/image/..) để mở page B đó lên

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
