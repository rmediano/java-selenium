package com.nearsoft.schools.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void Search_UserSearchesWithEmptyCriteria() {
        // Click on the search button
        searchPage.search("");

        // Expected result
        Assert.assertTrue(searchPage.isPageDisplayed(),"Search page is displayed");
        Assert.assertEquals(searchPage.getNumberOfResultsFound(),"0 results have been found.","Number of results is equal to 0");
        Assert.assertEquals(searchPage.getAlertMessage(),"Please enter a search keyword","'Please enter a search keyword' alert message is displayed");
    }

    @Test
    public void Search_UserSearchesUsingAValidKeyword() {
        // Search a valid keyword in the search box
        searchPage.search("Blouse");

        // Expected result
        Assert.assertEquals(searchPage.getSearchKeyword(),"\"BLOUSE\"","The keyword used is displayed next to title in quotes and uppercase");
        Assert.assertEquals(searchPage.getNumberOfResultsFound(),"1 result has been found.", "Number of results is equal to 1");
        Assert.assertTrue(searchPage.isItemDisplayedOnGrid("Blouse"),"Blouse item is displayed on the grid");
    }
}
