package com.testUI.openmrs.stepdefinitions;

import com.testUI.openmrs.pages.HomePage;
import com.testUI.openmrs.pages.PatientPage;
import com.testUI.openmrs.pages.PatientRecordPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverHelper;

public class AddPastVisitStepDef {

    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);
    PatientRecordPage patientRecordPage = new PatientRecordPage(driver);
    PatientPage patientPage = new PatientPage(driver);
    @When("User clicks find patient record Icon")
    public void userClicksFindPatientRecordIcon() {
       homePage.findPatientButton();
    }
    @Then("User search patient name {string} and ID {string} clicks it")
    public void userSearchPatientNameAndIDClicksIt(String name, String id) {
      patientRecordPage.nameInput(name);
      patientRecordPage.clickById(id);
      //patientRecordPage.clickId();
    }
    @Then("User validate patient first name {string}, family name {string} and ID {string}")
    public void userValidatePatientFirstNameFamilyNameAndID(String firstName, String lastName, String id) {
        Assert.assertEquals(firstName,patientPage.validateFirstName());
        Assert.assertEquals(lastName,patientPage.validateLastName());
        patientPage.validateId(id);
    }
    @Then("User clicks on {string} from the list and click confirm button")
    public void userClicksOnStartVisitFromTheListAndClickConfirmButton(String startVisit)  {
     patientPage.clickStartVisit(startVisit,driver);
    }
    @Then("User hoverOver at Actions button and clicks Add Past Visit")
    public void userHoverOverAtActionsButtonAndClicksAddPastVisit() throws InterruptedException {
       patientPage.hoverOverActionsList(driver);
       patientPage.clickAddPartVisit();
    }
    @Then("User choose the start date  year {string}, month {string} and date {string} August click confirm button")
    public void userChooseTheStartDateYearMonthJanAndDateAugustClickConfirmButton(String year, String month ,String day ) throws InterruptedException {
        patientPage.clickTimeStampTable(year,month,day);
    }
    @And("User validating add past date {string} and click end visit {string}")
    public void userValidatingAddPastDateAugAndClickEndVisitEndVisit(String startDate, String endVisit) {
        patientPage.validateStartDate(driver,startDate);
        patientPage.clickEndVisit(endVisit);
    }



}
