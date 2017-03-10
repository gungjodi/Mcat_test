package modules;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pageObjects.*;
import utility.ActionKeywords;
import utility.Constant;
import utility.ExcelUtils;

public class INC_Module {
	public static void access_CreateINCMenu() throws Exception{
		try{
		    ActionKeywords.clickAction(IncMenu_Page.CreateINC_Menu());
		}
		catch(Exception e){throw(e);}
	}
	public static void access_SearchINCMenu() throws Exception{
		try{
		    ActionKeywords.clickAction(IncMenu_Page.SearchINC_Menu());
		}
		catch(Exception e){throw(e);}
	}
	public static void set_SearchINCCriteria() throws Exception{
		try{
			HomePage_Module.waitLoading();
			ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
			ActionKeywords.clickAction(SearchCriteria.btn_AddCriteria());
			SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(5, 11));
			ActionKeywords.pageWait();
			SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));
			
			String searchCriteria=ExcelUtils.getCellData(19, 1);
			RawDataItem_Page.txt_Criteria().sendKeys(searchCriteria);
			ActionKeywords.clickAction(SearchCriteria.btn_Search());
			HomePage_Module.waitLoading();

//			String text = ConfigurationManage_Page.link_INCName().getText();
//
//			Assert.assertEquals(searchCriteria, text);
		}
		catch(Exception e){throw(e);}
	}

	public static void click_INCCode() throws Exception{
		try{
		    ActionKeywords.clickAction(IncMenu_Page.link_INCCode());
		}
		catch(Exception e){throw(e);}
	}
	public static void update_INCDetail() throws Exception{
		try{ActionKeywords.clickAction(CommonElement.saveBtn());}
		catch(Exception e){throw(e);}
	}

}
