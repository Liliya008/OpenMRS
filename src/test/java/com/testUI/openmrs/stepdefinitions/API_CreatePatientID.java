package com.testUI.openmrs.stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class API_CreatePatientID {
    private Response response;
    @Given("The user has endpoint")
    public void theUserHasEndpoint() {
        RestAssured.baseURI = "http://18.118.139.162";
        RestAssured.basePath="openmrs/module/idgen/generateIdentifier.form?source=1&username=admin&password=Admin123";
    }
    @When("The user send a get request")
    public void theUserSendAGetRequest() {
        response = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .queryParam("source",1).queryParam("username","admin")
                .queryParam("password","Admin123").header("Authorization","Basic QWRtaW46QWRtaW4xMjM=")
                .when().get();
    }
    @Then("The status code is {int}")
    public void theStatusCodeIs(int expectedStatusCode) {
        int actualStatusCode = response.statusCode();
        Assert.assertEquals(expectedStatusCode,actualStatusCode);

    }
    @Then("The user got {string}")
    public void theUserGot(String patientId) {
       Map<String,Object> parsedResponse = response.as(new TypeRef<Map<String,Object>>() {});
       List<String> identifiers = (List<String>) parsedResponse.get("identifiers");
       patientId = identifiers.get(0);
    }

}
