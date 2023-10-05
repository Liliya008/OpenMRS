package utils;

public class PayloadUtils {

    public static String getPersonPayload(String givenName, String familyName,
                                          String birthday, String address, String city, String country){
        String personPayload = "{\n" +
                "\n" +
                "    \"names\": [\n" +
                "\n" +
                "        {\n" +
                "\n" +
                "        \"givenName\": \""+givenName+"\",\n" +
                "\n" +
                "        \"familyName\": \""+familyName+"\"\n" +
                "\n" +
                "        }\n" +
                "\n" +
                "    ],\n" +
                "\n" +
                "    \"gender\": \"M\",\n" +
                "\n" +
                "    \"birthdate\": \""+birthday+"\",\n" +
                "\n" +
                "    \"addresses\": [\n" +
                "\n" +
                "        {\n" +
                "\n" +
                "        \"address1\": \""+address+"\",\n" +
                "\n" +
                "        \"cityVillage\": \""+city+"\",\n" +
                "\n" +
                "        \"country\": \""+country+"\",\n" +
                "\n" +
                "        \"postalCode\": \"89003\"\n" +
                "\n" +
                "        }\n" +
                "\n" +
                "    ]\n" +
                "\n" +
                "}";
        return personPayload;
    }
}
