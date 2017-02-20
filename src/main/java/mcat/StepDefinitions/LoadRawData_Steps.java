package mcat.StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mcat.modules.HomePage_Module;
import mcat.modules.LoadRawData_Module;
import mcat.modules.LoginModule;
import mcat.modules.RawDataItem_Module;
import mcat.pageObjects.BaseClass;
import mcat.utility.ActionKeywords;
import mcat.utility.Constant;
import org.openqa.selenium.WebDriver;

/**
 * Created by Agung_P1706 on 09/02/2017.
 */
public class LoadRawData_Steps {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

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

}
