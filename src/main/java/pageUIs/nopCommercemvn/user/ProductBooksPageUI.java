package pageUIs.nopCommercemvn.user;

public class ProductBooksPageUI {
    //div[@class='product-grid']//div[@class='details']//h2//a[text()='Fahrenheit 451 by Ray Bradbury']
    public static final String PRODUCT_BOOKS="xpath=//div[@class='product-grid']//div[@class='details']//h2//a[text()='%s']";

    public static final String ADD_YOUR_REVIEW_LINK="xpath=//div[@class='product-review-links']//a[text()='Add your review']";

    public static final String ADD_PRODUCT_TITLE_TEXTBOX="xpath=//div[@class='inputs']//input[@id='AddProductReview_Title']";

    public static final String REVIEW_TEXT_TEXTBOX="xpath=//div[@class='inputs']//textarea[@id='AddProductReview_ReviewText']";

    //div[@class='rating-options']//input[@value='1']
    public static final String INPUT_RATING_RADIO="xpath=//div[@class='rating-options']//input[@value='%s']";

    public static final String SUBMIT_REVIEW_BUTTON="xpath=//div[@class='buttons']//button[text()='Submit review']";

    public static final String ADD_TO_WISH_LIST ="xpath=//div[@class='add-to-wishlist']//button";

   public static final String WISH_LIST ="xpath=//div[@class='bar-notification success']//p//a";

    //div[@class='bar-notification success']//p[contains(text(),'The product has been added to your')]//a[text()='wishlist']
   public static final String WISH_LIST_MESSAGGE ="xpath=//div[@class='bar-notification success']//p[contains(text(),'%s')]//a[text()='wishlist']";


    public static final String ADD_TO_COMPARE_LIST="xpath=//a[text()='%s']//parent::h2//following-sibling::div[@class='add-info']//div[@class='buttons']//button[@title='Add to compare list']";

    //div[@class='bar-notification success']//p[text()='The product has been added to your ']//a[text()='product comparison']
    public static final String ADD_TO_COMPARE_LIST_MESSAGE="xpath=//div[@class='bar-notification success']//p[text()='%s']//a[text()='product comparison']";



}
