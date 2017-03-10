package modules;

import pageObjects.Attribute_Page;
import pageObjects.CommonElement;
import pageObjects.RawDataItem_Page;
import pageObjects.SearchCriteria;
import utility.ActionKeywords;
import utility.Constant;
import utility.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Agung_P1706 on 20/02/2017.
 */
public class CreateAttribute_Module {

    public static String searchCriteria,parentWindow;

    public static void create_Attribute() throws Exception
    {
        ActionKeywords.clickAction(Attribute_Page.CreateAttribute_Link());
    }

    public static void search_Attribute() throws Exception
    {
        ActionKeywords.clickAction(Attribute_Page.SearchAttribute_Link());
    }

    public static void fill_AttributeDetail() throws Exception
    {
        ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
        searchCriteria = ExcelUtils.getCellData(43,5);
        String Name = ExcelUtils.getCellData(43,6);
        String AttrType = ExcelUtils.getCellData(43,7);
        Attribute_Page.AttributeCode_Field().sendKeys(searchCriteria);
        Attribute_Page.AttributeName_Field().sendKeys(Name);
        ActionKeywords.selectDropdownElementByVisibleText("AttrTypeId",AttrType);
        parentWindow = ActionKeywords.getParentWindow();
        ActionKeywords.moveToElementExecutor(Attribute_Page.searchGroupBtn());
        for (String window : ActionKeywords.getAllWindows())
        {
            ActionKeywords.navigateOnWindow(window);
        }

        ActionKeywords.clickAction(SearchCriteria.btn_AddCriteria());
        SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(12, 11));
        ActionKeywords.pageWait();
        SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));
        String searchCriteria=ExcelUtils.getCellData(28, 11);;
        RawDataItem_Page.txt_Criteria().sendKeys(searchCriteria);
        ActionKeywords.clickAction(SearchCriteria.btn_Search());
        ActionKeywords.pageWait();
        ActionKeywords.moveToElementExecutor((ActionKeywords.findElementByPartialLinkText(searchCriteria)));
        ActionKeywords.navigateOnWindow(parentWindow);
    }

    public static void add_AttributeGroup() throws Exception
    {
        ActionKeywords.clickAction(CommonElement.addBtn());
    }

    public static void search_AttributeCriteria() throws Exception
    {
        HomePage_Module.waitLoading();
        ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
        WebElement addCriteria = SearchCriteria.btn_AddCriteria();
        ActionKeywords.clickAction(addCriteria);
        SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(10, 11));
        ActionKeywords.pageWait();
        SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));
        RawDataItem_Page.txt_Criteria().sendKeys(searchCriteria);
        ActionKeywords.clickAction(SearchCriteria.btn_Search());
    }
    public static void search_Result() throws Exception
    {
        HomePage_Module.waitLoading();
        ActionKeywords.assertTrueContains(searchCriteria,CommonElement.resultTableCell(1,1,"/a").getText());
    }

    public static void success_CreateAttribute() throws Exception {
        ActionKeywords.assertTrueContains("Attribute has been successfully updated",CommonElement.validation_Summary().getText());
    }
}
