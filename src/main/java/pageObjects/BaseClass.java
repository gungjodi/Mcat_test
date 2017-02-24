package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseClass {

	public static WebDriver driver;
	public static WebElement element;
	public static List<WebElement> elements;
	public static boolean bResult;
	public BaseClass(WebDriver driver){
		BaseClass.driver = driver;
		BaseClass.bResult = true;
	}
}
