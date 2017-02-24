package modules;

import pageObjects.Attribute_Page;
import pageObjects.CommonElement;
import pageObjects.RawDataItem_Page;
import pageObjects.SearchCriteria;
import utility.ActionKeywords;
import utility.Constant;
import utility.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Agung_P1706 on 20/02/2017.
 */
public class CreateAttribute_Module {

    public static String searchCriteria,parentWindow;

    public static void create_Attribute() throws Exception
    {
        ActionKeywords.clickAction(Attribute_Page.CreateAttribute_Link());
    }

    public static void search_Attribute() throws Exception
    {
        ActionKeywords.clickAction(Attribute_Page.SearchAttribute_Link());
    }

    public static void fill_AttributeDetail() throws Exception
    {
        Attribute_Page.AttributeCode_Field().sendKeys("01_MMANUFACTURER");
        Attribute_Page.AttributeName_Field().sendKeys("Manufacturer");
        ActionKeywords.selectDropdownElementByVisibleText("AttrTypeId","Business Unit");
        parentWindow = ActionKeywords.getParentWindow();
        ActionKeywords.moveToElementExecutor(Attribute_Page.searchGroupBtn());
        for (String window : ActionKeywords.getAllWindows())
        {
            ActionKeywords.navigateOnWindow(window);
        }
        ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
        ActionKeywords.clickAction(SearchCriteria.btn_AddCriteria());
        SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(12, 11));
        ActionKeywords.pageWait();
        SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));
        String searchCriteria=ExcelUtils.getCellData(28, 11);;
        RawDataItem_Page.txt_Criteria().sendKeys(searchCriteria);
        ActionKeywords.clickAction(SearchCriteria.btn_Search());
        ActionKeywords.pageWait();
        ActionKeywords.moveToElementExecutor((ActionKeywords.findElementByPartialLinkText(searchCriteria)));
        ActionKeywords.navigateOnWindow(parentWindow);
    }

    public static void add_AttributeGroup() throws Exception
    {
        ActionKeywords.clickAction(CommonElement.addBtn());
    }

    public static void search_AttributeCriteria() throws Exception
    {
        ActionKeywords.waitForElementDisappear(By.xpath("//*[@id=\"ResultTable\"]/tbody/tr/td/img"));
        ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
        WebElement addCriteria = SearchCriteria.btn_AddCriteria();
        ActionKeywords.clickAction(addCriteria);
        SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(10, 11));
        ActionKeywords.pageWait();
        SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));
        searchCriteria="01_MMANUFACTURER";
        RawDataItem_Page.txt_Criteria().sendKeys(searchCriteria);
        ActionKeywords.clickAction(SearchCriteria.btn_Search());
    }
    public static void search_Result() throws Exception
    {
        ActionKeywords.waitForElementDisappear(By.xpath("//*[@id=\"ResultTable\"]/tbody/tr/td/img"));
        ActionKeywords.findElementByXpath("//a[contains(.,'"+searchCriteria+"')]").isDisplayed();
    }
}
