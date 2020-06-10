package com.nearsoft.schools.automation.pages;

import com.nearsoft.schools.automation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
