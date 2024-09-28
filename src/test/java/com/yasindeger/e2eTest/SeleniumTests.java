package com.yasindeger.e2eTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTests {


    @DisplayName("Selenium Sample Test")
    @Test
    public void simpleNavigationToGoogle(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);
        driver.get("http://www.google.com");
        System.out.println("driver.getTitle() = " + driver.getTitle());
        driver.quit();

    }
}
