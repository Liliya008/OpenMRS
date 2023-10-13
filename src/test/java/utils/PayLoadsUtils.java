package utils;

public class PayLoadsUtils {

        public static String newPersonPayLoad(String firstName, String lastName, String gender, String birthDay, String address, String city, String country, String zipCode, String zip){
            String newPersonPayLoad = "{\n" +
                    "\n" +
                    "    \"names\": [\n" +
                    "\n" +
                    "        {\n" +
                    "\n" +
                    "        \"givenName\": \""+firstName+"\",\n" +
                    "\n" +
                    "        \"familyName\": \""+lastName+"\"\n" +
                    "\n" +
                    "        }\n" +
                    "\n" +
                    "    ],\n" +
                    "\n" +
                    "    \"gender\": \""+gender+"\",\n" +
                    "\n" +
                    "    \"birthdate\": \""+birthDay+"\",\n" +
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
                    "        \"postalCode\": \""+zipCode+"\"\n" +
                    "\n" +
                    "        }\n" +
                    "\n" +
                    "    ]\n" +
                    "\n" +
                    "}";
            return newPersonPayLoad;
        }

    public static String postPatientPayload(String person_ID,String id,String idType,String location){

        String payload="{\n" +
                " \n" +
                "    \"identifiers\": [\n" +
                "        {\n" +
                "          \"identifier\":\""+id+"\", \n" +
                "          \"identifierType\":\""+idType+"\", \n" +
                "          \"location\":\""+location+"\",\n" +
                "          \"preferred\":true\n" +
                "        } ],\n" +
                "    \"person\":\""+person_ID+"\"\n" +
                " \n" +
                "}";

        return payload;
    }
    }
