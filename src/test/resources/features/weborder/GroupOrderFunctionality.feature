Feature: Testing Group Order Functionality for WebOrder

  Background: Repetitive Steps for My House and Office
    Given User provides username and password to the Login Page
    When User selects Remember Me CheckBox and Clicks Login Button
    And User validates the title 'ORDER DETAILS - Weborder'
    And User clicks Group Order Box and Next Button
    And User sends the word 'I love Cucumber' for note tp the Invitees Section
    And User sends email address which are 'ainur@gmail.com' and 'dana@gmail.com' to the Invite List

  Scenario: Happy Path Group Order for My House
    And User chooses delivery address 'My House' and validates the address '3137 Laguna'
    And User clicks Group Order Button
    Then User validates the header is 'View Group Order'
    And User validates the description contains 'Your group order is now pending'

  Scenario: Happy Path Group Order for Office
    And User chooses delivery address 'Office' and validates the address '2012 EMPIRE BLVD'
    And User clicks Group Order Button
    Then User validates the header is 'View Group Order'
    And User validates the description contains 'Your group order is now pending'