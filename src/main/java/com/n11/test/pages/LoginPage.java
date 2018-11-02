package com.n11.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    By emailBy = By.id("email");
    By passwordBy = By.id("password");
    By loginButtonBy = By.id("loginButton");

    By emailByCss = By.cssSelector("#email");
    By passwordByName = By.name("password");
    By passwordByCss = By.cssSelector("#password");
    By passwordByAttributeCss = By.cssSelector("[type='password']");
    By passwordByCssValue = By.cssSelector("#loginForm input[type=password]");
    By passwordXpath = By.xpath("//*[@id='loginForm']//*[@id='password']");
    By passwordByXpath2 = By.xpath("//*[@id='password']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login() {
        login("123qwe");
    }
    public void login(String password) {
        write(emailBy, "testbau@mailinator.com");
        write(passwordBy, password);
        clickTo(loginButtonBy);
    }

    public boolean isErrorDisplayed(String warning) {
        return findElementWhenVisible(By.cssSelector("[data-errormessagefor=" + warning + "]")).isDisplayed();
    }
}
