Feature: test functionality for deleting existing patient on OpenMRS
  Background: steps for log in
    Given User provides username and password
    And User chooses location laboratory and clicks login button

    Scenario: delete an existing patient record
      Given User navigates to the Find Patient Record Page
      When User searches 'Jane Doe' in the search bar and select the patient for details
      And User navigates to General Action section and click Delete Patient
      And User enters the 'patient passed away' for deleting patient and confirm delete
      Then User validates if the patient info for 'Jane Doe' has been deleted from all patients record

