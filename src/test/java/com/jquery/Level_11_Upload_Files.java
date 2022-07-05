package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.upLoadFile.HomePageObject;
import pageObjects.jQuery.upLoadFile.PageGeneratorManager;

public class Level_11_Upload_Files extends BaseTest {
	String cookaFileName ="cooka.jpg";
	String cookbFileName ="cookb.jpg";
	String cookcFileName ="cookc.jpg";
	String englishFileName ="english.jpg";
	String[] multipleFileNames = {cookaFileName,cookbFileName,cookcFileName,englishFileName};
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage =  PageGeneratorManager.getHomePage(driver);
		
	}

	@Test
	public void Upload_01_One_File_Per_Time() {
		//step 01 -load singlefile
		homePage.uploadMultipleFiles(driver, cookaFileName);
		//step 02 -] verify single file loaded success
		Assert.assertTrue(homePage.isFileLoadedByName(cookaFileName));
		//step 03 - click to start button
		homePage.clickToStartButton();
		//step 04 - verify single file link uploaded sucess
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(cookaFileName));
		//step 05 - verify single file image upload sucess
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(cookaFileName));
		
	}
	
	@Test
	public void Upload_02_Multiple_File_Per_Time() {
		//refresh trang thai
		homePage.refereshCurrentPage(driver);
		//step 01 -load multiple lefile
				homePage.uploadMultipleFiles(driver, multipleFileNames);
				//step 02 -] verify multiple file loaded success
				Assert.assertTrue(homePage.isFileLoadedByName(cookaFileName));
				Assert.assertTrue(homePage.isFileLoadedByName(cookbFileName));
				Assert.assertTrue(homePage.isFileLoadedByName(cookcFileName));
				Assert.assertTrue(homePage.isFileLoadedByName(englishFileName));
				//step 03 - click to start button
				homePage.clickToStartButton();
				//step 04 - verify multiple file link uploaded sucess
				Assert.assertTrue(homePage.isFileLinkUpLoadedByName(cookaFileName));
				Assert.assertTrue(homePage.isFileLinkUpLoadedByName(cookbFileName));
				Assert.assertTrue(homePage.isFileLinkUpLoadedByName(cookcFileName));
				Assert.assertTrue(homePage.isFileLinkUpLoadedByName(englishFileName));
				//step 05 - verify multiple file image upload sucess
				Assert.assertTrue(homePage.isFileImageUpLoadedByName(cookaFileName));
				Assert.assertTrue(homePage.isFileImageUpLoadedByName(cookbFileName));
				Assert.assertTrue(homePage.isFileImageUpLoadedByName(cookcFileName));
				Assert.assertTrue(homePage.isFileImageUpLoadedByName(englishFileName));
				
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private HomePageObject homePage;
}
