package pageObjects.nopCommercemvn.usermvn;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommercemvn.user.DetailProductsPageUI;
import pageUIs.nopCommercemvn.user.HomePageUI;
import pageUIs.nopCommercemvn.user.LoginPageUI;
import pageUIs.nopCommercemvn.user.OrderPageUI;

public class ShoppingCartPageObject extends BasePage {
    private WebDriver driver;

    public ShoppingCartPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public WishListPageObject clickToWishList() {
        waitForElementClickable(driver, HomePageUI.WISHLIST_LINK);
        clickToElement(driver, HomePageUI.WISHLIST_LINK);
        return PageGeneratorManager.getWishListPage(driver);
    }

    public void hoverToShoppingCart() {
        waitForElementClickable(driver, HomePageUI.SHOPPING_CART_LINK);
        hoverMouseElement(driver, HomePageUI.SHOPPING_CART_LINK);
    }

    public boolean isItemShoppingMessage(String numberitem) {
        waitForElementVisible(driver, OrderPageUI.ITEM_YOUR_CART, numberitem);
        return isElementDisplayed(driver, OrderPageUI.ITEM_YOUR_CART,numberitem);
    }


    public boolean isNameDisplay(String nameproduct) {
        waitForElementVisible(driver, OrderPageUI.NAME_CART,nameproduct);
        return isElementDisplayed(driver, OrderPageUI.NAME_CART,nameproduct);
    }


    public boolean isProducPricetDisplay(String price) {
        waitForElementVisible(driver, OrderPageUI.PRICE_CART,price);
        return isElementDisplayed(driver, OrderPageUI.PRICE_CART,price);
    }


    public OrderPageObject clickGoToCartButton() {
        waitForElementClickable(driver, OrderPageUI.GO_TO_CART_BUTTON);
        clickToElement(driver, OrderPageUI.GO_TO_CART_BUTTON);
        return PageGeneratorManager.getOrderPage(driver);
    }

    public void clickToRemoveCart() {
        waitForElementClickable(driver, OrderPageUI.REMOVE_CART);
        clickToElement(driver, OrderPageUI.REMOVE_CART);
    }

    public boolean isEmptyCartMessage(String message) {
        waitForElementVisible(driver, OrderPageUI.CART_EMPTY_MESSAGE);
        return isElementDisplayed(driver, OrderPageUI.CART_EMPTY_MESSAGE,message);
    }

    public SortDisplayPaingPageObject dropdowndesktops(String submenuitem) {
        waitForElementClickable(driver, HomePageUI.MENU_COMPUTER_LINK);
        hoverMouseElement(driver, HomePageUI.MENU_COMPUTER_LINK);

        waitForElementClickable(driver, HomePageUI.MENU_DESKTOPS_LINK);
        clickToElement(driver, HomePageUI.MENU_DESKTOPS_LINK,submenuitem);
        return PageGeneratorManager.getSortDisplayPaingPage(driver);
    }

//    public void enterToQtyTextbox(String number) {
////        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
////        sendkeyToElement(driver,LoginPageUI.EMAIL_TEXTBOX,EmailAddress);
//    }

    public void enterToQtyTextbox(String number) {
        waitForElementVisible(driver, OrderPageUI.QTY_CART);
        sendkeyToElement(driver,OrderPageUI.QTY_CART, number);
    }

    public void clickToUpdateShoppingCart() {
        waitForElementClickable(driver, OrderPageUI.UPDATE_CART);
        clickToElement(driver, OrderPageUI.UPDATE_CART);
    }

    public boolean isTotalDisplay(String total) {
        waitForElementVisible(driver, OrderPageUI.TOTAL_CART);
        return isElementDisplayed(driver, OrderPageUI.TOTAL_CART, total);
    }


}
