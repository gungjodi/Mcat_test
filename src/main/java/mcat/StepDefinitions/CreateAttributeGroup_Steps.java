package mcat.StepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mcat.modules.CreateAttributeGroup_Module;
import mcat.modules.HomePage_Module;

/**
 * Created by Agung_P1706 on 20/02/2017.
 */
public class CreateAttributeGroup_Steps {


    @When("^User access create Attribute Group Menu$")
    public void userAccessCreateAttributeGroupMenu() throws Throwable {
        HomePage_Module.access_MCatMenu();
        HomePage_Module.access_ManageItemMenu();
        HomePage_Module.access_AttributeGroupMenu();
        CreateAttributeGroup_Module.CreateAttributeGroup();
    }

    @Then("^User fill Attribute Group detail$")
    public void userFillAttributeGroupDetail() throws Throwable {
        CreateAttributeGroup_Module.FillAttributeGroupDetail();
    }

    @And("^click add Attribute Group button$")
    public void clickAddAttributeGroupButton() throws Throwable {
        CreateAttributeGroup_Module.addAttributeGroup();
    }

    @When("^User access Search Attribute Group menu$")
    public void userAccessSearchAttributeGroupMenu() throws Throwable {
        CreateAttributeGroup_Module.SearchAttributeGroup();
    }

    @Then("^search Attribute Group criteria$")
    public void searchAttributeGroupCriteria() throws Throwable {
        CreateAttributeGroup_Module.SearchAttributeGroupCriteria();
    }

    @And("^Attribute Group item should be displayed$")
    public void attributeGroupItemShouldBeDisplayed() throws Throwable {
        CreateAttributeGroup_Module.searchResult();
    }
}
