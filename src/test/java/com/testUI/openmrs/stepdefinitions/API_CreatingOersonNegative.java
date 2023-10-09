package com.testUI.openmrs.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;
import utils.PayloadUtils;

public class API_CreatingOersonNegative {
    WebDriver driver = DriverHelper.getDriver();
    Response response;

    @When("User is sending header and authorization and request body without name")
    public void user_is_sending_header_and_authorization_and_request_body_without_name() {
        RestAssured.baseURI = "http://18.118.139.162/openmrs";
        RestAssured.basePath = "ws/rest/v1/person";
        response = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .header("Authorization", "Basic QWRtaW46QWRtaW4xMjM=")
                .body(PayloadUtils.getPersonPayloadNegative())
                .when().post();
    }
    @Then("User should get the status code {int}")
    public void user_should_get_the_status_code(int expectedStatusCode ) {
        Assert.assertEquals(expectedStatusCode,response.statusCode());
    }

}
