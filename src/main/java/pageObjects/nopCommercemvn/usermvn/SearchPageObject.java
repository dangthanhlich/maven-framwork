package pageObjects.nopCommercemvn.usermvn;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommercemvn.user.*;

public class SearchPageObject extends BasePage {
    private WebDriver driver;

    public SearchPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void ClickToButtonSearch() {
        waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
        clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
    }

    public boolean isErrorMessage(String message) {
        waitForElementVisible(driver, SearchPageUI.SEARCH_ERROR_EMPTY_MESSAGE, message);
        return isElementDisplayed(driver, SearchPageUI.SEARCH_ERROR_EMPTY_MESSAGE, message);
    }

    public void inputToSearchTextbox(String invalidsearch) {
        waitForElementVisible(driver, SearchPageUI.SEARCH_TEXTBOX);
        sendkeyToElement(driver,SearchPageUI.SEARCH_TEXTBOX,invalidsearch);
    }

    public boolean isProductSearch(String product) {
        waitForElementVisible(driver, SearchPageUI.PRODUCT_NAME, product);
        return isElementDisplayed(driver, SearchPageUI.PRODUCT_NAME, product);
    }

    public void checkboxToCheck() {
        waitForElementClickable(driver, SearchPageUI.ADVANCED_SEARCH_CHECK);
        checkToDefaultCheckboxOrRadio(driver, SearchPageUI.ADVANCED_SEARCH_CHECK);
    }

    public void dropdownComputers(String computersProduct) {
        waitForElementClickable(driver, SearchPageUI.CATEGORY_DROPDOWN);
        selectItemDefaultDropdown(driver, SearchPageUI.CATEGORY_DROPDOWN ,computersProduct);
    }

    public void checkboxToChecked() {
        waitForElementClickable(driver, SearchPageUI.AUTOMATIONCALLY_CHECK);
        checkToDefaultCheckboxOrRadio(driver, SearchPageUI.AUTOMATIONCALLY_CHECK);
    }

    public void dropdownManufacturer(String manufacturer) {
        waitForElementClickable(driver, SearchPageUI.MANUFACTURE);
        selectItemDefaultDropdown(driver, SearchPageUI.MANUFACTURE ,manufacturer);
    }

    public void UncheckboxToChecked() {
        waitForElementClickable(driver, SearchPageUI.AUTOMATIONCALLY_CHECK);
        uncheckToDefaultCheckboxOrRadio(driver, SearchPageUI.AUTOMATIONCALLY_CHECK);
    }
}
