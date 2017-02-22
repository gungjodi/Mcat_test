package mcat.StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mcat.modules.HomePage_Module;
import mcat.modules.LoadDictionaryData_Module;
import mcat.utility.ActionKeywords;

/**
 * Created by Agung_P1706 on 10/02/2017.
 */
public class BLoadDictionaryData_Steps {
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
}
