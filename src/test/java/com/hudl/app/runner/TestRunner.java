package com.hudl.app.runner;

/*
    Runner class to run stepdefs
 */

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features="classpath:features/",
        glue={"com.hudl.app.stepdefs"},
        plugin = {"pretty",
                "html:target/results.html",
                "json:target/json/results.json",
        }

)

public class TestRunner {


}
