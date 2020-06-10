package com.nearsoft.schools.automation.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverHandler {
    private static WebDriver driver;
    public static WebDriver getWebDriver() {
        if (driver == null) {
            driver = setupWebDriver();
        }
        return driver;
    }

    private static WebDriver setupWebDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
