package pageObjects.nopCommercemvn.usermvn;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommercemvn.user.ComparePageUI;
import pageUIs.nopCommercemvn.user.HomePageUI;
import pageUIs.nopCommercemvn.user.WishListPageUI;

public class ComparePageObject extends BasePage {
    private WebDriver driver;

    public ComparePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isRemove() {
        waitForElementVisible(driver, ComparePageUI.REMOVE_COMPARE);
        return isElementDisplayed(driver, ComparePageUI.REMOVE_COMPARE);
    }

    public boolean isPrice() {
        waitForElementVisible(driver, ComparePageUI.PRICE);
        return isElementDisplayed(driver, ComparePageUI.PRICE);
    }

    public boolean isName() {
        waitForElementVisible(driver, ComparePageUI.NAME);
        return isElementDisplayed(driver, ComparePageUI.NAME);
    }

    public boolean isNameProduct(String number, String nameproduct) {
        waitForElementVisible(driver, ComparePageUI.NAME_PRODUCT,number,nameproduct);
        return isElementDisplayed(driver, ComparePageUI.NAME_PRODUCT,number,nameproduct);
    }

    public boolean isPriceProduct(String number, String priceproduct) {
        waitForElementVisible(driver, ComparePageUI.PRICE_PRODUCT,number,priceproduct);
        return isElementDisplayed(driver, ComparePageUI.PRICE_PRODUCT,number,priceproduct);
    }

    public SortDisplayPaingPageObject dropdownNotebooks(String itemnotebook) {
        waitForElementClickable(driver, HomePageUI.MENU_COMPUTER_LINK);
        hoverMouseElement(driver, HomePageUI.MENU_COMPUTER_LINK);

        waitForElementClickable(driver, HomePageUI.MENU_NOTEBOOK_LINK);
        clickToElement(driver, HomePageUI.MENU_NOTEBOOK_LINK,itemnotebook);
        return PageGeneratorManager.getSortDisplayPaingPage(driver);
    }
}
