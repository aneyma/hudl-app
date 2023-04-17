package com.hudl.app.stepdefs;

import com.hudl.app.utils.SharedDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

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
		System.out.println("THE BROWSER TITLE IS - " + driver.getTitle() );
	}
	
//	@Given("^I set the browser dimensions to the specified size$")
//	public void i_set_the_browser_dimensions_to_the_specified_size(DataTable table) throws Throwable {
//		 Map<String,String> rows = table.asMaps(String.class, String.class).get(0);
//	     int width = Integer.parseInt(rows.get("width"));
//	     int height = Integer.parseInt(rows.get("height"));
//	     driver.manage().window().setSize(new Dimension(width, height));
//	}
	
	
//	/**
//     * Method to be invoked after the scenario has completed execution
//     */
//
//	public void clearBrowser(){
//
//        System.out.println("Cleaning session values of browser instance");
//
//	}

}
