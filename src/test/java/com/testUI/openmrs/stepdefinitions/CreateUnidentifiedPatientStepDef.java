package com.testUI.openmrs.stepdefinitions;

import com.testUI.openmrs.pages.HomePage;
import com.testUI.openmrs.pages.LoginPage;
import com.testUI.openmrs.pages.PatientPage;
import com.testUI.openmrs.pages.RegisterPatientPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class CreateUnidentifiedPatientStepDef {
    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    PatientPage patientPage =new PatientPage(driver);
    RegisterPatientPage registerPatientPage=new RegisterPatientPage(driver);
    @Given("User successfully logged in to the OpenMrs website")
    public void successfullyLoggedInToTheOpenMrsWebsite() {
        loginPage.provideCredentials(ConfigReader.readProperty("QA_UserName"),ConfigReader.readProperty("QA_Password"));
        loginPage.login();
    }

    @When("User clicks Register a patient options")
    public void userClicksRegisterAPatientOptions() {
homePage.chooseRegisterPatient();
    }


    @And("User clicks Unidentified Patient checkbox")
    public void userClicksUnidentifiedPatientCheckbox() {
registerPatientPage.clickUnidentifiedPatient();
    }
    @And("User choose gender {string}, clicks Next button and clicks Confirm button")
    public void userChooseGenderClicksNextButtonAndClicksConfirmButton(String gender) throws InterruptedException {
registerPatientPage.chooseGender(gender);
registerPatientPage.clickNextButton();
registerPatientPage.clickConfirmButton();
    }


}
