package pageUIs.nopCommercemvn.user;

public class OrderPageUI {
    public static final String ITEM_YOUR_CART = "xpath=//div[@class='mini-shopping-cart']//div[contains(text(),'There are')]//preceding-sibling::a[contains(text(),'%s')]";
    public static final String NAME_CART = "xpath=//div[@class='items']//div[@class='product']//div[@class='name']//a[text()='%s']";
    public static final String PRICE_CART = "xpath=//div[@class='mini-shopping-cart']//div[@class='totals']//strong[contains(text(),'%s')]";

    public static final String GO_TO_CART_BUTTON = "xpath=//button[@class='button-1 cart-button']";

    public static final String EDIT_CART = "xpath=//div[@class='edit-item']//a";

    public static final String REMOVE_CART = "xpath=//tbody//tr//td[@class='remove-from-cart']//button";

    public static final String CART_EMPTY_MESSAGE = "xpath=//div[@class='order-summary-content']//div";

    public static final String QTY_CART = "xpath=//td[@class='quantity']//input";
    public static final String UPDATE_CART = "xpath=//div[@class='common-buttons']//button[@id='updatecart']";

    public static final String TOTAL_CART = "xpath=//td[@class='subtotal']//span";


}
