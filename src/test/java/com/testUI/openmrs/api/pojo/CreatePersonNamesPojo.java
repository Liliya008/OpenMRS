package com.testUI.openmrs.api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatePersonNamesPojo {

private String names;
    private String givenName;
    private String familyName;
}
