package mcat.modules;

import mcat.pageObjects.RawDataItem_Page;
import mcat.pageObjects.SearchCriteria;
import mcat.pageObjects.UNSPSC_Page;
import mcat.utility.ActionKeywords;
import mcat.utility.Constant;
import mcat.utility.ExcelUtils;
import org.openqa.selenium.WebElement;

/**
 * Created by Agung_P1706 on 20/02/2017.
 */
public class CreateUNSPSC_module {

    public static String searchCriteria;
    public static void Create_UNSPSC() throws Exception
    {
        ActionKeywords.clickAction(UNSPSC_Page.CreateUNSPSC_Link());
    }

    public static void fillUNSPSC_detail() throws Exception
    {
        ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
        String UNSPSCTitle = ExcelUtils.getCellData(25, 11);
        String UNSPSCDesc = ExcelUtils.getCellData(25, 12);
        UNSPSC_Page.UnspscTitle_Field().sendKeys(UNSPSCTitle);
        UNSPSC_Page.UnspscDesc_Field().sendKeys(UNSPSCDesc);
    }

    public static void addUNSPSC() throws Exception
    {
        ActionKeywords.clickAction(UNSPSC_Page.addUnspsc_button());
    }

    public static void SearchUNSPSC() throws Exception
    {
        ActionKeywords.clickAction(UNSPSC_Page.SearchUNSPSC_Link());
    }

    public static void fillUNSPSC_Criteria() throws Exception
    {
        WebElement addCriteria = SearchCriteria.btn_AddCriteria();
        ActionKeywords.clickAction(addCriteria);
        SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(16, 11));
        ActionKeywords.pageWait();
        SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));
        searchCriteria=ExcelUtils.getCellData(25, 11);
        RawDataItem_Page.txt_Criteria().sendKeys(searchCriteria);
        WebElement btnSearch = SearchCriteria.btn_Search();
        ActionKeywords.clickAction(btnSearch);
        ActionKeywords.pageWait();
    }

    public static void searchResult() throws Exception
    {
        ActionKeywords.findElementByPartialLinkText(searchCriteria).isDisplayed();
    }

}
