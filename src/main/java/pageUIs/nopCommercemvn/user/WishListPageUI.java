package pageUIs.nopCommercemvn.user;

public class WishListPageUI {
    //div[@class='share-info']//a[@class='share-link']
    public static final String WISHLIST_SHARE_LINK = "xpath=//div[@class='share-info']//a[@class='share-link']";

    //tbody//tr//td[@class='product']//a[text()='Fahrenheit 451 by Ray Bradbury']
    public static final String PRODUCT_WISHLIST = "xpath=//tbody//tr//td[@class='product']//a[text()='%s']";

    public static final String CHECKBOX_WISHlIST="xpath=//tbody//tr//td[@class='add-to-cart']//input";

    public static final String ADD_TO_CART="xpath=//div[@class='buttons']//button[text()='Add to cart']";
    public static final String UPDATE_WISHLIST="xpath=//div[@class='buttons']//button[text()='Update wishlist']";

    public static final String REMOVE_WISHLIST="xpath=//td[@class='remove-from-cart']//button[@class='remove-btn']";

    //div[@class='page-body']//div[contains(text(),'The wishlist is empty!')]
    public static final String EMPTY_WISH_LIST_MESSAGE="xpath=//div[@class='page-body']//div[contains(text(),'%s')]";



}
