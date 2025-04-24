#General description of the TestCase
Feature: Testing the Purchase Functionality
  #Test Case
  Background: Choosing departure and destination part
#    Given User navigates to the 'https://www.blazedemo.com/'
    When User chooses 'Boston' for departure
    And User chooses 'London' for destination and click Finding Flight Button

  Scenario: Validating finding flights functionality
#    Given User navigates to the 'https://www.blazedemo.com/'
#    When User chooses 'Boston' for departure
#    And User chooses 'London' for destination and click Finding Flight Button
    Then User validates the header 'Flights from Boston to London:'

  Scenario: Validating purchase ticket functionality
#    Given User navigates to the 'https://www.blazedemo.com/'
#    When User chooses 'Boston' for departure
#    And User chooses 'London' for destination and click Finding Flight Button
    And User clicks the first flight
    And User provides 'Ainur Alimjan', '10925 Bluffside Dr', 'Studio City', 'CA', '91604'
    And User provides card information 'American Express', '1234567812345678', '12', '2027', 'Ainur Alimjan'
    And User clicks remember me and Purchase Flight button
    Then User validates the purchase message 'Thank you for your purchase today!'
