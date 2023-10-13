package com.testUI.openmrs.stepdefinitions;

import com.testUI.openmrs.api.pojo.RegisterPatientAPI;
import io.cucumber.java.bs.A;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.internal.mapping.GsonMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import utils.PayloadUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class API_Create_PatientStepDef {


    @Test
    public void createPatient(){

//       // get id
//        RestAssured.baseURI = "http://18.118.139.162";
//        RestAssured.basePath="openmrs/module/idgen/generateIdentifier.form?source=1&username=admin&password=Admin123";
//        Response response = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON)
//                .queryParam("source",1).queryParam("username","admin")
//                .queryParam("password","Admin123").header("Authorization","Basic QWRtaW46QWRtaW4xMjM=")
//                .when().get()
//                .then().statusCode(200).extract().response();
//
//
//        JsonPath jsonPath = response.jsonPath();
//        List<String> getIdentifiers = jsonPath.getList("identifiers");
//        String identifiersID= String.join(", ", getIdentifiers);
//        System.out.println(identifiersID);
//
//        //create person
//        RestAssured.baseURI = "http://18.118.139.162/openmrs";
//        RestAssured.basePath = "ws/rest/v1/person";
//        Response response2 = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON)
//                .header("Authorization", "Basic QWRtaW46QWRtaW4xMjM=")
//                .body(PayloadUtils.getPersonPayload())
//                .when().log().body().post();


    }



@Test
    public void test(){
    RegisterPatientAPI registerPatientAPI=new RegisterPatientAPI();
    RestAssured.baseURI="http://codefish.ninja/openmrs";
    RestAssured.basePath="module/idgen/generateIdentifier.form";
    registerPatientAPI.getID();
    registerPatientAPI.validateStatusCode(200);

    RestAssured.baseURI="http://codefish.ninja/openmrs";
    RestAssured.basePath="ws/rest/v1/patientidentifiertype";
    registerPatientAPI.getIdType();
    registerPatientAPI.validateStatusCode(200);

    RestAssured.baseURI="http://codefish.ninja/openmrs";
    RestAssured.basePath="ws/rest/v1/location";
    registerPatientAPI.getLocation();
    registerPatientAPI.validateStatusCode(200);


    RestAssured.baseURI="http://codefish.ninja/openmrs";
    RestAssured.basePath="/ws/rest/v1/patient";
    registerPatientAPI.postPatient();

}



}
