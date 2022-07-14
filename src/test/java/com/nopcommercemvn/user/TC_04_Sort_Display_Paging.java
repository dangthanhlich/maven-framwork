package com.nopcommercemvn.user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommercemvn.usermvn.PageGeneratorManager;
import pageObjects.nopCommercemvn.usermvn.SortDisplayPaingPageObject;
import pageObjects.nopCommercemvn.usermvn.USerHomePageObject;
import pageObjects.nopCommercemvn.usermvn.USerLoginPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;
import java.util.Random;

public class TC_04_Sort_Display_Paging extends BaseTest {

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        emailAddress = Common_01_Register.emailAddress;
        validPassword = Common_01_Register.validPassword;

        homePage = PageGeneratorManager.getUserHomePage(driver);

    }

    @Test
    public void Sort_Display_Paging_01_Login_User(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search to system");
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: open page");
        loginPage = homePage.openLoginPage();
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02:  Enter to Email textbox with value is '" + emailAddress + "'");
        loginPage.inputToEmailTextbox(emailAddress);
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03:  Enter to Password textbox with value is '" + validPassword + "'");
        loginPage.inputToPasswordTextbox(validPassword);
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to button Login");
        homePage = loginPage.clickToLoginButton();
    }

    @Test
    public void Sort_Display_Paging_02_Sort_Name_A_To_Z(Method method) {
        ExtentTestManager.startTest(method.getName(), "Sort to system");

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 01: Click to dropdown menu notebooks");
        sortdisplaypaingPage = homePage.dropdownNotebooks("Notebooks ");


        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 02: Click to dropdown menu notebooks");
        sortdisplaypaingPage.selectItemInProductSortDropdown("Name: A to Z");

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 03:verify Name A to Z is diplay");
        verifyTrue(sortdisplaypaingPage.isProductNameSortByAscending());

    }

//    @Test
//    public void Sort_Display_Paging_03_Sort_Name_Z_To_A(Method method) {
//        ExtentTestManager.startTest(method.getName(), "Sort to system");
//
//        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 01:  refresh page");
//        sortdisplaypaingPage.refereshCurrentPage(driver);
//
//
//        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 02: Click to dropdown menu notebooks");
//        sortdisplaypaingPage.selectItemInProductSortDropdown("Name: Z to A");
//
//        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 03:verify Name Z to A is diplay");
//        verifyTrue(sortdisplaypaingPage.isProductNameSortByDescending());
//
//    }

    @Test
    public void Sort_Display_Paging_04_Sort_Price_Low_To_High(Method method) {
        ExtentTestManager.startTest(method.getName(), "Sort to system");

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 01:  refresh page");
        sortdisplaypaingPage.refereshCurrentPage(driver);


        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 02: Click to dropdown menu notebooks");
        sortdisplaypaingPage.selectItemInProductSortDropdown("Price: Low to High");
        sortdisplaypaingPage.sleepInSecond(2);

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 03:verify Price: Low to High is diplay");
        verifyTrue(sortdisplaypaingPage.isProductPriceSortByAscendig());

    }


    @Test
    public void Sort_Display_Paging_05_Sort_Price_High_To_Low(Method method) {
        ExtentTestManager.startTest(method.getName(), "Sort to system");

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 01:  refresh page");
        sortdisplaypaingPage.refereshCurrentPage(driver);


        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 02: Click to dropdown menu notebooks");
        sortdisplaypaingPage.selectItemInProductSortDropdown("Price: High to Low");
        sortdisplaypaingPage.sleepInSecond(2);

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 03:verify Price: High to Low is diplay");
        verifyTrue(sortdisplaypaingPage.isProductPriceSortByDescending());

    }

    @Test
    public void Sort_Display_Paging_06_Display_3_product(Method method) {
        ExtentTestManager.startTest(method.getName(), "Display to system");

        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 01:  refresh page");
        sortdisplaypaingPage.refereshCurrentPage(driver);


        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 02: Click to dropdown products");
        sortdisplaypaingPage.selectNumberInProductSortDropdown("3");
        sortdisplaypaingPage.sleepInSecond(2);

//        ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 03:verify Price: High to Low is diplay");
//        verifyTrue(sortdisplaypaingPage.isCountProductNumberSortByDescending());


    }

//    @Test
//    public void Sort_Display_Paging_07_Display_6_product(Method method) {
//        ExtentTestManager.startTest(method.getName(), "Display to system");
//
//        ExtentTestManager.getTest().log(Status.INFO, "Display - Step 01: Enter to Search textbox with value is ");
//
//    }
//
//
//    @Test
//    public void Sort_Display_Paging_08_Display_9_product(Method method) {
//        ExtentTestManager.startTest(method.getName(), "Display to system");
//
//        ExtentTestManager.getTest().log(Status.INFO, "Display - Step 01: Enter to Search textbox with value is ");
//
//    }

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
    USerLoginPageObject loginPage;
    SortDisplayPaingPageObject sortdisplaypaingPage;
    String firstName, lastName, emailAddress, validPassword,inemailAddress,invalidPassword,inValidEmailAddress;

}
