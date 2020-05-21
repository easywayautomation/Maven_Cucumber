package pages;

import org.openqa.selenium.WebDriver;

import BasePage.BasePage2;
import BasePage.BasePageAbs;
import cucumber.api.Scenario;
import hooks.Hooks;

public class HomePage extends BasePageAbs {

	public static WebDriver driver;
	public static  FrameworkAccess _frameworkAccess;
	public static  Scenario sco;

	public HomePage() {
		super();
	}

	
	public void test1() {
		
		super.fName();
//		super.lName();

	}


	@Override
	public void homepage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

}
