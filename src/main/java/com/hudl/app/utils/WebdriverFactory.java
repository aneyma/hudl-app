package com.hudl.app.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class WebdriverFactory {

    private static WebDriver driver;
    private static final Logger log = Logger.getLogger(WebdriverFactory.class);


    public static WebDriver getWebdriver() {

        if(driver == null) {
            try{

                log.info("CREATING NEW INSTANCE OF WEBDRIVER");
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
                driver = createFirefoxDriver();
                break;
            default:
                driver = createFirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        return driver;
    }

    /**
     *Returns the browser to run the tests on set via System property
     * If no system property variable set the default browser Firefox will be returned
     */
    private static String getBrowserType() {

        try{
            return System.getProperty("browser").toLowerCase();
        }catch (NullPointerException ex) {
            return "firefox";
        }
    }

    private static WebDriver createFirefoxDriver() {
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    private static WebDriver createChromeDriver() {

        log.info(System.getProperty("chrome_driver_path"));
        final String path = System.getProperty("chrome_driver_path");
        if(path==null)
            throw new RuntimeException("PLEASE SUPPLY THE PATH FOR CHROME DRIVER");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }
}
