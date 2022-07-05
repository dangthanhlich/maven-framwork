//package com.nopcommerce.user;
//
//import java.lang.reflect.Method;
//import java.util.Random;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.aventstack.extentreports.Status;
//
//import commons.BaseTest;
//import commons.PageGeneratorManager;
//import pageObjects.nopCommerce.user.USerAddressPageObject;
//import pageObjects.nopCommerce.user.USerCustomerInforPageObject;
//import pageObjects.nopCommerce.user.USerHomePageObject;
//import pageObjects.nopCommerce.user.USerLoginPageObject;
//import pageObjects.nopCommerce.user.USerMyProductReviewPageObject;
//import pageObjects.nopCommerce.user.USerRegisterPageObject;
//import pageObjects.nopCommerce.user.USerRewardPointPageObject;
//import reportConfig.ExtentTestManager;
//
//
//public class Level_16_ExtentV5_Screenshot extends BaseTest {
//
//	@Parameters("browser")
//	@BeforeClass
//	public void beforeClass(String browserName) {
//		driver = getBrowserDriver(browserName);
//
//		homePage = PageGeneratorManager.getUserHomePage(driver);
//
//		firstName = "Automation";
//		lastName = "FC";
//		emailAddress = "afc" + generateFakeNumber() + "@gmail.vn";
//		validPassword = "123456";
//
//	}
//	
//		@Test
//		public void User_01_Register(Method method) {
//		
//			ExtentTestManager.startTest(method.getName(), "Register to system");
//			ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: open page");
//
//			registerPage = homePage.openRegisterPage();
//			
//			ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Enter to Firstname textbox with value is '" + firstName + "'");
//			registerPage.inputToFirstnameTextbox(firstName);
//			
//			ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
//			registerPage.inputToLastNameTextbox(lastName);
//			
//			ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter to Email textbox with value is '" + emailAddress + "'");
//			registerPage.inputToEmailTextbox(emailAddress);
//
//			ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter to Password textbox with value is '" + validPassword + "'");
//			registerPage.inputToPasswordTextbox(validPassword);
//
//			ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Enter to Confirm Password textbox with value is '" + validPassword + "'");
//			registerPage.inputToConfirmPasswordTextbox(validPassword);
//
//			ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to 'Register' button");
//			registerPage.clickToRegisterButton();
//
//			ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08: Verify register success message is displayed");
//			Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
//
//
//			
//			}
//
//		@Test
//		public void User_02_Login(Method method) {
//			ExtentTestManager.startTest(method.getName(), "Login to system successfully");
//			ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Navigate to Login page");
//			homePage = registerPage.clickToLogoutLink();
//			loginPage = homePage.openLoginPage();
//
//			ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Enter to Email textbox with value is '" + emailAddress + "'");
//			loginPage.inputToEmailTextbox(emailAddress);
//
//			ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Enter to Password textbox with value is '" + validPassword + "'");
//			loginPage.inputToPasswordTextbox(validPassword);
//
//			ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to Login button");
//			homePage = loginPage.clickToLoginButton();
//
//			ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify 'My Account' link is displayed");
//			Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
//
//			ExtentTestManager.getTest().log(Status.INFO, "Login - Step 06: Navigate to 'My Account' page");
//			customerInforPage = homePage.openMyAccountPage();
//
//			ExtentTestManager.getTest().log(Status.INFO, "Login - Step 06: Verify 'Customer Infor' page is displayed");
//			Assert.assertFalse(customerInforPage.isCustomerInforPageDisplayed());
//
//		}
//		
//	@AfterClass
//	public void afterClass() {
//		driver.quit();
//	}
//
//	public int generateFakeNumber() {
//		Random rand = new Random();
//		return rand.nextInt(9999);
//	}
//
//	private WebDriver driver;
//	 USerHomePageObject homePage;
//	 USerRegisterPageObject registerPage;
//	 USerLoginPageObject loginPage;
//	 USerCustomerInforPageObject customerInforPage;
//	 USerAddressPageObject addressPage;
//	 USerMyProductReviewPageObject myProductReviewPage;
//	 USerRewardPointPageObject rewardPointPage;
//	 String firstName, lastName, emailAddress, validPassword;
//
//}
