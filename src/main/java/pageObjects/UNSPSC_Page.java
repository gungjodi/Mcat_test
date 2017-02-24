package pageObjects;

import utility.ActionKeywords;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Agung_P1706 on 20/02/2017.
 */
public class UNSPSC_Page extends BaseClass {
    public UNSPSC_Page(WebDriver driver) {
        super(driver);
    }

    public static WebElement CreateUNSPSC_Link() throws Exception
    {
        try
        {
            element = ActionKeywords.findElementByXpath("//a[contains(.,'Create UNSPSC')]");
        }
        catch (Exception e)
        {
            throw (e);
        }
        return element;
    }

    public static WebElement SearchUNSPSC_Link() throws Exception
    {
        try
        {
            element = ActionKeywords.findElementByXpath("//a[contains(.,'Search UNSPSC')]");
        }
        catch (Exception e)
        {
            throw (e);
        }
        return element;
    }

    public static WebElement UnspscTitle_Field() throws Exception
    {
        try {
            element = ActionKeywords.findElementById("NspscTitle");
        }
        catch (Exception e)
        {
            throw e;
        }
        return element;
    }

    public static WebElement UnspscDesc_Field() throws Exception
    {
        try {
            element = ActionKeywords.findElementById("NspscDescription");
        }
        catch (Exception e)
        {
            throw e;
        }
        return element;
    }
}
