package com.nearsoft.schools.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class BasePage {
    private WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebElement findElement(By locator) {
        return getDriver().findElement(locator);
    }

    protected List<WebElement> findElements(By locator) {
        return getDriver().findElements(locator);
    }

    protected void click(By locator) {
        findElement(locator).click();
    }

    protected void type(By locator, String inputText) {
        findElement(locator).sendKeys(inputText);
    }

    protected boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
