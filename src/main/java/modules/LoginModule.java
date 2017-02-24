package modules;

import utility.ExcelUtils;

import pageObjects.LogIn_Page;
import utility.ActionKeywords;
import utility.Constant;

/**
 * Created by Agung_P1706 on 09/02/2017.
 */
public class LoginModule {

    public static void enter_UserName_Password_Project(String user) throws Exception{

        ActionKeywords.implicitWait();
        ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
        if(user.equals("Administrator"))
        {
            LogIn_Page.txt_UserId().sendKeys(ExcelUtils.getCellData(1, 2));
            LogIn_Page.txt_UserPassword().sendKeys(ExcelUtils.getCellData(2, 2));
            LogIn_Page.txt_UserProject(ExcelUtils.getCellData(3, 2));
        }
    }
    public static void click_On_Login_Button() throws Exception
    {LogIn_Page.btn_Login().click();}

    public static void click_On_Forgot_Password()throws Exception
    {LogIn_Page.link_Forgot_Password().click();}

    public static void succesfullyLoggedin() throws  Exception
    {
        LogIn_Page.loginDialogMessage().isDisplayed();
    }

    public static void loginPageIsDisplayed() throws Exception
    {
        LogIn_Page.formLogin().isDisplayed();
    }
}

