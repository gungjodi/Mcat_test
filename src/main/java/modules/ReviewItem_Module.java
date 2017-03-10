package modules;

import org.openqa.selenium.By;
import pageObjects.CommonElement;
import pageObjects.RawDataItem_Page;
import pageObjects.ReviewItem_Page;
import pageObjects.SearchCriteria;
import utility.ActionKeywords;
import utility.Constant;
import utility.ExcelUtils;

/**
 * Created by Agung_P1706 on 02/03/2017.
 */
public class ReviewItem_Module {
    public static void search_CataloguedItem() throws Exception{
        HomePage_Module.waitLoading();
        //FIRST CRITERIA
        ActionKeywords.moveToElementExecutor(SearchCriteria.btn_AddCriteria());
        ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
        SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(6, 11));
        Thread.sleep(1000);
        SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));
        Thread.sleep(1000);
        String statusCriteria=ExcelUtils.getCellData(35, 11);
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

    public static void click_CataloguedItem() throws Exception {
        String stockCode = CommonElement.resultTableCell(1,2,"/a").getText();
        ExcelUtils.setCellData(stockCode,47,4);
        ActionKeywords.moveToElementExecutor(CommonElement.resultTableCell(1,2,"/a"));
        ActionKeywords.pageWait();
    }

    public static void approve_CataloguedItem() throws Exception {
        ActionKeywords.moveToElementExecutor(ReviewItem_Page.approve_Btn());
        ActionKeywords.pageWait();
    }

    public static void search_ReviewedItem() throws Exception {
        HomePage_Module.waitLoading();
        String statusCriteria=ExcelUtils.getCellData(47, 6);
        String stockCode = ExcelUtils.getCellData(47,4);
        SearchCriteria.dropdown_SearchMethod("value1_0",statusCriteria);
        Thread.sleep(1000);
        SearchCriteria.dropdown_SearchMethod("criteria1",ExcelUtils.getCellData(2, 11));
        RawDataItem_Page.txt_Criteria1().sendKeys(stockCode);
        ActionKeywords.clickAction(SearchCriteria.btn_Search());
    }

    public static void displayed_approvedItem() throws Exception {
        String expectedStockCode = ExcelUtils.getCellData(47,4);
        String expectedStatus = ExcelUtils.getCellData(47, 6);
        ActionKeywords.assertTrueContains(expectedStockCode,CommonElement.resultTableCell(1,2,"/a").getText());
        ActionKeywords.assertTrueContains(expectedStatus,CommonElement.resultTableCell(1,6).getText());
    }

    public static void tick_CataloguedItems() throws Exception{
        for(int i=0;i<4;i++)
        {
            String stockCode = CommonElement.resultTableCell(i+1,2,"/a").getText();
            ActionKeywords.moveToElementExecutor(CommonElement.resultTableCheck(i));
            ExcelUtils.setCellData(stockCode,49+i,4);
        }
        ActionKeywords.moveToElementExecutor(CommonElement.reviewBtn());
        ActionKeywords.checkAlert();

    }

    public static void search_ApprovedItems() throws Exception {
        HomePage_Module.waitLoading();
        ActionKeywords.waitForElementPresence(By.id("value1_0"));
        String statusCriteria=ExcelUtils.getCellData(47, 6);
        SearchCriteria.dropdown_SearchMethod("value1_0",statusCriteria);
        Thread.sleep(1000);
        SearchCriteria.dropdown_SearchMethod("criteria1",ExcelUtils.getCellData(2, 11));
        for(int i=0;i<4;i++)
        {
            String stockCode = ExcelUtils.getCellData(49+i,4);
            RawDataItem_Page.txt_Criteria1().clear();
            RawDataItem_Page.txt_Criteria1().sendKeys(stockCode);
            ActionKeywords.clickAction(SearchCriteria.btn_Search());
            HomePage_Module.waitLoading();
            ActionKeywords.assertTrueContains(stockCode,CommonElement.resultTableCell(1,2,"/a").getText());
            ActionKeywords.assertTrueContains(statusCriteria,CommonElement.resultTableCell(1,6).getText());
        }
    }
}
