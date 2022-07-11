package pageObjects.nopCommercemvn.usermvn;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommercemvn.user.AddressesPageUI;
import pageUIs.nopCommercemvn.user.CustomerInforPageUI;

public class AddressesPageObject extends BasePage {
    private WebDriver driver;

    public AddressesPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToAddNewButton() {
        waitForElementClickable(driver, AddressesPageUI.ADD_NEW_BUTTON);
        clickToElement(driver, AddressesPageUI.ADD_NEW_BUTTON);
    }

    public void inputToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, AddressesPageUI.FIRST_NAME_TEXT_BOX);
        sendkeyToElement(driver, AddressesPageUI.FIRST_NAME_TEXT_BOX,firstName);
    }

    public void inputToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, AddressesPageUI.LAST_NAME_TEXT_BOX);
        sendkeyToElement(driver, AddressesPageUI.LAST_NAME_TEXT_BOX,lastName);
    }

    public void inputToEmailAddressTextBox(String emailAddress) {
        waitForElementVisible(driver, AddressesPageUI.EMAIL_TEXT_BOX);
        sendkeyToElement(driver, AddressesPageUI.EMAIL_TEXT_BOX,emailAddress);
    }

    public void inputToCompanyAddressTextbox(String companyAddress) {
        waitForElementVisible(driver, AddressesPageUI.COMPANY_TEXT_BOX);
        sendkeyToElement(driver, AddressesPageUI.COMPANY_TEXT_BOX,companyAddress);
    }

    public void dropdownCountry(String country) {
        waitForElementClickable(driver, AddressesPageUI.COUNTRY_TEXT_BOX);
        selectItemDefaultDropdown(driver, AddressesPageUI.COUNTRY_TEXT_BOX ,country);
    }

    public void dropdownStateProvince(String state) {
        waitForElementClickable(driver, AddressesPageUI.STATE_PROVINCE_TEXT_BOX);
        selectItemDefaultDropdown(driver, AddressesPageUI.STATE_PROVINCE_TEXT_BOX ,state);
    }

    public void inputToCityTextbox(String city) {
        waitForElementVisible(driver, AddressesPageUI.CITY_TEXT_BOX);
        sendkeyToElement(driver, AddressesPageUI.CITY_TEXT_BOX,city);
    }

    public void inputToAddress1Textbox(String address1) {
        waitForElementVisible(driver, AddressesPageUI.ADDRESS1_TEXT_BOX);
        sendkeyToElement(driver, AddressesPageUI.ADDRESS1_TEXT_BOX,address1);
    }

    public void inputToAddress2Textbox(String address2) {
        waitForElementVisible(driver, AddressesPageUI.ADDRESS2_TEXT_BOX);
        sendkeyToElement(driver, AddressesPageUI.ADDRESS2_TEXT_BOX,address2);
    }

    public void inputToZipPostalTextbox(String zipPostalCode) {
        waitForElementVisible(driver, AddressesPageUI.ZIP_POSTAL_TEXT_BOX);
        sendkeyToElement(driver, AddressesPageUI.ZIP_POSTAL_TEXT_BOX,zipPostalCode);
    }

    public void inputToPhoneNumberTextbox(String phoneNumber) {
        waitForElementVisible(driver, AddressesPageUI.PHONE_NUMBER_TEXT_BOX);
        sendkeyToElement(driver, AddressesPageUI.PHONE_NUMBER_TEXT_BOX,phoneNumber);
    }

    public void inputToFaxNumberTextbox(String fax_Number) {
        waitForElementVisible(driver, AddressesPageUI.FAX_NUMBER_BOX);
        sendkeyToElement(driver, AddressesPageUI.FAX_NUMBER_BOX,fax_Number);
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, AddressesPageUI.SAVE_BUTTON);
        clickToElement(driver, AddressesPageUI.SAVE_BUTTON);
    }

    public boolean isGenderDisplayed(String firstName, String lastName) {
        waitForElementVisible(driver, AddressesPageUI.FIRST_LAST_NAME, firstName,lastName);
        return isElementDisplayed(driver, AddressesPageUI.FIRST_LAST_NAME, firstName,lastName);
    }
}
