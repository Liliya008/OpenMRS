package com.testUI.openmrs.stepdefinitions;

import com.testUI.openmrs.pages.LoginPage;
import com.testUI.openmrs.pages.MainPage;
import com.testUI.openmrs.pages.PatientRecordPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class FindPatientRecord {
    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);
    PatientRecordPage patientRecordPage = new PatientRecordPage(driver);

    @Given("User is successfully logged in with valid.")
    public void user_is_successfully_logged_in_with_valid_and() {
        loginPage.provideCredentials(ConfigReader.readProperty("QA_UserName"), ConfigReader.readProperty("QA_Password"));
        loginPage.login();
    }

    @Given("User navigates to the Find Patient Record button and clicks on it.")
    public void userNavigatesToTheFindPatientRecordButtonAndClicksOnIt() {
        mainPage.findPatientButton();
    }

    @Then("User types his {string} in the search bar.")
    public void userTypesHisInTheSearchBar(String name) {
        patientRecordPage.nameInput(name);
    }


    @Then("User types {string} in the search bar.")
    public void userTypesInTheSearchBar(String name2) {
        patientRecordPage.nameInput(name2);
    }
    @Then("User validates {string} is on the list")
    public void userValidatesIsOnTheList(String amount) {
        patientRecordPage.amountValidation(driver,amount);

    }


    @Then("User validates message {string} found is displayed")
    public void user_validates_message_found_is_displayed(String massage) throws InterruptedException {
        patientRecordPage.messageValidation(driver,massage);
    }
}
