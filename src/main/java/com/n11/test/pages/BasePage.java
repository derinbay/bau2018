package com.n11.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 60); // 60 seconds of default wait timeout
    }

    public void write(By by, String text) {
    	findElementWhenVisible(by).sendKeys(text);
    }

    public void clickTo(By by) {
    	findElementWhenVisible(by).click();
    }
    
    /**
     * Waits until every element selected by given CSS selector is visible.
     * @param selector CSS Selector to select elements to test visibilities
     * @throws TimeoutException if the default timeout (60 seconds) exceeds.
     */
    public void waitForVisibilities(By selector) {
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selector));
    }
    
    /**
     * Waits until every element matching given CSS selector to become visible, then finds the very first item with given CSS selector.
     * @param selector CSS Selector to select element.
     * @return WebElement selected by given CSS selector.
     * @throws TimeoutException if the default timeout (60 seconds) exceeds, while waiting for all elements to come visible
     */
    public WebElement findElementWhenVisible(By selector) {
    	waitForVisibilities(selector);
    	return driver.findElement(selector);
    }
}
