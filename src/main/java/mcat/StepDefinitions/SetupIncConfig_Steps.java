package mcat.StepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mcat.modules.ConfigurationManage_Module;
import mcat.modules.HomePage_Module;
import mcat.pageObjects.ConfigurationManage_Page;
import mcat.utility.ExcelUtils;

/**
 * Created by Agung_P1706 on 22/02/2017.
 */
public class SetupIncConfig_Steps {
    @Given("^user is at Search Configuration Menu$")
    public void userIsAtSearchConfigurationMenu() throws Throwable {
        HomePage_Module.access_MCatMenu();
        HomePage_Module.access_ManageItemMenu();
        HomePage_Module.access_ManageItemMenuConfiguration();
        ConfigurationManage_Module.access_SearchConfigurationMenu();
    }

    @When("^user Search Criteria Configuration$")
    public void userSearchCriteriaConfiguration() throws Throwable {
        ConfigurationManage_Module.search_Configuration_Criteria();
    }

    @Then("^user click Configuration Name Link$")
    public void userClickConfigurationNameLink() throws Throwable {
        ConfigurationManage_Module.clickConfNameLink();
    }

    @Then("^user add an Attribute Group$")
    public void userAddAnAttributeGroup() throws Throwable {
        ConfigurationManage_Module.add_AttrGroup();
    }

    @Then("^user add attribute to Item Description Detail$")
    public void userAddAttributeToItemDescriptionDetail() throws Throwable {
        ConfigurationManage_Module.add_newRecordItemDesc();
        ConfigurationManage_Module.pick_LastRecordSearch();
    }

    @Then("^user Add attribute to Bussiness Unit Detail$")
    public void userAddAttributeToBussinessUnitDetail() throws Throwable {
        ConfigurationManage_Module.add_newBusDetailDesc();
        ConfigurationManage_Module.pick_LastBusDetailSearch();
    }

    @Then("^user Add attribute to Group Detail$")
    public void userAddAttributeToGroupDetail() throws Throwable {
        ConfigurationManage_Module.add_newGroupDetailDesc();
        ConfigurationManage_Module.pick_LastGroupDetailSearch();
    }

    @Then("^user click Save the Configuration$")
    public void saveTheConfiguration() throws Throwable {
        ConfigurationManage_Module.save_Configuration();
    }

    @And("^Configuration should be saved successfully$")
    public void configurationShouldBeSavedSuccessfully() throws Throwable {
        ConfigurationManage_Page.result().isDisplayed();
    }
}
