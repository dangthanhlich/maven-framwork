package pageUIs.nopCommercemvn.user;

public class SearchPageUI {
    public static final String SEARCH_TEXTBOX = "xpath=//div[@class='basic-search']//div[@class='inputs']//input";
    public static final String SEARCH_BUTTON = "xpath=//div[@class='buttons']//button";
    //div[@class='products-container']//div[@class='products-wrapper']//div[text()='Search term minimum length is 3 characters']
    public static final String SEARCH_ERROR_EMPTY_MESSAGE = "xpath=//div[@class='products-container']//div[@class='products-wrapper']//div[text()='%s']";

    //div[@class='product-item']//div//h2//a[text()='Lenovo Thinkpad X1 Carbon Laptop']
    public static final String PRODUCT_NAME = "xpath=//div[@class='product-item']//div//h2//a[text()='%s']";

    public static final String ADVANCED_SEARCH_CHECK = "xpath=//label[text()='Advanced search']//preceding-sibling::input";
    public static final String AUTOMATIONCALLY_CHECK = "xpath=//label[text()='Automatically search sub categories']//preceding-sibling::input";

    public static final String CATEGORY_DROPDOWN = "xpath=//div[@id='advanced-search-block']//div//select[@id='cid']";
    public static final String MANUFACTURE = "xpath=//div[@id='advanced-search-block']//div//select[@id='mid']";




}
