@smoke
Feature: Testing feature of finding location

  Scenario: Find available location
    Given User has endpoint
    When User send the GET request to get all location
    Then The status code is 200
    And User validate pharmacy location '7f65d926-57d6-4402-ae10-a5b3bcbf7986'