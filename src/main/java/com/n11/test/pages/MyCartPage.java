package com.n11.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyCartPage extends BasePage {

    By prodDescription = By.className("prodDescription");

    public MyCartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return findElementWhenVisible(prodDescription).getText();
    }
}
