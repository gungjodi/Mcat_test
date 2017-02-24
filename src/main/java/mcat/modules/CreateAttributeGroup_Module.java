package mcat.modules;

import mcat.pageObjects.*;
import mcat.utility.ActionKeywords;
import mcat.utility.Constant;
import mcat.utility.ExcelUtils;
import org.openqa.selenium.WebElement;

/**
 * Created by Agung_P1706 on 20/02/2017.
 */
public class CreateAttributeGroup_Module {

    public static String searchCriteria;

    public static void create_AttributeGroup() throws Exception
    {
        ActionKeywords.clickAction(AttributeGroup_Page.CreateAttributeGroup_Link());
    }

    public static void search_AttributeGroup() throws Exception
    {
        ActionKeywords.clickAction(AttributeGroup_Page.SearchAttributeGroup_Link());
    }

    public static void fill_AttributeGroupDetail() throws Exception
    {
        ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
        String detail = ExcelUtils.getCellData(28, 11);
        AttributeGroup_Page.AttributeGroupName_Field().sendKeys(detail);
    }

    public static void add_AttributeGroup() throws Exception
    {
        ActionKeywords.clickAction(CommonElement.addBtn());
    }

    public static void search_AttributeGroupCriteria() throws Exception
    {
        ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
        ActionKeywords.clickAction(SearchCriteria.btn_AddCriteria());
        SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(12, 11));
        ActionKeywords.pageWait();
        SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));
        searchCriteria=ExcelUtils.getCellData(28, 11);
        RawDataItem_Page.txt_Criteria().sendKeys(searchCriteria);
        ActionKeywords.clickAction(SearchCriteria.btn_Search());
    }

    public static void search_Result() throws Exception
    {
        ActionKeywords.findElementByXpath("//a[contains(.,'"+searchCriteria+"')]").isDisplayed();
    }
}
