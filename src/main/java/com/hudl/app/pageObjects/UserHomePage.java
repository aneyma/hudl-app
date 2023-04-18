package com.hudl.app.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * PageObject defining all elements and business actions applicable for Hudl UserHomePage
 */
public class UserHomePage extends BasePage<UserHomePage>{

    public UserHomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "div.hui-globaluseritem__display-name > span")
    private WebElement userNameDisplay;


    public boolean isLoggedIn(String userName){
        return (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.textToBePresentInElement(userNameDisplay,userName));
    }

    @Override
    public void isLoaded() {}

    @Override
    public void load() {}



}
