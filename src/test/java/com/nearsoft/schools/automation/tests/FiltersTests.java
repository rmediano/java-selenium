package com.nearsoft.schools.automation.tests;

import org.testng.annotations.Test;

public class FiltersTests extends BaseTest {

    @Test(groups = {"Filters", "Smoke"})
    public void Filters_UserCanFilterInDressesPage() {
        // Navigate to Dresses page
        landingPage.selectFromMenu("Dresses");

        // Select filter
        dressesPage.selectFilter("Styles", "Casual");

        // Results are filtered
        // code to validate
    }

    @Test(groups = {"Filters"})
    public void Filters_UserCanFilterInTshirtsPage() {
        // Navigate to Dresses page
        landingPage.selectFromMenu("T-shirts");

        // Select filter
        tshirtsPage.selectFilter("Compositions", "Cotton");

        // Results are filtered
        // code to validate
    }
}
