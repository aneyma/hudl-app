package com.hudl.app.stepdefs;

import com.hudl.app.pageObjects.LoginHelp;
import com.hudl.app.pageObjects.LoginPage;
import com.hudl.app.pageObjects.UserHomePage;
import com.hudl.app.utils.SharedDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    private final WebDriver driver;
    private LoginPage loginPage;
    private LoginHelp loginHelp;
    private UserHomePage userHomePage;


    public LoginSteps(SharedDriver sharedDriver){
        this.driver = sharedDriver;
        loginPage = new LoginPage(driver).get();
        loginHelp = new LoginHelp(driver).get();
        userHomePage = new UserHomePage(driver).get();
    }



    @When("I enter my correct credentials")
    public void i_enter_my_correct_credentials () {

        loginPage.enterCredentials("aneyma@gmail.com","Hudl1234");
    }

    @When("click login button")
    public void click_login_button () {

        loginPage.login();
    }


    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully () {

        Assert.assertTrue("Login Unsuccessful", userHomePage.isLoggedIn("Aneyma S"));
        driver.manage().deleteAllCookies();
    }

    @When("I enter my incorrect credentials")
    public void iEnterMyIncorrectCredentials() {

        loginPage.enterCredentials("xyz@gmail.com","abcd7654");
    }

    @Then("I should be alerted with an error message")
    public void iShouldBeAlertedWithAnErrorMessage() {

        Assert.assertTrue("No Login Error Displayed", loginPage.isLoginErrorDisplayed());
    }

    @When("I enter only password and blank email")
    public void iEnterOnlyPasswordAndBlankEmail() {

        loginPage.enterCredentials("","abcd7654");
    }

    @When("I enter only email and blank password")
    public void iEnterOnlyEmailAndBlankPassword() {

        loginPage.enterCredentials("aneyma@gmail.com","");
    }

    @Then("I should be prompted to enter the email to reset password")
    public void iShouldBePromptedToEnterTheEmailToResetPassword() {

        loginHelp.isLoginHelpPageDisplayed();
        loginHelp.resetPassword("xyz@gmail.com");
    }

    @When("I click on need help link")
    public void iClickOnNeedHelpLink() {
        loginPage.getHelp();
    }

    @And("I should see the check email message")
    public void iShouldSeeTheCheckEmailMessage() {

        Assert.assertTrue("", loginHelp.isRestPasswordSuccessful());
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.hudl.com/login/check-email" );
    }
}

