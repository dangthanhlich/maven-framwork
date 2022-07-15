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
import java.util.Random;

public class TC_06_Order extends BaseTest {
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        emailAddress = Common_01_Register.emailAddress;
        validPassword = Common_01_Register.validPassword;

        homePage = PageGeneratorManager.getUserHomePage(driver);
        numbercart = "2";

    }

    @Test
    public void Order_01_Login_User(Method method) {
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
    public void Order_02_Add_Product_To_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Product To Cart to system");
        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart - Step 01: open page");

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 01: Click to dropdown menu notebooks");
        sortdisplaypaingPage = homePage.dropdowndesktops("Desktops ");

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 03: Click to products name 1");
        detailProductsPage = sortdisplaypaingPage.clickToProductName("Build your own computer");

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 04: Select 'processor' dropdown");
        detailProductsPage.dropdownProcessor("2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 05: Select 'RAM' dropdown");
        detailProductsPage.dropdownRam("2 GB");

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 06: Choose HDD Checkbox ");
        detailProductsPage.checkboxradiotoHdd("400 GB [+$100.00]");

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 07: Choose OS Checkbox ");
        detailProductsPage.checkboxradiotoOs("Vista Home [+$50.00]");

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 08: Choose software Checkbox ");
        detailProductsPage.checkSoftware("Microsoft Office [+$50.00]");


        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 09: Choose software Checkbox ");
        detailProductsPage.checkSoftware("Acrobat Reader [+$10.00]");

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step `10: Choose software Checkbox ");
        detailProductsPage.checkSoftware("Total Commander [+$5.00]");

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 11: Click to button Add to Cart ");
        detailProductsPage.clickToAddToCart("Add to cart");
        detailProductsPage.sleepInSecond(2);

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 12: Verify  the product has been added to your shopping cart  message is displayed");
        verifyTrue(detailProductsPage.isAddToCartSuceessMessage("The product has been added to your "));

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 13: Click Shopping Cart");
        shoppingCartPage = detailProductsPage.clickShoppingCart("The product has been added to your ");

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 14: Hover Shopping Cart ");
        shoppingCartPage.hoverToShoppingCart();

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 15: Verify  'Count item' is display");
        verifyTrue(shoppingCartPage.isItemShoppingMessage("1 item(s)"));

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 16: Verify  'name' is display");
        verifyTrue(shoppingCartPage.isNameDisplay("Build your own computer"));

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 17: Verify  'price product' is display");
        verifyTrue(shoppingCartPage.isProducPricetDisplay("$1,330.00"));

    }

    @Test
    public void Order_03_Edit_Product_Shopping_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), "Edit Cart to system");
        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart - Step 01: Click go to Cart");
        orderPage = shoppingCartPage.clickGoToCartButton();

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart - Step 02: Click go to Edit Cart");
        detailProductsPage = orderPage.clickGoToEditCart();

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart  - Step 03: Select 'processor' dropdown");
        detailProductsPage.dropdownProcessor("2.2 GHz Intel Pentium Dual-Core E2200");

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart  - Step 04: Select 'RAM' dropdown");
        detailProductsPage.dropdownRam("4GB [+$20.00]");

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart  - Step 05: Choose HDD Checkbox ");
        detailProductsPage.checkboxradiotoHdd("320 GB");

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart  - Step 06: Choose OS Checkbox ");
        detailProductsPage.checkboxradiotoOs("Vista Premium [+$60.00]");

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart  - Step 07: Choose software Checkbox ");
        detailProductsPage.checkSoftware("Microsoft Office [+$50.00]");


        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart  - Step 08: Choose software Checkbox ");
        detailProductsPage.checkSoftware("Acrobat Reader [+$10.00]");

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart  - Step `9: Choose software Checkbox ");
        detailProductsPage.checkSoftware("Total Commander [+$5.00]");

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart - Step 10:  Enter to input number cart");
        detailProductsPage.inputToNumberCartTextbox(numbercart);

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart  - Step 11: Click to button Update ");
        detailProductsPage.clickToAddToCart("Update");

        detailProductsPage.sleepInSecond(2);

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart  - Step 13: Verify  the product has been added to your shopping cart  message is displayed");
        verifyTrue(detailProductsPage.isAddToCartSuceessMessage("The product has been added to your "));

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart  - Step 14: Click Shopping Cart");
        shoppingCartPage = detailProductsPage.clickShoppingCart("The product has been added to your ");

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart  - Step 15: Hover Shopping Cart ");
        shoppingCartPage.hoverToShoppingCart();

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart  - Step 16: Verify  'Count item' is display");
        verifyTrue(shoppingCartPage.isItemShoppingMessage("2 item(s)"));

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart  - Step 17: Verify  'name' is display");
        verifyTrue(shoppingCartPage.isNameDisplay("Build your own computer"));

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart  - Step 18: Verify  'price product' is display");
        verifyTrue(shoppingCartPage.isProducPricetDisplay("$2,670.00"));

    }

    @Test
    public void Order_04_Remove_From_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), "Remove cart to system");
        ExtentTestManager.getTest().log(Status.INFO, "Remove cart - Step 01: remove Cart");
        shoppingCartPage.clickToRemoveCart();

        ExtentTestManager.getTest().log(Status.INFO, "Remove Cart  - Step 18: Verify empty message is display");
        verifyTrue(shoppingCartPage.isEmptyCartMessage("Your Shopping Cart is empty!"));


    }

    @Test
    public void Order_05_Update_Shopping_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), "Update shopping cart to system");
        //ExtentTestManager.getTest().log(Status.INFO, "Update shopping cart - Step 01: open page");
        ExtentTestManager.getTest().log(Status.INFO, "Update shopping cart  - Step 01: Click to dropdown menu notebooks");
        sortdisplaypaingPage = shoppingCartPage.dropdowndesktops("Desktops ");

        ExtentTestManager.getTest().log(Status.INFO, "Update shopping cart - Step 02: Click to products name ");
        detailProductsPage = sortdisplaypaingPage.clickToProductName("Lenovo IdeaCentre 600 All-in-One PC");

        ExtentTestManager.getTest().log(Status.INFO, "Update shopping cart  - Step 03: Click to button Add to Cart ");
        detailProductsPage.clickToAddToCart("Add to cart");
        detailProductsPage.sleepInSecond(2);

        ExtentTestManager.getTest().log(Status.INFO, "Update shopping cart - Step 04: Verify  the product has been added to your shopping cart  message is displayed");
        verifyTrue(detailProductsPage.isAddToCartSuceessMessage("The product has been added to your "));

        ExtentTestManager.getTest().log(Status.INFO, "Update shopping cart  - Step 05: Click Shopping Cart");
        shoppingCartPage = detailProductsPage.clickShoppingCart("The product has been added to your ");

        ExtentTestManager.getTest().log(Status.INFO, "Update shopping cart  - Step 06: Enter qty textbox ");
        shoppingCartPage.enterToQtyTextbox("5");

        ExtentTestManager.getTest().log(Status.INFO, "Update shopping cart  - Step 07: Click to button Update shopping cart ");
        shoppingCartPage.clickToUpdateShoppingCart();

        ExtentTestManager.getTest().log(Status.INFO, "Update shopping cart - Step 08: Verify  'Total' is display");
        verifyTrue(shoppingCartPage.isTotalDisplay("$2,500.00"));
    }

    @Test
    public void Order_06_Checkout_Order(Method method) {
        ExtentTestManager.startTest(method.getName(), "Checkout order to system");
        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 01: open page");
    }

    @Test
    public void Order_07_Checkout_Payment(Method method) {
        ExtentTestManager.startTest(method.getName(), "Checkout Payment to system");
        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment - Step 01: open page");
    }

    @Test
    public void Order_08_Re_Order(Method method) {
        ExtentTestManager.startTest(method.getName(), "Re order to system");
        ExtentTestManager.getTest().log(Status.INFO, "Re order - Step 01: open page");
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
    USerLoginPageObject loginPage;

    OrderPageObject orderPage;
    ProductBooksPageObject ProductBooksPage;

    WishListPageObject WishListPage;

    ComparePageObject ComparePage;

    SortDisplayPaingPageObject sortdisplaypaingPage;

    DetailProductsPageObject detailProductsPage;

    ShoppingCartPageObject shoppingCartPage;

    RecentlyViewedProductsPageObject recentlyViewedProductsPage;

    String  emailAddress, validPassword, numbercart;


}
