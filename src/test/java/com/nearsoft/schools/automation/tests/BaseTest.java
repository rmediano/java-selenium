package com.nearsoft.schools.automation.tests;

import com.nearsoft.schools.automation.framework.DriverHandler;
import com.nearsoft.schools.automation.pages.DressesPage;
import com.nearsoft.schools.automation.pages.LandingPage;
import com.nearsoft.schools.automation.pages.SearchPage;
import com.nearsoft.schools.automation.pages.TshirtsPage;
import com.nearsoft.schools.automation.pages.behaviors.filters.CommonFilterBehaviorImpl;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public abstract class BaseTest {

    protected LandingPage landingPage;
    protected SearchPage searchPage;
    protected DressesPage dressesPage;
    protected TshirtsPage tshirtsPage;

    protected BaseTest() {
        landingPage = new LandingPage(getDriver());
        searchPage = new SearchPage(getDriver());
        dressesPage = new DressesPage(getDriver(), new CommonFilterBehaviorImpl(getDriver()));
        tshirtsPage = new TshirtsPage(getDriver(), new CommonFilterBehaviorImpl(getDriver()));
    }

    private WebDriver getDriver() {
        return DriverHandler.getWebDriver();
    }

    @BeforeSuite
    public static void setupSuite() {
        // Code to setup automation suite here
    }

    @BeforeMethod
    public void setupTest() {
        DriverHandler.getWebDriver().get("http://automationpractice.com/");
    }
    @AfterMethod
    public void teardownTest() {
        DriverHandler.clearWebDriver();
    }

    @AfterSuite
    public static void teardownSuite() {
        DriverHandler.teardownWebDriver();
    }
}
