
Feature: Testing Login Functionality for OpenMrs
  Scenario: Positive scenario with valid credentials
    When User provides username and password
    And User chooses location laboratory and clicks login button
    Then User successfully navigates to main page and gets 'Home'

    Scenario Outline: Negative scenario with invalid credentials
      When User provides '<username>' and '<password>'
      And User chooses location laboratory and clicks login button
      Then User gets a error message 'Invalid username/password. Please try again.'

      Examples:
        | username      | password      |
        | admin         | wrongPassword |
        | wrongUserName | Admin123      |
        | wrongUserName | wrongPassword |





