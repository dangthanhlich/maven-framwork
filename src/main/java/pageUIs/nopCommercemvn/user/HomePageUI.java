package pageUIs.nopCommercemvn.user;

public class HomePageUI {
    public static final String REGISTER_LINK ="css=a[class='ico-register']";
    public static final String LOGIN_LINK ="css=a[class='ico-login']";

    public static final String MY_ACCOUNT_LINK ="css=a[class='ico-account']";

    //ul[@class='list']//li//a[text()='Customer info']
    public static final String ITEM_LINK ="xpath=//ul[@class='list']//li//a[text()='%s']";

    //div[@class='header-menu']//ul//li//a[text()='Books ']
    //public static final String MENU_LINK="xpath=//div[@class='header-menu']//ul//li//a[text()='%s']";
    public static final String MENU_LINK="xpath=//div[@class='header-menu']//ul[@class='top-menu notmobile']//li//a[text()='%s']";
    public static final String MENU_COMPUTER_LINK="xpath=//div[@class='header-menu']//ul[@class='top-menu notmobile']//li//a[text()='Computers ']";
    public static final String MENU_NOTEBOOK_LINK="xpath=//div[@class='header-menu']//ul[@class='top-menu notmobile']//li//a[text()='Computers ']//following-sibling::ul//li//a[text()='Notebooks ']";

    public static final String SEARCH_FOOTER_LINK="xpath=//div[@class='footer-block customer-service']//ul//li/a[text()='Search']";
}
