@regression
Feature: OpenMRS Person Creation

  Scenario:Creating a person (positive)
    Given user has OpenMRS endpoint
    When User is sending header and authorization and request body with  "Emma", "HelloWorld", "09-15-1993", "1 Main St",  "Madison", "USA"
    Then I should get the status code 201
