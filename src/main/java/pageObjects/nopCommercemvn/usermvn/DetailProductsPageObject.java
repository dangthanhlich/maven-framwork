package pageObjects.nopCommercemvn.usermvn;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommercemvn.user.DetailProductsPageUI;
import pageUIs.nopCommercemvn.user.HomePageUI;
import pageUIs.nopCommercemvn.user.LoginPageUI;
import pageUIs.nopCommercemvn.user.SearchPageUI;

import static pageUIs.nopCommercemvn.user.DetailProductsPageUI.PROCESSER;

public class DetailProductsPageObject extends BasePage {
    private WebDriver driver;

    public DetailProductsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public SortDisplayPaingPageObject dropdownNotebooks(String submenuitem) {
        waitForElementClickable(driver, HomePageUI.MENU_COMPUTER_LINK);
        hoverMouseElement(driver, HomePageUI.MENU_COMPUTER_LINK);

        waitForElementClickable(driver, HomePageUI.MENU_NOTEBOOK_LINK);
        clickToElement(driver, HomePageUI.MENU_NOTEBOOK_LINK,submenuitem);
        return PageGeneratorManager.getSortDisplayPaingPage(driver);
    }

    public void dropdownProcessor(String itemprocesser) {
        waitForElementClickable(driver, DetailProductsPageUI.PROCESSER);
        selectItemDefaultDropdown(driver, DetailProductsPageUI.PROCESSER ,itemprocesser);
    }

    public void dropdownRam(String ram) {
        waitForElementClickable(driver, DetailProductsPageUI.RAM);
        selectItemDefaultDropdown(driver, DetailProductsPageUI.RAM ,ram);
    }

    public void checkboxradiotoHdd(String hdd) {
        waitForElementClickable(driver, DetailProductsPageUI.HDD);
        checkToDefaultCheckboxOrRadio(driver, DetailProductsPageUI.HDD,hdd);
    }

    public void checkboxradiotoOs(String os) {
        waitForElementClickable(driver, DetailProductsPageUI.OS);
        checkToDefaultCheckboxOrRadio(driver, DetailProductsPageUI.OS,os);
    }

    public void checkSoftware(String software) {
        waitForElementClickable(driver, DetailProductsPageUI.SOFTWARE,software);
        checkToDefaultCheckboxOrRadio(driver, DetailProductsPageUI.SOFTWARE,software);
    }

    public void clickToAddToCart(String buttoncart) {
        waitForElementClickable(driver, DetailProductsPageUI.ADD_TO_CART_BUTTON,buttoncart);
        clickToElement(driver, DetailProductsPageUI.ADD_TO_CART_BUTTON,buttoncart);
    }

    public boolean isAddToCartSuceessMessage(String message) {
        waitForElementVisible(driver, DetailProductsPageUI.ADD_TO_CART_SUCESS_MESSAGE, message);
        return isElementDisplayed(driver, DetailProductsPageUI.ADD_TO_CART_SUCESS_MESSAGE, message);
    }

    public ShoppingCartPageObject clickShoppingCart(String message) {
        waitForElementClickable(driver, DetailProductsPageUI.ADD_TO_CART_SUCESS_MESSAGE, message);
        clickToElement(driver, DetailProductsPageUI.ADD_TO_CART_SUCESS_MESSAGE, message);
        return PageGeneratorManager.getShoppingCartPage(driver);
    }

    public void inputToNumberCartTextbox(String numbercart) {
        waitForElementVisible(driver, DetailProductsPageUI.NUMBER_CART);
        sendkeyToElement(driver,DetailProductsPageUI.NUMBER_CART,numbercart);
    }
}
