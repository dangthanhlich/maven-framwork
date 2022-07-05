package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.nopCommerce.user.USerHomePageObject;
import pageObjects.nopCommerce.user.USerRegisterPageObject;

public class Level_03_Page_Object2 {

	// declare
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;
	// declare + init
	private String projectPath = System.getProperty("user.dir");
	private USerHomePageObject homePage;
	private USerRegisterPageObject registerPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
		password = "123456";
		homePage = new USerHomePageObject(driver);
		registerPage = new USerRegisterPageObject(driver);
	}

	@Test
	public void TC_01_Register_Empty_Data() {

		// waitForAllElementClickable(driver, "//a[@class='ico-register']");
		// clickToElement(driver, "//a[@class='ico-register']");
		System.out.println("Home Page 01 - step 01 : click to register link");
		homePage.openRegisterPage();

		// waitForAllElementClickable(driver, "//button[@id='register-button']");
		// clickToElement(driver, "//button[@id='register-button']");
		System.out.println("Register Page 01 - step 02 : Click to register button");
		registerPage.clickToRegisterButton();

		// Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		// Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		// Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		// Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		// Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");

		System.out.println("Register Page 01 - Step 03 : click to register button");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		// waitForAllElementClickable(driver, "//a[@class='ico-register']");
		// clickToElement(driver, "//a[@class='ico-register']");
		System.out.println("Home Page 02- step 01 : click to register link");
		homePage.openRegisterPage();

		// sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		// sendkeyToElement(driver, "//input[@id='LastName']", "FC");
		// sendkeyToElement(driver, "//input[@id='Email']", "###123");
		// sendkeyToElement(driver, "//input[@id='Company']", "ABC");
		// sendkeyToElement(driver, "//input[@id='Password']", "123456789");
		// sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456789");
		System.out.println("Register Page 02- step 2 : input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox("###123");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		// waitForAllElementClickable(driver, "//button[@id='register-button']");
		// clickToElement(driver, "//button[@id='register-button']");
		System.out.println("Register Page 02- step 03 : Click to register button");
		registerPage.clickToRegisterButton();

		// Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
		System.out.println("Register Page 02- step 04 : verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void TC_03_Register_Success() {
		System.out.println("Home Page 03- step 01 : click to register link");
		homePage.openRegisterPage();

		System.out.println("Register Page 03- step 2 : input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		// registerPage.inputToCompanyTextbox("ABC");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register Page 03- step 03 : Click to register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page 03- step 04:verify success mssage displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Register Page 03- step 05:click to logout link");
		registerPage.clickToLogoutLink();

	}

	@Test
	public void TC_04_Register_Existing_Email() {
		System.out.println("Home Page 04- step 01 : click to register link");
		homePage.openRegisterPage();

		System.out.println("Register Page 04- step 2 : input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		// registerPage.inputToCompanyTextbox("ABC");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register Page 04- step 03 : Click to register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page 04- step 04:verify error existing message displayed");
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");

	}

	@Test
	public void TC_05_Register_password_Less_Than_6_Chars() {
		System.out.println("Home Page - step 01 : click to register link");
		homePage.openRegisterPage();

		System.out.println("Register Page 05- step 2 : input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		// registerPage.inputToCompanyTextbox("ABC");
		registerPage.inputToPasswordTextbox("123");
		registerPage.inputToConfirmPasswordTextbox("123");

		System.out.println("Register Page 05- step 03 : Click to register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page 05- step 04:verify error have at least 6 characters");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {
		System.out.println("Home Page 06- step 01 : click to register link");
		homePage.openRegisterPage();

		System.out.println("Register Page 06- step 2 : input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		// registerPage.inputToCompanyTextbox("ABC");
		registerPage.inputToPasswordTextbox("123456789");
		registerPage.inputToConfirmPasswordTextbox("1234567");

		System.out.println("Register Page 06- step 03 : Click to register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page 06- step 04:verify error have at least 6 characters");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
