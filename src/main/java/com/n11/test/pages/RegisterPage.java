package com.n11.test.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By registrationEmail = By.id("registrationEmail");
    By registrationPassword = By.id("registrationPassword");
    By passwordAgain = By.id("passwordAgain");
    By genderMale = By.cssSelector("[for=genderMale]");
    By acceptContract = By.cssSelector("[for=acceptContract]");
    By submitButton = By.id("submitButton");

    public void register() {
        write(firstName, "Bau");
        write(lastName, "Test");
        write(registrationEmail, "testbau_" + RandomStringUtils.randomAlphabetic(5) + "@mailinator.com");
        write(registrationPassword, "123qwe");
        write(passwordAgain, "123qwe");
        clickTo(genderMale);
        jsClick("acceptContract");
        clickTo(submitButton);
    }
}
