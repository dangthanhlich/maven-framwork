package pageUIs.nopCommercemvn.user;

public class OrderPageUI {
    public static final String ITEM_YOUR_CART ="xpath=//div[@class='mini-shopping-cart']//div[contains(text(),'There are')]//preceding-sibling::a[contains(text(),'%s')]";
    public static final String NAME_CART ="xpath=//div[@class='items']//div[@class='product']//div[@class='name']//a[text()='%s']";
    public static final String PRICE_CART ="xpath=//div[@class='mini-shopping-cart']//div[@class='totals']//strong[contains(text(),'%s')]";

    public static final String GO_TO_CART_BUTTON ="xpath=//button[@class='button-1 cart-button']";

    public static final String EDIT_CART ="xpath=//div[@class='edit-item']//a";

    public static final String REMOVE_CART ="xpath=//tbody//tr//td[@class='remove-from-cart']//button";

    public static final String CART_EMPTY_MESSAGE ="xpath=//div[@class='order-summary-content']//div";

    public static final String QTY_CART ="xpath=//td[@class='quantity']//input";
    public static final String UPDATE_CART ="xpath=//div[@class='common-buttons']//button[@id='updatecart']";

    public static final String TOTAL_CART ="xpath=//td[@class='subtotal']//span";

    public static final String ESTIMATE_SHIPPING ="xpath=//div[@class='common-buttons']/a[@id='open-estimate-shipping-popup']";

    public static final String SELECT_COUNTRY ="xpath=//div[@class='estimate-shipping-row']//select";

    public static final String ZIP_POSTAL_CODE ="xpath=//div[@class='estimate-shipping-row']//input[@id='ZipPostalCode']";

    public static final String APPLY_BUTTON ="xpath=//div[@class='apply-shipping-button-container']//button";
    public static final String GIFT_WRAPPING_NO ="xpath=//div[@class='cart-options']//div[@class='selected-checkout-attributes']";


    public static final String AGREE_CART ="xpath=//div[@class='terms-of-service']//input";

    public static final String CHECK_OUT_CART ="xpath=//div[@class='checkout-buttons']//button";

    public static final String INPUT_FIRST_NAME_TEXTBOX ="xpath=//div[@class='inputs']//input[@id='BillingNewAddress_FirstName']";

    public static final String INPUT_LAST_NAME_TEXTBOX ="xpath=//div[@class='inputs']//input[@id='BillingNewAddress_LastName']";

    public static final String INPUT_ADDRESS_EMAIL_TEXTBOX ="xpath=//div[@class='inputs']//input[@id='BillingNewAddress_Email']";

    public static final String INPUT_ADDRESS_COUNTRY_TEXTBOX ="xpath=//div[@class='inputs']//select[@id='BillingNewAddress_CountryId']";

    public static final String INPUT_CITY_TEXTBOX ="xpath=//div[@class='inputs']//input[@id='BillingNewAddress_City']";

    public static final String INPUT_ADDRESS1_TEXTBOX ="xpath=//div[@class='inputs']//input[@id='BillingNewAddress_Address1']";

    public static final String INPUT_ZIPPOSTAL_CODE_TEXTBOX ="xpath=//div[@class='inputs']//input[@id='BillingNewAddress_ZipPostalCode']";

    public static final String INPUT_PHONE_NUMBER_TEXTBOX ="xpath=//div[@class='inputs']//input[@id='BillingNewAddress_PhoneNumber']";

    public static final String CONTINUE_BUTTON ="xpath=//div[@id='billing-buttons-container']//button[text()='Continue']";

    //div[@class='method-name']//label[contains(text(),'Ground ($0.00)')]//preceding-sibling::input
    public static final String SHOPPING_METHOD_RADIO ="xpath=//div[@class='method-name']//label[contains(text(),'%s')]//preceding-sibling::input";

    public static final String CONTINUE_2_BUTTON ="xpath=//div[@id='shipping-method-buttons-container']//button[text()='Continue']";

    //div[@class='payment-details']//input//following-sibling::label[text()='Check / Money Order']
    public static final String CHECK_CART ="xpath=//div[@class='payment-details']//label[contains(text(),'%s')]//preceding-sibling::input";

    public static final String CONTINUE_3_BUTTON ="xpath=//div[@id='payment-method-buttons-container']//button[text()='Continue']";

