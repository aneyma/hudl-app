package com.hudl.app.stepdefs;

import com.hudl.app.utils.SharedDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * StepDef class for generic browser actions
 */
public class BrowserControlSteps {

    private final WebDriver driver;
	private static final Logger log = Logger.getLogger(BrowserControlSteps.class);

	@Before
	public void startUp(){
		log.info("STARTING THE HUDL LOGIN TESTS");
	}

	public BrowserControlSteps(SharedDriver s_driver)
    {
		this.driver = s_driver;
	}
	
	@Given("^I navigate to \"(.*?)\"$")
	public void i_navigate_to(String url) throws Throwable {

		driver.get(url);
		log.info("THE BROWSER TITLE IS - " + driver.getTitle() );
	}

}
