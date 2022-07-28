package pageObjects.nopCommercemvn.adminmvn;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommercemvn.admin.AdminPageUI;
import pageUIs.nopCommercemvn.user.LoginPageUI;
import pageUIs.nopCommercemvn.user.SearchPageUI;

public class ProductsPageObject extends BasePage {
    private WebDriver driver;

    public ProductsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductsDetailDisplayed(String message) {
        waitForElementVisible(driver, AdminPageUI.PRODUCT_NAME_TEXT,message);
        return isElementDisplayed(driver, AdminPageUI.PRODUCT_NAME_TEXT,message);
    }

    public void clickToSearchButton() {
        waitForElementClickable(driver, AdminPageUI.SEARCH_BUTTON);
        clickToElement(driver, AdminPageUI.SEARCH_BUTTON);
    }

    public void inputToEmailTextbox(String name) {
        waitForElementVisible(driver, AdminPageUI.PRODUCT_NAME_TEXTBOX);
        sendkeyToElement(driver,AdminPageUI.PRODUCT_NAME_TEXTBOX,name);
    }

    public void clickToDropdown(String computers) {
        waitForElementVisible(driver, AdminPageUI.DROPDOWN_CATEGORY);
        selectItemDefaultDropdown(driver, AdminPageUI.DROPDOWN_CATEGORY,computers);
    }

    public void clickToCheckbox() {
        waitForElementClickable(driver, AdminPageUI.SEARCH_CHECKBOX);
        checkToDefaultCheckboxOrRadio(driver, AdminPageUI.SEARCH_CHECKBOX);
    }

    public boolean isMessageisDisplayed(String no_data_available_in_table) {
        waitForElementVisible(driver, AdminPageUI.NO_PRODUCT_MESSAGE);
        return isElementDisplayed(driver, AdminPageUI.NO_PRODUCT_MESSAGE,no_data_available_in_table);
    }

    public void unclickToCheckbox() {
        waitForElementClickable(driver, AdminPageUI.SEARCH_CHECKBOX);
        uncheckToDefaultCheckboxOrRadio(driver, AdminPageUI.SEARCH_CHECKBOX);
    }

    public void clickToDropdownManufacturer(String apple) {
        waitForElementVisible(driver, AdminPageUI.NO_PRODUCT_MANUFACTURER);
        selectItemDefaultDropdown(driver, AdminPageUI.NO_PRODUCT_MANUFACTURER,apple);
    }

    public void clickToDropdownVendor(String all) {
        waitForElementVisible(driver, AdminPageUI.NO_PRODUCT_VENDER);
        selectItemDefaultDropdown(driver, AdminPageUI.NO_PRODUCT_VENDER,all);
    }

    public ProductDetailPageObject clickToEditButton(String name) {
        waitForElementClickable(driver, AdminPageUI.EDIT_BUTTON,name);
        clickToElement(driver, AdminPageUI.EDIT_BUTTON,name);
        return PageGeneratorManager.getProductDetailPage(driver);
    }

    public boolean isDetailProductsDisplayed(String name) {
        waitForElementVisible(driver, AdminPageUI.INPUT_PRODUCT_NAME_TEXTBOX,name);
        return isElementDisplayed(driver, AdminPageUI.INPUT_PRODUCT_NAME_TEXTBOX,name);
    }


    public CustomerPageObject clickToCustomer() {
        waitForElementClickable(driver, AdminPageUI.CLICK_TO_ICON_CUSTOMER);
        clickToElement(driver, AdminPageUI.CLICK_TO_ICON_CUSTOMER);
        waitForElementClickable(driver, AdminPageUI.CLICK_TO_CUSTOMER);
        clickToElement(driver, AdminPageUI.CLICK_TO_CUSTOMER);
        return PageGeneratorManager.getCustomerPage(driver);
    }
}
