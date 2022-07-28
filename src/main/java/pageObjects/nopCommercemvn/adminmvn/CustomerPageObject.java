package pageObjects.nopCommercemvn.adminmvn;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommercemvn.admin.AdminPageUI;

public class CustomerPageObject extends BasePage {
    private WebDriver driver;

    public CustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToAddNew() {
        waitForElementClickable(driver, AdminPageUI.CLICK_ADD_NEW);
        clickToElement(driver, AdminPageUI.CLICK_ADD_NEW);
    }

    public void enterToEmail(String emailCustomer) {
        waitForElementVisible(driver, AdminPageUI.EMAIL_CUSTOMER_TEXTBOX);
        sendkeyToElement(driver,AdminPageUI.EMAIL_CUSTOMER_TEXTBOX,emailCustomer);
    }

    public void enterToPassword(String passwordCustomer) {
        waitForElementVisible(driver, AdminPageUI.PASSWORD_CUSTOMER_TEXTBOX);
        sendkeyToElement(driver,AdminPageUI.PASSWORD_CUSTOMER_TEXTBOX,passwordCustomer);
    }

    public void enterToFirstName(String firstName) {
        waitForElementVisible(driver, AdminPageUI.FIRST_NAME_CUSTOMER_TEXTBOX);
        sendkeyToElement(driver,AdminPageUI.FIRST_NAME_CUSTOMER_TEXTBOX,firstName);
    }

    public void enterToLastName(String lastName) {
        waitForElementVisible(driver, AdminPageUI.LAST_NAME_CUSTOMER_TEXTBOX);
        sendkeyToElement(driver,AdminPageUI.LAST_NAME_CUSTOMER_TEXTBOX,lastName);
    }

    public void clickToGenderRadio(String male) {
        waitForElementClickable(driver, AdminPageUI.GENDER);
        checkToDefaultCheckboxOrRadio(driver, AdminPageUI.GENDER,male);
    }

    public void enterToDateOfbirth(String dateCustomer) {
        waitForElementVisible(driver, AdminPageUI.DATE_OF_BIRTH);
        sendkeyToElement(driver,AdminPageUI.DATE_OF_BIRTH,dateCustomer);
    }

    public void enterToCompanyName(String companyName) {
        waitForElementVisible(driver, AdminPageUI.COMPANY_NAME);
        sendkeyToElement(driver,AdminPageUI.COMPANY_NAME,companyName);
    }

    public void searchToCompanyName(String companyName) {
        waitForElementVisible(driver, AdminPageUI.SEARCH_COMPANY_NAME);
        sendkeyToElement(driver,AdminPageUI.SEARCH_COMPANY_NAME,companyName);
    }

    public void clickToActiveCheckbox() {
        waitForElementClickable(driver, AdminPageUI.ACTIVE_CHECKBOX);
        checkToDefaultCheckboxOrRadio(driver, AdminPageUI.ACTIVE_CHECKBOX);
    }

    public void adminCommentTextarea(String addCustomerComment) {
        waitForElementVisible(driver, AdminPageUI.ADMIN_COMMENT);
        sendkeyToElement(driver,AdminPageUI.ADMIN_COMMENT,addCustomerComment);
    }

    public void clickToSaveCContinueEdit() {
        waitForElementClickable(driver, AdminPageUI.SAVE_AND_CONTINUE_EDIT);
        clickToElement(driver, AdminPageUI.SAVE_AND_CONTINUE_EDIT);
    }

    public void clickToSearchButton() {
        waitForElementClickable(driver, AdminPageUI.SEARCH_BUTTON);
        clickToElement(driver, AdminPageUI.SEARCH_BUTTON);
    }

    public void clickToSearchCustomerButton() {
        waitForElementClickable(driver, AdminPageUI.SEARCH_CUSTOMER_BUTTON);
        clickToElement(driver, AdminPageUI.SEARCH_CUSTOMER_BUTTON);
    }
    public boolean isMessageAddedDisplayed(String message) {
        waitForElementVisible(driver, AdminPageUI.SUCCESSFULLY_MESSAGE);
        return isElementDisplayed(driver, AdminPageUI.SUCCESSFULLY_MESSAGE,message);
    }

    public void clickTobackCustomerList() {
        waitForElementClickable(driver, AdminPageUI.BACK_TO_CUTOMER_LIST);
        clickToElement(driver, AdminPageUI.BACK_TO_CUTOMER_LIST);
    }



    public boolean isCompanyDisplayed(String companyCustomer) {
        waitForElementVisible(driver, AdminPageUI.COMPANY_CUSTOMER_DETAILS,companyCustomer);
        return isElementDisplayed(driver, AdminPageUI.COMPANY_CUSTOMER_DETAILS,companyCustomer);
    }

    public void enterToCustomerDropdownItem(String guests) {
        waitForElementVisible(driver, AdminPageUI.ROLES_CLOSE);
        clickToElement(driver, AdminPageUI.ROLES_CLOSE);

        waitForElementVisible(driver, AdminPageUI.CUSTOMER_ROLES);
        sendkeyToElement(driver,AdminPageUI.CUSTOMER_ROLES,guests);
    }

    public void clickToCustomerDropdownItem() {
        waitForElementVisible(driver, AdminPageUI.CUSTOMER_ROLES);
        clickToElement(driver, AdminPageUI.CUSTOMER_ROLES);
        sleepInSecond(1);
        waitForElementVisible(driver, AdminPageUI.CUSTOMER_ROLES_ITEM);
        clickToElement(driver, AdminPageUI.CUSTOMER_ROLES_ITEM);
        sleepInSecond(1);
        waitForElementVisible(driver, AdminPageUI.ROLES_CLOSE);
        clickToElement(driver, AdminPageUI.ROLES_CLOSE);
    }

    public void EnterToCustomerRole() {
        waitForElementVisible(driver, AdminPageUI.INPUT_ROLES_CUSTOMERS);
        clickToElement(driver, AdminPageUI.INPUT_ROLES_CUSTOMERS);
        sleepInSecond(1);
        waitForElementVisible(driver, AdminPageUI.ROLES_ITEM_CUSTOMERS);
        clickToElement(driver, AdminPageUI.ROLES_ITEM_CUSTOMERS);
        sleepInSecond(1);
        waitForElementVisible(driver, AdminPageUI.ROLES_CLOSE_CUSTOMERS);
        clickToElement(driver, AdminPageUI.ROLES_CLOSE_CUSTOMERS);
    }
}
