@regression
  Feature: OpenMrs identifier type
    Scenario: create identifier type
      Given User has the endpoint
      When User sends GET request
      Then User get status code 200
