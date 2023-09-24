@regression
Feature: Start Visit Functionality
  Background:Login to the website same step
    When User provides username and password
    And User chooses location laboratory and clicks login button

    Scenario:Verifies the functionality of a patient visit
      When User clicks find patient record Icon
      Then User search patient name 'said souma' and ID '100JNX' clicks it
      And User validate patient first name 'said', family name 'souma' and ID '100JNX'
      Then User clicks on 'Start Visit' from the list and click confirm button
      And User hoverOver at Actions button and clicks Add Past Visit
      Then User choose the start date  year '2023', month 'May' and date '3' August click confirm button
      And User validating add past date '03.May.2023' and click end visit 'End Visit'




