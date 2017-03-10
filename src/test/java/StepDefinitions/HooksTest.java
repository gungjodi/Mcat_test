package StepDefinitions;

import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utility.ActionKeywords;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

public class HooksTest {

	private static WebDriver driver;

	@Before
	public void buildDriver() throws Throwable{

		driver = ActionKeywords.OpenBrowser("Firefox");
//		driver = ActionKeywords.OpenBrowser("Chrome");
        driver.manage().window().maximize();
	}

	@After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); //stick it in the report
        }
        //		Thread.sleep(2000);
//        driver.close();
    }

//	public void closeBrowser() throws Throwable{
//		Thread.sleep(2000);
//		driver.close();
//	}
	
}
