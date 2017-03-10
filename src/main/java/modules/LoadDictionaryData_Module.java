package modules;

import pageObjects.CommonElement;
import utility.ActionKeywords;
import utility.Constant;
import pageObjects.LoadDictionaryData_Page;
import org.openqa.selenium.By;

public class LoadDictionaryData_Module {
	public static void access_UploadFile() throws Exception{
		try{
			LoadDictionaryData_Page.btn_UploadFile().click();
			if(ActionKeywords.browserName=="Chrome")
			{
				Runtime.getRuntime().exec(Constant.File_DictionaryDataUploadChrome);
			}
			else
			{
				Runtime.getRuntime().exec(Constant.File_DictionaryDataUpload);
			}
			Thread.sleep(5000);
			LoadDictionaryData_Page.btn_LoadExcelFile().click();
			Thread.sleep(15000);
			HomePage_Module.waitLoading();
		}
		catch(Exception e)
		{throw(e);}
	}

    public static void result() throws Exception {
	    HomePage_Module.waitLoadingDiv();
		String expectedResult = ".xlsx have been uploaded successfully";
		String actualResult = CommonElement.validation_Summary().getText();
		ActionKeywords.assertTrueContains(expectedResult,actualResult);
    }
}
