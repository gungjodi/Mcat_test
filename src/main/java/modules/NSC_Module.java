package modules;

import utility.ActionKeywords;
import utility.Constant;
import utility.ExcelUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pageObjects.NscMenu_Page;
import pageObjects.RawDataItem_Page;
import pageObjects.SearchCriteria;

public class NSC_Module {
	public static void access_CreateNSCMenu() throws Exception{
		try{
			WebElement createNSCMenu= NscMenu_Page.CreateNSC_Menu();
		    ActionKeywords.clickAction(createNSCMenu);
		}
		catch(Exception e){throw(e);}
	}
	public static void access_SearchNSCMenu() throws Exception{
		try{
			WebElement searchNSCMenu= NscMenu_Page.SearchNSC_Menu();
		    ActionKeywords.clickAction(searchNSCMenu);
		}
		catch(Exception e){throw(e);}
	}
	public static void set_SearchNSCCriteria() throws Exception{
		try{
			HomePage_Module.waitLoading();
			ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
			ActionKeywords.clickAction(SearchCriteria.btn_AddCriteria());
			SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(1, 11));
			ActionKeywords.pageWait();
			SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(1, 12));
			
			String searchCriteria=ExcelUtils.getCellData(19, 5);
			RawDataItem_Page.txt_Criteria().sendKeys(searchCriteria);
			ActionKeywords.clickAction(SearchCriteria.btn_Search());
			HomePage_Module.waitLoading();

			String text =NscMenu_Page.link_NSCCode().getText();
			Assert.assertEquals(text, searchCriteria);
		}
		catch(Exception e){throw(e);}
	}

	public static void click_NSCCode() throws Exception{
		try{
			WebElement nscCode= NscMenu_Page.link_NSCCode();
		    ActionKeywords.clickAction(nscCode);
		}
		catch(Exception e){throw(e);}
	}
	public static void update_NSCDetail() throws Exception{
		try{ActionKeywords.clickAction(NscMenu_Page.btn_SaveNSCDetail());}
		catch(Exception e){throw(e);}
	}
}
