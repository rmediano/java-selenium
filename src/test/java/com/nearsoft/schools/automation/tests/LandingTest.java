package com.nearsoft.schools.automation.tests;

import org.junit.Test;
import org.junit.Assert;

public class LandingTest extends BaseTest {

    @Test
    public void navigatingToMainPage() {
        // Navigate to Main Page
        getDriver().get("http://automationpractice.com");

        // Check Logo is displayed
        Assert.assertTrue("Logo is displayed.", landingPage.isLogoDisplayed());

        // Check Search Box is displayed
        Assert.assertTrue("Search Box is Displayed.", landingPage.isLogoDisplayed());

        // Check Cart Preview is displayed
        Assert.assertTrue("Cart Preview is displayed.", landingPage.isCartPreviewDisplayed());
    }

}
