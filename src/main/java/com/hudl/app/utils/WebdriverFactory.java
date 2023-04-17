package com.hudl.app.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class WebdriverFactory {

    private static WebDriver driver;
    private final static String DEFAULT_FF_VERSION = "47.0.1";
    private final static String HUB_URL = "http://localhost:4444/wd/hub/";

    public static WebDriver getWebdriver() {

        if(driver == null) {
            try{

                System.out.println("CREATING NEW INSTANCE OF WEBDRIVER");
                driver = initialiseWebDriver();
                driver.manage().window().maximize();
            } finally {
                try {
                    Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
                } catch (Exception e) { }
            }
        }
        return driver;
    }

    private static class BrowserCleanup implements Runnable {
        @Override
        public void run() {
            driver.quit();
        }
    }

    /**
     * Creates a new instance of WebDriver based on the browser string set.
     * @return WebDriver
     */
    private static WebDriver initialiseWebDriver() {
        String browserType = getBrowserType();
        WebDriver driver;
        switch (browserType) {
            case "chrome" :
                driver = createChromeDriver();
                break;
            case "firefox" :
            default:
                driver = createChromeDriver();
        }

        return driver;
    }

    /**
     *Returns the browser to run the tests on set via System property
     * If no system property variable set the default browser Chrome will be returned
     */
    private static String getBrowserType() {

        try{
            return System.getProperty("browser").toLowerCase();
        }catch (NullPointerException ex) {
            return "chrome";
        }
    }

    private static WebDriver createFirefoxFDriver() {
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    private static WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "/Users/aneyma/workspace/chromedriver");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        return driver;
    }
}
