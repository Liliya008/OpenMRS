@regression
Feature: Testing creating new Patient
  Scenario: Creating new patient ID
    Given The user has endpoint
    When The user send a get request
    Then The status code is 200
    And The user got ID
  Scenario: Creating new patient
    Given The user has endpoint to create a patient
    When The user send post request with authorization and request body
    Then The user got is 201 status code