package modules;

import cucumber.api.java.en_old.Ac;
import org.openqa.selenium.WebElement;
import pageObjects.*;
import utility.ActionKeywords;
import utility.Constant;
import utility.ExcelUtils;

/**
 * Created by Agung_P1706 on 06/03/2017.
 */
public class AdvanceSearch_Module {
    static String expectedAttr,statusCriteria;
    public static void search_AdvanceINC() throws Exception {
        HomePage_Module.waitLoading();
        //FIRST CRITERIA
        ActionKeywords.moveToElementExecutor(SearchCriteria.btn_AddCriteria());
        ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
        SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(5, 11));
        Thread.sleep(1000);
        SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));
        Thread.sleep(1000);
        String statusCriteria=ExcelUtils.getCellData(7, 6);
        RawDataItem_Page.txt_Criteria().sendKeys(statusCriteria);

        //SECOND CRITERIA
        ActionKeywords.moveToElementExecutor(SearchCriteria.btn_AddCriteria());
        ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
        SearchCriteria.dropdown_SearchMethod("criteria1",ExcelUtils.getCellData(6, 11));
        Thread.sleep(1000);
        SearchCriteria.dropdown_Operator("operator1",ExcelUtils.getCellData(7, 12));
        Thread.sleep(1000);
        String asisgnedToCriteria=ExcelUtils.getCellData(47, 6);
        RawDataItem_Page.txt_Criteria1().sendKeys(asisgnedToCriteria);
        ActionKeywords.clickAction(SearchCriteria.btn_Search());
    }

    public static void displayed_INCCode() throws Exception{
        HomePage_Module.waitLoading();
        String expected = ExcelUtils.getCellData(7, 6);
        String actual = CommonElement.advanceTableCell(1,5).getText();
        ActionKeywords.assertTrueContains(expected,actual);
    }

    public static void search_AdvanceAttribute() throws Exception {
        String parentWindow = ActionKeywords.getParentWindow();
        ActionKeywords.moveToElementExecutor(SearchCriteria.btn_AddAttribute());
        Thread.sleep(500);
        ActionKeywords.moveToElementExecutor(SearchCriteria.btn_pickAttribute());
        for (String window:ActionKeywords.getAllWindows()) {
            ActionKeywords.navigateOnWindow(window);
        }
        HomePage_Module.waitLoading();
        //FIRST CRITERIA
        ActionKeywords.moveToElementExecutor(SearchCriteria.btn_AddCriteria());
        ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
        SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(5, 11));
        Thread.sleep(1000);
        SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));
        Thread.sleep(1000);
        statusCriteria=ExcelUtils.getCellData(7, 6);
        RawDataItem_Page.txt_Criteria().sendKeys(statusCriteria);
        ActionKeywords.clickAction(SearchCriteria.btn_Search());
        HomePage_Module.waitLoading();

        expectedAttr = CommonElement.resultTableCell(1,2).getText();
        ActionKeywords.moveToElementExecutor(CommonElement.resultTableCell(1,1,"/a"));
        ActionKeywords.navigateOnWindow(parentWindow);
        String actualAttr = AdvanceSearch_Page.attributeCriteria_Field().getAttribute("value");
        ActionKeywords.assertTrueContains(expectedAttr,actualAttr);
        ActionKeywords.moveToElementExecutor(AdvanceSearch_Page.advanceSearchAttribute_Button());
        HomePage_Module.waitLoading();

    }

    public static void displayed_AdvanceAttribute() throws Exception {
        String attrInTable = AdvanceSearch_Page.advanceTableHeader_Last().getText();
        ActionKeywords.assertTrueContains(expectedAttr,attrInTable);
        String incCodeInTable = CommonElement.advanceTableCell(1,5).getText();
        ActionKeywords.assertTrueContains(statusCriteria,incCodeInTable);
    }

    public static void search_ItemCriteria() throws Exception {
        HomePage_Module.waitLoading();
        //FIRST CRITERIA
        ActionKeywords.moveToElementExecutor(SearchCriteria.btn_AddCriteria());
        ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
        SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(5, 11));
        Thread.sleep(1000);
        SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));
        Thread.sleep(1000);
        statusCriteria=ExcelUtils.getCellData(7, 6);
        RawDataItem_Page.txt_Criteria().sendKeys(statusCriteria);
        ActionKeywords.clickAction(SearchCriteria.btn_Search());
        HomePage_Module.waitLoading();

        //SECOND CRITERIA
        ActionKeywords.moveToElementExecutor(SearchCriteria.btn_AddCriteria());
        ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
        SearchCriteria.dropdown_SearchMethod("criteria1",ExcelUtils.getCellData(6, 11));
        Thread.sleep(1000);
        SearchCriteria.dropdown_Operator("operator1",ExcelUtils.getCellData(7, 12));
        Thread.sleep(1000);
        String statusCriteria1=ExcelUtils.getCellData(34, 11);
        RawDataItem_Page.txt_Criteria1().sendKeys(statusCriteria1);
        ActionKeywords.clickAction(SearchCriteria.btn_Search());
        HomePage_Module.waitLoading();
    }

    public static void pick_StockCode() throws Exception {
        String stockCode = CommonElement.advanceTableCell(1,2,"/a").getText();
        ActionKeywords.moveToElementExecutor(CommonElement.advanceTableCell(1,1,"/input"));
        ExcelUtils.setCellData(stockCode,37,11);
    }

    public static void editToAssign_StockCode() throws Exception{
        ActionKeywords.moveToElementExecutor(AdvanceSearch_Page.EditToAssignedButton_Button());
        ActionKeywords.checkAlert();
        ActionKeywords.pageWait();
        ActionKeywords.moveToElementExecutor(AdvanceSearch_Page.Submit_Button());
    }

    public static void search_EditToAssign() throws Exception {
        SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(2, 11));
        Thread.sleep(1000);
        SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));
        Thread.sleep(1000);
        RawDataItem_Page.txt_Criteria().sendKeys(ExcelUtils.getCellData(37,11));
        SearchCriteria.dropdown_Operator("operator1",ExcelUtils.getCellData(7, 12));
        String statusCriteria1=ExcelUtils.getCellData(35, 11);
        RawDataItem_Page.txt_Criteria1().sendKeys(statusCriteria1);
        ActionKeywords.clickAction(SearchCriteria.btn_Search());
        HomePage_Module.waitLoading();
    }

    public static void displayed_EditToAssign() throws Exception {
        String expected = ExcelUtils.getCellData(37,11);
        String actual = CommonElement.advanceTableCell(1,2,"/a").getText();
        ActionKeywords.assertTrueContains(expected,actual);
    }

    public static void search_QAItemCriteria() throws Exception {
        SearchCriteria.dropdown_SearchMethod("criteria1",ExcelUtils.getCellData(6, 11));
        Thread.sleep(1000);
        SearchCriteria.dropdown_Operator("operator1",ExcelUtils.getCellData(7, 12));
        Thread.sleep(1000);
        String statusCriteria1=ExcelUtils.getCellData(35, 11);
        RawDataItem_Page.txt_Criteria1().sendKeys(statusCriteria1);
        ActionKeywords.clickAction(SearchCriteria.btn_Search());
        HomePage_Module.waitLoading();
    }

    public static void editToReview_StockCode() throws Exception {
        ActionKeywords.moveToElementExecutor(AdvanceSearch_Page.EditToReview_Button());
        ActionKeywords.checkAlert();
        ActionKeywords.pageWait();
        String Attribute = ExcelUtils.getCellData(43,13);
        if(AssignedItem_Page.attributeValues_Field().size()>0)
        {
            for (WebElement element : AssignedItem_Page.attributeValues_Field())
            {
                ActionKeywords.scrollToElement(element);
                element.clear();
                element.sendKeys(Attribute);
                Thread.sleep(500);
            }
        }
        ActionKeywords.pageWait();
        ActionKeywords.moveToElementExecutor(AdvanceSearch_Page.Approve_Button());
    }

    public static void search_EditToReview() throws Exception {
        ActionKeywords.pageWait();
        SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(2, 11));
        Thread.sleep(1000);
        SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));
        Thread.sleep(1000);
        RawDataItem_Page.txt_Criteria().sendKeys(ExcelUtils.getCellData(37,11));
        SearchCriteria.dropdown_Operator("operator1",ExcelUtils.getCellData(7, 12));
        String statusCriteria1=ExcelUtils.getCellData(47, 6);
        RawDataItem_Page.txt_Criteria1().sendKeys(statusCriteria1);
        ActionKeywords.clickAction(SearchCriteria.btn_Search());
        HomePage_Module.waitLoading();
    }

    public static void displayed_EditToReview() throws Exception {
        String expected = ExcelUtils.getCellData(37,11);
        String actual = CommonElement.advanceTableCell(1,2,"/a").getText();
        ActionKeywords.assertTrueContains(expected,actual);
    }
}
