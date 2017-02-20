package mcat.modules;

import mcat.utility.ActionKeywords;
import mcat.utility.Constant;
import org.openqa.selenium.By;
import mcat.pageObjects.LoadRawData_Page;

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
			ActionKeywords.waitForElement(By.id("validationSummary"));
		}
		catch(Exception e)
		{throw(e);}
	}
}

