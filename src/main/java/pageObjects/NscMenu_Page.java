package pageObjects;

import utility.ActionKeywords;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Agung_P1706 on 20/02/2017.
 */
public class NscMenu_Page extends BaseClass{

    public NscMenu_Page(WebDriver driver) {
        super(driver);
    }

    public static WebElement CreateNSC_Menu() throws Exception
    {
        try
        {
            element = ActionKeywords.findElementByXpath("//a[contains(.,'Create NSC')]");
        }
        catch (Exception e)
        {
            throw (e);
        }
        return element;
    }

    public static WebElement SearchNSC_Menu() throws Exception
    {
        try
        {
            element = ActionKeywords.findElementByXpath("//a[contains(.,'Search NSC')]");
        }
        catch (Exception e)
        {
            throw (e);
        }
        return element;
    }

    public static WebElement searchIncCode_link() throws Exception
    {
        try {
            element = ActionKeywords.findElementByXpath("//a[contains(@href,'/Nsc/IncLookup')]");
        }
        catch (Exception e)
        {
            throw e;
        }
        return element;
    }

    public static WebElement NSCCode_field() throws Exception
    {
        try {
            element=ActionKeywords.findElementById("NscCode");
        }
        catch (Exception e)
        {
            throw e;
        }
        return element;
    }

    public static WebElement NSCTitle_field() throws Exception
    {
        try {
            element=ActionKeywords.findElementById("NscTitle");
        }
        catch (Exception e)
        {
            throw e;
        }
        return element;
    }

    public static WebElement resultSuccess() throws Exception
    {
        try {
            element=ActionKeywords.findElementById("validationSummary");
        }
        catch (Exception e)
        {
            throw e;
        }
        return element;
    }

    public static WebElement link_NSCCode() throws Exception{
        try{element = ActionKeywords.findElementByXpath(".//*[@id='ResultRow0']/td[2]/a");}
        catch(Exception e){throw(e);}
        return element;
    }

    public static WebElement btn_SaveNSCDetail() throws Exception{
        try{element = ActionKeywords.findElementByXpath("//input[@value='Save']");}
        catch(Exception e){throw(e);}
        return element;
    }
}
