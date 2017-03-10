package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.ActionKeywords;

/**
 * Created by Agung_P1706 on 02/03/2017.
 */
public class ReviewItem_Page extends BaseClass {
    public ReviewItem_Page(WebDriver driver) {
        super(driver);
    }

    public static WebElement approve_Btn() throws Exception {
        element = ActionKeywords.findElementById("ApproveButton");
        return element;
    }
}
