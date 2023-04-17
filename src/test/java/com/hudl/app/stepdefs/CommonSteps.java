package com.hudl.app.stepdefs;

import com.hudl.app.pageObjects.HomePage;
import com.hudl.app.pageObjects.LoginMenu;
import com.hudl.app.utils.SharedDriver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

import static com.hudl.app.utils.Constants.BASE_URL;

public class CommonSteps {

    private final WebDriver driver;
    private HomePage homePage;
    private LoginMenu loginMenu;

    public CommonSteps(SharedDriver sharedDriver){
        this.driver = sharedDriver;
        homePage = new HomePage(driver).get();
        loginMenu = new LoginMenu(driver).get();

    }

    @Given("the login page displays successfully")
    public void the_login_page_displays_successfully (){
        driver.navigate().to(BASE_URL);
        homePage.login();
        loginMenu.selectHudl();

    }
}
