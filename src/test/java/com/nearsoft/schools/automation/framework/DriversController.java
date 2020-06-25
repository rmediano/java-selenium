package com.nearsoft.schools.automation.framework;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriversController {
    private static DriversController instance;
    private ConcurrentHashMap<Integer, WebDriver> driverMap;

    private DriversController() {
        driverMap = new ConcurrentHashMap<>();
    }

    public static DriversController getInstance() {
        if (instance == null) {
            instance = new DriversController();
        }

        return instance;
    }

    public int getDriverId() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--window-size=1024x768");
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        int id = webDriver.hashCode();

        // Code to move window manually
        /*
        try {
            Thread.sleep(TimeUnit.MILLISECONDS.convert(30, TimeUnit.MINUTES));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        */

        driverMap.put(id, webDriver);
        return id;
    }

    public WebDriver getDriver(int id) {
        return driverMap.get(id);
    }

    public synchronized void clearWebDriver(int id) {
        WebDriver driver = driverMap.get(id);

        if (driver != null) {
            driver.manage().deleteAllCookies();
        }
    }

    public synchronized void teardownWebDriver(int id) {
        WebDriver driver = driverMap.get(id);

        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
