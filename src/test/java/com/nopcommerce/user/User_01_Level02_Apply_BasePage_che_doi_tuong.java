package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class User_01_Level02_Apply_BasePage_che_doi_tuong {
	WebDriver driver;
	String emailAddress;
	// Declare(khai bao)
	BasePage basePage;
	// basePage: Class
	// basePage: Object
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		// Initial(khoi tao)
		// che giấu đi việc khởi tạo của 1 đối tượng
		basePage = BasePage.getBasePageObject();

		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		// sẵn sàng click chưa
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"),
				"First name is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"),
				"Password is required.");

	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "FC");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", "###123");
		basePage.sendkeyToElement(driver, "//input[@id='Company']", "ABC");
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456789");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456789");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
	}

	@Test
	public void TC_03_Register_Success() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "FC");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendkeyToElement(driver, "//input[@id='Company']", "ABC");
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456789");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456789");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");

		basePage.waitForElementClickable(driver, "//a[@class='ico-logout']");
		basePage.clickToElement(driver, "//a[@class='ico-logout']");

	}

	@Test
	public void TC_04_Register_Existing_Email() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "FC");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendkeyToElement(driver, "//input[@id='Company']", "ABC");
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456789");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456789");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//div[contains(@class,'message-error')]//li"),
				"The specified email already exists");

	}

	@Test
	public void TC_05_Register_password_Less_Than_6_Chars() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "FC");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendkeyToElement(driver, "//input[@id='Company']", "ABC");
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"),
				"Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "FC");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendkeyToElement(driver, "//input[@id='Company']", "ABC");
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456789");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "1234567");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"),
				"The password and confirmation password do not match.");

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
