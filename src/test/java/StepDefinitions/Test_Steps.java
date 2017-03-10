package StepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.*;
import org.openqa.selenium.WebDriver;
import pageObjects.BaseClass;
import pageObjects.CommonElement;
import utility.ActionKeywords;
import utility.Constant;

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
    /////      1. LOAD RAW DATA       ////
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
    public void successful_Upload_message_should_display() throws Exception {
        LoadRawData_Module.result_Displayed();
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

    //////////////////////////////
    //     LOAD DICTIONARY     //
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
        LoadDictionaryData_Module.result();
    }

    @Then("^Attribute Data is displayed$")
    public void attribute_Data_is_displayed() throws Throwable {
        Attribute_Module.set_SearchAttributeItemCriteria();
    }

    @When("^User click the Attribute Code$")
    public void user_click_the_Attribute_Code() throws Throwable {
        Attribute_Module.click_AttributeCode();
    }

    @When("^Save the update attribute detail$")
    public void save_the_update_attribute_detail() throws Throwable {
        Attribute_Module.update_AttributeDetail();
    }

    @Then("^Attribute Detail has been successfully updated$")
    public void attribute_Detail_has_been_successfully_updated() throws Throwable {
        ActionKeywords.assertTrueContains("Attribute Name already exists in database.",ActionKeywords.findElementById("validationSummary").getText());
    }

    @When("^User access Search NSC menu$")
    public void user_access_Search_NSC_menu() throws Throwable {
        HomePage_Module.access_MCatMenu();
        HomePage_Module.access_ManageItemMenu();
        HomePage_Module.access_NSCMenu();
        NSC_Module.access_SearchNSCMenu();
    }

    @Then("^NSC Data is displayed$")
    public void nsc_Data_is_displayed() throws Throwable {
        NSC_Module.set_SearchNSCCriteria();
    }

    @When("^User click the NSC Code$")
    public void user_click_the_NSC_Code() throws Throwable {
        NSC_Module.click_NSCCode();
    }

    @When("^Save the update NSC detail$")
    public void save_the_update_NSC_detail() throws Throwable {
        NSC_Module.update_NSCDetail();
    }

    @Then("^NSC Detail has been successfully updated$")
    public void nsc_Detail_has_been_successfully_updated() throws Throwable {
        ActionKeywords.assertTrueContains("NSC has been successfully updated",ActionKeywords.findElementById("validationSummary").getText());
    }

    @When("^User acess Search INC menu$")
    public void user_acess_Search_INC_menu() throws Throwable {
        HomePage_Module.access_MCatMenu();
        HomePage_Module.access_ManageItemMenu();
        HomePage_Module.access_INCMenu();
        INC_Module.access_SearchINCMenu();
    }

    @Then("^INC Data is displayed$")
    public void inc_Data_is_displayed() throws Throwable {
        INC_Module.set_SearchINCCriteria();
    }

    @When("^User click the INC Code$")
    public void user_click_the_INC_Code() throws Throwable {
        INC_Module.click_INCCode();
    }

    @And("^Save the update INC detail$")
    public void save_the_update_INC_detail() throws Throwable {
        INC_Module.update_INCDetail();
    }

    @Then("^INC Detail has been successfully updated$")
    public void incDetailHasBeenSuccessfullyUpdated() throws Throwable {
        ActionKeywords.assertTrueContains("INC has been successfully updated",ActionKeywords.findElementById("validationSummary").getText());
    }

    @When("^User access Search Configuration Menu$")
    public void userAccessSearchConfigurationMenu() throws Throwable {
        HomePage_Module.access_MCatMenu();
        HomePage_Module.access_ManageItemMenu();
        HomePage_Module.access_ManageItemMenuConfiguration();
        ConfigurationManage_Module.access_SearchConfigurationMenu();
    }

    @Then("^Configuration Data is Displayed$")
    public void configurationDataIsDisplayed() throws Throwable {
        INC_Module.set_SearchINCCriteria();
    }

    @When("^User click Configuration Item$")
    public void userClickConfigurationItem() throws Throwable {
        ConfigurationManage_Module.click_ConfNameLink();
    }

    @Then("^INC Code is Displayed on Item Description Detail$")
    public void incCodeIsDisplayedOnItemDescriptionDetail() throws Throwable {
        ConfigurationManage_Module.verify_IncCode();
    }

    //////////////////////////////////////
    //          2. NAME THE ITEM          //
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
    }

    @When("^User Name the Item$")
    public void userNameTheItem() throws Throwable {
        RawDataItem_Module.nameItem();
    }

    @Then("^Item should be named$")
    public void itemShouldBeNamed() throws Throwable {
        RawDataItem_Module.checkItemNamed();
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

    @Then("^User Click name button$")
    public void userClickNameButton() throws Throwable {
        RawDataItem_Module.nameItems();
    }

    @And("^Items should be named$")
    public void itemsShouldBeNamed() throws Throwable {
        RawDataItem_Module.checkItemFromChecklistNamed();
    }
    //////////////////////////////////////////
    //          3. CREATE NEW INC              //
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
        CreateINC_module.success_CreateInc();
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
    ///     4. CREATE NEW NSC          ///
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
        CreateNSC_module.success_CreateNsc();
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
    //        5. CREATE NEW UNSPSC        //
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

    @Then("^click add UNSPSC button$")
    public void clickAddUNSPSCButton() throws Throwable {
        CreateUNSPSC_module.add_UNSPSC();
    }

    @And("^UNSPSC should be created$")
    public void unspscShouldBeCreated() throws Throwable {
        CreateUNSPSC_module.success_CreateUnspsc();
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
    ///       6. CREATE ATTRIBUTE GROUP        ///
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

    @Then("^click add Attribute Group button$")
    public void clickAddAttributeGroupButton() throws Throwable {
        CreateAttributeGroup_Module.add_AttributeGroup();
    }

    @And("^Attribute Group item should be created$")
    public void attributeGroupItemShouldBeCreated() throws Throwable {
        CreateAttributeGroup_Module.success_CreateAttributeGroup();
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
    //          7. CREATE ATTRIBUTE        //
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

    @Then("^click add Attribute button$")
    public void clickAddAttributeButton() throws Throwable {
        CreateAttribute_Module.add_AttributeGroup();
    }

    @And("^Attribute item should be created$")
    public void attributeItemShouldBeCreated() throws Throwable {
        CreateAttribute_Module.success_CreateAttribute();
    }

    @When("^User access Search Attribute menu$")
    public void userAccessSearchAttributeMenu() throws Throwable {
        HomePage_Module.access_MCatMenu();
        HomePage_Module.access_ManageItemMenu();
        HomePage_Module.access_AttributeMenu();
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
    //          8. SETUP INC CONFIGURATION         //
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
        ConfigurationManage_Module.success_SaveConfiguration();
    }

    //////////////////////////////////////////////
    //              9. ASSIGN ITEM               //
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

    /////////////////////////////////////////
    ////    10. Submit Assigned Item    ////
    ///////////////////////////////////////
    @When("^User access Search Assigned Item Menu$")
    public void userAccessSearchAssignedItemMenu() throws Throwable {
        HomePage_Module.access_MCatMenu();
        HomePage_Module.access_CatalogueItemMenu();
        HomePage_Module.access_AssignedItemMenu();
    }

    @Then("^User search the assigned item$")
    public void userSearchTheAssignedItem() throws Throwable {
        AssignedItem_Module.search_AssignedItem();
    }

    @And("^User submit the assigned item$")
    public void userSubmitTheAssignedItem() throws Throwable {
        AssignedItem_Module.click_AssignedItem();
        AssignedItem_Module.submit_AssignedItem();
    }

    @Then("^User search the submitted item$")
    public void userSearchTheSubmittedItem() throws Throwable {
        AssignedItem_Module.search_SubmittedItem();
    }

    @And("^submitted item should be displayed$")
    public void submittedItemShouldBeDisplayed() throws Throwable {
        AssignedItem_Module.displayed_submittedItem();
    }

    ////////////////////////////////////////////////////////
    ////    10. Submit Assigned Item From Checklist    ////
    //////////////////////////////////////////////////////
    @Then("^User search the assigned items from checklist$")
    public void userSearchTheAssignedItemsFromChecklist() throws Throwable {
        AssignedItem_Module.search_AssignedItem();
    }

    @And("^User submit the checked items$")
    public void userSubmitTheCheckedItems() throws Throwable {
        AssignedItem_Module.tick_AssignedItems();
    }

    @Then("^User search the submitted items$")
    public void userSearchTheSubmittedItems() throws Throwable {
        for (int i = 0; i < 4; i++) {
            AssignedItem_Module.submit_AssignedItem();
            if(i<3)
            {
                ActionKeywords.assertTrueContains("Raw Data has been successfully updated",CommonElement.validation_Summary().getText());
            }
        }
    }

    @And("^submitted items should be displayed$")
    public void submittedItemsShouldBeDisplayed() throws Throwable {
        AssignedItem_Module.search_SubmittedItems();
    }

    //////////////////////////////////////////////
    /////       11. REVIEW ITEM       ///////////
    ////////////////////////////////////////////
    @When("^User access Search Review Item Menu$")
    public void userAccessSearchReviewItemMenu() throws Throwable {
        HomePage_Module.access_MCatMenu();
        HomePage_Module.access_CatalogueItemMenu();
        HomePage_Module.access_ReviewItemMenu();
    }

    @Then("^User search the catalogued item$")
    public void userSearchTheCataloguedItem() throws Throwable {
        ReviewItem_Module.search_CataloguedItem();
    }

    @And("^User approve the catalogued item$")
    public void userApproveTheCataloguedItem() throws Throwable {
        ReviewItem_Module.click_CataloguedItem();
        ReviewItem_Module.approve_CataloguedItem();
    }

    @Then("^User search the reviewed item$")
    public void userSearchTheReviewedItem() throws Throwable {
        ReviewItem_Module.search_ReviewedItem();
    }

    @And("^reviewed item should be displayed$")
    public void reviewedItemShouldBeDisplayed() throws Throwable {
        ReviewItem_Module.displayed_approvedItem();
    }

    ///////////////////////////////////////////////////////
    /////       11. REVIEW ITEM FROM CHECKLIST    ////////
    /////////////////////////////////////////////////////
    @Then("^User search the catalogued items from checklist$")
    public void userSearchTheCataloguedItemsFromChecklist() throws Throwable {
        ReviewItem_Module.search_CataloguedItem();
    }

    @And("^User approve the checked items$")
    public void userApproveTheCheckedItems() throws Throwable {
        ReviewItem_Module.tick_CataloguedItems();
    }

    @Then("^User search the approved items$")
    public void userSearchTheApprovedItems() throws Throwable {
        for (int i = 0; i < 4; i++) {
            ReviewItem_Module.approve_CataloguedItem();
            if(i<3)
            {
                ActionKeywords.assertTrueContains("Raw Data has been successfully updated",CommonElement.validation_Summary().getText());
            }
        }
    }

    @And("^approved items should be displayed$")
    public void approvedItemsShouldBeDisplayed() throws Throwable {
        ReviewItem_Module.search_ApprovedItems();
    }

    ///////////////////////////////////
    ////     Advance Search      /////
    /////////////////////////////////

    @When("^User access Advance Search Menu$")
    public void userAccessAdvanceSearchMenu() throws Throwable {
        HomePage_Module.access_MCatMenu();
        HomePage_Module.access_CatalogueItemMenu();
        HomePage_Module.access_AdvanceSearchMenu();
    }

    @Then("^User search item based on INC$")
    public void userSearchItemBasedOnINC() throws Throwable {
        AdvanceSearch_Module.search_AdvanceINC();
    }

    @And("^INC item is displayed$")
    public void incItemIsDisplayed() throws Throwable {
        AdvanceSearch_Module.displayed_INCCode();
    }

    @When("^User search Attribute$")
    public void userSearchAttribute() throws Throwable {
        AdvanceSearch_Module.search_AdvanceAttribute();
    }

    @Then("^Attribute is Displayed$")
    public void attributeIsDisplayed() throws Throwable {
        AdvanceSearch_Module.displayed_AdvanceAttribute();
    }


    @Then("^User search item criteria$")
    public void userSearchItemCriteria() throws Throwable {
        AdvanceSearch_Module.search_ItemCriteria();
    }

    @And("^User edit to Assigned Item$")
    public void userEditToAssignedItem() throws Throwable {
        AdvanceSearch_Module.pick_StockCode();
        AdvanceSearch_Module.editToAssign_StockCode();

    }

    @When("^User check edited item$")
    public void userCheckEditedItem() throws Throwable {
        AdvanceSearch_Module.search_EditToAssign();
    }

    @Then("^edited item is displayed$")
    public void editedItemIsDisplayed() throws Throwable {
        AdvanceSearch_Module.displayed_EditToAssign();
    }

    @Then("^User search QA item criteria$")
    public void userSearchQAItemCriteria() throws Throwable {
        AdvanceSearch_Module.search_ItemCriteria();
        AdvanceSearch_Module.search_QAItemCriteria();
    }

    @And("^User edit to Review Item$")
    public void userEditToReviewItem() throws Throwable {
        AdvanceSearch_Module.pick_StockCode();
        AdvanceSearch_Module.editToReview_StockCode();
    }

    @When("^User check Reviewed item$")
    public void userCheckReviewedItem() throws Throwable {
        HomePage_Module.access_AdvanceSearchMenu();
        AdvanceSearch_Module.search_EditToReview();
    }

    @Then("^Reviewed item is displayed$")
    public void reviewedItemIsDisplayed() throws Throwable {
        AdvanceSearch_Module.displayed_EditToReview();
    }
}
