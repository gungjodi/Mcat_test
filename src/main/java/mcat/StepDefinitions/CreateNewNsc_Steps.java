package mcat.StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mcat.modules.CreateNSC_module;
import mcat.modules.HomePage_Module;
import mcat.pageObjects.NscMenu_Page;

/**
 * Created by Agung_P1706 on 20/02/2017.
 */
public class CreateNewNsc_Steps {
    @When("^User access create NSC menu$")
    public void userAccessCreateNSCMenu() throws Throwable {
        HomePage_Module.access_MCatMenu();
        HomePage_Module.access_ManageItemMenu();
        HomePage_Module.access_NSCMenu();
        CreateNSC_module.create_NSC();
    }

    @Then("^User click search INC code$")
    public void userClickSearchINCCode() throws Throwable {
        CreateNSC_module.searchINC();
    }

    @Then("^User choose INC code$")
    public void userChooseINCCode() throws Throwable {
        CreateNSC_module.pickINC();
    }

    @Then("^User fill NSC detail$")
    public void userFillNSCDetail() throws Throwable {
        CreateNSC_module.fillNSCdetail();
    }

    @Then("^User click add NSC button$")
    public void userClickAddNSCButton() throws Throwable {
        CreateNSC_module.clickAddNsc();
    }

    @And("^NSC should be added$")
    public void nscShouldBeAdded() throws Throwable {
        NscMenu_Page.resultSuccess().isDisplayed();
    }

    @When("^User access search NSC menu$")
    public void userAccessSearchNSCMenu() throws Throwable {
        CreateNSC_module.searchNscMenu();
    }

    @Then("^User search NSC code$")
    public void userSearchNSCCode() throws Throwable {
        CreateNSC_module.searchNscCode();
    }

    @And("^NSC code should be displayed$")
    public void nscCodeShouldBeDisplayed() throws Throwable {
        CreateNSC_module.NSCExists();
    }
}
