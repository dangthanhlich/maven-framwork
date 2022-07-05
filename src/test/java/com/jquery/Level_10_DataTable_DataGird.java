package com.jquery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.dataTable.HomePageObject;
import pageObjects.jQuery.dataTable.PageGeneratorManager;

public class Level_10_DataTable_DataGird extends BaseTest {
	HomePageObject homePage;
	List<String> actualAllCountryValues;
	List<String> expectedAllCountryValues;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	public void Table_01_Paging() {
		//https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/
		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.isPageNumberActived("10"));

		homePage.openPagingByPageNumber("20");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.isPageNumberActived("20"));

		homePage.openPagingByPageNumber("7");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.isPageNumberActived("7"));

		homePage.openPagingByPageNumber("18");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.isPageNumberActived("18"));

	}

	public void Table_02_Enter_To_Header() {
		// search_header
		// tránh dữ liệu bị refresh lại
		homePage.refereshCurrentPage(driver);

		homePage.enterToHeaderTextboxByLabel("Country", "Argentina");
		homePage.enterToHeaderTextboxByLabel("Females", "338282");
		homePage.enterToHeaderTextboxByLabel("Males", "349238");
		homePage.enterToHeaderTextboxByLabel("Total", "687522");
		homePage.sleepInSecond(3);

		homePage.enterToHeaderTextboxByLabel("Country", "Antigua and Barbuda");
		homePage.enterToHeaderTextboxByLabel("Females", "777");
		homePage.enterToHeaderTextboxByLabel("Males", "803");
		homePage.enterToHeaderTextboxByLabel("Total", "1580");
		homePage.sleepInSecond(3);
	}

	
	public void Table_03_Enter_To_Header() {
		// chạy từng page (vòng lặp)
		// quét dữ liệu cell/row/column lưu lại vào list (arrayList)

		actualAllCountryValues = homePage.getValueEachRowAtAllPage();
		Assert.assertEquals(actualAllCountryValues, expectedAllCountryValues);

	}
	
	@Test
	public void Table_04_Enter_to_Textbox_At_Any_Row(){
		homePage.clickToLoadButton();
		homePage.sleepInSecond(5);
		
		//https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/
		//value de nhap lieu - tham so 1
		//row number :tai row nao
		//Ex:nhap vao textbox tai dong so 3/5/2
		//column name :Album/Artist/year/price
		
//		homePage.enterToTextboxByColumnNameAtRowNumber("Album","1","Michael 97");
//		homePage.sleepInSecond(2);
//		homePage.enterToTextboxByColumnNameAtRowNumber("Artist","1","Michael jackson");
//		homePage.sleepInSecond(2);
//		homePage.enterToTextboxByColumnNameAtRowNumber("Year","1","1997");
//		homePage.sleepInSecond(2);
//		homePage.enterToTextboxByColumnNameAtRowNumber("Price","1","150");
//		homePage.sleepInSecond(2);
//		homePage.selectDropdownByColumnNameAtRowNumber("Origin", "5", "Japan");
//	
//		homePage.checkToCheckboxByColumnNameAtRowNumber("With Poster?","3");
//		homePage.checkToCheckboxByColumnNameAtRowNumber("With Poster?","5");
//		
//		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?","1");
//		homePage.sleepInSecond(2);
//		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?","2");
//		homePage.sleepInSecond(2);
//		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?","4");
//		homePage.sleepInSecond(2);
		
		homePage.clickToIconByRowNumber("1","Remove Current Row");
		homePage.sleepInSecond(1);
		homePage.clickToIconByRowNumber("1","Insert Row Above");
		homePage.sleepInSecond(1);
		homePage.clickToIconByRowNumber("3","Move Up");
		homePage.sleepInSecond(1);
		
		homePage.clickToIconByRowNumber("5","Remove Current Row");
		homePage.sleepInSecond(1);
		homePage.clickToIconByRowNumber("4","Remove Current Row");
		homePage.sleepInSecond(1);
		homePage.clickToIconByRowNumber("3","Remove Current Row");
		homePage.sleepInSecond(1);
		homePage.clickToIconByRowNumber("2","Remove Current Row");
		homePage.sleepInSecond(1);
		homePage.clickToIconByRowNumber("1","Remove Current Row");
		homePage.sleepInSecond(1);
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
}
