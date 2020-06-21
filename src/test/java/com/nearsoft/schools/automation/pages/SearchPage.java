package com.nearsoft.schools.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    private By searchBoxBy = By.id("search_query_top");
    private By searchButtonBy = By.name("submit_search");
    private By pageTitleBy = By.cssSelector(".page-heading");
    private By resultsCounterBy = By.cssSelector(".heading-counter");
    private By alertMessageBy = By.cssSelector(".alert-warning");
    private By searchKeywordBy = By.cssSelector(".lighter");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void search(String keyword) {
        type(searchBoxBy, keyword);
        click(searchButtonBy);
    }

    public boolean isPageDisplayed() {
        return getTabTitle().startsWith("Search") && isElementDisplayed(pageTitleBy);
    }

    public String getNumberOfResultsFound() {
        return getText(resultsCounterBy);
    }

    public String getAlertMessage() {
        return getText(alertMessageBy);
    }

    public boolean isItemDisplayedOnGrid(String productName) {
        return isElementDisplayed(By.cssSelector(".product-container .product-name[title~=" + productName + "]"));
    }

    public String getSearchKeyword() {
        return getText(searchKeywordBy);
    }
}
