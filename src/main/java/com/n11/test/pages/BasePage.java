package com.n11.test.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    WebDriver driver;

    By cookieUsagePopIn = By.id("cookieUsagePopIn");
    By closeCookiePopup = By.className("closeBtn");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToBeClickable(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeInvisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void write(By by, String text) {
        findElement(by).sendKeys(text);
    }

    public void clickTo(By by) {
        try {
            findElement(by).click();
        } catch (WebDriverException ex) {
            if (ex.getMessage().contains("is not clickable at point")) {
                findElement(closeCookiePopup).click();
                waitForElementToBeInvisible(cookieUsagePopIn);
                findElement(by).click();
            }
        }
    }

    public WebElement findElement(By by) {
        waitForElementToBeClickable(by);
        return driver.findElement(by);
    }

    public void jsClick(String id) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.getElementById('" + id + "').click()");
    }
}
