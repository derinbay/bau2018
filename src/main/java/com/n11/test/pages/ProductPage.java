package com.n11.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    By addToCartButton = By.className("btnAddBasket");
    By productTitle = By.className("proName");
    By cartIcon = By.className("myBasket");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        clickTo(addToCartButton);
    }

    public String getProductName() {
        return findElementWhenVisible(productTitle).getText();
    }

    public MyCartPage goToCart() {
        clickTo(cartIcon);
        return new MyCartPage(driver);
    }
}
