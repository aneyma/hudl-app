package com.hudl.app.utils;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Base class to maintain driver instance through out the tests.
 * The webdriver instance will be injected to required stepdefs
 */
public class SharedDriver extends EventFiringWebDriver {

    private static WebDriver driver = WebdriverFactory.getWebdriver();

    public SharedDriver() {
        super(driver);
    }

    @After
    private static void afterStep(){
        driver.manage().deleteAllCookies();
    }
}
