package mcat.StepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mcat.modules.RawDataItem_Module;
import mcat.utility.ActionKeywords;

/**
 * Created by Agung_P1706 on 16/02/2017.
 */
public class NameItemsFromChecklist_Steps {

    @When("^User tick one or more checkboxes$")
    public void userTickOneOrMoreCheckboxes() throws Throwable {
        RawDataItem_Module.tickOneOrMoreRow();
    }

    @Then("^user search INC code$")
    public void userSearchINCCode() throws Throwable {
        RawDataItem_Module.pickIncCode();
    }

    @And("^User Click name button$")
    public void userClickNameButton() throws Throwable {
        RawDataItem_Module.nameItems();
    }
}
