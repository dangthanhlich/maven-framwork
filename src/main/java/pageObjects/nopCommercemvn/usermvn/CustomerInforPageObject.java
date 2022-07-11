package pageObjects.nopCommercemvn.usermvn;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommercemvn.user.CustomerInforPageUI;
import pageUIs.nopCommercemvn.user.MyAccountPageUI;

public class CustomerInforPageObject extends BasePage {
    private WebDriver driver;

    public CustomerInforPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void genderMaleOrFemale(String radioInputName) {
        waitForElementClickable(driver, CustomerInforPageUI.RADIO_GENDER, radioInputName);
        checkToDefaultCheckboxOrRadio(driver, CustomerInforPageUI.RADIO_GENDER, radioInputName);
    }

    public void inputToFirstnameTextbox(String editFirstName) {
        waitForElementVisible(driver, CustomerInforPageUI.INPUT_FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver,CustomerInforPageUI.INPUT_FIRST_NAME_TEXTBOX,editFirstName);
    }

    public void inputToLastnameTextbox(String editLastName) {
        waitForElementVisible(driver, CustomerInforPageUI.INPUT_LAST_NAME_TEXTBOX);
        sendkeyToElement(driver,CustomerInforPageUI.INPUT_LAST_NAME_TEXTBOX,editLastName);
    }


    public void inputToEmailTextbox(String editEmailAddress) {
        waitForElementVisible(driver, CustomerInforPageUI.INPUT_EMAIL_TEXTBOX);
        sendkeyToElement(driver,CustomerInforPageUI.INPUT_EMAIL_TEXTBOX,editEmailAddress);
    }

    public void inputToCompanyTextbox(String companyAddress) {
        waitForElementVisible(driver, CustomerInforPageUI.INPUT_COMPANY_TEXTBOX);
        sendkeyToElement(driver,CustomerInforPageUI.INPUT_COMPANY_TEXTBOX,companyAddress);
    }

    public void dropdownItemDay( String day) {
        waitForElementClickable(driver, CustomerInforPageUI.ACTION_DROPDOWN_DAY);
        selectItemDefaultDropdown(driver, CustomerInforPageUI.ACTION_DROPDOWN_DAY ,day);
    }

    public void dropdownItemMonth( String month) {
        waitForElementClickable(driver, CustomerInforPageUI.ACTION_DROPDOWN_MONTH );
        selectItemDefaultDropdown(driver, CustomerInforPageUI.ACTION_DROPDOWN_MONTH ,month);
    }

    public void dropdownItemYear(String year) {
        waitForElementClickable(driver, CustomerInforPageUI.ACTION_DROPDOWN_YEAR );
        selectItemDefaultDropdown(driver, CustomerInforPageUI.ACTION_DROPDOWN_YEAR ,year);
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, CustomerInforPageUI.SAVE_BUTTON);
        clickToElement(driver, CustomerInforPageUI.SAVE_BUTTON);
    }

    public boolean isGenderDisplayed(String male) {
        waitForElementVisible(driver, CustomerInforPageUI.RADIO_GENDER, male);
        return isElementDisplayed(driver, CustomerInforPageUI.RADIO_GENDER, male);
    }


    public AddressesPageObject openAddressAddNewPage(String addresses) {
        waitForElementClickable(driver, MyAccountPageUI.ITEM_MENU_LIST,addresses);
        clickToElement(driver, MyAccountPageUI.ITEM_MENU_LIST,addresses);
        return PageGeneratorManager.getAddressesPage(driver);
    }
}
