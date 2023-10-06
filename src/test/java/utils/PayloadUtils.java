package utils;

import com.github.javafaker.Faker;

public class PayloadUtils {

    public static String getPersonPayload( ){
        Faker name = new Faker();

        String personPayload ="{\n" +
                "\n" +
                "    \"names\": [\n" +
                "\n" +
                "        {\n" +
                "\n" +
                "        \"givenName\": \""+name.name().firstName()+"\",\n" +
                "\n" +
                "        \"familyName\": \""+name.name().lastName()+"\"\n" +
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
                "        \"cityVillage\": \""+name.address().city()+"\",\n" +
                "\n" +
                "        \"country\": \"USA\",\n" +
                "\n" +
                "        \"postalCode\": \""+name.address().zipCode()+"\"\n" +
                "\n" +
                "        }\n" +
                "\n" +
                "    ]\n" +
                "\n" +
                "}";
        return personPayload;
    }
}
