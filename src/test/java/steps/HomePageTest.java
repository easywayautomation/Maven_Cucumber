package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import BrowserAccess.Browser;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hooks.Hooks;
import hooks.LoggerHelper;
import pages.FrameworkAccess;
import pages.HomePage;

public class HomePageTest {
	
	WebDriver driver;
	FrameworkAccess _frameworkAccess;
	HomePage  homepages ;
	Scenario sco;
	private static Logger log = LogManager.getLogger(LoggerHelper.class);
	
	@Before
	public void before(Scenario sco) {
		this.sco=sco;
	}
	
	public HomePageTest() {
		this.driver=Hooks.driver;
		this._frameworkAccess=Hooks._frameworkAccess;
	}
	
	@Given("^I want to Main capital one site$")
	public void i_want_to_Main_capital_one_site() {
		sco.write("Sajib");
		System.out.println("1st Step :@Given");
		Hooks.openBrowser(Browser.browser, Browser.baseurl);
		
	}

	@When("^I Enter MainMenu$")
	public void i_Enter_MainMenu() {
		// All type of Action 
		System.out.println("3rd Step in @When");
		homepages = new HomePage(); // 4th Step
		homepages.test1(); // 5th Step
	}

	@Then("^I validate Main Page$")
	public void i_validate_Main_Page() {
		// Asseration or verification or outcome
		System.out.println("6th Step in @Then");
//		Hooks.closeBrowser("");
	}
	

}
