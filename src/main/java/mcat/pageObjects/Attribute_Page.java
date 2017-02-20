package mcat.pageObjects;

import mcat.utility.ActionKeywords;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Agung_P1706 on 20/02/2017.
 */
public class Attribute_Page extends BaseClass{
    public Attribute_Page(WebDriver driver) {
        super(driver);
    }

    public static WebElement CreateAttribute_Link() throws Exception
    {
        try {
            element = ActionKeywords.findElementByXpath("//a[contains(.,'Create Attribute')]");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement SearchAttribute_Link() throws Exception
    {
        try {
            element = ActionKeywords.findElementByXpath("//a[contains(.,'Search Attribute')]");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement AttributeCode_Field() throws Exception
    {
        try {
            element = ActionKeywords.findElementById("AttrCode");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement AttributeName_Field() throws Exception
    {
        try {
            element = ActionKeywords.findElementById("AttrName");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement searchGroupBtn() throws Exception
    {
        try {
            element = ActionKeywords.findElementByXpath("/html/body/div[4]/div/div[2]/form/div/table/tbody/tr[2]/td[2]/a");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement addBtn() throws Exception
    {
        try {
            element = ActionKeywords.findElementByXpath("/html/body/div[4]/div/div[2]/form/p/input");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }
}