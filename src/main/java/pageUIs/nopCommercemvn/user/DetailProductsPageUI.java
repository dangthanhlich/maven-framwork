package pageUIs.nopCommercemvn.user;

public class DetailProductsPageUI {

    //div[@class='footer-block customer-service']//ul//li//a[text()='Recently viewed products']
    public static final String RECENTLY_VIEWED_PRODUCTS="xpath=//div[@class='footer-block customer-service']//ul//li//a[text()='%s']";

    public static final String PROCESSER ="xpath=//div[@class='attributes']//dl/dd[@id='product_attribute_input_1']//select";

    public static final String RAM ="xpath=//div[@class='attributes']//dl/dd[@id='product_attribute_input_2']//select";

    public static final String HDD ="xpath=//dd[@id='product_attribute_input_3']//ul[@class='option-list']//li//input";

    public static final String OS ="xpath=//div[@class='attributes']//dl/dd[@id='product_attribute_input_4']//ul//li";

    public static final String SOFTWARE ="xpath=//div[@class='attributes']//dl/dd[@id='product_attribute_input_5']//ul//li//label[text()='%s']/preceding-sibling::input";

    public static final String ADD_TO_CART_BUTTON ="xpath=//div[@class='add-to-cart']//div//button[text()='%s']";

    //div[@class='bar-notification success']//p[text()='The product has been added to your ']//a[text()='shopping cart']
    public static final String ADD_TO_CART_SUCESS_MESSAGE ="xpath=//div[@class='bar-notification success']//p[text()='%s']//a[text()='shopping cart']";

    public static final String NUMBER_CART ="xpath=//input[@id='product_enteredQuantity_1']";


}
