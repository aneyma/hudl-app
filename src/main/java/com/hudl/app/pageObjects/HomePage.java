package com.hudl.app.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * PageObject defining all elements and business actions applicable for Hudl HomePage
 */
public class HomePage extends BasePage<HomePage>{

    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@data-qa-id='login-select']")
    private WebElement login;


    public void login(){
        login.click();
    }

    @Override
    public void isLoaded() {}

    @Override
    public void load() {}



}
