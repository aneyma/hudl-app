package com.hudl.app.runner;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Registration {

    public static void main(String[] args) {

        // System Property for Chrome Driver
        System.setProperty("webdriver.chrome.driver", "/Users/aneyma/workspace/chromedriver");


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setAcceptInsecureCerts(true);

        // Instantiate a ChromeDriver class.
        WebDriver driver = new ChromeDriver(options);

        // Launch Website
        driver.navigate().to("http://www.hudl.com/");
        driver.findElement(By.xpath("//*[@data-qa-id='login-select']")).click();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        driver.findElement(By.xpath("//*[@data-qa-id='login-hudl']")).click();
        driver.findElement(By.xpath("//*[@data-qa-id='email-input']")).sendKeys("aneyma@gmail.com");
        driver.findElement(By.xpath("//*[@data-qa-id='password-input']")).sendKeys("Hudl1234");
        driver.findElement(By.xpath("//*[@data-qa-id='login-btn']")).click();
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.hui-globaluseritem__display-name > span")));
        Assert.assertTrue("Element not found", driver.findElement(By.cssSelector("div.hui-globaluseritem__display-name > span")).getText()
                .equalsIgnoreCase("Vinod"));


        //Maximize the browser
        driver.manage().window().maximize();

//        if(driver.findElement(By.className("ssrcss-1tt7th2-SearchText")).isDisplayed()){
//            System.out.println("displayed");
//
//            driver.findElement(By.className("e1gviwgp4")).click();


        // Click on the Search button

        driver.close();
        driver.quit();
    }
    }

