package pageObjects.nopCommercemvn.usermvn;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommercemvn.user.HomePageUI;

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
}
