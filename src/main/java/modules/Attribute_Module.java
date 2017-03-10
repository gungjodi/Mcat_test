package modules;


import pageObjects.CommonElement;
import utility.ActionKeywords;
import utility.Constant;
import utility.ExcelUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pageObjects.Attribute_Page;
import pageObjects.RawDataItem_Page;
import pageObjects.SearchCriteria;

public class Attribute_Module {
	public static void access_CreateAttributeMenu() throws Exception{
		try{
			WebElement createAttributeMenu= Attribute_Page.CreateAttribute_Link();
		    ActionKeywords.clickAction(createAttributeMenu);
		}
		catch(Exception e){throw(e);}
	}
	public static void access_SearchAttributeMenu() throws Exception{
		try{
			WebElement searchAttributeMenu= Attribute_Page.SearchAttribute_Link();
		    ActionKeywords.clickAction(searchAttributeMenu);
		}
		catch(Exception e){throw(e);}
	}
	public static void set_SearchAttributeItemCriteria() throws Exception{
		try{
			HomePage_Module.waitLoading();
			ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
			WebElement addCriteria = SearchCriteria.btn_AddCriteria();
			ActionKeywords.clickAction(SearchCriteria.btn_AddCriteria());
			SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(5, 11));
			ActionKeywords.pageWait();
			SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));
			
			String searchCriteria=ExcelUtils.getCellData(19, 1);
			RawDataItem_Page.txt_Criteria().sendKeys(searchCriteria);
			WebElement btnSearch = SearchCriteria.btn_Search();
			ActionKeywords.clickAction(btnSearch);
            HomePage_Module.waitLoading();

			String text = CommonElement.resultTableCell(1,7).getText();
			Assert.assertEquals(searchCriteria, text);
		}
		catch(Exception e){throw(e);}
	}

	public static void click_AttributeCode() throws Exception{
		try{
			WebElement linkAttributeCode= Attribute_Page.link_AttributeCode();
		    ActionKeywords.clickAction(linkAttributeCode);   
		}
		catch(Exception e){throw(e);}
	}

	public static void update_AttributeDetail() throws Exception{
		try{
			//Store Parent Window
			String parentWindowHandler = ActionKeywords.getParentWindow();
            ActionKeywords.clickAction(Attribute_Page.picklist_AttributeGroupName());
            for(String window : ActionKeywords.getAllWindows())
            {
                ActionKeywords.navigateOnWindow(window);
            }
			ActionKeywords.clickAction(Attribute_Page.link_AttributeGroup());
			//Back to Parent Window
			ActionKeywords.navigateOnWindow(parentWindowHandler);
			ActionKeywords.clickAction(CommonElement.saveBtn());
		}
		catch(Exception e){throw(e);}
	}
}
