package modules;

import org.junit.Assert;
import pageObjects.CommonElement;
import utility.ActionKeywords;
import utility.Constant;
import org.openqa.selenium.By;
import pageObjects.LoadRawData_Page;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class LoadRawData_Module {
	
	public static void access_UploadFile() throws Exception{
		try{
			LoadRawData_Page.btn_UploadFile().click();
			if(ActionKeywords.browserName=="Chrome")
			{
				Runtime.getRuntime().exec(Constant.File_RawDataUploadChrome);
			}
			else
			{
				Runtime.getRuntime().exec(Constant.File_RawDataUpload);
			}
			Thread.sleep(5000);
			LoadRawData_Page.btn_LoadExcelFile().click();
			HomePage_Module.waitLoading();
		}
		catch(Exception e)
		{throw(e);}
	}

	public static void result_Displayed() throws Exception
	{
		HomePage_Module.waitLoading();
		String expectedResult = ".xlsx have been uploaded successfully";
		String actualResult = CommonElement.validation_Summary().getText();
		ActionKeywords.assertTrueContains(expectedResult,actualResult);
	}
}

