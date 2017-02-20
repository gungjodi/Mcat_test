package mcat.pageObjects;

import mcat.utility.ActionKeywords;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Main_Page extends BaseClass{

	public Main_Page(WebDriver driver) {
		super(driver);
		
	}

	public static WebElement menu_McatMainMenu() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//a[contains(.,'MCat Menu')]");}
		catch(Exception e){throw(e);}
		return element;
	}
	
	public static WebElement menu_DataPreparation() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//a[contains(.,'Data Preparation')]");}
		catch(Exception e){throw(e);}
		return element;
	}
	public static WebElement menu_CatalogueItem() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//a[contains(.,'Catalogue Item')]");}
		catch(Exception e){throw(e);}
		return element;
	}
	public static WebElement menu_ManageItem() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//a[contains(.,'Manage Item')]");}
		catch(Exception e){throw(e);}
		return element;
	}
	//For access Security Configuration Menu
	public static WebElement menu_SecurityConfig() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//a[contains(.,'Security Configuration')]");}
		catch(Exception e){throw(e);}
		return element;
	}
	//For access Load Raw Data Menu
	public static WebElement menu_LoadRawData() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//a[contains(.,'Load Raw Data')]");}
		catch(Exception e){throw(e);}
		return element;
	}
	//For access Load Dictionary Menu
	public static WebElement menu_LoadDictionaryData() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//a[contains(.,'Load Dictionary Data')]");}
		catch(Exception e){throw(e);}
		return element;
	}
	//For access Attribute Menu
	public static WebElement menu_Attribute() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//a[(@class='main-menu') and( text()='Attribute')]");}
		catch(Exception e){throw(e);}
		return element;
	}
	//For access NSC Menu
	public static WebElement menu_NSC() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//a[contains(.,'NSC')]");}
		catch(Exception e){throw(e);}
		return element;
	}

	public static WebElement menu_INC() throws Exception
	{
		try
		{
			element = ActionKeywords.findElementByXpath("//a[contains(.,'INC')]");
		}
		catch (Exception e)
		{
			throw (e);
		}
		return element;
	}

	public static WebElement menu_UNSPSC() throws Exception
	{
		try
		{
			element = ActionKeywords.findElementByXpath("//a[contains(.,'UNSPSC')]");
		}
		catch (Exception e)
		{
			throw (e);
		}
		return element;
	}
	public static WebElement menu_BuildOutput() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//a[contains(.,'Build Output')]");}
		catch(Exception e){throw(e);}
		return element;
	}
	public static WebElement menu_RawDataItem() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//a[contains(.,'RAW Data Item')]");}
		catch(Exception e){throw(e);}
		return element;
	}
	public static WebElement menu_AssignedItem() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//a[contains(.,'Assigned Item')]");}
		catch(Exception e){throw(e);}
		return element;
	}
	public static WebElement menu_ReviewItem() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//a[contains(.,'Review Item')]");}
		catch(Exception e){throw(e);}
		return element;
	}
	public static WebElement menu_AdvanceSearch() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//a[contains(.,'Advance Search')]");}
		catch(Exception e){throw(e);}
		return element;
	}
	public static WebElement menu_PreOutputValidation() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//a[contains(.,'Pre-output Validation')]");}
		catch(Exception e){throw(e);}
		return element;
	}
	public static WebElement link_ProjectName() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//a[contains(.,'MATest2')]");}
		catch(Exception e){throw(e);}
		return element;
	}
	public static WebElement link_AboutUs() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//a[contains(.,'About Us')]");}
		catch(Exception e){throw(e);}
		return element;
	}
	public static WebElement link_Help() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//a[contains(.,'Help')]");}
		catch(Exception e){throw(e);}
		return element;
	}
	public static WebElement link_SendFeedback() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//a[contains(.,'Send a Feedback')]");}
		catch(Exception e){throw(e);}
		return element;
	}
	public static WebElement btn_Logout() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//a[@class='logoutbutton']");}
		catch(Exception e){throw(e);}
		return element;
	}
}
