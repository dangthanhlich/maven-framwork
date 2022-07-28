package com.nopcommercemvn.admin;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommercemvn.adminmvn.*;
import reportConfig.ExtentTestManager;


import java.lang.reflect.Method;
import java.util.Random;

public class TC_01_Admin extends BaseTest {

    String adminUrl, endUserUrl;
    String emailAddress = "admin@yourstore.com";
    String Password ="admin";

    String EmailCustomer="aaautometionafc" + generateFakeNumber() + "@gmail.vn";
    String passwordCustomer="123456789";
    String firstName="automation";
    String lastName="autofc";
    String DateCustomer="1/1/2000";
    String companyName="Automation FC";
    String addCustomerComment="Automation FC Comment";

    @Parameters({ "browser", "urlAdmin", "urlUser" })
    @BeforeClass
    public void beforeClass(String browserName, String adminUrl, String endUserUrl) {
        this.adminUrl = adminUrl;
        this.endUserUrl = endUserUrl;
        driver = getBrowserDriver(browserName, adminUrl);
        adminPage = PageGeneratorManager.getAdminPage(driver);
    }

    @Test
    public void Admin_01_Login(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login to system");
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01:  Enter to Email textbox with value is '" + emailAddress + "'");
        adminPage.inputToEmailTextbox(emailAddress);
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02:  Enter to Password textbox with value is '" + Password + "'");
        adminPage.inputToPasswordTextbox(Password);
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Click to button Login");
        adminPage.clickToLoginButton();
   }

    @Test
    public void Admin_02_Search_With_Product_Name(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search products to system");
        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01:  click to dropdown products");
        productsPage =adminPage.clickToDropdown("Products");
        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02:  Enter to Email textbox with value is product name");
        productsPage.inputToEmailTextbox("Lenovo IdeaCentre 600 All-in-One PC");
        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Click to search button");
        productsPage.clickToSearchButton();
        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Verify Product name is requied");
        verifyTrue(productsPage.isProductsDetailDisplayed("Lenovo IdeaCentre 600 All-in-One PC"));
        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 05: Verify Product SKU is requied");
        verifyTrue(productsPage.isProductsDetailDisplayed("LE_IC_600"));
        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 06: Verify Product Price is requied");
        verifyTrue(productsPage.isProductsDetailDisplayed("500"));
        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 07: Verify Product Stock quantity is requied");
        verifyTrue(productsPage.isProductsDetailDisplayed("10000"));
    }

