package mcat.pageObjects;

import mcat.utility.ActionKeywords;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
