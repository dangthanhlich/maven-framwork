package pageObjects.nopCommercemvn.usermvn;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.nopCommercemvn.user.HomePageUI;
import pageUIs.nopCommercemvn.user.SearchPageUI;
import pageUIs.nopCommercemvn.user.SortDisplayPaingPageUI;
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
        // khai báo ra 1 ArayList để chứa product name trên UI
        ArrayList<Float> productUIList = new ArrayList<Float>();

        // lấy ra hết tất cả các text product name
        List<WebElement> productPriceText = getListWebElement(driver, SortDisplayPaingPageUI.PRODUCT_PRICE_TEXT);

        // dùng vòng lawpk để getText và add vào ArayList trên
        for (WebElement productPrice : productPriceText) {

            productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
            System.out.print("Product name  on UI" + productPrice.getText());
        }

        // tạo ra 1 ArayList mới để sort dữ liệu trong ArayList cũ xem đúng hay không
        ArrayList<Float> productSortList = new ArrayList<Float>();
        for (Float product : productUIList) {
            productSortList.add(product);
        }

        // sort cái ProductsortList
        Collections.sort(productUIList);
        for (Float productName : productSortList) {
            System.out.print("Product name after sort" + productName);
        }

        // so sánh 2 List đã bằng nhau
        return productSortList.equals(productUIList);
    }

    public boolean isProductPriceSortByDescending() {
        // khai báo ra 1 ArayList để chứa product name trên UI
        ArrayList<Float> productUIList = new ArrayList<Float>();

        // lấy ra hết tất cả các text product name
        List<WebElement> productPriceText = getListWebElement(driver, SortDisplayPaingPageUI.PRODUCT_PRICE_TEXT);

        // dùng vòng lawpk để getText và add vào ArayList trên
        for (WebElement productPrice : productPriceText) {

            productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
            System.out.print("Product name  on UI" + productPrice.getText());
        }

        // tạo ra 1 ArayList mới để sort dữ liệu trong ArayList cũ xem đúng hay không
        ArrayList<Float> productSortList = new ArrayList<Float>();
        for (Float product : productUIList) {
            productSortList.add(product);
        }

        // sort cái ProductsortList
        Collections.sort(productUIList);
        for (Float productName : productSortList) {
            System.out.print("Product name after sort" + productName);
        }

        Collections.reverse(productSortList);

        // so sánh 2 List đã bằng nhau
        return productSortList.equals(productUIList);
    }
}
