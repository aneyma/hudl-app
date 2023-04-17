package com.hudl.app.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginHelp extends BasePage<LoginHelp>{

    public LoginHelp(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@data-qa-id='password-reset-input']")
    private WebElement passResetTextField;

    @FindBy(xpath = "//*[@data-qa-id='password-reset-submit-btn']")
    private WebElement passResetBtn;

    @FindBy(xpath = "//h3[contains(text(), 'Check Your Email')]")
    private WebElement checkEmailText;

    @FindBy(xpath = "//*[@data-qa-id='login-help-headline']")
    private WebElement loginHelpText;

    public void resetPassword(String email){

        passResetTextField.sendKeys(email);
        passResetBtn.click();
    }

    public boolean isLoginHelpPageDisplayed(){
        return (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.textToBePresentInElement(loginHelpText,"Login Help"));
    }

    public boolean isRestPasswordSuccessful(){
        return (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.visibilityOf(checkEmailText)).isDisplayed();
    }


}
