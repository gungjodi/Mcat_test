package modules;

import pageObjects.CommonElement;
import pageObjects.NscMenu_Page;
import pageObjects.RawDataItem_Page;
import pageObjects.SearchCriteria;
import utility.ActionKeywords;
import utility.ExcelUtils;

/**
 * Created by Agung_P1706 on 20/02/2017.
 */
public class CreateNSC_module {
    public static String parentWindow;
    public static String searchNSCCriteria;

    public static void create_NSC() throws Exception
    {
        ActionKeywords.clickAction(NscMenu_Page.CreateNSC_Menu());
    }

    public static void search_INC() throws Exception
    {
        parentWindow = ActionKeywords.getParentWindow();
        ActionKeywords.clickAction(NscMenu_Page.searchIncCode_link());
    }

    public static void pick_INC() throws Exception
    {
        for (String window : ActionKeywords.getAllWindows())
        {
            ActionKeywords.navigateOnWindow(window);
        }
        ActionKeywords.clickAction(SearchCriteria.btn_AddCriteria());
        SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(5, 11));
        ActionKeywords.pageWait();
        SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));
        String searchCriteria=ExcelUtils.getCellData(22, 11);
        RawDataItem_Page.txt_Criteria().sendKeys(searchCriteria);
        ActionKeywords.clickAction(SearchCriteria.btn_Search());
        ActionKeywords.pageWait();
        ActionKeywords.moveToElementExecutor((ActionKeywords.findElementByPartialLinkText(searchCriteria)));
        ActionKeywords.navigateOnWindow(parentWindow);
    }

    public static void fill_NSCdetail() throws Exception
    {
        String nsc_code=ExcelUtils.getCellData(20, 11);
        String nsc_title=ExcelUtils.getCellData(20, 12);
        NscMenu_Page.NSCCode_field().sendKeys(nsc_code);
        NscMenu_Page.NSCTitle_field().sendKeys(nsc_title);
    }

    public static void click_AddNsc() throws Exception
    {
        ActionKeywords.moveToElementExecutor(CommonElement.addBtn());
        ActionKeywords.pageWait();
    }

    public static void search_NscMenu() throws Exception
    {
        ActionKeywords.moveToElementExecutor(NscMenu_Page.SearchNSC_Menu());
        ActionKeywords.pageWait();
    }

    public static void search_NscCode() throws Exception
    {
        HomePage_Module.waitLoading();
        ActionKeywords.clickAction(SearchCriteria.btn_AddCriteria());
        SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(1, 11));
        Thread.sleep(1000);
        SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));
        searchNSCCriteria=ExcelUtils.getCellData(20, 11);
        RawDataItem_Page.txt_Criteria().sendKeys(searchNSCCriteria);
        Thread.sleep(1000);
        ActionKeywords.clickAction(SearchCriteria.btn_Search());
        HomePage_Module.waitLoading();
    }

    public static void NSC_Exists() throws Exception
    {
        ActionKeywords.assertTrueContains(searchNSCCriteria,CommonElement.resultTableCell(1,2,"/a").getText());
    }

    public static void success_CreateNsc() throws Exception{
        ActionKeywords.assertTrueContains("NSC has been successfully added",CommonElement.validation_Summary().getText());
    }
}
