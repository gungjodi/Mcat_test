package mcat.pageObjects;

import mcat.utility.ActionKeywords;
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
}
