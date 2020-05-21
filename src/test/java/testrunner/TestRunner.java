package testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {
				
				"src/test/resources/Feature/HomePage.feature",
				
			},
		glue = {"steps"}, 
		plugin = {"pretty", "html:target/cucumber-html-report",
				"json:target/Destination/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		},		
		monochrome=true,
		strict = false,
		dryRun = false,
		tags= {"@SmokeTest"}
		
		
		
		)


public class TestRunner {
	
}
