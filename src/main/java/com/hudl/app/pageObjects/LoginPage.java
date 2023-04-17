package com.hudl.app.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage<LoginPage> {

    private static final String ERROR_MSG = "We didn't recognize that email and/or password.Need help?";

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@data-qa-id='email-input']")
    private WebElement emailTextField;

    @FindBy(xpath = "//*[@data-qa-id='password-input']")
    private WebElement passwordTextField;

    @FindBy(xpath = "//*[@data-qa-id='login-btn']")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[@data-qa-id='error-display']")
    private WebElement loginError;

    @FindBy(xpath = "//*[@data-qa-id='need-help-link']")
    private WebElement needHelpLink;

    public void enterCredentials(String email, String password){
        emailTextField.sendKeys(email);
        passwordTextField.sendKeys(password);
    }

    public void hudlLogin(String email, String password){
        emailTextField.sendKeys(email);
        passwordTextField.sendKeys(password);
        loginBtn.click();
    }

    public void login(){
        loginBtn.click();
    }

    public String getLoginError(){
        return loginError.getText();
    }

    public void getHelp(){
        needHelpLink.click();
    }

    public boolean isLoginErrorDisplayed(){
        return (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.textToBePresentInElement(loginError,ERROR_MSG));
    }

}
