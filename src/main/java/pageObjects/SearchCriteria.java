package pageObjects;

import utility.ActionKeywords;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchCriteria extends BaseClass {
	public SearchCriteria (WebDriver driver){
		super (driver);
	}
	public static void dropdown_SearchMethod(String id, String text) throws Exception{
		try{ActionKeywords.selectDropdownElementByVisibleText(id, text);}
		catch (Exception e){throw(e);}
		
	}
	public static void dropdown_Operator(String id, String text) throws Exception{
		try{ActionKeywords.selectDropdownElementByValue(id, text);}
		catch (Exception e){throw(e);}
	}
	public static WebElement btn_AddCriteria() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//a[contains(.,'Add Criteria')]");}
		catch (Exception e){throw(e);}
		return element;
	}
	public static WebElement btn_ClearAllValues() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//a[contains(.,'Clear All Values')]");}
		catch (Exception e){throw(e);}
		return element;
	}
	public static WebElement btn_RemoveAllCriteria() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//a[contains(.,'Remove All Criteria')]");}
		catch (Exception e){throw(e);}
		return element;
	}
	public static WebElement btn_Search() throws Exception{
		try{element = ActionKeywords.findElementById("criteriaSearchButton");}
		catch (Exception e){throw(e);}
		return element;
	}
}
