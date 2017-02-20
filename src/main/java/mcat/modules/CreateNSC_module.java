package mcat.modules;

import cucumber.api.java.gl.E;
import mcat.pageObjects.IncMenu_Page;
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

    public static void searchINC() throws Exception
    {
        parentWindow = ActionKeywords.getParentWindow();
        ActionKeywords.clickAction(NscMenu_Page.searchIncCode_link());
    }

    public static void pickINC() throws Exception
    {
        for (String window : ActionKeywords.getAllWindows())
        {
            ActionKeywords.navigateOnWindow(window);
        }
        WebElement addCriteria = SearchCriteria.btn_AddCriteria();
        ActionKeywords.clickAction(addCriteria);
        SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(5, 11));
        ActionKeywords.pageWait();
        SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));
        String searchCriteria=ExcelUtils.getCellData(22, 11);
        RawDataItem_Page.txt_Criteria().sendKeys(searchCriteria);
        WebElement btnSearch = SearchCriteria.btn_Search();
        ActionKeywords.clickAction(btnSearch);
        ActionKeywords.pageWait();
        ActionKeywords.moveToElementExecutor((ActionKeywords.findElementByPartialLinkText(searchCriteria)));
        ActionKeywords.navigateOnWindow(parentWindow);
    }

    public static void fillNSCdetail() throws Exception
    {
        String nsc_code=ExcelUtils.getCellData(20, 11);
        String nsc_title=ExcelUtils.getCellData(20, 12);
        NscMenu_Page.NSCCode_field().sendKeys(nsc_code);
        NscMenu_Page.NSCTitle_field().sendKeys(nsc_title);
    }

    public static void clickAddNsc() throws Exception
    {
        ActionKeywords.moveToElementExecutor(NscMenu_Page.addNsc_button());
    }

    public static void searchNscMenu() throws Exception
    {
        ActionKeywords.moveToElementExecutor(NscMenu_Page.SearchNSC_Menu());
    }

    public static void searchNscCode() throws Exception
    {
        WebElement addCriteria = SearchCriteria.btn_AddCriteria();
        ActionKeywords.clickAction(addCriteria);
        SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(1, 11));
        ActionKeywords.pageWait();
        SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));
        searchNSCCriteria=ExcelUtils.getCellData(20, 11);
        RawDataItem_Page.txt_Criteria().sendKeys(searchNSCCriteria);
        WebElement btnSearch = SearchCriteria.btn_Search();
        ActionKeywords.clickAction(btnSearch);
        ActionKeywords.pageWait();
    }

    public static void NSCExists() throws Exception
    {
        ActionKeywords.findElementByPartialLinkText(searchNSCCriteria).isDisplayed();
    }
}
