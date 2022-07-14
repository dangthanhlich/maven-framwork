package pageObjects.nopCommercemvn.usermvn;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommercemvn.user.ComparePageUI;
import pageUIs.nopCommercemvn.user.RecentlyViewedProductsUI;

public class RecentlyViewedProductsPageObject  extends BasePage {
    private WebDriver driver;

    public RecentlyViewedProductsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductname(String productname) {
        waitForElementVisible(driver, RecentlyViewedProductsUI.ITEM_PRODUCTS,productname);
        return isElementDisplayed(driver, RecentlyViewedProductsUI.ITEM_PRODUCTS,productname);
    }
}
