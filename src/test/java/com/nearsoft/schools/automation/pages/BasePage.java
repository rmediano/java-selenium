package com.nearsoft.schools.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {
    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private Actions actions;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 30);
        this.actions = new Actions(driver);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected Actions getActions() {
        return actions;
    }

    protected WebElement findElement(By locator) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return getDriver().findElement(locator);
    }

    protected List<WebElement> findElements(By locator) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return getDriver().findElements(locator);
    }

    protected void click(By locator) {
        findElement(locator).click();
    }

    protected void type(By locator, String inputText) {
        findElement(locator).sendKeys(inputText);
    }

    protected String getText(By locator) {
        return findElement(locator).getText();
    }

    protected boolean isElementDisplayed(By locator) {
        WebElement element = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element.isDisplayed();
    }

    protected String getTabTitle() {
        return getDriver().getTitle();
    }

    protected void hover(By locator) {
        getActions().moveToElement(findElement(locator)).perform();
    }
}
