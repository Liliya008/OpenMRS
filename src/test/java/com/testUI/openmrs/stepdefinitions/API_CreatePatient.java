package com.testUI.openmrs.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.PayloadUtils;

public class API_CreatePatient {
    private Response response;

    @Given("The user has endpoint to create a patient")
    public void theUserHasEndpointToCreateAPatient() {
        RestAssured.baseURI = "http://18.118.139.162";
        RestAssured.basePath="openmrs/ws/rest/v1/patient";

    }
    @When("The user send post request with authorization and request body")
    public void theUserSendPostRequestWithAuthorizationAndRequestBody() {
        response = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .header("Authorization", "Basic QWRtaW46QWRtaW4xMjM=")
                .body(PayloadUtils.getPatientPayload())
                .when().post();
    }
    @Then("The user got is {int} status code")
    public void theUserGotIsStatusCode(int expectedStatusCode) {
        int actualStatusCode = response.statusCode();
        Assert.assertEquals(expectedStatusCode,actualStatusCode);
    }
}
