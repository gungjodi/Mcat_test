package mcat.modules;

import mcat.pageObjects.IncMenu_Page;
import mcat.pageObjects.RawDataItem_Page;
import mcat.pageObjects.SearchCriteria;
import mcat.utility.ActionKeywords;
import mcat.utility.Constant;
import mcat.utility.ExcelUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Agung_P1706 on 16/02/2017.
 */
public class CreateINC_module {
    public static String parentWindow,inc_code;
    public static void create_INC() throws Exception
    {
        ActionKeywords.clickAction(IncMenu_Page.CreateINC_Menu());
    }

    public static void fill_INC_detail() throws Exception
    {
        ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
        inc_code = ExcelUtils.getCellData(10, 6);
        String inc_name = ExcelUtils.getCellData(10, 7);
        String inc_desc = ExcelUtils.getCellData(10, 8);
        System.out.println("INC CODE : "+inc_code);
        IncMenu_Page.IncCode_Field().sendKeys(inc_code);
        IncMenu_Page.IncName_Field().sendKeys(inc_name);
        IncMenu_Page.IncDesc_Field().sendKeys(inc_desc);

        parentWindow = ActionKeywords.getParentWindow();
        ActionKeywords.moveToElementExecutor(IncMenu_Page.searchNscCode_link());

        for (String window : ActionKeywords.getAllWindows())
        {
            ActionKeywords.navigateOnWindow(window);
        }

        WebElement addCriteria = SearchCriteria.btn_AddCriteria();
        ActionKeywords.clickAction(addCriteria);
        SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(1, 11));
        ActionKeywords.pageWait();
        SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));
        String searchCriteria=ExcelUtils.getCellData(12, 6);
        RawDataItem_Page.txt_Criteria().sendKeys(searchCriteria);
        WebElement btnSearch = SearchCriteria.btn_Search();
        ActionKeywords.clickAction(btnSearch);
        ActionKeywords.pageWait();
        ActionKeywords.moveToElementExecutor((ActionKeywords.findElementByPartialLinkText(searchCriteria)));
    }

    public static void addInc() throws Exception
    {
        ActionKeywords.navigateOnWindow(parentWindow);
        ActionKeywords.clickAction(IncMenu_Page.Add_Btn());
    }

    public static void access_INCSearchMenu() throws Exception
    {
        ActionKeywords.clickAction(IncMenu_Page.SearchINC_Menu());
    }

    public static void search_IncItem() throws Exception
    {
        ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
        WebElement addCriteria = SearchCriteria.btn_AddCriteria();
        ActionKeywords.clickAction(addCriteria);
        SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(5, 11));
        ActionKeywords.pageWait();
        SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));

        RawDataItem_Page.txt_Criteria().sendKeys(inc_code);
        WebElement btnSearch = SearchCriteria.btn_Search();
        ActionKeywords.clickAction(btnSearch);
        ActionKeywords.pageWait();
    }

    public static void itemExists() throws Exception
    {
        Assert.assertTrue("Item exists",ActionKeywords.findElementByPartialLinkText(inc_code).isDisplayed());
    }
}
