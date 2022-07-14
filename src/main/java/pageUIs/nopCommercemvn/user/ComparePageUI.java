package pageUIs.nopCommercemvn.user;

public class ComparePageUI {
    public static final String REMOVE_COMPARE ="xpath=//table[@class='compare-products-table']//tbody//tr//td//button[text()='Remove']";

    public static final String CLEAR_LIST_BUTTON ="xpath=//div[@class='page-body']//a[text()='Clear list']";

    public static final String NAME ="xpath=//tr[@class='product-name']//td//label[text()='Name']";

    public static final String PRICE ="xpath=//tr[@class='product-price']//td//label[text()='Price']";

    //tr[@class='product-price']//td//label[text()='Price']//parent::td//following-sibling::td[1][text()='$51.00']
    public static final String PRICE_PRODUCT ="xpath=//tr[@class='product-price']//td//label[text()='Price']//parent::td//following-sibling::td[%s][text()='%s']";

    //tr[@class='product-name']//td//label[text()='Name']//parent::td//following-sibling::td[1]//a[text()='First Prize Pies']
    public static final String NAME_PRODUCT ="xpath=//tr[@class='product-name']//td//label[text()='Name']//parent::td//following-sibling::td[%s]//a[text()='%s']";

}