    public static final String NOP_SOLUTION ="xpath=//div[@class='section payment-info']//p//b[text()='NOP SOLUTIONS']";

    public static final String CONTINUE_4_BUTTON ="xpath=//div[@id='payment-info-buttons-container']//button";

    public static final String EMAIL_ADDRESS ="xpath=//div[@class='billing-info']//ul[@class='info-list']//li[@class='email']";

    public static final String PHONE ="xpath=//div[@class='billing-info']//ul[@class='info-list']//li[@class='phone']";

    public static final String PAY_MENT_METHOD ="xpath=//div[@class='payment-method-info']//ul[@class='info-list']//li";


    public static final String SHIPPING_METHOD ="xpath=//div[@class='shipping-method-info']//ul[@class='info-list']//li";

    public static final String SKU ="xpath=//td[@class='sku']//span[@class='sku-number']";

    public static final String NAME_PRODUCT ="xpath=//tbody//tr//td[@class='product']//a";

    public static final String PRICE ="xpath=//td[@class='unit-price']//span";

    public static final String QTY ="xpath=//td[@class='quantity']//span";

    public static final String TOTAL ="xpath=//td[@class='subtotal']//span";

    public static final String GIFT_WRAPPING ="xpath=//div[@class='cart-options']//div";

//    public static final String SUB_TOTAL ="xpath=//tbody//tr[@class='order-subtotal']//td//label";
//
//    public static final String SHIPPING_GROUP ="xpath=//tbody//tr[@class='shipping-cost']//td//label";
//
//    public static final String TAX ="xpath=//tr[@class='tax-value']//td//label";
//
//    public static final String TOTAL_PAY ="xpath=//tr[@class='order-total']//td//label";

    //label[text()='Sub-Total:']//parent::td//following-sibling::td//span[text()='$1,000.00']
    public static final String PAY_SHIPPING ="xpath=//label[contains(text(),'%s')]//parent::td//following-sibling::td//span[contains(text(),'%s')]";

    public static final String CONFIRM ="xpath=//div[@id='confirm-order-buttons-container']//button";

    public static final String THANK_YOU_MESSAGE ="xpath=//div[@class='page checkout-page order-completed-page']//div[@class='page-title']//h1";

    public static final String ORDER_SUCESSFULLY_MESSAGE ="xpath=//div[@class='section order-completed']//div[@class='title']//strong";

    //public static final String ORDER_NUMBER ="xpath=//div[@class='details']//div[@class='order-number']//strong";

    public static final String DETAIL_BUTTON ="xpath=//div[@class='buttons']//button";

    //page order in my account
    public static final String MY_ACCOUNT_ORDER ="xpath=//div[@class='section order-item']//div//strong";
    public static final String ORDER ="xpath=//div[@class='order-overview']//div//strong";
    public static final String ORDER_DATE ="xpath=//ul[@class='order-overview-content']//li[@class='order-date']";
    public static final String ORDER_STATUS ="xpath=//ul[@class='order-overview-content']//li[@class='order-status']";
    public static final String ORDER_TOTAL ="xpath=//ul[@class='order-overview-content']//li[@class='order-total']";
    public static final String EMAIL ="xpath=//div[@class='billing-info']//ul[@class='info-list']//li[@class='email']";
    public static final String PAYMENT_METHOD ="xpath=//div[@class='payment-method-info']//ul[@class='info-list']//li[@class='payment-method']";
    public static final String PHONE_SHIPPING ="xpath=//div[@class='shipping-info']//ul[@class='info-list']//li[@class='phone']";
    public static final String SHIPPING_METHOD_ORDER ="xpath=//div[@class='shipping-method-info']//ul//li[@class='shipping-method']";
    public static final String SKU_ORDER ="xpath=//tbody//tr//td[@class='sku']//span";
    public static final String NAME_ORDER ="xpath=//td[@class='product']//em//a";
    public static final String PRICE_ORDER ="xpath=//td[@class='unit-price']//span";
    public static final String QUANTITY_ORDER ="xpath=//td[@class='quantity']//span";
    public static final String TOTAL_ORDER ="xpath=//td[@class='total']//span";
    public static final String GIFT_WRAPING_ORDER ="xpath=//div[@class='section options']//div";

    public static final String SUB_TOTAL_ORDERL ="xpath=//label[contains(text(),'%s')]//parent::td//following-sibling::td//span//strong[contains(text(),'%s')]";










}
