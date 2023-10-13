package com.testUI.openmrs.stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class API_GetAvailableLocationStepDef {

private Response response ;
    @Given("User has endpoint")
    public void userHasEndpoint() {
        RestAssured.baseURI="http://18.118.139.162";
        RestAssured.basePath="openmrs/ws/rest/v1/location";

    }
    @When("User send the GET request to get all location")
    public void userSendTheGETRequestToGetAllLocation() {
       response=RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON)
               .header("Authorization","Basic QWRtaW46QWRtaW4xMjM=")
               .when().get();
    }
    @Then("The status code is {int}")
    public void theStatusCodeIs(int expectedStatusCode) {
        int actualStatusCode = response.statusCode();
        Assert.assertEquals(expectedStatusCode,actualStatusCode);
    }
    @Then("User validate pharmacy location {string}")
    public void userValidatePharmacyLocation(String expectedID) {
        Map<String,Object> parsedResponse = response.as(new TypeRef<Map<String, Object>>() {});
        List<Map<String,String>> results = (List<Map<String,String>>)parsedResponse.get("results");
        String actualID ;
        for(Map<String,String> map: results){
          if( map.get("display").contains("Pharmacy")){
              actualID=map.get("uuid");
              System.out.println(actualID);
              Assert.assertEquals(expectedID,actualID);
              break;
          }



        }
    }



}
