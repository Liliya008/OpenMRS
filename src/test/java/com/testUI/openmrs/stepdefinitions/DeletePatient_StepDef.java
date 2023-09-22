package com.testUI.openmrs.stepdefinitions;

import com.testUI.openmrs.pages.FindPatientPage;
import com.testUI.openmrs.pages.MainPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class DeletePatient_StepDef {
    WebDriver driver= DriverHelper.getDriver();
    MainPage mainPage=new MainPage(driver);
    FindPatientPage findPatientPage=new FindPatientPage(driver);

    @Given("User navigates to the Find Patient Record Page")
    public void user_navigates_to_the_find_patient_record_page() {
     mainPage.clickFindPatientRecord();
    }


    @When("User searches {string} in the search bar and select the patient for details")
    public void user_searches_in_the_search_bar_and_select_the_patient_for_details(String patientName) throws InterruptedException {
        findPatientPage.searchPatient(patientName);
        findPatientPage.selectPatient(patientName);
    }
    @Then("User navigates to General Action section and click Delete Patient")
    public void user_navigates_to_general_action_section_and_click_delete_patient() {
    findPatientPage.clickDeletePatientButton();
    }

    @When("User enters the {string} for deleting patient and confirm delete")
    public void user_enters_the_for_deleting_patient_and_confirm_delete(String reason) {
       findPatientPage.deleteReason(reason);
       findPatientPage.clickDeleteConfirmButton();
    }
    @Then("User validates if the patient info for {string} has been deleted from all patients record")
    public void user_validates_if_the_patient_info_for_has_been_deleted_from_all_patients_record(String patientName) {
        findPatientPage.validateDeletePatientRecord(patientName);
    }

}
