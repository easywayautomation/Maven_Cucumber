package pages;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hooks.Hooks;
import hooks.LoggerHelper;

public class FrameworkAccess {

	public static WebDriver driver;
	public static JavascriptExecutor js;
	public FrameworkAccess _frameworkAccess;
	private static Logger log = LogManager.getLogger(LoggerHelper.class);

	public FrameworkAccess() {
		this.driver = Hooks.driver;
		this._frameworkAccess = Hooks._frameworkAccess;
	}

	public void openURl(String url) {
		driver.get(url);
	}

	public void pageLoadFor2Seconds() {
		((JavascriptExecutor) driver).executeAsyncScript("window.setTimeout(arguments[arguments.length-1], 2000);");

	}

	public void pageLoadFor(long millis) {
		try {
			Thread.sleep(millis);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void drawBorder(WebElement element, WebDriver driver) {
		js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid blue'", element);

	}

	public void flash(WebElement element, WebDriver driver) {
		js = ((JavascriptExecutor) driver);
		String bgColor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 2; i++) {
			changeColor("rgb(0,200,0)", element, driver);
			changeColor(bgColor, element, driver);

		}

	}

	public void changeColor(String color, WebElement element, WebDriver driver) {
		js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
		pageLoadFor(500);

	}

	private Actions getActions() {
		return new Actions(driver);
	}

	public WebElement mouseHover(WebElement e) {
		Actions actions = getActions();
		actions.moveToElement(e).build().perform();
		return e;
	}

	private WebDriverWait getWebDriverWait() {
		return new WebDriverWait(driver, 60);
	}

	public WebElement wait_until_element_to_be_visible(By locator) {
		WebDriverWait wait = getWebDriverWait();
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitUntilClickable(WebElement e) {
		WebDriverWait wait = getWebDriverWait();
		return wait.until(ExpectedConditions.elementToBeClickable(e));

	}

	public WebElement findElementByXpath(String xpath) {
		try {
			return driver.findElement(By.xpath(xpath));
		} catch (Exception e) {
			return null;
		}
	}

	public void clickByXpath(String xpath) {
		try {
			WebElement e = waitUntilClickable(mouseHover(findElementByXpath(xpath)));
			flash(e, driver);
			drawBorder(e, driver);
			e.click();
		} catch (Exception e) {
			System.err.println("Not found");
		}

	}

	public void typeTextByXpath(String xpath, Keys tab) {

		WebElement ele = driver.findElement(By.xpath(xpath));
		flash(ele, driver);
		drawBorder(ele, driver);
		try {
			ele.sendKeys(tab);
		} catch (Exception e) {
			System.err.println("Not found");
		}
	}
	
	public void typeTextByXpath(String xpath, String typeText) {
		try {
			WebElement ele = driver.findElement(By.xpath(xpath));
			flash(ele, driver);
			drawBorder(ele, driver);
			try {
				ele.sendKeys(typeText);
				log.info("Sajib");
			} catch (Exception e) {
				System.err.println("Not found");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}

	public void verifyTextByXpath(String xpath, String textToverify) {
		try {
			String actual = findElementByXpath(xpath).getText();
			flash(driver.findElement(By.xpath(xpath)), driver);
			drawBorder(driver.findElement(By.xpath(xpath)), driver);
			if (actual.equals((textToverify))) {
			} else {
				System.err.println("xpath Not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
