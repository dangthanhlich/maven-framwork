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

public class TC_05_WishList extends BaseTest {
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        emailAddress = Common_01_Register.emailAddress;
        validPassword = Common_01_Register.validPassword;

        homePage = PageGeneratorManager.getUserHomePage(driver);

    }

    @Test
    public void Cart_01_Login_User(Method method) {
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
    public void Cart_02_Add_To_Wishlist(Method method) {
        ExtentTestManager.startTest(method.getName(), "Wishlist to system");

        ExtentTestManager.getTest().log(Status.INFO, "Wishlist - Step 01:Open books product");
        ProductBooksPage = homePage.openAddressAddNewPage("Books ");

        ExtentTestManager.getTest().log(Status.INFO, "Wishlist - Step 02:Click to name book link");
        ProductBooksPage.clickToBookLink("Fahrenheit 451 by Ray Bradbury");

        ExtentTestManager.getTest().log(Status.INFO, "Wishlist - Step 03: click to 'Add To WishList' ");
        ProductBooksPage.clickToAddToWishList();

        ExtentTestManager.getTest().log(Status.INFO, "Wishlist - Step 04: Verify  'The product has been added to your wishlist' message is displayed");
        verifyTrue(ProductBooksPage.isProductwishlist("The product has been added to your "));

        ExtentTestManager.getTest().log(Status.INFO, "Wishlist - Step 05: click to 'wishlist' ");
        WishListPage = ProductBooksPage.clickToToWishList();

        ExtentTestManager.getTest().log(Status.INFO, "Wishlist - Step 06: Verify  The product is displayed");
        verifyTrue(WishListPage.isProductWishList("Fahrenheit 451 by Ray Bradbury"));

        ExtentTestManager.getTest().log(Status.INFO, "Wishlist - Step 07: click to  Your wishlist URL for sharing ");
        WishListPage.clickToWishListSharing();


    }

    @Test
    public void Cart_03_Add_Product_To_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Product to system");
        ExtentTestManager.getTest().log(Status.INFO, "Add Product - Step 01:Click to check box");
        WishListPage.clickToCheckbox();

        ExtentTestManager.getTest().log(Status.INFO, "Add Product - Step 02:Click to Add to cart");
        shoppingCartPage = WishListPage.clickToAddToCart();

        ExtentTestManager.getTest().log(Status.INFO, "Add Product - Step 03:Click to Wishlist");
        WishListPage = shoppingCartPage.clickToWishList();

        ExtentTestManager.getTest().log(Status.INFO, "Add Product - Step 04:Click to Remove Wishlist");
        WishListPage.clickToRemoveWishList();

        ExtentTestManager.getTest().log(Status.INFO, "Add Product - Step 05:Verify  Wishlist remove is display");
        verifyTrue(WishListPage.isProductRemoveWishList("0"));

        ExtentTestManager.getTest().log(Status.INFO, "Add Product - Step 06:Verify Cart is display");
        verifyTrue(WishListPage.isCartShopping("1"));
    }

    @Test
    public void Cart_04_Remove_Product(Method method) {
        ExtentTestManager.startTest(method.getName(), "Remove Product to system");

        ExtentTestManager.getTest().log(Status.INFO, "Remove Product - Step 01:Open books product");
        ProductBooksPage = WishListPage.openAddressAddNewPage("Books");

        ExtentTestManager.getTest().log(Status.INFO, "Remove Product - Step 02:Click to name book link");
        ProductBooksPage.clickToBookLink("First Prize Pies");

        ExtentTestManager.getTest().log(Status.INFO, "Remove Product - Step 03: click to 'Add To WishList' ");
        ProductBooksPage.clickToAddToWishList();

        ExtentTestManager.getTest().log(Status.INFO, "Remove Product - Step 04: Verify  'The product has been added to your wishlist' message is displayed");
        verifyTrue(ProductBooksPage.isProductwishlist("The product has been added to your "));

        ExtentTestManager.getTest().log(Status.INFO, "Remove Product - Step 05: click to 'wishlist' ");
        WishListPage = ProductBooksPage.clickToToWishList();

        ExtentTestManager.getTest().log(Status.INFO, "Remove Product - Step 06: Verify  The product is displayed");
        verifyTrue(WishListPage.isProductWishList("First Prize Pies"));

        ExtentTestManager.getTest().log(Status.INFO, "Remove Product - Step 03: Click to check box ");
        WishListPage.clickToCheckbox();

        ExtentTestManager.getTest().log(Status.INFO, "Remove Product - Step 04:Click to UpDate WishList");
        WishListPage.clickToUpDateToWishList();

        ExtentTestManager.getTest().log(Status.INFO, "Remove Product - Step 05:Click to Remove Wishlist");
        WishListPage.clickToRemoveWishList();

        ExtentTestManager.getTest().log(Status.INFO, "Remove Product - Step 06:Verify 'The wishlist is empty! ' message is display");
        verifyTrue(WishListPage.isemptyMessage("The wishlist is empty!"));

        ExtentTestManager.getTest().log(Status.INFO, "Remove Product - Step 07:Verify  Wishlist remove is display");
        verifyTrue(WishListPage.isProductRemoveWishList("0"));
    }

    @Test
    public void Cart_05_Add_Product(Method method) {
        ExtentTestManager.startTest(method.getName(), "Compare to system");

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 01:Open books product");
        ProductBooksPage = WishListPage.openAddressAddNewPage("Books");

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 02:Click to name book link");
        ProductBooksPage.clickToCompare("First Prize Pies");
        ProductBooksPage.sleepInSecond(3);

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 03: Verify  'The product has been added to your product comparison' message is displayed");
        verifyTrue(ProductBooksPage.isProductComParision("The product has been added to your "));

        ProductBooksPage.sleepInSecond(3);

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 04:Click to name book link");
        ProductBooksPage.clickToCompare("Fahrenheit 451 by Ray Bradbury");

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 05: Verify  'The product has been added to your product comparison' message is displayed");
        verifyTrue(ProductBooksPage.isProductComParision("The product has been added to your "));



        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 06: click to 'product comparison' ");
        ComparePage = ProductBooksPage.clickToToProductComparision("The product has been added to your ");

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 07: Verify  remove is displayed");
        verifyTrue(ComparePage.isRemove());

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 08: Verify  Price is displayed");
        verifyTrue(ComparePage.isPrice());

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 09: Verify  Name is displayed");
        verifyTrue(ComparePage.isName());

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 10: Verify  Name product is displayed");
        verifyTrue(ComparePage.isNameProduct("1","First Prize Pies"));

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 11: Verify  Name product is displayed");
        verifyTrue(ComparePage.isNameProduct("2","Fahrenheit 451 by Ray Bradbury"));

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 12: Verify  Price Product is displayed");
        verifyTrue(ComparePage.isPriceProduct("1","$51.00"));

        ExtentTestManager.getTest().log(Status.INFO, "Compare - Step 13: Verify  Price Product is displayed");
        verifyTrue(ComparePage.isPriceProduct("2","$27.00"));

    }

    @Test
    public void Cart_06_Recently_Viewed_Products(Method method) {
        ExtentTestManager.startTest(method.getName(), "Recently viewed products to system");

        ExtentTestManager.getTest().log(Status.INFO, "Recently viewed products - Step 01: Click to dropdown menu notebooks");
        sortdisplaypaingPage = ComparePage.dropdownNotebooks("Notebooks ");

        ExtentTestManager.getTest().log(Status.INFO, "Recently viewed products - Step 02: Click to products name 1");
        detailProductsPage = sortdisplaypaingPage.clickToProductName("Apple MacBook Pro 13-inch");

        ExtentTestManager.getTest().log(Status.INFO, "Recently viewed products - Step 03: Click to dropdown menu notebooks");
        sortdisplaypaingPage = detailProductsPage.dropdownNotebooks("Notebooks ");

        ExtentTestManager.getTest().log(Status.INFO, "Recently viewed products - Step 04: Click to products name 2");
        detailProductsPage = sortdisplaypaingPage.clickToProductName("Asus N551JK-XO076H Laptop");
        detailProductsPage.sleepInSecond(2);

        ExtentTestManager.getTest().log(Status.INFO, "Recently viewed products - Step 05: Click to dropdown menu notebooks");
        sortdisplaypaingPage = detailProductsPage.dropdownNotebooks("Notebooks ");

        ExtentTestManager.getTest().log(Status.INFO, "Recently viewed products - Step 06: Click to products name 3");
        detailProductsPage = sortdisplaypaingPage.clickToProductName("HP Envy 6-1180ca 15.6-Inch Sleekbook");
        detailProductsPage.sleepInSecond(2);

        ExtentTestManager.getTest().log(Status.INFO, "Recently viewed products - Step 07: Click to dropdown menu notebooks");
        sortdisplaypaingPage = detailProductsPage.dropdownNotebooks("Notebooks ");

        ExtentTestManager.getTest().log(Status.INFO, "Recently viewed products - Step 08: Click to products name 4");
        detailProductsPage = sortdisplaypaingPage.clickToProductName("HP Spectre XT Pro UltraBook");
        detailProductsPage.sleepInSecond(2);

        ExtentTestManager.getTest().log(Status.INFO, "Recently viewed products - Step 09: Click to dropdown menu notebooks");
        sortdisplaypaingPage = detailProductsPage.dropdownNotebooks("Notebooks ");

        ExtentTestManager.getTest().log(Status.INFO, "Recently viewed products - Step 10: Click to products name 5");
        detailProductsPage = sortdisplaypaingPage.clickToProductName("Lenovo Thinkpad X1 Carbon Laptop");
        detailProductsPage.sleepInSecond(2);

        ExtentTestManager.getTest().log(Status.INFO, "Recently viewed products - Step 11: Click to Recently viewed products");
        recentlyViewedProductsPage = sortdisplaypaingPage.clickToRecentlyViewedProducts("Recently viewed products");

        ExtentTestManager.getTest().log(Status.INFO, "Recently viewed products - Step 12: Verify  Product is displayed");
        verifyTrue(recentlyViewedProductsPage.isProductname("HP Envy 6-1180ca 15.6-Inch Sleekbook"));

        ExtentTestManager.getTest().log(Status.INFO, "Recently viewed products - Step 13: Verify  Product is displayed");
        verifyTrue(recentlyViewedProductsPage.isProductname("HP Spectre XT Pro UltraBook"));

        ExtentTestManager.getTest().log(Status.INFO, "Recently viewed products - Step 14: Verify  Product is displayed");
        verifyTrue(recentlyViewedProductsPage.isProductname("Lenovo Thinkpad X1 Carbon Laptop"));
        recentlyViewedProductsPage.sleepInSecond(3);

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
    ProductBooksPageObject ProductBooksPage;

    WishListPageObject WishListPage;

    ComparePageObject ComparePage;

    SortDisplayPaingPageObject sortdisplaypaingPage;

    DetailProductsPageObject detailProductsPage;

    ShoppingCartPageObject shoppingCartPage;

    RecentlyViewedProductsPageObject recentlyViewedProductsPage;

    String firstName, lastName, emailAddress, validPassword,inemailAddress,invalidPassword,inValidEmailAddress;

}
