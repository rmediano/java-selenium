package com.nearsoft.schools.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LandingTest extends BaseTest {

    @Test(groups = {"Landing", "Smoke"})
    public void Landing_UserNavigatesToMainPage() {
        // Check Logo is displayed
        Assert.assertTrue(landingPage.isLogoDisplayed(), "Logo is displayed.");

        // Check Search Box is displayed
        Assert.assertTrue(landingPage.isLogoDisplayed(), "Search Box is Displayed.");

        // Check Cart Preview is displayed
        Assert.assertTrue(landingPage.isCartPreviewDisplayed(), "Cart Preview is displayed.");
    }

    @Test(groups = {"Landing"})
    public void Landing_HoveringOverTopMenuDisplaysSubmenu() {
        // Mouse over Woman button
        landingPage.hoverMenuButton("Women");

        // Check Woman submenu is displayed
        Assert.assertTrue(landingPage.isSubmenuDisplayed("Women"), "Woman submenu is displayed after hovering Woman button.");
    }

}
