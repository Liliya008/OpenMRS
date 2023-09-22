package com.testUI.openmrs.stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class CreatingNewPatientStepDef {
    WebDriver driver = DriverHelper.getDriver();

    @When("User logged in, clicks register a patient button")
    public void userLoggedInClicksRegisterAPatientButton() {

    }
    @When("User enters {string}, {string} and clicks next button")
    public void userEntersAndClicksNextButton(String string, String string2) {

    }
    @When("User chooses his {string} and clicks next button")
    public void userChoosesHisAndClicksNextButton(String string) {

    }
    @When("User enters his {string},{string},{string} of birth and clicks next button")
    public void userEntersHisOfBirthAndClicksNextButton(String string, String string2, String string3) {

    }
    @When("User enters his {string} and clicks next button")
    public void userEntersHisAndClicksNextButton(String string) {

    }
    @When("User chooses his {string}, enter the {string} and clicks next button")
    public void userChoosesHisEnterTheAndClicksNextButton(String string, String string2) {

    }
    @When("User validate his {string},{string},{string},{string},{string},{string} is displayed and clicks confirm button")
    public void userValidateHisIsDisplayedAndClicksConfirmButton(String string, String string2, String string3, String string4, String string5, String string6) {

    }
    @When("User validate his {string} and {string} is displayed on his page")
    public void userValidateHisAndIsDisplayedOnHisPage(String string, String string2) {

    }
    @When("User clicks on home page and choose find patient record button")
    public void userClicksOnHomePageAndChooseFindPatientRecordButton() {

    }
    @Then("User enter his {string} in search bar and validate his {string} is unique")
    public void userEnterHisInSearchBarAndValidateHisIsUnique(String string, String string2) {

    }

}
