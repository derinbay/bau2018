package com.n11.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getResultText() {
//        WebElement element = driver.findElement(By.cssSelector(".resultText > h1"));
//        String text = element.getText();
//        return text;
        return findElementWhenVisible(By.cssSelector(".resultText > h1")).getText();
    }
}
