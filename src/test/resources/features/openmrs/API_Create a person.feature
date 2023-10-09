@regression
Feature: OpenMRS Person Creation

  Scenario:Creating a person (positive)
    Given user has OpenMRS endpoint
    When User is sending header and authorization and request body
    Then I should get the status code 201 and birthdate "1997-06-02"


  Scenario:Creating a person (negative)
    Given user has OpenMRS endpoint
    When User is sending header and authorization and request body without name
    Then User should get the status code 400
