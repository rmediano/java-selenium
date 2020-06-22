package com.nearsoft.schools.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BasePage {

    private By logoBy = By.cssSelector("div#header_logo img");
    private By searchBoxBy = By.id("search_query_top");
    private By searchButtonBy = By.name("submit_search");
    private By cartPreviewBy = By.className("shopping_cart");

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoDisplayed() {
        return isElementDisplayed(logoBy);
    }

    public boolean isSearchBoxDisplayed() {
        return isElementDisplayed(searchBoxBy) &&
                isElementDisplayed(searchButtonBy);
    }

    public boolean isCartPreviewDisplayed() {
        return isElementDisplayed(cartPreviewBy);
    }

    public void hoverMenuButton(String menuTitle) {
        hover(By.cssSelector("#block_top_menu a[title=" + menuTitle + "]"));
    }

    public boolean isSubmenuDisplayed(String menuTitle) {
        return isElementDisplayed(By.cssSelector("#block_top_menu a[title=" + menuTitle + "] + ul"), 1);
    }

    public void selectFromMenu(String menuTitle) {
        click(By.cssSelector("#block_top_menu > ul > li > a[title=" + menuTitle + "]"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".category-name")));
    }
}
