package mcat.modules;

import mcat.utility.ActionKeywords;
import mcat.utility.Constant;
import mcat.utility.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import mcat.pageObjects.Main_Page;
import mcat.pageObjects.RawDataItem_Page;
import mcat.pageObjects.SearchCriteria;

import java.util.List;
import java.util.Set;

public class RawDataItem_Module {

    static String parentincwindow;
    static String incWindow;
	public static void access_SearchRawDataItemMenu() throws Exception{
		try{
			WebElement searchRawDataItemMenu= Main_Page.menu_McatMainMenu();
		    ActionKeywords.clickAction(searchRawDataItemMenu);
		}
		catch(Exception e)
		{
			throw(e);
		}
	}
	public static void set_SearchRawDataItemCriteria() throws Exception{
		try{
			ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
			WebElement addCriteria = SearchCriteria.btn_AddCriteria();
			ActionKeywords.clickAction(addCriteria);
			SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(2, 11));
			ActionKeywords.pageWait();
			SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(1, 12));
			String searchCriteria=ExcelUtils.getCellData(7, 1);
			RawDataItem_Page.txt_Criteria().sendKeys(searchCriteria);
			WebElement btnSearch = SearchCriteria.btn_Search();
			ActionKeywords.clickAction(btnSearch);
			ActionKeywords.findElementByXpath("//a[contains(.,'"+searchCriteria+"')]").isDisplayed();
		}
		catch(Exception e)
		{
			throw(e);
		}
	}

	public static void searchRawDataIsDisplayed() throws Exception
	{
		RawDataItem_Page.menu_SearchRawDataItem().isDisplayed();
	}

	public static void newRawItem() throws Exception
    {
        ActionKeywords.waitForElementDisappear(By.xpath("//*[@id=\"ResultTable\"]/tbody/tr/td/img"));
        List<WebElement> rows = RawDataItem_Page.RawDataRows();
        for (int i = 0 ; i<rows.size();i++) {
            String resultRow = "ResultRow"+i;
            List<WebElement> column= ActionKeywords.findElementsByXpath("//*[@id='"+resultRow+"']/td");
            if(column.get(5).getText().equals("NEW"))
            {
                WebElement stockCodeLink = RawDataItem_Page.StockCodeLink("//*[@id='"+resultRow+"']/td[2]/a");
                ActionKeywords.moveToElementExecutor(stockCodeLink);
                break;
            }
        }
        ActionKeywords.pageWait();
        ActionKeywords.moveToElementExecutor(RawDataItem_Page.nameLink());

    }

    public static void nameItem() throws Exception
    {
        ActionKeywords.pageWait();
        String parentwindow = ActionKeywords.getParentWindow();
        ActionKeywords.clickAction(RawDataItem_Page.searchLink());

        for (String window : ActionKeywords.getAllWindows())
        {
            ActionKeywords.navigateOnWindow(window);
        }
        //get INC Code data from testdata excel
        ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
        WebElement incLink = ActionKeywords.findElementByPartialLinkText(ExcelUtils.getCellData(7, 6));
        ActionKeywords.moveToElementExecutor(incLink);
        ActionKeywords.navigateOnWindow(parentwindow);
        ActionKeywords.clickAction(ActionKeywords.findElementByXpath("//*[@id='NameButton']"));
    }

    public static void tickOneOrMoreRow() throws Exception
    {
        for (int i = 0 ; i<2;i++) {
            String resultCheckNum = "Resultcheck"+i;
            WebElement resultCheck = ActionKeywords.findElementByXpath("//*[@id='"+resultCheckNum+"']");
            ActionKeywords.clickAction(resultCheck);
        }

    }

    public static void pickIncCode() throws Exception
    {
        parentincwindow = ActionKeywords.getParentWindow();
        ActionKeywords.moveToElementExecutor(ActionKeywords.findElementByXpath("//*[@id=\"buttons\"]/table/tbody/tr/td[2]/input"));
        ActionKeywords.checkAlert();
        for (String window : ActionKeywords.getAllWindows())
        {
            ActionKeywords.navigateOnWindow(window);
        }

        WebElement searchInc = ActionKeywords.findElementByXpath("/html/body/div[4]/div/div[2]/form/div/table/tbody/tr[1]/td[2]/a");

        incWindow = ActionKeywords.getParentWindow();
        ActionKeywords.clickAction(searchInc);

    }

    public static void nameItems() throws Exception
    {
        for (String window : ActionKeywords.getAllWindows())
        {
            ActionKeywords.navigateOnWindow(window);
        }
        ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
        WebElement incLink = ActionKeywords.findElementByPartialLinkText(ExcelUtils.getCellData(7, 6));
        ActionKeywords.moveToElementExecutor(incLink);
        ActionKeywords.navigateOnWindow(incWindow);
        ActionKeywords.clickAction(ActionKeywords.findElementByXpath("//*[@id='NameButton']"));
        ActionKeywords.closeWindow();
        ActionKeywords.navigateOnWindow(parentincwindow);
    }
}
