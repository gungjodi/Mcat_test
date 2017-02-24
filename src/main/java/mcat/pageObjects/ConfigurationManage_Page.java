package mcat.pageObjects;

import mcat.utility.ActionKeywords;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Agung_P1706 on 22/02/2017.
 */
public class ConfigurationManage_Page extends BaseClass{
    public ConfigurationManage_Page(WebDriver driver) {
        super(driver);
    }

    public static WebElement SearchConfiguration_menu() throws Exception
    {
        try {
            element = ActionKeywords.findElementByPartialLinkText("Search Configuration");
        }
        catch (Exception e)
        {
            throw e;
        }
        return element;
    }

    public static WebElement firstAttrCode() throws Exception
    {
        try
        {
            element = ActionKeywords.findElementByXpath("//*[@id='ResultRow0']/td[1]/a");
        }
        catch (Exception e)
        {
            throw e;
        }
        return element;
    }

    public static WebElement addAnAttrGoup_btn() throws Exception
    {
        try {
            element = ActionKeywords.findElementByXpath("//input[@value='Add an Attribute Group']");
        }
        catch (Exception e)
        {
            throw e;
        }
        return element;
    }

    public static WebElement rowSearchCriteria() throws Exception
    {
        try {
            element = ActionKeywords.findElementByXpath("//*[@id='ResultRow0']/td[2]/a");
        }
        catch (Exception e)
        {
            throw e;
        }
        return element;
    }

    public static WebElement addLastRecordItem_Btn() throws Exception
    {
        try
        {
            element = ActionKeywords.findElementByXpath("//input[@value='Add New Record'][contains(@onclick,'cfdAttributeGridItem')]");
        }
        catch (Exception e)
        {
            throw e;
        }
        return element;
    }

    public static WebElement lastRecordItem_searchBtn() throws Exception
    {
        try
        {
            element = ActionKeywords.findElementByXpath("//*[@id='cfdAttributeGridResultItemTable']/tbody/tr[last()]/td[last()]/a");
        }
        catch (Exception e)
        {
            throw e;
        }
        return element;
    }

    public static WebElement addLastBusDetail_Btn() throws Exception
    {
        try
        {
            element = ActionKeywords.findElementByXpath("//input[@value='Add New Record'][contains(@onclick,'cfdAttributeGridBus')]");
        }
        catch (Exception e)
        {
            throw e;
        }
        return element;
    }

    public static WebElement LastBusDetail_searchBtn() throws Exception
    {
        try
        {
            element = ActionKeywords.findElementByXpath("//*[@id='cfdAttributeGridResultBusTable']/tbody/tr[last()]/td[last()]/a");
        }
        catch (Exception e)
        {
            throw e;
        }
        return element;
    }

    public static WebElement addLastGroupDetail_Btn() throws Exception {
        try
        {
            element = ActionKeywords.findElementByXpath("//input[@value='Add New Record'][contains(@onclick,'cfdAttributeGridGroup')]");
        }
        catch (Exception e)
        {
            throw e;
        }
        return element;
    }

    public static WebElement LastGroupDetail_searchBtn() throws Exception
    {
        try
        {
            element = ActionKeywords.findElementByXpath("//*[@id='cfdAttributeGridResultGroupTable']/tbody/tr[last()]/td[last()]/a");
        }
        catch (Exception e)
        {
            throw e;
        }
        return element;
    }

    public static WebElement save_Btn() throws Exception {
        try
        {
            element = ActionKeywords.findElementByXpath("//input[@value='Save'][contains(@onclick,'Submitter')]");
        }
        catch (Exception e)
        {
            throw e;
        }
        return element;
    }

    public static WebElement result() throws Exception {
        try
        {
            element = ActionKeywords.findElementById("validationSummary");
        }
        catch (Exception e)
        {
            throw e;
        }
        return element;
    }
}
