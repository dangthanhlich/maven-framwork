package pageObjects.nopCommercemvn.usermvn;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.nopCommercemvn.user.*;
import pageUIs.sauceLab.ProductPageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortDisplayPaingPageObject extends BasePage {
    private WebDriver driver;

    public SortDisplayPaingPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void selectItemInProductSortDropdown(String textItem) {
        waitForElementClickable(driver, SortDisplayPaingPageUI.SORT_BY_ITEM);
        selectItemDefaultDropdown(driver, SortDisplayPaingPageUI.SORT_BY_ITEM, textItem);
    }

    public boolean isProductNameSortByAscending() {
        ArrayList<String> productUIList = new ArrayList<String>();

        List<WebElement> productNameText = getListWebElement(driver, SortDisplayPaingPageUI.PRODUCT_NAME_TEXT);

        for (WebElement productName : productNameText) {
            productUIList.add(productName.getText());
            System.out.print("Product name  on UI" + productName.getText());
        }

        ArrayList<String> productSortList = new ArrayList<String>();
        for (String product : productUIList) {
            productSortList.add(product);
        }

        Collections.sort(productUIList);
        for (String productName : productSortList) {
            System.out.print("Product name after sort" + productName);
        }

        return productSortList.equals(productUIList);
    }

    public boolean isProductNameSortByDescending() {
        ArrayList<String> productUIList = new ArrayList<String>();


        List<WebElement> productNameText = getListWebElement(driver, SortDisplayPaingPageUI.PRODUCT_NAME_TEXT);

        for (WebElement productName : productNameText) {
            productUIList.add(productName.getText());
            System.out.print("Product name  on UI" + productName.getText());
        }

        ArrayList<String> productSortList = new ArrayList<String>();
        for (String product : productUIList) {
            productSortList.add(product);

        }

        for (String productName : productSortList) {
            System.out.print("Product name after sort ASC" + productName);
        }
        Collections.sort(productUIList);
        sleepInSecond(3);
        Collections.reverse(productSortList);
        for (String productName : productSortList) {
            System.out.print("Product name after sort DESC" + productName);
        }

        return productSortList.equals(productUIList);
    }

    public boolean isProductPriceSortByAscendig() {
        ArrayList<Float> productUIList = new ArrayList<Float>();

        List<WebElement> productPriceText = getListWebElement(driver, SortDisplayPaingPageUI.PRODUCT_PRICE_TEXT);

        for (WebElement productPrice : productPriceText) {

            productUIList.add(Float.parseFloat(productPrice.getText().replace("$", ",").replace(",", "")));
            System.out.print("Product name  on UI:" + productPrice.getText() + "\n");
        }

        ArrayList<Float> productSortList = new ArrayList<Float>();
        for (Float product : productUIList) {
            productSortList.add(product);
        }

        Collections.sort(productSortList);
        for (Float productName : productSortList) {
            System.out.print("Product name after sort" + productName + "\n");
        }

        return productSortList.equals(productUIList);
    }

    public boolean isProductPriceSortByDescending() {
        // khai báo ra 1 ArayList để chứa product name trên UI
        ArrayList<Float> productUIList = new ArrayList<Float>();

        // lấy ra hết tất cả các text product name
        List<WebElement> productPriceText = getListWebElement(driver, SortDisplayPaingPageUI.PRODUCT_PRICE_TEXT);

        // dùng vòng lawpk để getText và add vào ArayList trên
        for (WebElement productPrice : productPriceText) {

            productUIList.add(Float.parseFloat(productPrice.getText().replace("$", ",").replace(",", "")));
            System.out.print("Product name  on UI" + productPrice.getText() + "\n");
        }

        // tạo ra 1 ArayList mới để sort dữ liệu trong ArayList cũ xem đúng hay không
        ArrayList<Float> productSortList = new ArrayList<Float>();
        for (Float product : productUIList) {
            productSortList.add(product);
        }

        // sort cái ProductsortList
        Collections.sort(productSortList);
        for (Float productName : productSortList) {
            System.out.print("Product name after sort" + productName + "\n");
        }
        Collections.reverse(productSortList);
        return productSortList.equals(productUIList);
    }

    public void selectNumberInProductSortDropdown(String numberproduct) {
        waitForElementClickable(driver, SortDisplayPaingPageUI.NUMBER_PRODUCT);
        selectItemDefaultDropdown(driver, SortDisplayPaingPageUI.NUMBER_PRODUCT, numberproduct);
    }

    public DetailProductsPageObject clickToProductName(String nameproduct) {
        waitForElementClickable(driver, SortDisplayPaingPageUI.PRODUCT_NAME, nameproduct);
        clickToElement(driver, SortDisplayPaingPageUI.PRODUCT_NAME, nameproduct);
        return PageGeneratorManager.getDetailProductsPage(driver);
    }


    public RecentlyViewedProductsPageObject clickToRecentlyViewedProducts(String recently_viewed_products) {
        waitForElementClickable(driver, DetailProductsPageUI.RECENTLY_VIEWED_PRODUCTS, recently_viewed_products);
        clickToElement(driver, DetailProductsPageUI.RECENTLY_VIEWED_PRODUCTS, recently_viewed_products);
        return PageGeneratorManager.getRecentlyViewedProductsPage(driver);
    }
}
