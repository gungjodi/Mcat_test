package mcat.modules;

import mcat.pageObjects.Attribute_Page;
import mcat.pageObjects.RawDataItem_Page;
import mcat.pageObjects.SearchCriteria;
import mcat.utility.ActionKeywords;
import mcat.utility.Constant;
import mcat.utility.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.management.Attribute;

/**
 * Created by Agung_P1706 on 20/02/2017.
 */
public class CreateAttribute_Module {

    public static String searchCriteria,parentWindow;

    public static void CreateAttribute() throws Exception
    {
        ActionKeywords.clickAction(Attribute_Page.CreateAttribute_Link());
    }

    public static void SearchAttribute() throws Exception
    {
        ActionKeywords.clickAction(Attribute_Page.SearchAttribute_Link());
    }

    public static void FillAttributeDetail() throws Exception
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
        WebElement addCriteria = SearchCriteria.btn_AddCriteria();
        ActionKeywords.clickAction(addCriteria);
        SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(12, 11));
        ActionKeywords.pageWait();
        SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));
        String searchCriteria=ExcelUtils.getCellData(28, 11);;
        RawDataItem_Page.txt_Criteria().sendKeys(searchCriteria);
        WebElement btnSearch = SearchCriteria.btn_Search();
        ActionKeywords.clickAction(btnSearch);
        ActionKeywords.pageWait();
        ActionKeywords.moveToElementExecutor((ActionKeywords.findElementByPartialLinkText(searchCriteria)));
        ActionKeywords.navigateOnWindow(parentWindow);
    }

    public static void addAttributeGroup() throws Exception
    {
        ActionKeywords.clickAction(Attribute_Page.addBtn());
    }

    public static void SearchAttributeCriteria() throws Exception
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
        WebElement btnSearch = SearchCriteria.btn_Search();
        ActionKeywords.clickAction(btnSearch);
    }

    public static void searchResult() throws Exception
    {
        ActionKeywords.waitForElementDisappear(By.xpath("//*[@id=\"ResultTable\"]/tbody/tr/td/img"));
        ActionKeywords.findElementByXpath("//a[contains(.,'"+searchCriteria+"')]").isDisplayed();
    }
}
