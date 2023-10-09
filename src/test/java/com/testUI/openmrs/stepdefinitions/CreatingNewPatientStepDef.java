package com.testUI.openmrs.stepdefinitions;

import com.testUI.openmrs.pages.HomePage;
import com.testUI.openmrs.pages.LoginPage;
import com.testUI.openmrs.pages.PatientPage;
import com.testUI.openmrs.pages.RegisterPatientPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class CreatingNewPatientStepDef {
    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    RegisterPatientPage registerPatientPage = new RegisterPatientPage(driver);
    PatientPage patientPage = new PatientPage(driver);

    @When("User logged in, clicks register a patient button")
    public void userLoggedInClicksRegisterAPatientButton() {
        loginPage.provideCredentials(ConfigReader.readProperty("QA_UserName"),ConfigReader.readProperty("QA_Password"));
        loginPage.login();
        homePage.chooseRegisterPatient();
    }
    @When("User enters {string}, {string} and clicks next button")
    public void userEntersAndClicksNextButton(String firstName, String lastName) {
        registerPatientPage.enterFullNamePatient(firstName,lastName);
        registerPatientPage.clickNextButton();
    }
    @When("User chooses his {string} and clicks next button")
    public void userChoosesHisAndClicksNextButton(String gender) {
        registerPatientPage.chooseGender(gender);
        registerPatientPage.clickNextButton();

    }
    @When("User enters his {string},{string},{string} of birth and clicks next button")
    public void userEntersHisOfBirthAndClicksNextButton(String day, String month, String year) {
        registerPatientPage.enterDateOfBirth(day,month,year);
        registerPatientPage.clickNextButton();
    }
    @When("User enters his {string} and clicks next button")
    public void userEntersHisAndClicksNextButton(String address) {
        registerPatientPage.addressInput(address);
        registerPatientPage.phoneNumberInput("608-223-23-234");

    }
    @When("User chooses his {string}, enter the {string} and clicks next button")
    public void userChoosesHisEnterTheAndClicksNextButton(WebDriver driver,String relationship, String nameRelationship) throws InterruptedException {
        registerPatientPage.selectRelationship(driver,relationship,nameRelationship);

    }
    @When("User validate his {string},{string},{string},{string},{string},{string} is displayed and clicks confirm button")
    public void userValidateHisIsDisplayedAndClicksConfirmButton(String fullName, String gender, String birthday, String address, String phoneNumber, String relatives) throws InterruptedException {
       registerPatientPage.verificationOfEnteredInfo(fullName, gender, birthday, address, phoneNumber, relatives);
       registerPatientPage.clickConfirmButton();
    }
    @When("User validate his {string} and {string} is displayed on his page")
    public void userValidateHisAndIsDisplayedOnHisPage(String firstName, String lastName) {
        patientPage.verifyingPatientInfoDisplayed();


    }
    @When("User clicks on home page and choose find patient record button")
    public void userClicksOnHomePageAndChooseFindPatientRecordButton() {
        patientPage.clickHomePage();
    }
    @Then("User enter his {string} in search bar and validate his id is unique")
    public void userEnterHisInSearchBarAndValidateHisIdIsUnique(String string) {

    }

}
