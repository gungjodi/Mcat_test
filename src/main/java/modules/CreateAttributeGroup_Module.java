package modules;

import pageObjects.AttributeGroup_Page;
import pageObjects.CommonElement;
import pageObjects.RawDataItem_Page;
import pageObjects.SearchCriteria;
import utility.ActionKeywords;
import utility.Constant;
import utility.ExcelUtils;

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
        ActionKeywords.assertTrueContains(searchCriteria,CommonElement.resultTableCell(1,2,"/a").getText());
    }

    public static void success_CreateAttributeGroup() throws Exception {
        ActionKeywords.assertTrueContains("Attribute Group has been successfully added",CommonElement.validation_Summary().getText());
    }
}
