package com.hudl.app.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginMenu extends BasePage<LoginMenu>{

    public LoginMenu(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@data-qa-id='login-hudl']")
    private WebElement hudl;

    public void selectHudl(){
        hudl.click();
    }


}
