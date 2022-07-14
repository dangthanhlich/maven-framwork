package pageObjects.nopCommercemvn.usermvn;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommercemvn.user.HomePageUI;
import pageUIs.nopCommercemvn.user.ProductBooksPageUI;
import pageUIs.nopCommercemvn.user.SearchPageUI;
import pageUIs.nopCommercemvn.user.WishListPageUI;

public class WishListPageObject extends BasePage {
    private WebDriver driver;

    public WishListPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductWishList(String productWishList) {
        waitForElementVisible(driver, WishListPageUI.PRODUCT_WISHLIST,productWishList);
        return isElementDisplayed(driver, WishListPageUI.PRODUCT_WISHLIST,productWishList);
    }

    public void clickToWishListSharing() {
        waitForElementClickable(driver, WishListPageUI.WISHLIST_SHARE_LINK);
        clickToElement(driver, WishListPageUI.WISHLIST_SHARE_LINK);
    }

    public void clickToCheckbox() {
        waitForElementClickable(driver, WishListPageUI.CHECKBOX_WISHlIST);
        checkToDefaultCheckboxOrRadio(driver, WishListPageUI.CHECKBOX_WISHlIST);
    }

    public ShoppingCartPageObject clickToAddToCart() {
        waitForElementClickable(driver, WishListPageUI.ADD_TO_CART);
        clickToElement(driver, WishListPageUI.ADD_TO_CART);
        return PageGeneratorManager.getShoppingCartPage(driver);
    }

    public void clickToRemoveWishList() {
        waitForElementClickable(driver, WishListPageUI.REMOVE_WISHLIST);
        clickToElement(driver, WishListPageUI.REMOVE_WISHLIST);
    }

    public boolean isProductRemoveWishList(String product) {
        waitForElementVisible(driver, HomePageUI.WISHLIST_COUNT_PRODUCT_LINK, product);
        return isElementDisplayed(driver, HomePageUI.WISHLIST_COUNT_PRODUCT_LINK, product);
    }

    public boolean isCartShopping(String product) {
        waitForElementVisible(driver, HomePageUI.SHOPPING_CART_LINK, product);
        return isElementDisplayed(driver, HomePageUI.SHOPPING_CART_LINK, product);
    }

    public void clickToUpDateToWishList() {
        waitForElementClickable(driver, WishListPageUI.UPDATE_WISHLIST);
        clickToElement(driver, WishListPageUI.UPDATE_WISHLIST);
    }


    public boolean isemptyMessage(String message) {
        waitForElementVisible(driver, WishListPageUI.EMPTY_WISH_LIST_MESSAGE, message);
        return isElementDisplayed(driver, WishListPageUI.EMPTY_WISH_LIST_MESSAGE, message);
    }

    public ProductBooksPageObject openAddressAddNewPage(String booksProduct) {
        waitForElementClickable(driver, HomePageUI.MENU_LINK,booksProduct);
        clickToElement(driver, HomePageUI.MENU_LINK,booksProduct);
        return PageGeneratorManager.getProductBooksPage(driver);
    }
}
