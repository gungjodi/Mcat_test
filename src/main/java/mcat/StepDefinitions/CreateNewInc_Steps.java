package mcat.StepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mcat.modules.CreateINC_module;
import mcat.modules.HomePage_Module;
import mcat.pageObjects.IncMenu_Page;

/**
 * Created by Agung_P1706 on 16/02/2017.
 */
public class CreateNewInc_Steps {
    @When("^User access INC menu$")
    public void userAccessINCMenu() throws Throwable {
        HomePage_Module.access_MCatMenu();
        HomePage_Module.access_ManageItemMenu();
        HomePage_Module.access_INCMenu();
    }

    @Then("^User click Create new INC menu$")
    public void userClickCreateNewINCMenu() throws Throwable {
        CreateINC_module.create_INC();
    }

    @And("^User fill INC detail$")
    public void userFillINCDetail() throws Throwable {
        CreateINC_module.fill_INC_detail();
    }

    @When("^User click add button$")
    public void userClickAddButton() throws Throwable {
        CreateINC_module.addInc();
    }

    @Then("^INC should be created$")
    public void incShouldCreated() throws Throwable {
        IncMenu_Page.resultSuccess().isDisplayed();
    }

    @When("^user click search inc menu$")
    public void userClickSearchIncMenu() throws Throwable {
        CreateINC_module.access_INCSearchMenu();
    }

    @Then("^user search the created INC$")
    public void userSearchTheCreatedINC() throws Throwable {
        CreateINC_module.search_IncItem();
    }

    @And("^the created INC should be displayed$")
    public void theCreatedINCShouldBeDisplayed() throws Throwable {
        CreateINC_module.itemExists();
    }
}
