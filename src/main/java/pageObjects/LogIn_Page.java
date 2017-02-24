package pageObjects;

import utility.ActionKeywords;
import utility.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogIn_Page extends BaseClass{

	public LogIn_Page(WebDriver driver) {
		super(driver);
	}

	public static void main_Page() throws Exception{
		try{
			driver.get(Constant.HOME_PAGE);
			driver.manage().window().maximize();
		}
		catch (Exception e){
			throw(e);
		}
	}

	public static WebElement formLogin() throws Exception
	{
		try {
			element = ActionKeywords.findElementByXpath("//*[@id=\"logincontainer\"]/div/div/div[3]/form");
		}
		catch (Exception e)
		{
			throw(e);
		}
		return element;
	}

	public static WebElement txt_UserId () throws Exception{
		try{
			element = ActionKeywords.findElementById("UserName");
		}
		catch (Exception e)
		{
			throw (e);
		}
		return element;
	}
	public static WebElement txt_UserPassword () throws Exception{
		try{
			element = ActionKeywords.findElementById("Password");
		}
		catch (Exception e)
		{
			throw (e);
		}
		return element;
	}
	public static WebElement txt_UserProject (String project) throws Exception{
		try{
			ActionKeywords.selectDropdownElementByVisibleText("Project", project);
		}
		catch (Exception e)
		{
			throw (e);
		}
		return element;
	}
	public static WebElement btn_Login () throws Exception{
		try{element = ActionKeywords.findElementByXpath("//input[@class='loginButton']");}
		catch (Exception e){throw (e);}
		return element;
	}
	public static WebElement link_Forgot_Password() throws Exception{
		try{element = ActionKeywords.findElementByXpath("//a[contains(.,'Forgot Password?')]");}
		catch (Exception e){throw(e);}
		return element;
	}

	public static WebElement loginDialogMessage() throws Exception
	{
		try
		{
			element = ActionKeywords.findElementByXpath("//*[@id=\"welcomeDialog\"]/p");
		}
		catch (Exception e)
		{
			throw (e);
		}
		return element;
	}

}
