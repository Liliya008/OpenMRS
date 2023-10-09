@regression
Feature: Testing Register new patient functionality

  Scenario Outline: Positive scenario for creating new patient
    When User logged in, clicks register a patient button
    And User enters '<givenName>', '<familyName>' and clicks next button
    And User chooses his '<gender>' and clicks next button
    And User enters his '<date>','<month>','<year>' of birth and clicks next button
    And User enters his '<address>' and clicks next button
    And User enters his '<phoneNumber>' and clicks next button
    And User chooses his '<relationshipType>', enter the '<name>' and clicks next button
    And User validate his '<fullName>','<gender>','<birthday>','<address>','<phoneNumber>','<relationshipType>' is displayed and clicks confirm button
    And User validate his '<givenName>' and '<familyName>' is displayed on his page
    And User clicks on home page and choose find patient record button
    Then User enter his '<fullName>' in search bar and validate his id is unique
    Examples:
      | givenName | familyName | gender | date | month | year | address     | phoneNumber | relationshipType | name | fullName       | birthday       |
      | Adam      | White      | Male   | 8    | May   | 1995 | 100 Main St | 12345       | Doctor           | John | Adam, White    | 8, May, 1995   |
      | Jessica   | Black      | Female | 15   | June  | 1999 | 100 Main St | 12325       | Parent           | Adam | Jessica, Black | 15, June, 1999 |



