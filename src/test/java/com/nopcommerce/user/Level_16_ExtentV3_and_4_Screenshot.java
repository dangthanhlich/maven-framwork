package com.nopcommerce.user;

import java.lang.reflect.Method;
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


public class Level_16_ExtentV3_and_4_Screenshot extends BaseTest {

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
		public void User_01_Register(Method method) {
		
			registerPage = homePage.openRegisterPage();
			
			registerPage.inputToFirstnameTextbox(firstName);
			
			registerPage.inputToLastNameTextbox(lastName);
			
		    registerPage.inputToEmailTextbox(emailAddress);
			
			registerPage.inputToPasswordTextbox(validPassword);
			
			registerPage.inputToConfirmPasswordTextbox(validPassword);
			
			registerPage.clickToRegisterButton();

			Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

			
			}

		@Test
		public void User_02_Login(Method method) {
			homePage = registerPage.clickToLogoutLink();
			
			loginPage = homePage.openLoginPage();

			loginPage.inputToEmailTextbox(emailAddress);
			
			loginPage.inputToPasswordTextbox(validPassword);
			
			homePage = loginPage.clickToLoginButton();
			
			Assert.assertFalse(homePage.isMyAccountLinkDisplayed());

			customerInforPage = homePage.openMyAccountPage();
			
			Assert.assertFalse(customerInforPage.isCustomerInforPageDisplayed());
		
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
	 USerHomePageObject homePage;
	 USerRegisterPageObject registerPage;
	 USerLoginPageObject loginPage;
	 USerCustomerInforPageObject customerInforPage;
	 USerAddressPageObject addressPage;
	 USerMyProductReviewPageObject myProductReviewPage;
	 USerRewardPointPageObject rewardPointPage;
	 String firstName, lastName, emailAddress, validPassword;

}
