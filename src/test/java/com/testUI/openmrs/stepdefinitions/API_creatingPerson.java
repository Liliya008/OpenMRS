package com.testUI.openmrs.stepdefinitions;

import com.testUI.openmrs.pages.LoginPage;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;
import utils.PayloadUtils;

public class API_creatingPerson {

    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    Response response;

    @Given("user has OpenMRS endpoint")
    public void user_has_open_mrs_endpoint() {
        RestAssured.baseURI = "http://18.118.139.162/openmrs";
        RestAssured.basePath = "ws/rest/v1/person";
    }

    @When("User is sending header and authorization and request body")
    public void user_is_sending_header_and_authorization_and_request_body() {

        response = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .header("Authorization", "Basic QWRtaW46QWRtaW4xMjM=")
                .body(PayloadUtils.getPersonPayload())
                .when().post();


    }

    @Then("I should get the status code {int}")
    public void i_should_get_the_status_code(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode,response.statusCode());
    }
}
