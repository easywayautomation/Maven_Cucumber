package BasePage;

import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.RegEx;

import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import cucumber.api.Scenario;
import hooks.Hooks;
import pages.FrameworkAccess;

public abstract class BasePageAbs implements BasePage, BasePage2 {

	 WebDriver driver;
	 FrameworkAccess _frameworkAccess;
	 String fname="fristName";
	 String lname="lname";
	 ArrayList<String> userName = new ArrayList<String>();
	
	 @FindBy(xpath="//input[@id='lastName']") public WebElement fnames;
	 
	 
	public BasePageAbs() {
		System.out.println("4th Step: Home Page Constructor");
		this.driver=Hooks.driver;
		this._frameworkAccess=Hooks._frameworkAccess;
		PageFactory.initElements(driver, this);
	}
	
//	@Override
	public void fName2() {
		
		int i=0;
		int retry=5;
		while (i<5) {
//			_frameworkAccess.typeTextByXpath("//input[@id='"+Searching.xpath()+"' or '"+b()+"']", ""+c()+"");
			driver.findElement(By.xpath("//input[@id='lastName' ]")).sendKeys("Sajib00"+i);
			userName.add("Sajib00"+i);
//			driver.findElement(By.xpath("//input[@id='lastName' ]")).clear();
			_frameworkAccess.pageLoadFor(2000);
			
			driver.findElement(By.xpath("//input[@id='lname' ]")).sendKeys("Tonni"+i);
//			driver.findElement(By.xpath("//input[@id='lname' ]")).clear();
			userName.add("Tonni"+i);
			_frameworkAccess.pageLoadFor(2000);
			driver.findElement(By.xpath("//input[@type='submit' ]")).click();
			i=i+1;
			
		};
		

		
	}
	

	public void fName1() {
		
		int i=0;
		int retry=5;
		do {
//			_frameworkAccess.typeTextByXpath("//input[@id='"+Searching.xpath()+"' or '"+b()+"']", ""+c()+"");
			driver.findElement(By.xpath("//input[@id='lastName' ]")).sendKeys("Sajib00"+i);
//			driver.findElement(By.xpath("//input[@id='lastName' ]")).clear();
			_frameworkAccess.pageLoadFor(2000);
			
			driver.findElement(By.xpath("//input[@id='lname' ]")).sendKeys("Tonni"+i);
//			driver.findElement(By.xpath("//input[@id='lname' ]")).clear();
			_frameworkAccess.pageLoadFor(2000);
			driver.findElement(By.xpath(/*UserName*/ "//input[@type='submit' ]" /* Pass*/)).click();
			i=i+1;
		} while (i<5);
		

		
	}
	
	
public void fName() {
		
		int j=0;
		int retry=5;
		
		for ( j = 0; j < retry; j++) {
//			_frameworkAccess.typeTextByXpath("//input[@id='"+Searching.xpath()+"' or '"+b()+"']", ""+c()+"");
			driver.findElement(By.xpath("//input[@id='lastName' ]")).sendKeys("Sajib00"+j);
			userName.add("Sajib00"+j);
//			driver.findElement(By.xpath("//input[@id='lastName' ]")).clear();
			_frameworkAccess.pageLoadFor(2000);
			
			driver.findElement(By.xpath("//input[@id='lname' ]")).sendKeys("Tonni"+j);
			userName.add("Tonni"+j);
//			driver.findElement(By.xpath("//input[@id='lname' ]")).clear();
			_frameworkAccess.pageLoadFor(2000);
			driver.findElement(By.xpath("//input[@type='submit' ]")).click();

		}
		
		for (String name : userName) {
			System.out.println(name);
		}

		
	}
	

	
	
	
	@Override
	public void lName() {
		_frameworkAccess.pageLoadFor(2000);
//		_frameworkAccess.typeTextByXpath("//input[@id='lname' ]", ""+c()+"");
		_frameworkAccess.pageLoadFor(2000);
		
	}
	
	
	@Override
	public abstract void homepage() ;
	public String a() {
		String a="fristName";
		return a;
		
	}
	
	public String b() {
		String b="lastName";
		return b;
		
	}
	
	public String c() {
		String c= "Typing ... Frist Name"; 
		return c;
	}
	public String name() {
		return null;
	}
	
	public void logout() {
		System.out.println("Logout Page");
	};
}
