@regression
Feature: Testing patient record functionality on OpenMRS website

  Background:  patient records
    Given User is successfully logged in with valid.
    And User navigates to the Find Patient Record button and clicks on it.

  Scenario: Validating registered patient information is visible on the page (happy path)

    Then User types his 'John' in the search bar.
    Then User validates '7' is on the list


  Scenario: Validating unregistered patient is not visible on the page (negative scenario)
    Then User types 'Tanya' in the search bar.
    Then User validates message "No matching records found " found is displayed








