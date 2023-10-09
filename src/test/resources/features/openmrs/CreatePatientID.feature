@smoke
Feature: Testing creating new Patient ID
  Scenario: Creating new patient ID
    Given The user has endpoint
    When The user send a get request
    Then The status code is 200
    And The user got 'ID'