package pageUIs.nopCommercemvn.admin;

public class AdminPageUI {
    public static final String EMAIL_TEXTBOX="xpath=//input[@id='Email']";
    public static final String PASSWORD_TEXTBOX="xpath=//input[@id='Password']";
    public static final String LOGIN_BUTTON="xpath=//div[@class='buttons']//button";

    //p[contains(text(),'Catalog')]//parent::a//ancestor::li//ul//li//a//p[contains(text(),'Products')]
    public static final String CLICK_TO_PRODUCT="xpath=//p[contains(text(),'Catalog')]//parent::a//ancestor::li//ul//li//a//p[contains(text(),'%s')]";
    public static final String CLICK_TO_ICON_PRODUCT="xpath=//p[contains(text(),'Catalog')]//preceding-sibling::i[@class='right fas fa-angle-left ']";


    public static final String PRODUCT_NAME_TEXTBOX="xpath=//input[@id='SearchProductName']";
    public static final String SEARCH_BUTTON="xpath=//button[@id='search-products']";
    public static final String SEARCH_CUSTOMER_BUTTON="xpath=//button[@id='search-customers']";
    //tr[@class='odd']//td[text()='Lenovo IdeaCentre 600 All-in-One PC']
    public static final String PRODUCT_NAME_TEXT="xpath=//tr[@class='odd']//td[text()='%s']";

    public static final String DROPDOWN_CATEGORY="xpath=//select[@id='SearchCategoryId']";

    public static final String SEARCH_CHECKBOX="xpath=//input[@id='SearchIncludeSubCategories']";

    public static final String NO_PRODUCT_MESSAGE="xpath=//tbody//tr//td[@class='dataTables_empty']";

    public static final String NO_PRODUCT_MANUFACTURER="xpath=//select[@id='SearchManufacturerId']";
    public static final String NO_PRODUCT_VENDER="xpath=//select[@id='SearchVendorId']";

    //td[text()='Build your own computer']//parent::td//following-sibling::td[@class=' button-column']//a
    public static final String EDIT_BUTTON="xpath=//td[text()='%s']//parent::td//following-sibling::td[@class=' button-column']//a";
    //div[@class='input-group input-group-required']//input[@value='Build your own computer']
    public static final String INPUT_PRODUCT_NAME_TEXTBOX="xpath=//div[@class='input-group input-group-required']//input[@value='%s']";


    public static final String CLICK_TO_ICON_CUSTOMER="xpath=//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']//a//i[@class='nav-icon far fa-user']//following-sibling::p//i";
    public static final String CLICK_TO_CUSTOMER="xpath=//li[@class='nav-item has-treeview menu-open']//a//i[@class='nav-icon far fa-user']//ancestor::li//following-sibling::ul//li//a//p[contains(text(),'Customers')]";

    public static final String CLICK_ADD_NEW="xpath=//div[@class='float-right']//a";
    public static final String EMAIL_CUSTOMER_TEXTBOX="xpath=//input[@id='Email']";
    public static final String PASSWORD_CUSTOMER_TEXTBOX="xpath=//input[@id='Password']";
    public static final String FIRST_NAME_CUSTOMER_TEXTBOX="xpath=//input[@id='FirstName']";
    public static final String LAST_NAME_CUSTOMER_TEXTBOX="xpath=//input[@id='LastName']";
    public static final String GENDER="xpath=//div[@class='form-check']";
    public static final String DATE_OF_BIRTH="xpath=//input[@id='DateOfBirth']";
    public static final String COMPANY_NAME="xpath=//input[@id='Company']";
    public static final String SEARCH_COMPANY_NAME="xpath=//input[@id='SearchCompany']";

    public static final String CUSTOMER_ROLES_ITEM="xpath=//ul[@id='SelectedCustomerRoleIds_listbox']//li[text()='Guests']";
    public static final String ROLES_CLOSE="xpath=//span[text()='Registered']//following-sibling::span";
    public static final String CUSTOMER_ROLES="xpath=//div[@class='input-group-append input-group-required']//div[@class='k-multiselect-wrap k-floatwrap']";
    public static final String ACTIVE_CHECKBOX="xpath=//input[@id='Active']";
    public static final String ADMIN_COMMENT="xpath=//textarea[@id='AdminComment']";
    public static final String SAVE_AND_CONTINUE_EDIT="xpath=//button[@name='save-continue']";
    public static final String SUCCESSFULLY_MESSAGE="xpath=//div[@class='alert alert-success alert-dismissable']";
    public static final String BACK_TO_CUTOMER_LIST="xpath=//a[text()='back to customer list']";
    public static final String CUSTOMER_ROLES_CUSTOMER="xpath=//ul[@id='SelectedCustomerRoleIds_listbox']//li";
    public static final String EMAIL_CUSTOMER_DETAILS="xpath=//tr//td[text()='ssss@gmail.com']";
    public static final String COMPANY_CUSTOMER_DETAILS="xpath=//tr//td[text()='%s']";

    public static final String ROLES_ITEM_CUSTOMERS="xpath=//ul[@id='SelectedCustomerRoleIds_listbox']//li[text()='Guests']";
    public static final String ROLES_CLOSE_CUSTOMERS="xpath=//span[text()='Registered']//following-sibling::span";
    public static final String INPUT_ROLES_CUSTOMERS="xpath=//div[@class='k-multiselect-wrap k-floatwrap']";

}
