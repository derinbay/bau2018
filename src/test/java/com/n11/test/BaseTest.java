package com.n11.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Locale;

public class BaseTest {

    WebDriver driver;

    @Before
    public void startUp() {
        Locale.setDefault(new Locale("en", "EN"));
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.n11.com");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
