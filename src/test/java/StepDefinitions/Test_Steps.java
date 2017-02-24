package StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.*;
import pageObjects.BaseClass;
import pageObjects.ConfigurationManage_Page;
import pageObjects.IncMenu_Page;
import pageObjects.NscMenu_Page;
import utility.ActionKeywords;
import utility.Constant;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by Agung_P1706 on 09/02/2017.
 */
public class Test_Steps {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    //////////////////////////
    ///    LOGIN FLOW     ///
    /////////////////////////
    @Given("^User is at the Home Page$")
    public void userIsAtTheHomePage() throws Throwable {
        BaseClass.driver.get(Constant.HOME_PAGE);

    }

    @When("^User \"([^\"]*)\" enters UserName and Password$")
    public void userEntersUserNameAndPassword(String arg0) throws Throwable {
        LoginModule.enter_UserName_Password_Project(arg0);
    }


    @Then("^Click on the LogIn button$")
    public void clickOnTheLogInButton() throws Throwable {
        LoginModule.click_On_Login_Button();
    }

    @And("^Login success dialog is displayed$")
    public void loginSuccessDialogIsDisplayed() throws Throwable {
        LoginModule.succesfullyLoggedin();
    }

    ////////////////////////////////////
    /////      LOAD RAW DATA       ////
    ///////////////////////////////////
    @When("^User access Load Raw Data menu$")
    public void userAccessLoadRawDataMenu() throws Throwable {
        HomePage_Module.access_MCatMenu();
        HomePage_Module.access_DataPreparationMenu();
        HomePage_Module.access_LoadRawDataMenu();
    }

    @Then("^Load the Excel file$")
    public void loadTheExcelFile() throws Throwable {
        LoadRawData_Module.access_UploadFile();
    }

    @And("^Successful Upload message should display$")
    public void successful_Upload_message_should_display() throws Throwable {
        ActionKeywords.findElementByXpath("//div[@id='validationSummary' and contains(text(), 'Raw Data.xlsx have been uploaded successfully')]").isDisplayed();
    }

    @When("^User check loaded raw data$")
    public void iCheckLoadedRawData() throws Throwable {
        HomePage_Module.access_MCatMenu();
        HomePage_Module.access_CatalogueItemMenu();
        HomePage_Module.access_RawDataItem();
    }

    @Then("^loaded raw data should be displayed$")
    public void loadedRawDataShouldBeDisplayed() throws Throwable {
        RawDataItem_Module.set_SearchRawDataItemCriteria();
    }

    @When("^User click LogOut button$")
    public void userClickLogOutButton() throws Throwable {
        HomePage_Module.logout();
    }

    @Then("^User should be logged out$")
    public void userShouldBeLoggedOut() throws Throwable {
        LoginModule.loginPageIsDisplayed();
    }

    //////////////////////////////
    //      LOAD DICTIONARY     //
    /////////////////////////////
    @When("^User access Load Dictionary Data menu$")
    public void userAccessLoadDictionaryDataMenu() throws Throwable {
        HomePage_Module.access_MCatMenu();
        HomePage_Module.access_DataPreparationMenu();
        HomePage_Module.access_LoadDictionaryDataMenu();
    }

    @And("^Load the Dictionary Excel file$")
    public void loadTheDictionaryExcelFile() throws Throwable {
        LoadDictionaryData_Module.access_UploadFile();
    }

    @Then("^Successful Upload Dictionary message should display$")
    public void successful_Upload_Dictionary_message_should_display() throws Throwable {
        ActionKeywords.findElementByXpath("//div[@id='validationSummary' and contains(text(), 'Dictionary data.xlsx have been uploaded successfully')]").isDisplayed();
    }

    //////////////////////////////////////
    //          NAME THE ITEM          //
    /////////////////////////////////////
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

