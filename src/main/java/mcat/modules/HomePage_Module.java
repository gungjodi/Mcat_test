package mcat.modules;

import mcat.utility.ActionKeywords;
import org.openqa.selenium.WebElement;
import mcat.pageObjects.Main_Page;

public class HomePage_Module {
	
	public static void access_MCatMenu() throws Exception{
		try{
			WebElement menuHover= Main_Page.menu_McatMainMenu();
		    ActionKeywords.hoverAction(menuHover);
		}
		catch(Exception e)
		{
			throw(e);
		}
	}
	public static void access_DataPreparationMenu() throws Exception{
		try{
			//access_MCatMenu();
			WebElement dataPreparationMenu = Main_Page.menu_DataPreparation();
			ActionKeywords.clickAction(dataPreparationMenu);
		}
		catch(Exception e)
		{throw(e);}
	}
	public static void access_CatalogueItemMenu() throws Exception{
		try{
			WebElement catalogueItemMenu = Main_Page.menu_CatalogueItem();
			ActionKeywords.clickAction(catalogueItemMenu);
		}
		catch(Exception e)
		{throw(e);}
	}
	public static void access_ManageItemMenu() throws Exception{
		try{
			WebElement manageItemMenu = Main_Page.menu_ManageItem();
			ActionKeywords.clickAction(manageItemMenu);
		}
		catch(Exception e)
		{throw(e);}
	}

	public static void access_ManageItemMenuConfiguration() throws Exception{
		try{
			WebElement manageItemMenu = Main_Page.menu_ManageItem_Configuration();
			ActionKeywords.clickAction(manageItemMenu);
		}
		catch(Exception e)
		{throw(e);}
	}

	public static void access_LoadRawDataMenu() throws Exception{
		try{
			WebElement loadRawDataMenu = Main_Page.menu_LoadRawData();
			ActionKeywords.clickAction(loadRawDataMenu);
		}
		catch(Exception e)
		{throw(e);}
	}
	public static void access_RawDataItem() throws Exception{
		try{
			WebElement rawDataItemMenu = Main_Page.menu_RawDataItem();
			ActionKeywords.clickAction(rawDataItemMenu);
		}
		catch(Exception e)
		{throw(e);}
	}
	public static void access_LoadDictionaryDataMenu() throws Exception{
		try{
			WebElement loadDictionaryDataMenu = Main_Page.menu_LoadDictionaryData();
			ActionKeywords.clickAction(loadDictionaryDataMenu);
		}
		catch(Exception e)
		{throw(e);}
	}
	public static void access_AttributeMenu() throws Exception{
		try{
			WebElement attributeMenu = Main_Page.menu_Attribute();
			ActionKeywords.clickAction(attributeMenu);
		}
		catch(Exception e)
		{throw(e);}
	}


	public static void access_NSCMenu() throws Exception{
		try{
			WebElement nscMenu = Main_Page.menu_NSC();
			ActionKeywords.clickAction(nscMenu);
		}
		catch(Exception e)
		{throw(e);}
	}

	public static void access_UNSPSCMenu() throws Exception{
		try{
			WebElement UNSPSCMenu = Main_Page.menu_UNSPSC();
			ActionKeywords.clickAction(UNSPSCMenu);
		}
		catch(Exception e)
		{throw(e);}
	}

	public static void access_AttributeGroupMenu() throws Exception{
		try{
			WebElement UNSPSCMenu = Main_Page.menu_AttributeGroup();
			ActionKeywords.clickAction(UNSPSCMenu);
		}
		catch(Exception e)
		{throw(e);}
	}

	public static void access_INCMenu() throws Exception{
		try{
			WebElement nscMenu = Main_Page.menu_INC();
			ActionKeywords.clickAction(nscMenu);
		}
		catch(Exception e)
		{throw(e);}
	}

	public static void logout() throws Exception{
		try {
			WebElement logout = Main_Page.btn_Logout();
			ActionKeywords.clickAction(logout);
		}
		catch (Exception e)
		{
			throw (e);
		}
	}
}

