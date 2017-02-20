package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.ActionKeywords;

public class LoadRawData_Page extends BaseClass{

	public LoadRawData_Page(WebDriver driver) {
		super(driver);
		
	}
	
	public static WebElement btn_UploadFile() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//input[@name='uploadFile']");}
		catch(Exception e){throw(e);}
		return element;
	}
	public static WebElement btn_LoadExcelFile() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//input[@id='loadButton']");}
		catch(Exception e){throw(e);}
		return element;
	}
}
