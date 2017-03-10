package modules;

import com.google.common.base.Verify;
import pageObjects.CommonElement;
import pageObjects.IncMenu_Page;
import pageObjects.RawDataItem_Page;
import pageObjects.SearchCriteria;
import utility.ActionKeywords;
import utility.Constant;
import utility.ExcelUtils;
import org.junit.Assert;

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
        IncMenu_Page.IncCode_Field().sendKeys(inc_code);
        IncMenu_Page.IncName_Field().sendKeys(inc_name);
        IncMenu_Page.IncDesc_Field().sendKeys(inc_desc);

        parentWindow = ActionKeywords.getParentWindow();
        ActionKeywords.moveToElementExecutor(IncMenu_Page.searchNscCode_link());

        for (String window : ActionKeywords.getAllWindows())
        {
            ActionKeywords.navigateOnWindow(window);
        }

        ActionKeywords.clickAction(SearchCriteria.btn_AddCriteria());
        SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(1, 11));
        ActionKeywords.pageWait();
        SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));
        String searchCriteria=ExcelUtils.getCellData(12, 6);
        RawDataItem_Page.txt_Criteria().sendKeys(searchCriteria);
        ActionKeywords.clickAction(SearchCriteria.btn_Search());
        ActionKeywords.pageWait();
        ActionKeywords.moveToElementExecutor((ActionKeywords.findElementByPartialLinkText(searchCriteria)));
    }

    public static void add_Inc() throws Exception
    {
        ActionKeywords.navigateOnWindow(parentWindow);
        ActionKeywords.clickAction(CommonElement.addBtn());
    }

    public static void access_INCSearchMenu() throws Exception
    {
        ActionKeywords.clickAction(IncMenu_Page.SearchINC_Menu());
    }

    public static void search_IncItem() throws Exception
    {
        ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
        ActionKeywords.clickAction(SearchCriteria.btn_AddCriteria());
        SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(5, 11));
        ActionKeywords.pageWait();
        SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));

        RawDataItem_Page.txt_Criteria().sendKeys(inc_code);
        ActionKeywords.clickAction(SearchCriteria.btn_Search());
        ActionKeywords.pageWait();
    }

    public static void item_Exists() throws Exception
    {
        ActionKeywords.assertTrueContains(inc_code,CommonElement.resultTableCell(1,1,"/a").getText());

    }

    public static void success_CreateInc() throws Exception {
        ActionKeywords.assertTrueContains("INC has been successfully added",CommonElement.validation_Summary().getText());
    }
}
