package mcat.StepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mcat.modules.CreateAttribute_Module;
import mcat.modules.HomePage_Module;

/**
 * Created by Agung_P1706 on 20/02/2017.
 */
public class CreateNewAttribute_Steps {
    @When("^User access create Attribute Menu$")
    public void userAccessCreateAttributeMenu() throws Throwable {
        HomePage_Module.access_MCatMenu();
        HomePage_Module.access_ManageItemMenu();
        HomePage_Module.access_AttributeMenu();
        CreateAttribute_Module.CreateAttribute();
    }

    @Then("^User fill Attribute detail$")
    public void userFillAttributeDetail() throws Throwable {
        CreateAttribute_Module.FillAttributeDetail();
    }

    @And("^click add Attribute button$")
    public void clickAddAttributeButton() throws Throwable {
        CreateAttribute_Module.addAttributeGroup();
    }

    @When("^User access Search Attribute menu$")
    public void userAccessSearchAttributeMenu() throws Throwable {
        CreateAttribute_Module.SearchAttribute();
    }

    @Then("^search Attribute criteria$")
    public void searchAttributeCriteria() throws Throwable {
        CreateAttribute_Module.SearchAttributeCriteria();
    }

    @And("^Attribute item should be displayed$")
    public void attributeItemShouldBeDisplayed() throws Throwable {
        CreateAttribute_Module.searchResult();
    }
}
