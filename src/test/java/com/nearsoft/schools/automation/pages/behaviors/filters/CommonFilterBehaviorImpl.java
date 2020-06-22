package com.nearsoft.schools.automation.pages.behaviors.filters;

import com.nearsoft.schools.automation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CommonFilterBehaviorImpl extends BasePage implements IFilterBehavior {
    public CommonFilterBehaviorImpl(WebDriver driver) {
        super(driver);
    }

    public void selectFilter(String filterTitle, String filterOption) {
        List<WebElement> filterDivs = findElements(By.cssSelector("div.layered_filter"));
        for (WebElement filterDiv : filterDivs) {
            String filterName = filterDiv.findElement(By.cssSelector("span.layered_subtitle")).getText();
            if (filterTitle.equals(filterName)) {
                List<WebElement> optionElements = filterDiv.findElements(By.cssSelector("ul > li"));
                for (WebElement optionElement: optionElements) {
                    String optionName = optionElement.findElement(By.cssSelector("label > a")).getText();
                    if (optionName.startsWith(filterOption)) {
                        optionElement.click();
                        return;
                    }
                }
            }
        }
        throw new NoSuchElementException("Filter " + filterTitle + ">" + filterOption + " was not found.");
    }

    public boolean isFilterSelected(String filterTitle, String FilterOption) {
        // code to check if filter is selected
        return false;
    }
}
