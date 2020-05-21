package hooks;

import java.awt.Toolkit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.FrameworkAccess;

public class Hooks {

	public static WebDriver driver;
	public static DesiredCapabilities cap = null;
	public static FrameworkAccess _frameworkAccess;
	public static WebDriverWait wait;
	public static String browser;
	public static String baseurl = "E:/February Class/xpath.html";
	
	public Hooks() {
	}

	@Before
	public static void openBrowser(String browsername, String url) {

		if (driver == null) {

			if (browsername.equals("firefox")) {

				cap = DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");
				cap.setPlatform(Platform.WIN10);

			} else if (browsername.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				_frameworkAccess = new FrameworkAccess();
				
				java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				double width = screenSize.getWidth();
				double height = screenSize.getHeight();
				if (width <= 1920) {
					Point point = new Point((int) width, 0);
					driver.manage().window().setPosition(point);
					driver.manage().window().maximize();
				} else

				{
					Point point = new Point(0, 0);
					driver.manage().window().setPosition(point);

					Dimension targetWindowSize = new Dimension(1920, 1080);
					driver.manage().window().setSize(targetWindowSize);
				}

			} 

		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public static void closeBrowser(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException e) {
				System.err.println(e.getMessage());
			} catch (ClassCastException c) {
				c.printStackTrace();
			}
		}
		driver.close();
		driver.quit();
	}

}
