package pageObjects;

import utility.ActionKeywords;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Agung_P1706 on 20/02/2017.
 */
public class AttributeGroup_Page extends BaseClass{
    public AttributeGroup_Page(WebDriver driver) {
        super(driver);
    }

    public static WebElement CreateAttributeGroup_Link() throws Exception
    {

        try {
            element = ActionKeywords.findElementByXpath("//a[contains(.,'Create Attribute Group')]");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement SearchAttributeGroup_Link() throws Exception
    {
        try {
            element = ActionKeywords.findElementByXpath("//a[contains(.,'Search Attribute Group')]");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement AttributeGroupName_Field() throws Exception
    {
        try {
            element = ActionKeywords.findElementById("AttrGroupName");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

}
