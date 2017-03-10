package modules;

import cucumber.api.java.en_old.Ac;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.AssignedItem_Page;
import pageObjects.CommonElement;
import pageObjects.RawDataItem_Page;
import pageObjects.SearchCriteria;
import utility.ActionKeywords;
import utility.Constant;
import utility.ExcelUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Agung_P1706 on 01/03/2017.
 */
public class AssignedItem_Module {

    public static void access_SearchAssignedItem() throws Exception
    {
        ActionKeywords.clickAction(AssignedItem_Page.searchAssigned_Menu());
        ActionKeywords.pageWait();
    }

    public static void search_AssignedItem() throws Exception {
        HomePage_Module.waitLoading();
        //FIRST CRITERIA
        ActionKeywords.moveToElementExecutor(SearchCriteria.btn_AddCriteria());
        ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
        SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(6, 11));
        Thread.sleep(1000);
        SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));
        Thread.sleep(1000);
        String statusCriteria=ExcelUtils.getCellData(34, 11);
        RawDataItem_Page.txt_Criteria().sendKeys(statusCriteria);

        //SECOND CRITERIA
        ActionKeywords.moveToElementExecutor(SearchCriteria.btn_AddCriteria());
        ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
        SearchCriteria.dropdown_SearchMethod("criteria1",ExcelUtils.getCellData(7, 11));
        Thread.sleep(1000);
        SearchCriteria.dropdown_Operator("operator1",ExcelUtils.getCellData(7, 12));
        Thread.sleep(1000);
        String asisgnedToCriteria=ExcelUtils.getCellData(34, 12);
        RawDataItem_Page.txt_Criteria1().sendKeys(asisgnedToCriteria);
        ActionKeywords.clickAction(SearchCriteria.btn_Search());
        HomePage_Module.waitLoading();
    }

    public static void click_AssignedItem() throws Exception
    {
        String stockCode = CommonElement.resultTableCell(1,2,"/a").getText();
        ExcelUtils.setCellData(stockCode,43,9);
        ActionKeywords.moveToElementExecutor(CommonElement.resultTableCell(1,1,"/a"));
        ActionKeywords.pageWait();
    }

    public static void submit_AssignedItem() throws Exception {
        String Tag = ExcelUtils.getCellData(43,11);
        String IncName = ExcelUtils.getCellData(43,12);
        String Attribute = ExcelUtils.getCellData(43,13);
        String BusinessUnit = ExcelUtils.getCellData(43,14);
        String GroupDetail = ExcelUtils.getCellData(43,15);

        AssignedItem_Page.tag_Field().clear();
        AssignedItem_Page.tag_Field().sendKeys(Tag);
        ActionKeywords.scrollToElement(AssignedItem_Page.incName_Field());
        AssignedItem_Page.incName_Field().clear();
        AssignedItem_Page.incName_Field().sendKeys(IncName);
        String parentWindow = ActionKeywords.getParentWindow();
        //fill all value in attribute detail fields
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

        Thread.sleep(1000);
        //fill all value in attribute business unit fields
        if(AssignedItem_Page.businessUnit_Field().size()>0)
        {
            for (WebElement element : AssignedItem_Page.businessUnit_Field())
            {
                element.clear();
                element.sendKeys(BusinessUnit);
                Thread.sleep(500);
            }
        }

        if(AssignedItem_Page.groupDetail_searchLink().size()>0)
        {

            for (WebElement element : AssignedItem_Page.groupDetail_searchLink())
            {
                ActionKeywords.moveToElementExecutor(element);
                for(String window: ActionKeywords.getAllWindows())
                {
                    ActionKeywords.navigateOnWindow(window);
                    ActionKeywords.moveToElementExecutor(CommonElement.resultTableCell(1,1,"/a"));
                }
                ActionKeywords.navigateOnWindow(parentWindow);
                Thread.sleep(500);
            }
        }
        ActionKeywords.moveToElementExecutor(CommonElement.submitBtn());
        ActionKeywords.pageWait();
    }

    public static void search_SubmittedItem() throws Exception {
        HomePage_Module.waitLoading();
        ActionKeywords.waitForElementPresence(By.id("value1_0"));
        String statusCriteria=ExcelUtils.getCellData(35, 11);
        String stockCode = ExcelUtils.getCellData(43,9);
        SearchCriteria.dropdown_SearchMethod("value1_0",statusCriteria);
        Thread.sleep(1000);
        SearchCriteria.dropdown_SearchMethod("criteria1",ExcelUtils.getCellData(2, 11));
        RawDataItem_Page.txt_Criteria1().sendKeys(stockCode);
        ActionKeywords.clickAction(SearchCriteria.btn_Search());
    }

    public static void displayed_submittedItem() throws Exception{
        String expectedStockCode = ExcelUtils.getCellData(43,9);
        String expectedStatus = ExcelUtils.getCellData(35, 11);
        ActionKeywords.assertTrueContains(expectedStockCode,CommonElement.resultTableCell(1,2,"/a").getText());
        ActionKeywords.assertTrueContains(expectedStatus,CommonElement.resultTableCell(1,6).getText());
    }

    public static void tick_AssignedItems() throws Exception {
        for(int i=0;i<4;i++)
        {
            String stockCode = CommonElement.resultTableCell(i+1,2,"/a").getText();
//            ActionKeywords.scrollToElement(CommonElement.resultTableCheck(i));
            ActionKeywords.moveToElementExecutor(CommonElement.resultTableCheck(i));
            ExcelUtils.setCellData(stockCode,45+i,9);
        }
        ActionKeywords.moveToElementExecutor(CommonElement.editBtn());
        ActionKeywords.checkAlert();
    }


    public static void search_SubmittedItems() throws Exception{
        HomePage_Module.waitLoading();
        ActionKeywords.waitForElementPresence(By.id("value1_0"));
        String statusCriteria=ExcelUtils.getCellData(35, 11);
        SearchCriteria.dropdown_SearchMethod("value1_0",statusCriteria);
        Thread.sleep(1000);
        SearchCriteria.dropdown_SearchMethod("criteria1",ExcelUtils.getCellData(2, 11));
        for(int i=0;i<4;i++)
        {
            String stockCode = ExcelUtils.getCellData(45+i,9);
            RawDataItem_Page.txt_Criteria1().clear();
            RawDataItem_Page.txt_Criteria1().sendKeys(stockCode);
            ActionKeywords.clickAction(SearchCriteria.btn_Search());
            HomePage_Module.waitLoading();
            ActionKeywords.assertTrueContains(stockCode,CommonElement.resultTableCell(1,2,"/a").getText());
            ActionKeywords.assertTrueContains(statusCriteria,CommonElement.resultTableCell(1,6).getText());
        }
    }
}
