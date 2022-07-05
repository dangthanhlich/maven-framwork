package pageObjects.sauceLab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.sauceLab.ProductPageUI;

public class ProductPageObject extends BasePage {
	WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInProductSortDropdown(String textItem) {
		waitForElementClickable(driver, ProductPageUI.PRODUCT_SORT_CONTAINER_DROPDOWN);
		selectItemDefaultDropdown(driver, ProductPageUI.PRODUCT_SORT_CONTAINER_DROPDOWN, textItem);
	}

	public boolean isProductNameSortByAscending() {
		// khai báo ra 1 ArayList để chứa product name trên UI
		ArrayList<String> productUIList = new ArrayList<String>();

		// lấy ra hết tất cả các text product name
		List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);

		// dùng vòng lawpk để getText và add vào ArayList trên
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
			System.out.print("Product name  on UI" + productName.getText());
		}

		// tạo ra 1 ArayList mới để sort dữ liệu trong ArayList cũ xem đúng hay không
		ArrayList<String> productSortList = new ArrayList<String>();
		for (String product : productUIList) {
			productSortList.add(product);
		}

		// sort cái ProductsortList
		Collections.sort(productUIList);
		for (String productName : productSortList) {
			System.out.print("Product name after sort" + productName);
		}

		// so sánh 2 List đã bằng nhau
		return productSortList.equals(productUIList);
	}

	public boolean isProductNameSortByDescending() {
		// khai báo ra 1 ArayList để chứa product name trên UI
		ArrayList<String> productUIList = new ArrayList<String>();

		// lấy ra hết tất cả các text product name
		List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);

		// dùng vòng lawpk để getText và add vào ArayList trên
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
			System.out.print("Product name  on UI" + productName.getText());
		}

		// tạo ra 1 ArayList mới để sort dữ liệu trong ArayList cũ xem đúng hay không
		ArrayList<String> productSortList = new ArrayList<String>();
		for (String product : productUIList) {
			productSortList.add(product);

		}

		for (String productName : productSortList) {
			System.out.print("Product name after sort ASC" + productName);
		}
		// sort cái ProductsortList
		Collections.sort(productUIList);

		// reverse cái ProductsortList
		Collections.reverse(productSortList);
		for (String productName : productSortList) {
			System.out.print("Product name after sort DESC" + productName);
		}

		// so sánh 2 List đã bằng nhau
		return productSortList.equals(productUIList);
	}

	public boolean isProductPriceSortByAscendig() {
		// khai báo ra 1 ArayList để chứa product name trên UI
		ArrayList<Float> productUIList = new ArrayList<Float>();

		// lấy ra hết tất cả các text product name
		List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE_TEXT);

		// dùng vòng lawpk để getText và add vào ArayList trên
		for (WebElement productPrice : productPriceText) {
//			String priceText = productPrice.getText();
//
//			// xóa kiểu kí tự $ đi
//			priceText.replace("$", "");
//
//			// Convert qua kiểu float
//			Float priceTextFloat = Float.parseFloat(priceText);
//
//			productUIList.add(priceTextFloat);

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
		List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE_TEXT);

		// dùng vòng lawpk để getText và add vào ArayList trên
		for (WebElement productPrice : productPriceText) {
//			String priceText = productPrice.getText();
//
//			// xóa kiểu kí tự $ đi
//			priceText.replace("$", "");
//
//			// Convert qua kiểu float
//			Float priceTextFloat = Float.parseFloat(priceText);
//
//			productUIList.add(priceTextFloat);

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
