package com.nearsoft.schools.automation.tests;

import com.nearsoft.schools.automation.framework.DriversController;
import com.nearsoft.schools.automation.pages.DressesPage;
import com.nearsoft.schools.automation.pages.LandingPage;
import com.nearsoft.schools.automation.pages.SearchPage;
import com.nearsoft.schools.automation.pages.TshirtsPage;
import com.nearsoft.schools.automation.pages.behaviors.filters.CommonFilterBehaviorImpl;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public abstract class BaseTest {

    protected int webDriverId;
    protected LandingPage landingPage;
    protected SearchPage searchPage;
    protected DressesPage dressesPage;
    protected TshirtsPage tshirtsPage;

    protected BaseTest() {
        webDriverId = DriversController.getInstance().getDriverId();
        landingPage = new LandingPage(getDriver());
        searchPage = new SearchPage(getDriver());
        dressesPage = new DressesPage(getDriver(), new CommonFilterBehaviorImpl(getDriver()));
        tshirtsPage = new TshirtsPage(getDriver(), new CommonFilterBehaviorImpl(getDriver()));
    }

    private WebDriver getDriver() {
        return DriversController.getInstance().getDriver(webDriverId);
    }

    @AfterClass(groups = {"Filters", "Landing", "Smoke"})
    public void setupSuite() {
        // Code to setup automation suite here
    }

    @BeforeMethod(groups = {"Filters", "Landing", "Smoke"})
    public void setupTest() {
        DriversController.getInstance().getDriver(webDriverId).get("http://automationpractice.com/");
    }
    @AfterMethod(groups = {"Filters", "Landing", "Smoke"})
    public void teardownTest() {
        DriversController.getInstance().clearWebDriver(webDriverId);
    }

    @AfterClass(groups = {"Filters", "Landing", "Smoke"})
    public void teardownSuite() {
        DriversController.getInstance().teardownWebDriver(webDriverId);
    }
}
