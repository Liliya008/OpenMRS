package utils;

import com.github.javafaker.Faker;
import com.testUI.openmrs.api.pojo.OpenMRSPojo;
import com.testUI.openmrs.stepdefinitions.API_CreatePatientID;
import com.testUI.openmrs.stepdefinitions.API_creatingPerson;

public class PayloadUtils {

    public static String getPersonPayload() {
        Faker name = new Faker();

        String personPayload = "{\n" +
                "\n" +
                "    \"names\": [\n" +
                "\n" +
                "        {\n" +
                "\n" +
                "        \"givenName\": \"" + name.name().firstName() + "\",\n" +
                "\n" +
                "        \"familyName\": \"" + name.name().lastName() + "\"\n" +
                "\n" +
                "        }\n" +
                "\n" +
                "    ],\n" +
                "\n" +
                "    \"gender\": \"M\",\n" +
                "\n" +
                "    \"birthdate\": \"1997-06-02\",\n" +
                "\n" +
                "    \"addresses\": [\n" +
                "\n" +
                "        {\n" +
                "\n" +
                "        \"address1\": \"1 Kiev\",\n" +
                "\n" +
                "        \"cityVillage\": \"" + name.address().city() + "\",\n" +
                "\n" +
                "        \"country\": \"USA\",\n" +
                "\n" +
                "        \"postalCode\": \"" + name.address().zipCode() + "\"\n" +
                "\n" +
                "        }\n" +
                "\n" +
                "    ]\n" +
                "\n" +
                "}";
        return personPayload;
    }

    public static String getPersonPayloadNegative() {

        Faker name = new Faker();

        String personPayloadNegative = "{\n" +
                "\n" +
                "    \"names\": [\n" +
                "\n" +
                "        {\n" +
                "\n" +
                "        \"givenName\": \"\",\n" +
                "\n" +
                "        \"familyName\": \"" + name.name().lastName() + "\"\n" +
                "\n" +
                "        }\n" +
                "\n" +
                "    ],\n" +
                "\n" +
                "    \"gender\": \"M\",\n" +
                "\n" +
                "    \"birthdate\": \"1997-06-02\",\n" +
                "\n" +
                "    \"addresses\": [\n" +
                "\n" +
                "        {\n" +
                "\n" +
                "        \"address1\": \"1 Kiev\",\n" +
                "\n" +
                "        \"cityVillage\": \"" + name.address().city() + "\",\n" +
                "\n" +
                "        \"country\": \"USA\",\n" +
                "\n" +
                "        \"postalCode\": \"" + name.address().zipCode() + "\"\n" +
                "\n" +
                "        }\n" +
                "\n" +
                "    ]\n" +
                "\n" +
                "}";
        return personPayloadNegative;
    }
    public static String getPatientPayload() {
        API_CreatePatientID api_createPatientID = new API_CreatePatientID();
        OpenMRSPojo openMRSPojo = new OpenMRSPojo();


        String patientPayload = "{\n" +
                "\"identifiers\":[\n" +
                "    {\n" +
                "     \"identifier\":\""+api_createPatientID.getId()+"\",\n" +
                "     \"identifierType\":\"05a29f94-c0ed-11e2-94be-8c13b969e334\",\n" +
                "     \"location\":\"7f65d926-57d6-4402-ae10-a5b3bcbf7986\",\n" +
                "     \"preferred\":true\n" +
                "    }],\n" +
                "\"person\":\""+openMRSPojo.getUuid()+"\"\n" +
                "}";
        return patientPayload;
    }
}
