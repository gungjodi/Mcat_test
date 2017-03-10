package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.ActionKeywords;

/**
 * Created by Agung_P1706 on 06/03/2017.
 */
public class AdvanceSearch_Page extends BaseClass {
    public AdvanceSearch_Page(WebDriver driver) {
        super(driver);
    }

    public static WebElement attributeCriteria_Field() throws Exception
    {
        element = ActionKeywords.findElementById("attr_0");
        return element;
    }

    public static WebElement advanceSearchAttribute_Button() throws Exception
    {
        element = ActionKeywords.findElementById("AdvanceSearchButton");
        return element;
    }

    public static WebElement EditToAssignedButton_Button() throws Exception
    {
        element = ActionKeywords.findElementById("MassiveEditToAssignedButton");
        return element;
    }

    public static WebElement Submit_Button() throws Exception
    {
        element = ActionKeywords.findElementById("SubmitButton");
        return element;
    }

    public static WebElement advanceTableHeader_Last() throws Exception
    {
        element = ActionKeywords.findElementByXpath("//*[@id='AdvanceGridTable']/thead/tr/th[last()]");
        return element;
    }

    public static WebElement EditToReview_Button() throws Exception {
        element = ActionKeywords.findElementById("MassiveEditToReviewButton");
        return element;
    }

    public static WebElement Approve_Button() throws Exception {
        element = ActionKeywords.findElementById("ApproveButton");
        return element;
    }
}
