package pageObjects;

import utility.ActionKeywords;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Agung_P1706 on 16/02/2017.
 */
public class IncMenu_Page extends BaseClass{
    public IncMenu_Page(WebDriver driver) {
        super(driver);
    }
    public static WebElement CreateINC_Menu() throws Exception
    {
        try
        {
            element = ActionKeywords.findElementByXpath("//a[contains(.,'Create INC')]");
        }
        catch (Exception e)
        {
            throw (e);
        }
        return element;
    }

    public static WebElement IncCode_Field() throws Exception
    {
        try {
            element = ActionKeywords.findElementById("IncCode");
        }
        catch (Exception e)
        {
            throw e;
        }
        return element;
    }

    public static WebElement IncName_Field() throws Exception
    {
        try {
            element = ActionKeywords.findElementById("IncName");
        }
        catch (Exception e)
        {
            throw e;
        }
        return element;
    }

    public static WebElement IncDesc_Field() throws Exception
    {
        try {
            element = ActionKeywords.findElementById("IncDesc");
        }
        catch (Exception e)
        {
            throw e;
        }
        return element;
    }

    public static WebElement searchNscCode_link() throws Exception
    {
        try {
            element = ActionKeywords.findElementByXpath("//a[contains(@href,'/Inc/NscLookup')]");
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
            element = ActionKeywords.findElementById("validationSummary");
        }
        catch (Exception e)
        {
            throw e;
        }
        return element;
    }

    public static WebElement SearchINC_Menu() throws Exception
    {
        try {
            element = ActionKeywords.findElementByXpath("//a[contains(.,'Search INC')]");
        }
        catch (Exception e)
        {
            throw e;
        }
        return element;
    }
}
