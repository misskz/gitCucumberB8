@regression
Feature: Feature: Testing Smart Order Functionality

  Scenario Outline: Happy Path Order
    Given User provides username,password and click loginButton
    When User clicks the Order Link from MainPage
    And User provides the '<Product>',<Quantity> for Product Information
    And User provides the '<CustomerName>','<Street>','<City>','<State>','<ZipCode>' for Address Information
    And User provides the '<cardType>','<cardNumber>','<expireDate>' for Payment Information
    Then User clicks process button and validates '<message>'
    And User clicks view all orders Link from MainPage
    And User validates all information '<CustomerName>','<Product>','<Quantity>','<date>','<Street>','<City>','<State>','<ZipCode>','<cardType>','<cardNumber>','<expireDate>'
    Examples:
      | Product     | Quantity | CustomerName | Street   | City       | State | ZipCode | cardType         | cardNumber   | expireDate | message                                | date       |
      | MyMoney     | 4        | Ahmet        | 20545 St | DesPlaines | IL    | 606565  | Visa             | 345345345345 | 06/27      | New order has been successfully added. | 02/27/2025 |
      | ScreenSaver | 4        | Mehmet       | 20545 St | DesPlaines | IL    | 606565  | American Express | 345345345345 | 06/27      | New order has been successfully added. | 02/27/2025 |
      | FamilyAlbum | 4        | Mahmut       | 20545 St | DesPlaines | IL    | 606565  | MasterCard       | 345345345345 | 06/27      | New order has been successfully added. | 02/27/2025 |


  @regression
  Scenario: Happy Path Order 2
    Given User provides username,password and click loginButton
    When User clicks the Order Link from MainPage
    And User provides the Product Information
      | product  | ScreenSaver |
      | quantity | 4           |
    And User provides the Address Information
      | customerName | Ahmet      |
      | street       | 20545 st   |
      | city         | DesPlaines |
      | state        | IL         |
      | zipCode      | 606565     |
    And User provides the Payment Information
      | cardType   | American Express |
      | cardNumber | 345345345345     |
      | expireDate | 06/27            |
    Then User clicks process button and validates
      | New order has been successfully added. |