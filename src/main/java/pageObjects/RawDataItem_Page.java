package pageObjects;

import utility.ActionKeywords;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.ExcelUtils;

import java.util.List;

public class RawDataItem_Page extends BaseClass {

	public RawDataItem_Page(WebDriver driver) {
		super(driver);
		
	}
	public static WebElement menu_SearchRawDataItem() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//a[contains(.,'Search RAW Data Item')]");}
		catch(Exception e){throw(e);}
		return element;
	}
	public static WebElement txt_Criteria() throws Exception{
		try{element = ActionKeywords.findElementByXpath(".//*[@id='value1_0']");}
		catch(Exception e){throw(e);}
		return element;
	}

	public static WebElement txt_Criteria1() throws Exception{
		try{element = ActionKeywords.findElementByXpath(".//*[@id='value1_1']");}
		catch(Exception e){throw(e);}
		return element;
	}

	public static WebElement btn_Name() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//input[@type='button' and @value='Name']");}
		catch(Exception e){throw(e);}
		return element;
	}

	public static WebElement btn_Edit() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//input[@type='button' and @value='Edit']");}
		catch(Exception e){throw(e);}
		return element;
	}
	public static WebElement btn_Print() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//input[@type='button' and @value='Print']");}
		catch(Exception e){throw(e);}
		return element;
	}
	public static WebElement btn_Tag() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//input[@type='button' and @value='Tag']");}
		catch(Exception e){throw(e);}
		return element;
	}

	public static WebElement btn_searchAssignedTo() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//a[contains(@href,'AssignedToCatName')]");}
		catch(Exception e){throw(e);}
		return element;
	}

	public static WebElement btn_Assign() throws Exception{
		try{element = ActionKeywords.findElementById("AssignButton");}
		catch(Exception e){throw(e);}
		return element;
	}

	public static WebElement btn_AssignItems() throws Exception{
		try{element = ActionKeywords.findElementByXpath(".//input[@type='button' and @value='Assign']");}
		catch(Exception e){throw(e);}
		return element;
	}

	public static WebElement btn_doAssignitem() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//*[@type='submit' and @value='Assign']");}
		catch(Exception e){throw(e);}
		return element;
	}

	public static List<WebElement> RawDataRows() throws Exception{
		try{
			elements = ActionKeywords.findElementsByXpath("//*[@id='ResultTable']/tbody/tr");
		}

		catch(Exception e){throw(e);}
		return elements;
	}

	public static WebElement StockCodeLink(String xpath) throws Exception
	{
		try {
			element = ActionKeywords.findElementByXpath(xpath);
		}
		catch (Exception e)
		{
			throw (e);
		}
		return element;
	}

	public static WebElement linkUsername(String username) throws Exception
	{
		try {
			element = ActionKeywords.findElementByPartialLinkText(username);
		}
		catch (Exception e)
		{
			throw (e);
		}
		return element;
	}

	public static WebElement nameLink() throws Exception
	{
		try
		{
			element = ActionKeywords.findElementByXpath("//*[@id='NameButton']");
		}
		catch (Exception e)
		{
			throw (e);
		}
		return element;
	}

    public static WebElement firstRowTable() throws Exception
	{
		try {
			element = ActionKeywords.findElementByXpath("//*[@id='ResultRow0']/td[2]/a");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}

	public static WebElement firstItemStatus() throws Exception
	{
		try {
			element = ActionKeywords.findElementByXpath("//*[@id='ResultRow0Col5']");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}

	public static WebElement searchIncBtn() throws Exception
	{
		try {
			element = ActionKeywords.findElementByXpath("//a[contains(@href,'/Nsc/IncLookup')]");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}


}
