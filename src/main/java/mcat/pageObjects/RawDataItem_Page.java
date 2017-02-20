package mcat.pageObjects;

import cucumber.api.java.en_old.Ac;
import mcat.utility.ActionKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

	public static WebElement searchLink() throws Exception
    {
        try
        {
            element = ActionKeywords.findElementByXpath("html/body/div[4]/div/div[2]/form/div/table/tbody/tr[4]/td[2]/a");
        }
        catch (Exception e)
        {
            throw (e);
        }
        return element;
    }
}
