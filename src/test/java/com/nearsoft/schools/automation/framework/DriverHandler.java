package com.nearsoft.schools.automation.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Deprecated
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

    public static void clearWebDriver() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
        }
    }

    public static void teardownWebDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
