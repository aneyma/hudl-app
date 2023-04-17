package com.hudl.app.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage<T extends BasePage<T>> extends LoadableComponent<T> {

    protected static WebDriver driver;
    private static final long wait = 30;

    protected BasePage(WebDriver webDriver) {
        driver = webDriver;
        PageFactory.initElements(driver,this);



    }

    @Override
            public void isLoaded() {}

            @Override
            public void load(){

            }

        public static boolean findElementSafely(WebElement webElement, By by) {

            try {
                return webElement.findElement(by).isEnabled();
            } catch (NoSuchElementException ex) {
                return false;
            }
        }

        public static void waitForElementToBeClickable(WebElement element){
            (new WebDriverWait(driver, Duration.ofSeconds(wait)))
                    .until(ExpectedConditions.elementToBeClickable(element));
        }

}
