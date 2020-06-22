package com.nearsoft.schools.automation.pages;

import com.nearsoft.schools.automation.pages.behaviors.filters.IFilterBehavior;
import org.openqa.selenium.WebDriver;

public class DressesPage extends BasePage {

    private IFilterBehavior filter;

    public DressesPage(WebDriver driver, IFilterBehavior filterBehavior) {
        super(driver);
        this.filter = filterBehavior;
    }

    public void selectFilter(String filterTitle, String filterOption) {
        filter.selectFilter(filterTitle, filterOption);
    }

}
