package modules;

import utility.ActionKeywords;
import org.openqa.selenium.By;
import pageObjects.Main_Page;

public class HomePage_Module {
	
	public static void access_MCatMenu() throws Exception{
		try{
		    ActionKeywords.hoverAction(Main_Page.menu_McatMainMenu());
		}
		catch(Exception e)
		{
			throw(e);
		}
	}
	public static void access_DataPreparationMenu() throws Exception{
		try{
			ActionKeywords.clickAction(Main_Page.menu_DataPreparation());
		}
		catch(Exception e)
		{throw(e);}
	}
	public static void access_CatalogueItemMenu() throws Exception{
		try{
			ActionKeywords.clickAction(Main_Page.menu_CatalogueItem());
		}
		catch(Exception e)
		{throw(e);}
	}
	public static void access_ManageItemMenu() throws Exception{
		try{
			ActionKeywords.clickAction(Main_Page.menu_ManageItem());
		}
		catch(Exception e)
		{throw(e);}
	}

	public static void access_ManageItemMenuConfiguration() throws Exception{
		try{
			ActionKeywords.clickAction(Main_Page.menu_ManageItem_Configuration());
		}
		catch(Exception e)
		{throw(e);}
	}

	public static void access_LoadRawDataMenu() throws Exception{
		try{
			ActionKeywords.clickAction(Main_Page.menu_LoadRawData());
		}
		catch(Exception e)
		{throw(e);}
	}
	public static void access_RawDataItem() throws Exception{
		try{
			ActionKeywords.clickAction(Main_Page.menu_RawDataItem());
		}
		catch(Exception e)
		{throw(e);}
	}
	public static void access_LoadDictionaryDataMenu() throws Exception{
		try{
			ActionKeywords.clickAction(Main_Page.menu_LoadDictionaryData());
		}
		catch(Exception e)
		{throw(e);}
	}
	public static void access_AttributeMenu() throws Exception{
		try{
			ActionKeywords.clickAction(Main_Page.menu_Attribute());
		}
		catch(Exception e)
		{throw(e);}
	}


	public static void access_NSCMenu() throws Exception{
		try{
			ActionKeywords.clickAction(Main_Page.menu_NSC());
		}
		catch(Exception e)
		{throw(e);}
	}

	public static void access_UNSPSCMenu() throws Exception{
		try{
			ActionKeywords.clickAction(Main_Page.menu_UNSPSC());
		}
		catch(Exception e)
		{throw(e);}
	}

	public static void access_AttributeGroupMenu() throws Exception{
		try{
			ActionKeywords.clickAction(Main_Page.menu_AttributeGroup());
		}
		catch(Exception e)
		{throw(e);}
	}

	public static void access_INCMenu() throws Exception{
		try{
			ActionKeywords.clickAction(Main_Page.menu_INC());
		}
		catch(Exception e)
		{throw(e);}
	}

	public static void logout() throws Exception{
		try {
			ActionKeywords.clickAction(Main_Page.btn_Logout());
		}
		catch (Exception e)
		{
			throw (e);
		}
	}

	public static void waitLoading() throws Exception
	{
		try {
			ActionKeywords.waitForElementDisappear(By.xpath("//*[@id=\"ResultTable\"]/tbody/tr/td/img"));
		}
		catch (Exception e)
		{
			throw (e);
		}
	}
}

