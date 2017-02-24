package StepDefinitions;

import utility.ActionKeywords;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

public class HooksTest {

	public static WebDriver driver;
	
	@Before
	public void buildDriver()throws Throwable{

		driver = ActionKeywords.OpenBrowser("Firefox");
//		driver = ActionKeywords.OpenBrowser("Chrome");
        driver.manage().window().maximize();
	}
	@After
	public void closeBrowser() throws Throwable{
		Thread.sleep(2000);
		driver.close();
	}
	
}
