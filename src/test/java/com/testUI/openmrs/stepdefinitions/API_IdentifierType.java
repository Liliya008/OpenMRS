package com.testUI.openmrs.stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

public class API_IdentifierType {

private Response response;
    @Given("User has the endpoint")
    public void user_has_the_endpoint() {

        RestAssured.baseURI = "http://18.118.139.162/openmrs";
        RestAssured.basePath = "ws/rest/v1/patientidentifiertype";
    }
    @When("User sends GET request")
    public void user_sends_get_request() {
       response= RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON)
               .header("Authorization","Basic QWRtaW46QWRtaW4xMjM=")
               .when().get();
    }
    @Then("User get status code {int}")
    public void user_get_status_code(int expectedDtaCode) {
int actualSatusCode= response.statusCode();
        Assert.assertEquals(expectedDtaCode,actualSatusCode);

    }

}
