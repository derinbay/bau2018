package com.n11.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    By btnSignUp = By.cssSelector(".btnSignUp");
    By searchInput = By.id("searchData");
    By searchButton = By.className("iconSearch");
    By firstProduct = By.cssSelector(".catGroup .tabPanel.active li");

    public LoginPage clickToLogin() {
    	findElementWhenVisible(By.cssSelector(".btnSignIn")).click();
        return new LoginPage(driver);
    }

    public String getUserName() {
        return findElementWhenVisible(By.className("user")).getText();
    }

    public RegisterPage clickRegisterButton() {
        clickTo(btnSignUp);
        return new RegisterPage(driver);
    }

    public SearchResultPage search(String keyword) {
        write(searchInput, keyword);
        clickTo(searchButton);
        return new SearchResultPage(driver);
    }

    public ProductPage getFirstProduct() {
        findElementWhenVisible(firstProduct).click();
        return new ProductPage(driver);
    }
}
