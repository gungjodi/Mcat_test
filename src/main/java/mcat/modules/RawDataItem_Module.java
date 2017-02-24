package mcat.modules;

import mcat.pageObjects.NscMenu_Page;
import mcat.pageObjects.RawDataItem_Page;
import mcat.pageObjects.SearchCriteria;
import mcat.utility.ActionKeywords;
import mcat.utility.Constant;
import mcat.utility.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RawDataItem_Module {
    static List<String> stockCodes = new ArrayList<String>();
    static String parentincwindow;
    static String incWindow;
	public static void access_SearchRawDataItemMenu() throws Exception{
		try{
		    ActionKeywords.clickAction(RawDataItem_Page.menu_SearchRawDataItem());
		}
		catch(Exception e)
		{
			throw(e);
		}
	}

	public static void set_SearchRawDataItemCriteria() throws Exception{
		try{
			ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
			ActionKeywords.clickAction(SearchCriteria.btn_AddCriteria());
			SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(2, 11));
			ActionKeywords.pageWait();
			SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(1, 12));
			String searchCriteria=ExcelUtils.getCellData(7, 1);
			RawDataItem_Page.txt_Criteria().sendKeys(searchCriteria);
			ActionKeywords.clickAction(SearchCriteria.btn_Search());
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
        ActionKeywords.clickAction(NscMenu_Page.searchIncCode_link());

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


    public static void setCriteriaNamed() throws Exception
    {
        ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
        ActionKeywords.clickAction(SearchCriteria.btn_AddCriteria());
        SearchCriteria.dropdown_SearchMethod("criteria0",ExcelUtils.getCellData(6, 11));
        ActionKeywords.pageWait();
        SearchCriteria.dropdown_Operator("operator0",ExcelUtils.getCellData(7, 12));
        Thread.sleep(1000);
        String searchCriteria=ExcelUtils.getCellData(34, 11);
        SearchCriteria.dropdown_SearchMethod("value1_0",searchCriteria);
    }

    public static void searchCriteriaNamed() throws Exception {
        Thread.sleep(1000);
        ActionKeywords.clickAction(SearchCriteria.btn_Search());
    }

    public static void access_FirstRow() throws Exception {
        ActionKeywords.pageWait();
        ExcelUtils.setCellData(RawDataItem_Page.firstRowTable().getText(),34,13);
        ActionKeywords.moveToElementExecutor(RawDataItem_Page.firstRowTable());
    }

    public static void assignItem() throws Exception {
        ActionKeywords.pageWait();
        String parentWindow = ActionKeywords.getParentWindow();
        ActionKeywords.moveToElementExecutor(RawDataItem_Page.btn_Assign());
        ActionKeywords.pageWait();
        ActionKeywords.moveToElementExecutor(RawDataItem_Page.btn_searchAssignedTo());
        for(String window : ActionKeywords.getAllWindows())
        {
            ActionKeywords.navigateOnWindow(window);
        }
        String username = ExcelUtils.getCellData(34,12);
        WebElement linkUsername = ActionKeywords.findElementByPartialLinkText(username);
        ActionKeywords.moveToElementExecutor(linkUsername);
        ActionKeywords.navigateOnWindow(parentWindow);
        ActionKeywords.moveToElementExecutor(RawDataItem_Page.btn_doAssignitem());
    }

    public static void searchCriteriaAssignedTo() throws Exception {
	    ActionKeywords.pageWait();
        HomePage_Module.waitLoading();
        ActionKeywords.moveToElementExecutor(SearchCriteria.btn_AddCriteria());
	    String stockCode = ExcelUtils.getCellData(34,13);
        ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
        SearchCriteria.dropdown_SearchMethod("criteria1",ExcelUtils.getCellData(7, 11));
        Thread.sleep(1000);
        SearchCriteria.dropdown_Operator("operator1",ExcelUtils.getCellData(7, 12));
        Thread.sleep(1000);
        String searchCriteria=ExcelUtils.getCellData(34, 12);
        RawDataItem_Page.txt_Criteria1().sendKeys(searchCriteria);
        ActionKeywords.clickAction(SearchCriteria.btn_Search());
        HomePage_Module.waitLoading();
        String xpathResult = "//a[contains(text(),"+stockCode+")]/parent::td/parent::tr/td[@id='ResultRow0Col6' and contains(text(),'"+searchCriteria+"')]";
        ActionKeywords.findElementByXpath(xpathResult).isDisplayed();
    }

    public static void tickItems() throws Exception {
	    for (int i = 0 ; i<4;i++) {
            String resultCheckNum = "Resultcheck"+i;
            String resultStockNum = "ResultRow"+i;
            String stockCodePath = "//*[@id='"+resultStockNum+"']/td[2]/a";
            WebElement stock = ActionKeywords.findElementByXpath(stockCodePath);
            stockCodes.add(stock.getText());
            ExcelUtils.setCellData(RawDataItem_Page.firstRowTable().getText(),34+i,14);
            WebElement resultCheck = ActionKeywords.findElementByXpath("//*[@id='"+resultCheckNum+"']");
            ActionKeywords.clickAction(resultCheck);
        }
    }

    public static void assignItems() throws Exception {
	    String parentWindow = ActionKeywords.getParentWindow();
	    ActionKeywords.moveToElementExecutor(RawDataItem_Page.btn_AssignItems());
        ActionKeywords.checkAlert();
        for (String window:ActionKeywords.getAllWindows())
        {
            ActionKeywords.navigateOnWindow(window);
        }
        String secondWindow = ActionKeywords.getParentWindow();
        ActionKeywords.pageWait();
        Thread.sleep(2000);
        ActionKeywords.clickAction(RawDataItem_Page.btn_searchAssignedTo());

        for (String window:ActionKeywords.getAllWindows())
        {
            ActionKeywords.navigateOnWindow(window);
        }

        String username = ExcelUtils.getCellData(34,12);
        WebElement linkUsername = ActionKeywords.findElementByPartialLinkText(username);
        ActionKeywords.moveToElementExecutor(linkUsername);
        ActionKeywords.navigateOnWindow(secondWindow);
        ActionKeywords.moveToElementExecutor(RawDataItem_Page.btn_doAssignitem());
        ActionKeywords.closeWindow();
        ActionKeywords.navigateOnWindow(parentWindow);
    }

    public static void resultItemsAssignedTo() throws Exception {
	    HomePage_Module.waitLoading();
        ActionKeywords.pageWait();
        ActionKeywords.clickAction(SearchCriteria.btn_AddCriteria());
        ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
        SearchCriteria.dropdown_SearchMethod("criteria1",ExcelUtils.getCellData(7, 11));
        Thread.sleep(1000);
        SearchCriteria.dropdown_Operator("operator1",ExcelUtils.getCellData(7, 12));
        Thread.sleep(1000);
        String searchCriteria=ExcelUtils.getCellData(34, 12);
        RawDataItem_Page.txt_Criteria1().sendKeys(searchCriteria);
        ActionKeywords.clickAction(SearchCriteria.btn_Search());
        HomePage_Module.waitLoading();
        for (int i = 0; i < stockCodes.size(); i++)
        {
            WebElement item = ActionKeywords.findElementByXpath("//a[contains(text(),'"+stockCodes.get(i)+"')]/parent::td/parent::tr/td[@id='ResultRow"+i+"Col6' and contains(text(),'"+searchCriteria+"')]");
            ActionKeywords.moveToElementExecutor(item);
            item.isDisplayed();
        }
    }
}
