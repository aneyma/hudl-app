package com.hudl.app.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * PageObject defining all elements and business actions applicable for Hudl LoginMenu
 */

public class LoginMenu extends BasePage<LoginMenu>{

    public LoginMenu(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@data-qa-id='login-hudl']")
    private WebElement hudl;

    public void selectHudl(){
        hudl.click();
    }

    @Override
    public void isLoaded() {}

    @Override
    public void load() {}


}
