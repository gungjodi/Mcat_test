package mcat.modules;

import mcat.pageObjects.AttributeGroup_Page;
import mcat.pageObjects.RawDataItem_Page;
import mcat.pageObjects.SearchCriteria;
import mcat.utility.ActionKeywords;
import mcat.utility.Constant;
import mcat.utility.ExcelUtils;
import org.openqa.selenium.WebElement;

/**
 * Created by Agung_P1706 on 20/02/2017.
 */
public class CreateAttributeGroup_Module {

    public static String searchCriteria;

    public static void CreateAttributeGroup() throws Exception
    {
        ActionKeywords.clickAction(AttributeGroup_Page.CreateAttributeGroup_Link());
    }

    public static void SearchAttributeGroup() throws Exception
    {
        ActionKeywords.clickAction(AttributeGroup_Page.SearchAttributeGroup_Link());
    }

    public static void FillAttributeGroupDetail() throws Exception
    {
        ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
        String detail = ExcelUtils.getCellData(28, 11);
        AttributeGroup_Page.AttributeGroupName_Field().sendKeys(detail);
    }

    public static void addAttributeGroup() throws Exception
    {
        ActionKeywords.clickAction(AttributeGroup_Page.addBtn());
    }

    public static void SearchAttributeGroupCriteria() throws Exception
    {
        ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
        WebElement addCriteria = SearchCriteria.btn_AddCriteria();
        ActionKeywords.clickAction(addCriteria);
        SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(12, 11));
        ActionKeywords.pageWait();
        SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));
        searchCriteria=ExcelUtils.getCellData(28, 11);
        RawDataItem_Page.txt_Criteria().sendKeys(searchCriteria);
        WebElement btnSearch = SearchCriteria.btn_Search();
        ActionKeywords.clickAction(btnSearch);
    }

    public static void searchResult() throws Exception
    {
        ActionKeywords.findElementByXpath("//a[contains(.,'"+searchCriteria+"')]").isDisplayed();
    }
}
