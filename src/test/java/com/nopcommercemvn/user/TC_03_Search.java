package com.nopcommercemvn.user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommercemvn.usermvn.*;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class TC_03_Search extends BaseTest {
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getUserHomePage(driver);

        firstName = "dao";
        lastName = "dang";
        emailAddress = "afc" + generateFakeNumber() + "@gmail.vn";
        validPassword = "123456";
        invalidsearch = "product Macbook Pro 2025";
        nameProductSearch = "Lenovo";
        validnameProductSearch="ThinkPad X1 Carbon";
        searchKewordProduct="Apple MacBook Pro";

    }

    @Test
    public void Search_01_Register_user(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register to system");

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: open page");
        registerPage = homePage.openRegisterPage();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02:  Enter to Firstname textbox with value is '" + firstName + "'");
        registerPage.inputToFirstnameTextbox(firstName);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03:  Enter to LastName textbox with value is '" + lastName + "'");
        registerPage.inputToLastnameTextbox(lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04:  Enter to Email textbox with value is '" + emailAddress + "'");
        registerPage.inputToEmailTextbox(emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05:  Enter to validPassword textbox with value is '" + validPassword + "'");
        registerPage.inputToPasswordTextbox(validPassword);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06:  Enter to validPassword textbox with value is '" + validPassword + "'");
        registerPage.inputToConfirmPasswordTextbox(validPassword);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to button Register");
        registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08:  Verify register success message is displayed");
        verifyTrue(registerPage.isRegisterSuccessMessage("Your registration completed"));

    }

    @Test
    public void Search_02_Search_Empty_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search to system");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: click to Search");
        searchPage = registerPage.clickToSearchLink();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Click to buttun search ");
        searchPage.ClickToButtonSearch();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Verify  'Search term minimum length is 3 characters' message is displayed");
        verifyTrue(searchPage.isErrorMessage("Search term minimum length is 3 characters"));
    }

    @Test
    public void Search_03_Search_Data_not_Exist(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search to system");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Enter to Search textbox with value is '" + invalidsearch + "'");
        searchPage.inputToSearchTextbox(invalidsearch);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Click to buttun search ");
        searchPage.ClickToButtonSearch();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Verify  'No products were found that matched your criteria.' message is displayed");
        verifyTrue(searchPage.isErrorMessage("No products were found that matched your criteria."));
    }

    @Test
    public void Search_04_Search_Product_Name(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search to system");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Enter to Search textbox with value is '" + nameProductSearch + "'");
        searchPage.inputToSearchTextbox(nameProductSearch);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Click to buttun search ");
        searchPage.ClickToButtonSearch();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Verify  'Lenovo IdeaCentre 600 All-in-One PC' message is displayed");
        verifyTrue(searchPage.isProductSearch("Lenovo IdeaCentre 600 All-in-One PC"));

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Verify  'Lenovo IdeaCentre 600 All-in-One PC' message is displayed");
        verifyTrue(searchPage.isProductSearch("Lenovo Thinkpad X1 Carbon Laptop"));

    }

    @Test
    public void Search_05_Advanced_Search_Parent_Categories(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search to system");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Enter to Search textbox with value is '" + nameProductSearch + "'");
        searchPage.inputToSearchTextbox(validnameProductSearch);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Click to buttun search ");
        searchPage.ClickToButtonSearch();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Verify  'Lenovo IdeaCentre 600 All-in-One PC' message is displayed");
        verifyTrue(searchPage.isProductSearch("Lenovo Thinkpad X1 Carbon Laptop"));

    }

    @Test
    public void Search_06_Search_Sub_Categories(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search to system");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Enter to Search textbox with value is '" + searchKewordProduct + "'");
        searchPage.inputToSearchTextbox(searchKewordProduct);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Checkbox input 'Advanced Search: Checked' ");
        searchPage.checkboxToCheck();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Select 'Category: Computers' dropdown");
        searchPage.dropdownComputers("Computers");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: 'Automationcally search sub categories: checked' ");
        searchPage.UncheckboxToChecked();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Click to buttun search ");
        searchPage.ClickToButtonSearch();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 05: Verify  'Lenovo IdeaCentre 600 All-in-One PC' message is displayed");
        verifyTrue(searchPage.isErrorMessage("No products were found that matched your criteria."));

    }

    @Test
    public void Search_07_Advanced_Search_incorrect_Manufacturer(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search to system");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Enter to Search textbox with value is '" + searchKewordProduct + "'");
        searchPage.inputToSearchTextbox(searchKewordProduct);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Checkbox input 'Advanced Search: Checked' ");
        searchPage.checkboxToCheck();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Select 'Category: Computers' dropdown");
        searchPage.dropdownComputers("Computers");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: 'Automationcally search sub categories: checked' ");
        searchPage.checkboxToChecked();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Click to buttun search ");
        searchPage.ClickToButtonSearch();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Verify  'Apple MacBook Pro 13-inch' message is displayed");
        verifyTrue(searchPage.isProductSearch("Apple MacBook Pro 13-inch"));


    }

    @Test
    public void Search_08_Advanced_Search_InCorrect_Manufacturer(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search to system");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Enter to Search textbox with value is '" + searchKewordProduct + "'");
        searchPage.inputToSearchTextbox(searchKewordProduct);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Checkbox input 'Advanced Search: Checked' ");
        searchPage.checkboxToCheck();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Select 'Category: Computers' dropdown");
        searchPage.dropdownComputers("Computers");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: 'Automationcally search sub categories: checked' ");
        searchPage.checkboxToChecked();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Select 'Manufacturer:HP' dropdown");
        searchPage.dropdownManufacturer("HP");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Click to buttun search ");
        searchPage.ClickToButtonSearch();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 05: Verify  Search  message is displayed");
        verifyTrue(searchPage.isErrorMessage("No products were found that matched your criteria."));

    }

    @Test
    public void Search_09_Advanced_Search_Correct_Manufacturer(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search to system");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Enter to Search textbox with value is '" + searchKewordProduct + "'");
        searchPage.inputToSearchTextbox(searchKewordProduct);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Checkbox input 'Advanced Search: Checked' ");
        searchPage.checkboxToCheck();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Select 'Category: Computers' dropdown");
        searchPage.dropdownComputers("Computers");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: 'Automationcally search sub categories: checked' ");
        searchPage.checkboxToChecked();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Select 'Manufacturer:HP' dropdown");
        searchPage.dropdownManufacturer("Apple");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Click to buttun search ");
        searchPage.ClickToButtonSearch();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 05: Verify  Search  message is displayed");
        verifyTrue(searchPage.isProductSearch("Apple MacBook Pro 13-inch"));

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;
    USerHomePageObject homePage;
    USerRegisterPageObject registerPage;
    SearchPageObject searchPage;
    String  firstName, lastName, emailAddress, validPassword,invalidsearch,nameProductSearch,validnameProductSearch,searchKewordProduct;

}