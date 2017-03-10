package pageObjects;

import org.openqa.selenium.By;
import utility.ActionKeywords;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Agung_P1706 on 24/02/2017.
 */
public class CommonElement extends BaseClass {
    public CommonElement(WebDriver driver) {
        super(driver);
    }

    public static WebElement addBtn() throws Exception
    {
        try {
            element = ActionKeywords.findElementByXpath("//input[@value='Add' and @type='submit']");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement editBtn() throws Exception
    {
        try {
            element = ActionKeywords.findElementByXpath("//input[@value='Edit' and @type='button']");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement reviewBtn() throws Exception
    {
        try {
            element = ActionKeywords.findElementByXpath("//input[@value='Review' and @type='button']");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement saveBtn() throws Exception{
        try{element = ActionKeywords.findElementByXpath("//input[@value='Save']");}
        catch(Exception e){throw(e);}
        return element;
    }

    public static WebElement submitBtn() throws Exception{
        try{element = ActionKeywords.findElementByXpath("//*[@id='SubmitButton']");}
        catch(Exception e){throw(e);}
        return element;
    }

    public static WebElement validation_Summary() throws Exception
    {
        try {
            element = ActionKeywords.findElementByXpath("//div[@id='validationSummary']");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement resultTableCell(int row,int col,String extension) throws Exception
    {
        try {

            element = ActionKeywords.findElementByXpath("//*[@id='ResultTable']/tbody/tr["+row+"]/td["+col+"]"+extension);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public static WebElement resultTableCell(int row,int col) throws Exception
    {
        try {
            element = ActionKeywords.findElementByXpath("//*[@id='ResultTable']/tbody/tr["+row+"]/td["+col+"]");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public static WebElement advanceTableCell(int row,int col,String extension) throws Exception
    {
        try {
            element = ActionKeywords.findElementByXpath("//*[@id='AdvanceGridTable']/tbody/tr["+row+"]/td["+col+"]"+extension);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public static WebElement advanceTableCell(int row,int col) throws Exception
    {
        try {
            element = ActionKeywords.findElementByXpath("//*[@id='AdvanceGridTable']/tbody/tr["+row+"]/td["+col+"]");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public static WebElement resultTableCheck(int index) throws Exception
    {
        element = ActionKeywords.findElementById("Resultcheck"+index);
        return element;
    }
}
