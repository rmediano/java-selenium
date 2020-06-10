package com.nearsoft.schools.automation.tests;

import com.nearsoft.schools.automation.framework.DriverHandler;
import com.nearsoft.schools.automation.pages.LandingPage;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {

    protected LandingPage landingPage;

    public BaseTest() {
        landingPage = new LandingPage(getDriver());
    }

    protected WebDriver getDriver() {
        return DriverHandler.getWebDriver();
    }
}