    ////////////////////////////////////////////////
    ///         NAME ITEM FROM CHECKLIST        ///
    //////////////////////////////////////////////
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
    //////////////////////////////////////////
    //          CREATE NEW INC              //
    //////////////////////////////////////////
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
        CreateINC_module.add_Inc();
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
        CreateINC_module.item_Exists();
    }

    ////////////////////////////////////
    ///     CREATE NEW NSC          ///
    ///////////////////////////////////
    @When("^User access create NSC menu$")
    public void userAccessCreateNSCMenu() throws Throwable {
        HomePage_Module.access_MCatMenu();
        HomePage_Module.access_ManageItemMenu();
        HomePage_Module.access_NSCMenu();
        CreateNSC_module.create_NSC();
    }

    @Then("^User click search INC code$")
    public void userClickSearchINCCode() throws Throwable {
        CreateNSC_module.search_INC();
    }

    @Then("^User choose INC code$")
    public void userChooseINCCode() throws Throwable {
        CreateNSC_module.pick_INC();
    }

    @Then("^User fill NSC detail$")
    public void userFillNSCDetail() throws Throwable {
        CreateNSC_module.fill_NSCdetail();
    }

    @Then("^User click add NSC button$")
    public void userClickAddNSCButton() throws Throwable {
        CreateNSC_module.click_AddNsc();
    }

    @And("^NSC should be added$")
    public void nscShouldBeAdded() throws Throwable {
        NscMenu_Page.resultSuccess().isDisplayed();
    }

    @When("^User access search NSC menu$")
    public void userAccessSearchNSCMenu() throws Throwable {
        CreateNSC_module.search_NscMenu();
    }

    @Then("^User search NSC code$")
    public void userSearchNSCCode() throws Throwable {
        CreateNSC_module.search_NscCode();
    }

    @And("^NSC code should be displayed$")
    public void nscCodeShouldBeDisplayed() throws Throwable {
        CreateNSC_module.NSC_Exists();
    }

    //////////////////////////////////////
    //        CREATE NEW UNSPSC        //
    /////////////////////////////////////
    @When("^User access create UNSPSC Menu$")
    public void userAccessCreateUNSPSCMenu() throws Throwable {
        HomePage_Module.access_MCatMenu();
        HomePage_Module.access_ManageItemMenu();
        HomePage_Module.access_UNSPSCMenu();
        CreateUNSPSC_module.Create_UNSPSC();
    }

    @Then("^User fill UNSPSC detail$")
    public void userFillUNSPSCDetail() throws Throwable {
        CreateUNSPSC_module.fill_UNSPSCDetail();
    }

    @And("^click add UNSPSC button$")
    public void clickAddUNSPSCButton() throws Throwable {
        CreateUNSPSC_module.add_UNSPSC();
    }

    @When("^User access Search UNSPSC menu$")
    public void userAccessSearchUNSPSCMenu() throws Throwable {
        CreateUNSPSC_module.search_UNSPSC();
    }

    @Then("^search UNSPSC criteria$")
    public void searchUNSPSCCriteria() throws Throwable {
        CreateUNSPSC_module.fill_UNSPSCCriteria();
    }

    @And("^UNSPSC item should be displayed$")
    public void unspscItemShouldBeDisplayed() throws Throwable {
        CreateUNSPSC_module.search_Result();
    }

    ///////////////////////////////////////////
    ///       CREATE ATTRIBUTE GROUP        ///
    //////////////////////////////////////////
    @When("^User access create Attribute Group Menu$")
    public void userAccessCreateAttributeGroupMenu() throws Throwable {
        HomePage_Module.access_MCatMenu();
        HomePage_Module.access_ManageItemMenu();
        HomePage_Module.access_AttributeGroupMenu();
        CreateAttributeGroup_Module.create_AttributeGroup();
    }

    @Then("^User fill Attribute Group detail$")
    public void userFillAttributeGroupDetail() throws Throwable {
        CreateAttributeGroup_Module.fill_AttributeGroupDetail();
    }

    @And("^click add Attribute Group button$")
    public void clickAddAttributeGroupButton() throws Throwable {
        CreateAttributeGroup_Module.add_AttributeGroup();
    }

    @When("^User access Search Attribute Group menu$")
    public void userAccessSearchAttributeGroupMenu() throws Throwable {
        CreateAttributeGroup_Module.search_AttributeGroup();
    }

    @Then("^search Attribute Group criteria$")
    public void searchAttributeGroupCriteria() throws Throwable {
        CreateAttributeGroup_Module.search_AttributeGroupCriteria();
    }

    @And("^Attribute Group item should be displayed$")
    public void attributeGroupItemShouldBeDisplayed() throws Throwable {
        CreateAttributeGroup_Module.search_Result();
    }

    //////////////////////////////////////
    //          CREATE ATTRIBUTE        //
    /////////////////////////////////////
    @When("^User access create Attribute Menu$")
    public void userAccessCreateAttributeMenu() throws Throwable {
        HomePage_Module.access_MCatMenu();
        HomePage_Module.access_ManageItemMenu();
        HomePage_Module.access_AttributeMenu();
        CreateAttribute_Module.create_Attribute();
    }

    @Then("^User fill Attribute detail$")
    public void userFillAttributeDetail() throws Throwable {
        CreateAttribute_Module.fill_AttributeDetail();
    }

    @And("^click add Attribute button$")
    public void clickAddAttributeButton() throws Throwable {
        CreateAttribute_Module.add_AttributeGroup();
    }

    @When("^User access Search Attribute menu$")
    public void userAccessSearchAttributeMenu() throws Throwable {
        CreateAttribute_Module.search_Attribute();
    }

    @Then("^search Attribute criteria$")
    public void searchAttributeCriteria() throws Throwable {
        CreateAttribute_Module.search_AttributeCriteria();
    }

    @And("^Attribute item should be displayed$")
    public void attributeItemShouldBeDisplayed() throws Throwable {
        CreateAttribute_Module.search_Result();
    }

    ///////////////////////////////////////////////
    //          SETUP INC CONFIGURATION         //
    //////////////////////////////////////////////
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
        ConfigurationManage_Module.click_ConfNameLink();
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

    //////////////////////////////////////////////
    //               ASSIGN ITEM               //
    ////////////////////////////////////////////
    @Given("^User is at Search Raw Data Menu$")
    public void userIsAtSearchRawDataMenu() throws Throwable {
        HomePage_Module.access_MCatMenu();
        HomePage_Module.access_CatalogueItemMenu();
        HomePage_Module.access_RawDataItem();
    }

    @When("^User search Named Item$")
    public void userSearchAnItem() throws Throwable {
        RawDataItem_Module.setCriteriaNamed();
        RawDataItem_Module.searchCriteriaNamed();
    }

    @Then("^User assign the Item$")
    public void userAssignTheItem() throws Throwable {
        RawDataItem_Module.access_FirstRow();
        RawDataItem_Module.assignItem();
    }

    @And("^Assigned item is displayed on table$")
    public void assignedItemIsDisplayedOnTable() throws Throwable {
        RawDataItem_Module.searchCriteriaAssignedTo();
    }

    @Then("^User assign ticked Items$")
    public void userAssignTickedItems() throws Throwable {
        RawDataItem_Module.tickItems();
        RawDataItem_Module.assignItems();
    }

    @And("^Assigned items are displayed on table$")
    public void assignedItemsAreDisplayedOnTable() throws Throwable {
        RawDataItem_Module.resultItemsAssignedTo();
    }
}
