package com.testUI.openmrs.stepdefinitions;

import com.testUI.openmrs.pages.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginStepDef {
    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage=new LoginPage(driver);

    @When("User provides username and password")
    public void userProvidesAnd() {
       loginPage.provideCredentials(ConfigReader.readProperty("QA_UserName"),ConfigReader.readProperty("QA_Password"));
    }
    @When("User provides {string} and {string}")
    public void userProvidesAdminAndWrongPassword(String username,String password) {
       loginPage.provideCredentials(username,password);
    }
    @When("User chooses location laboratory and clicks login button")
    public void userChoosesLocationLaboratoryAndClicksLoginButton() {
        loginPage.login();
    }
    @Then("User successfully navigates to main page and gets {string}")
    public void userSuccessfullyNavigatesToMainPageAndGets(String title) {
        loginPage.validateTitle(driver,title);
    }
    @Then("User gets a error message {string}")
    public void userGetsAErrorMessage(String errorMessage) {
        loginPage.validateErrorMessage(errorMessage);
    }
}
