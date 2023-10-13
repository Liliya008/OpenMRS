Feature:  OpenMRS Patient Creation
  Scenario: Create a Patient (Positive)
    Given User has OpenMRS endpoint
    When User sending POST request
    Then User provide the identifier '', identifier type '', location '' and person ''
    And User get statusCode 201
