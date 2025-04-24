Feature: Testing Login Functionality

  Scenario: Testing happy Path Login (correct Username + correct Password)
    When User provides username 'guest1@microworks.com' and password 'Guest1!'
    And User selects Remember Me CheckBox and Clicks Login Button
    Then User validates the title 'ORDER DETAILS - Weborder'

  Scenario Outline: Testing Negative Login
    When User provides username '<username>' and password '<password>'
    And User selects Remember Me CheckBox and Clicks Login Button
    Then User validates the '<message>' from Login Page

    Examples:
      | username              | password | message        |
      | guest1@microworks.com | guest1   | Sign in Failed |
      | ainur@microworks.com  | Guest1   | Sign in Failed |
      |                       |          | Sign in Failed |


#Task 1:
#1- Navigate to the website "https://demo.weborder.net" (HOOK CLASS AND CONFIGREADER)
#2-Provide username and password (you might clear it) --> guest1@microworks.com. and password : Guest1!
#3-Validate the title which is ORDER DETAILS - Weborder


#  Homework
  #Task 2:
#  1-Create 3 more scenarios of negative Login testing
#     --> Correct Username  + Wrong Password
#     --> Wrong username + Correct Password
#     -->Both box are empty
#
#     --> Sign in Failed (Validate this message)

  #TASK 3
#  1- login successfully
#  2-validate the title is ORDER DETAILS - Weborder
#  3-Click group order box and next button
#  4-sends the word I love Cucumber on the Invitees section
#  5-sends the email address ahmet@gmail.cm and mehmet@gmail.com to invite List
#  6-choose delivery address My House and validate the address 3137 Laguna contains
#  7-click create Group Order Button
#  8-validate the header is View Group Order
#  9-validate the word contains Your group order is now pending from description

  #Task 4
#  1- login successfully
#  2-validate the title is ORDER DETAILS - Weborder
#  3-Click group order box and next button
#  4-sends the word I love Cucumber on the Invitees section
#  5-sends the email address ahmet@gmail.cm and mehmet@gmail.com to invite List
#  6-choose delivery address Office and validate the address 2012 EMPIRE BLVD contains
#  7-click create Group Order Button
#  8-validate the header is View Group Order
#  9-validate the word contains Your group order is now pending from description
#
#  NOTE:Think about Background keyword