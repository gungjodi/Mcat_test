package modules;

import pageObjects.CommonElement;
import pageObjects.RawDataItem_Page;
import pageObjects.SearchCriteria;
import pageObjects.UNSPSC_Page;
import utility.ActionKeywords;
import utility.Constant;
import utility.ExcelUtils;

/**
 * Created by Agung_P1706 on 20/02/2017.
 */
public class CreateUNSPSC_module {

    public static String searchCriteria;

    public static void Create_UNSPSC() throws Exception
    {
        ActionKeywords.clickAction(UNSPSC_Page.CreateUNSPSC_Link());
    }

    public static void fill_UNSPSCDetail() throws Exception
    {
        ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
        String UNSPSCTitle = ExcelUtils.getCellData(25, 11);
        String UNSPSCDesc = ExcelUtils.getCellData(25, 12);
        UNSPSC_Page.UnspscTitle_Field().sendKeys(UNSPSCTitle);
        UNSPSC_Page.UnspscDesc_Field().sendKeys(UNSPSCDesc);
    }

    public static void add_UNSPSC() throws Exception
    {
        ActionKeywords.clickAction(CommonElement.addBtn());
    }

    public static void search_UNSPSC() throws Exception
    {
        ActionKeywords.clickAction(UNSPSC_Page.SearchUNSPSC_Link());
    }

    public static void fill_UNSPSCCriteria() throws Exception
    {
        ActionKeywords.clickAction(SearchCriteria.btn_AddCriteria());
        SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(16, 11));
        ActionKeywords.pageWait();
        SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));
        searchCriteria=ExcelUtils.getCellData(25, 11);
        RawDataItem_Page.txt_Criteria().sendKeys(searchCriteria);
        ActionKeywords.clickAction(SearchCriteria.btn_Search());
        ActionKeywords.pageWait();
    }

    public static void search_Result() throws Exception
    {
        ActionKeywords.assertTrueContains(searchCriteria,CommonElement.resultTableCell(1,1,"/a").getText());
    }

    public static void success_CreateUnspsc() throws Exception {
        ActionKeywords.assertTrueContains("UNSPSC has been successfully added",CommonElement.validation_Summary().getText());
    }
}