    @Test
    public void Admin_03_Search_With_Product_Name_parent_Catefory_unChecked(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search products to system");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01:  Enter to Email textbox with value is product name");
        productsPage.inputToEmailTextbox("Lenovo IdeaCentre 600 All-in-One PC");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02:  click to dropdown category");
        productsPage.clickToDropdown("Computers");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03:  click to Checkbox");
        productsPage.unclickToCheckbox();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Click to search button");
        productsPage.clickToSearchButton();
        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 05: Verify message No data available in table ");
        verifyTrue(productsPage.isMessageisDisplayed("No data available in table"));
    }

    @Test
    public void Admin_04_Search_With_Product_Name_parent_Catefory_Checked(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search products to system");

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01:  Enter to Email textbox with value is product name");
        productsPage.inputToEmailTextbox("Lenovo IdeaCentre 600 All-in-One PC");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02:  click to dropdown category");
        productsPage.clickToDropdown("Computers");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03:  click to Checkbox");
        productsPage.clickToCheckbox();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Click to search button");
        productsPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 05: Verify Product name is requied");
        verifyTrue(productsPage.isProductsDetailDisplayed("Lenovo IdeaCentre 600 All-in-One PC"));
    }

    @Test
    public void Admin_05_Search_With_Product_Name_Child_Category(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search products to system");

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01:  Enter to Email textbox with value is product name");
        productsPage.inputToEmailTextbox("Lenovo IdeaCentre 600 All-in-One PC");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02:  click to dropdown category");
        productsPage.clickToDropdown("Computers >> Desktops");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03:  click to Checkbox");
        productsPage.clickToCheckbox();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Click to search button");
        productsPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 05: Verify Product name is requied");
        verifyTrue(productsPage.isProductsDetailDisplayed("Lenovo IdeaCentre 600 All-in-One PC"));
    }

    @Test
    public void Admin_06_Search_With_Product_Name_Manufacturer(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search products to system");

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01:  Enter to Email textbox with value is product name");
        productsPage.inputToEmailTextbox("Lenovo IdeaCentre 600 All-in-One PC");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02:  click to dropdown category");
        productsPage.clickToDropdown("All");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03:  click to Checkbox");
        productsPage.unclickToCheckbox();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02:  click to dropdown Manufacturer");
        productsPage.clickToDropdownManufacturer("Apple");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02:  click to dropdown Vendor");
        productsPage.clickToDropdownVendor("All");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Click to search button");
        productsPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 05: Verify Product name is requied");
        verifyTrue(productsPage.isProductsDetailDisplayed("Lenovo IdeaCentre 600 All-in-One PC"));
    }

    @Test
    public void Admin_07_Go_directly_to_product_SKU(Method method) {
        //productDetailPage
        ExtentTestManager.startTest(method.getName(), "Details products to system");

        ExtentTestManager.getTest().log(Status.INFO, "Dtails - Step 01:  Click to Edit button");
        productDetailPage = productsPage.clickToEditButton("Lenovo IdeaCentre 600 All-in-One PC");

//        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 05: Verify Product name is requied");
//        verifyTrue(productsPage.isDetailProductsDisplayed("Lenovo IdeaCentre 600 All-in-One PC"));
    }

    @Test
    public void Admin_08_Create_new_Customer(Method method) {
        ExtentTestManager.startTest(method.getName(), "Customer to system");
        ExtentTestManager.getTest().log(Status.INFO, "Customer - Step 01:  click to customer link");
        customerPage =productsPage.clickToCustomer();

        ExtentTestManager.getTest().log(Status.INFO, "Customer - Step 02:  click to Add new button");
        customerPage.clickToAddNew();

        ExtentTestManager.getTest().log(Status.INFO, "Customer - Step 03:  enter to Email");
        customerPage.enterToEmail(EmailCustomer);

        ExtentTestManager.getTest().log(Status.INFO, "Customer - Step 04:  enter to Password");
        customerPage.enterToPassword(passwordCustomer);

        ExtentTestManager.getTest().log(Status.INFO, "Customer - Step 05:  enter to firstname");
        customerPage.enterToFirstName(firstName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer - Step 06:  enter to lastname");
        customerPage.enterToLastName(lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer - Step 07:  Click to gender radio");
        customerPage.clickToGenderRadio("Male");

        ExtentTestManager.getTest().log(Status.INFO, "Customer - Step 08: Enter to Date");
        customerPage.enterToDateOfbirth(DateCustomer);

        ExtentTestManager.getTest().log(Status.INFO, "Customer - Step 09: enter to company name");
        customerPage.enterToCompanyName(companyName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer - Step 10: click to customer role dropdown");
        customerPage.clickToCustomerDropdownItem();

        ExtentTestManager.getTest().log(Status.INFO, "Customer - Step 11: Click To Active checkbox");
        customerPage.clickToActiveCheckbox();

        ExtentTestManager.getTest().log(Status.INFO, "Customer - Step 12: Enter admin comment");
        customerPage.adminCommentTextarea(addCustomerComment);

        ExtentTestManager.getTest().log(Status.INFO, "Customer - Step 13: Click to save continue Edit");
        customerPage.clickToSaveCContinueEdit();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 14: Verify message added sucessfully");
        verifyTrue(customerPage.isMessageAddedDisplayed("The new customer has been added successfully."));

        ExtentTestManager.getTest().log(Status.INFO, "Customer - Step 15: Click to back to customer list");
        customerPage.clickTobackCustomerList();

        ExtentTestManager.getTest().log(Status.INFO, "Customer - Step 09: enter to company name");
        customerPage.searchToCompanyName(companyName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer - Step 16: Enter tu customer role ");
        customerPage.EnterToCustomerRole();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 17: Click to search button");
        customerPage.clickToSearchCustomerButton();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 18: Verify company is display");
        verifyTrue(customerPage.isCompanyDisplayed(companyName));
    }


    @Test
    public void Admin_10_Search_Customer_With_First_Last_Name(Method method) {

    }

    @Test
    public void Admin_11_Search_Customer_Company(Method method) {

    }

    @Test
    public void Admin_12_Search_Customer_And_Full_Data(Method method) {

    }

    @Test
    public void Admin_13_Edit_Customer(Method method) {

    }

    @Test
    public void Admin_14_Add_New_Address_In_Customer_Detail(Method method) {

    }

    @Test
    public void Admin_15_Edit_Address_in_Cutomer_Detail(Method method) {

    }

    @Test
    public void Admin_16_Delete_Address_in_Customer_Detail(Method method) {

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
    AdminPageObject adminPage;
    ProductsPageObject productsPage;
    ProductDetailPageObject productDetailPage;
    CustomerPageObject customerPage;
}
