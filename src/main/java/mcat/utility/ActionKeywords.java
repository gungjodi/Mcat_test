package mcat.utility;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import mcat.pageObjects.BaseClass;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ActionKeywords extends BaseClass {
	
	public ActionKeywords (WebDriver driver){
		super (driver);
	}
	static String parentWindow;
	static Set<String> handles;
	public static String browserName;
	public static WebDriver OpenBrowser (String browserName) throws Exception{
		try{
		
			if(browserName.equals("Firefox")){
				driver = new FirefoxDriver();
			}
			else if(browserName.equals("IE")){
				driver=new InternetExplorerDriver();
			}
			else if(browserName.equals("Chrome")){
				driver=new ChromeDriver();
			}
			ActionKeywords.browserName = browserName;
		}
		catch (Exception e)
		{throw(e);}
		
		return driver;
	}

	//Select Dropdown list by Visible Text
	public static void selectDropdownElementByVisibleText (String id, String text){
		element= driver.findElement(By.id(id));
		Select oSelect = new Select (element);
		oSelect.selectByVisibleText(text);
	}
	
	//Select Dropdown list by Value
	public static void selectDropdownElementByValue (String id, String value){
		element= driver.findElement(By.id(id));
		Select oSelect = new Select (element);
		oSelect.selectByValue(value);
	}
	
	public static void refreshPage(){
		driver.navigate().refresh();
	}
	
	public static void waitForElement(By by){
		 WebDriverWait wait = new WebDriverWait(driver, 10);
	     wait.until(ExpectedConditions.visibilityOfElementLocated((By) by));
	}

	public static void waitForElementDisappear(By by){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.ignoring(StaleElementReferenceException.class)
			.ignoring(NoSuchElementException.class)
			.until(ExpectedConditions.invisibilityOfElementLocated((By) by));
	}

	public static void implicitWait(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	
	public static void navigateOnWindow (String windowHandler) throws Exception{
		try{driver.switchTo().window(windowHandler);}
		catch(Exception e){throw(e);}
	}
	
	public static void getCurrentURL () throws Exception{
		try{driver.getCurrentUrl();}
		catch(Exception e){throw(e);}
	}

	public static void hoverAction(WebElement element) throws Exception{
		try {
			Actions action = new Actions (driver);
			action.moveToElement(element).build().perform();
		}
		catch(Exception e){throw(e);}
	}

	public static void moveToElementAction(WebElement element) throws Exception{
		try {
			Actions action = new Actions (driver);
			action.moveToElement(element).click().build().perform();
		}
		catch(Exception e){throw(e);}
	}

	public static void clickAction(WebElement element) throws Exception{
		try {element.click();}
		catch(Exception e){throw(e);}
	}
	public static String getParentWindow() throws Exception{
		try{parentWindow = driver.getWindowHandle();}
		catch(Exception e){throw(e);}
		return parentWindow;
	}
	public static Set<String> getAllWindows() throws Exception{
		try{handles = driver.getWindowHandles();}
		catch(Exception e){throw(e);}
		return handles;
	}
	
	public static WebElement findElementByXpath (String xpathExpression) throws Exception{
		try {element = driver.findElement(By.xpath(xpathExpression));}
		catch(Exception e){throw(e);}
		return element;
	}
	public static WebElement findElementById (String id) throws Exception{
		try {element = driver.findElement(By.id(id));}
		catch(Exception e){throw(e);}
		return element;
	}
	public static WebElement findElementByName (String name) throws Exception{
		try {element = driver.findElement(By.name(name));}
		catch(Exception e){throw(e);}
		return element;
	}
	public static WebElement findElementByCssSelector (String cssSelector) throws Exception{
		try {element = driver.findElement(By.cssSelector(cssSelector));}
		catch(Exception e){throw(e);}
		return element;
	}
	// ---Additional for scenario--- 
	// 4. Manage Item - Create NSC	
	public static void pageWait(){
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	public static void moveToElementExecutor(WebElement element)throws Exception {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("arguments[0].click();", element);
	}

	public static List<WebElement> findElementsById(String idSelector) throws Exception
    {
        elements = driver.findElements(By.id(idSelector));
        return elements;
    }

    public static List<WebElement> findElementsByClass(String classSelector) throws Exception
    {
        elements = driver.findElements(By.className(classSelector));
        return elements;
    }

    public static List<WebElement> findElementsByXpath(String xpathSelector) throws Exception
    {
        elements = driver.findElements(By.xpath(xpathSelector));
        return elements;
    }

    public static WebElement findElementByPartialLinkText(String partialLinkText) throws Exception
	{
		element = driver.findElement(By.partialLinkText(partialLinkText));
		return element;
	}

	public static void checkAlert() throws Exception{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			//exception handling
		}
	}

	public static void closeWindow() throws Exception
	{
		try {
			driver.close();
		}
		catch (Exception e)
		{
			throw (e);
		}
	}
}
