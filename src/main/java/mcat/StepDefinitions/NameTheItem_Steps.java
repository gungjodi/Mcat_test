package mcat.StepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mcat.modules.HomePage_Module;
import mcat.modules.RawDataItem_Module;
import mcat.pageObjects.RawDataItem_Page;
import mcat.utility.ActionKeywords;
import org.openqa.selenium.By;

/**
 * Created by Agung_P1706 on 10/02/2017.
 */
public class NameTheItem_Steps {
    @When("^User access Search Raw Data Item menu$")
    public void userAccessSearchRawDataItemMenu() throws Throwable {
        HomePage_Module.access_MCatMenu();
        HomePage_Module.access_CatalogueItemMenu();
        HomePage_Module.access_RawDataItem();
    }

    @Then("^raw data should be displayed$")
    public void rawDataShouldBeDisplayed() throws Throwable {
        RawDataItem_Module.searchRawDataIsDisplayed();
    }

    @And("^User click StockCode with New$")
    public void userClickStockCodeWithNew() throws Throwable {
        RawDataItem_Module.newRawItem();
        RawDataItem_Module.nameItem();
    }
}
