
Feature: Validating Unidentified Patient Creation in OpenMrs
  Background:
  Given User successfully logged in to the OpenMrs website

  Scenario: Positive scenario for Creation Unidentified Patient
    When  User clicks Register a patient options
    And User clicks Unidentified Patient checkbox
    And User choose gender 'Male', clicks Next button and clicks Confirm button
    Then User validate successful  Message 'This is a temporary record for an unidentified patient'

