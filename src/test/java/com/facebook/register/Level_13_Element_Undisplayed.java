package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.Facebook.LoginPageObject;
import pageObjects.Facebook.PageGeneratorManager;

public class Level_13_Element_Undisplayed extends BaseTest {
	private LoginPageObject loginPage;
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}

	@Test
	public void TC_01_Verify_Element_Displayed() {
		loginPage.clickToCreateNewAccountButton();
		//nếu 1 hàm chỉ mong đợi để verify element displayed thôi - kết hợp cả wait + isDisplayed
		//waitForElementVisible
		//isElementDisplayed
		verifyTrue(loginPage.isEmailAddressTextboxDisplayed());
		
		//verify true - mong đợi confirm Email displayed(true)
		loginPage.enterToEmailAddressTextbox("automationfc@gmail.com");
		loginPage.sleepInSecond(2);
		verifyTrue(loginPage.isConfirmEmailAddressTextboxDisplayed());
		
	}
	
	@Test
	public void TC_02_Verify_Element_Undisplayed_In_Dom() {
		//verify true - cho hàm trả về là Undisplayed
		//nếu như mình mong đợi 1 cái hàm verify displayed /undisplayed thì không kết hợp wait
		//waitForElementVisible
		//isElementDisplayed
		
	
		
		//veryfy false- mong đợi confirm Email undisplayed(false)
		loginPage.enterToEmailAddressTextbox("");
		loginPage.sleepInSecond(3);
		verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed());
		
	}
	
	@Test
	public void TC_03_Verify_Element_Undisplayed_Not_In_Dom() {
		loginPage.clickCloseIconAtRegisterForm();
		loginPage.sleepInSecond(2);
		
		//khi close cái form Register đi thì confirm Email không còn trong DOM nữa
		//Nên hàm findElement dẽ bị fail vì không tìm thấy element
		//1 - nó sẽ chờ heeys timeout sẽ bị fail vì không tìm thấy elemnt
		//2 - nó sẽ đánh dail testcase tại đúng step này luôn
		//3 - không có chạy các step còn lại nữa
		
		//verify False - mong đợi confirm Email undisplayed (false)
		//isDisplayed L bản chất không kiểm tra 1 element không có trong DOM được
		//verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed());
		
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());

	}

	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
}
