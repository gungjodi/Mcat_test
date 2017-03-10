package modules;

import pageObjects.CommonElement;
import pageObjects.ConfigurationManage_Page;
import pageObjects.RawDataItem_Page;
import pageObjects.SearchCriteria;
import utility.ActionKeywords;
import utility.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Agung_P1706 on 22/02/2017.
 */
public class ConfigurationManage_Module {
    public static String parentWindow;
    public static void access_SearchConfigurationMenu() throws Exception
    {
        ActionKeywords.moveToElementExecutor(ConfigurationManage_Page.SearchConfiguration_menu());
    }

    public static void search_Configuration_Criteria() throws Exception
    {
        WebElement addCriteria = SearchCriteria.btn_AddCriteria();
        ActionKeywords.clickAction(addCriteria);
        SearchCriteria.dropdown_SearchMethod("criteria0", ExcelUtils.getCellData(5, 11));
        ActionKeywords.pageWait();
        SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));
        String searchCriteria=ExcelUtils.getCellData(31, 11);
        RawDataItem_Page.txt_Criteria().sendKeys(searchCriteria);
        ActionKeywords.clickAction(SearchCriteria.btn_Search());
        ActionKeywords.pageWait();
    }

    public static void click_ConfNameLink() throws Exception
    {
        HomePage_Module.waitLoading();
        ActionKeywords.moveToElementExecutor(ConfigurationManage_Page.rowSearchCriteria());
    }

    public static void add_AttrGroup() throws Exception
    {
        parentWindow = ActionKeywords.getParentWindow();
        ActionKeywords.moveToElementExecutor(ConfigurationManage_Page.addAnAttrGoup_btn());
        for(String window:ActionKeywords.getAllWindows())
        {
            ActionKeywords.navigateOnWindow(window);
        }
        ActionKeywords.pageWait();
        String attrGroup = ExcelUtils.getCellData(31,12);
        ActionKeywords.moveToElementExecutor(ActionKeywords.findElementByPartialLinkText(attrGroup));
    }

    public static void add_newRecordItemDesc() throws Exception
    {
        ActionKeywords.navigateOnWindow(parentWindow);
        ActionKeywords.pageWait();
        Thread.sleep(1000);
        ActionKeywords.moveToElementExecutor(ConfigurationManage_Page.addLastRecordItem_Btn());
    }

    public static void pick_LastRecordSearch() throws Exception
    {
        Thread.sleep(1000);
        ActionKeywords.moveToElementExecutor(ConfigurationManage_Page.lastRecordItem_searchBtn());
        for(String window:ActionKeywords.getAllWindows())
        {
            ActionKeywords.navigateOnWindow(window);
        }
        HomePage_Module.waitLoading();
        String expected = ConfigurationManage_Page.firstAttrName().getText();
        ActionKeywords.moveToElementExecutor(ConfigurationManage_Page.firstAttrCode());
        ActionKeywords.navigateOnWindow(parentWindow);
        ActionKeywords.assertTrueContains(expected,ConfigurationManage_Page.lastRecordItem_Field().getAttribute("value"));
    }

    public static void add_newBusDetailDesc() throws Exception{
        ActionKeywords.pageWait();
        Thread.sleep(1000);
        ActionKeywords.moveToElementExecutor(ConfigurationManage_Page.addLastBusDetail_Btn());
    }

    public static void pick_LastBusDetailSearch() throws Exception{
        Thread.sleep(1000);
        ActionKeywords.moveToElementExecutor(ConfigurationManage_Page.LastBusDetail_searchBtn());
        for(String window:ActionKeywords.getAllWindows())
        {
            ActionKeywords.navigateOnWindow(window);
        }
        ActionKeywords.waitForElementDisappear(By.xpath("//*[@id='ResultTable']/tbody/tr/td/img"));
        String expected = ConfigurationManage_Page.firstAttrName().getText();
        ActionKeywords.moveToElementExecutor(ConfigurationManage_Page.firstAttrCode());
        ActionKeywords.navigateOnWindow(parentWindow);
        ActionKeywords.assertTrueContains(expected,ConfigurationManage_Page.lastBusDetail_Field().getAttribute("value"));
    }

    public static void add_newGroupDetailDesc() throws Exception {
        ActionKeywords.pageWait();
        Thread.sleep(1000);
        ActionKeywords.moveToElementExecutor(ConfigurationManage_Page.addLastGroupDetail_Btn());
    }

    public static void pick_LastGroupDetailSearch() throws Exception {
        Thread.sleep(1000);
        ActionKeywords.moveToElementExecutor(ConfigurationManage_Page.LastGroupDetail_searchBtn());
        for(String window:ActionKeywords.getAllWindows())
        {
            ActionKeywords.navigateOnWindow(window);
        }
        ActionKeywords.waitForElementDisappear(By.xpath("//*[@id='ResultTable']/tbody/tr/td/img"));
        String expected = ConfigurationManage_Page.firstAttrName().getText();
        ActionKeywords.moveToElementExecutor(ConfigurationManage_Page.firstAttrCode());
        ActionKeywords.navigateOnWindow(parentWindow);
        ActionKeywords.assertTrueContains(expected,ConfigurationManage_Page.lastGroupDetail_Field().getAttribute("value"));
    }

    public static void save_Configuration() throws Exception {
        ActionKeywords.moveToElementExecutor(ConfigurationManage_Page.save_Btn());
    }

    public static void verify_IncCode() throws Exception {
        String incCode = ExcelUtils.getCellData(19,1);
        ActionKeywords.assertTrueContains(incCode,ConfigurationManage_Page.incCode_field().getAttribute("value"));
    }

    public static void success_SaveConfiguration() throws Exception {
        ActionKeywords.assertTrueContains("Configuration has been successfully updated.", CommonElement.validation_Summary().getText());

    }
}
