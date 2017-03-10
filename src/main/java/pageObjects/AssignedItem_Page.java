package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.ActionKeywords;

import java.util.List;

/**
 * Created by Agung_P1706 on 01/03/2017.
 */
public class AssignedItem_Page extends BaseClass{
    public AssignedItem_Page(WebDriver driver) {
        super(driver);
    }

    public static WebElement searchAssigned_Menu() throws Exception
    {
        element = ActionKeywords.findElementByPartialLinkText("Search Assigned Item");
        return element;
    }

    public static WebElement tag_Field() throws Exception {
        element = ActionKeywords.findElementById("Tag");
        return element;
    }

    public static WebElement incName_Field() throws Exception {
        element = ActionKeywords.findElementById("IncName");
        return element;
    }

    public static List<WebElement> attributeValues_Field() throws Exception {
        elements = ActionKeywords.findElementsByXpath("//*[@id='cfdAttributeGridResultItemTable']/tbody/tr/td[2]/input");
        return elements;
    }

    public static List<WebElement> businessUnit_Field() throws Exception {
        elements = ActionKeywords.findElementsByXpath("//*[@id='cfdAttributeGridResultBusTable']/tbody/tr/td[2]/input");
        return elements;
    }

    public static List<WebElement> groupDetail_searchLink() throws Exception {
        elements = ActionKeywords.findElementsByXpath("//*[@id='cfdAttributeGridResultGroupTable']/tbody/tr/td[2]/a");
        return elements;
    }
}
