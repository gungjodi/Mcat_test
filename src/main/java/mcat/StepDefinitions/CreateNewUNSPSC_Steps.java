package mcat.StepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mcat.modules.CreateUNSPSC_module;
import mcat.modules.HomePage_Module;
import mcat.pageObjects.UNSPSC_Page;

/**
 * Created by Agung_P1706 on 20/02/2017.
 */
public class CreateNewUNSPSC_Steps {
    @When("^User access create UNSPSC Menu$")
    public void userAccessCreateUNSPSCMenu() throws Throwable {
        HomePage_Module.access_MCatMenu();
        HomePage_Module.access_ManageItemMenu();
        HomePage_Module.access_UNSPSCMenu();
        CreateUNSPSC_module.Create_UNSPSC();
    }

    @Then("^User fill UNSPSC detail$")
    public void userFillUNSPSCDetail() throws Throwable {
        CreateUNSPSC_module.fillUNSPSC_detail();
    }

    @And("^click add UNSPSC button$")
    public void clickAddUNSPSCButton() throws Throwable {
        CreateUNSPSC_module.addUNSPSC();
    }

    @When("^User access Search UNSPSC menu$")
    public void userAccessSearchUNSPSCMenu() throws Throwable {
        CreateUNSPSC_module.SearchUNSPSC();
    }

    @Then("^search UNSPSC criteria$")
    public void searchUNSPSCCriteria() throws Throwable {
        CreateUNSPSC_module.fillUNSPSC_Criteria();
    }

    @And("^UNSPSC item should be displayed$")
    public void unspscItemShouldBeDisplayed() throws Throwable {
        CreateUNSPSC_module.searchResult();
    }
}
