package mcat.modules;

import mcat.pageObjects.CommonElement;
import mcat.pageObjects.NscMenu_Page;
import mcat.pageObjects.RawDataItem_Page;
import mcat.pageObjects.SearchCriteria;
import mcat.utility.ActionKeywords;
import mcat.utility.ExcelUtils;
import org.openqa.selenium.WebElement;

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
    }

    public static void search_NscMenu() throws Exception
    {
        ActionKeywords.moveToElementExecutor(NscMenu_Page.SearchNSC_Menu());
    }

    public static void search_NscCode() throws Exception
    {
        ActionKeywords.clickAction(SearchCriteria.btn_AddCriteria());
        SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(1, 11));
        ActionKeywords.pageWait();
        SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));
        searchNSCCriteria=ExcelUtils.getCellData(20, 11);
        RawDataItem_Page.txt_Criteria().sendKeys(searchNSCCriteria);
        ActionKeywords.clickAction(SearchCriteria.btn_Search());
        ActionKeywords.pageWait();
    }

    public static void NSC_Exists() throws Exception
    {
        ActionKeywords.findElementByPartialLinkText(searchNSCCriteria).isDisplayed();
    }
}
