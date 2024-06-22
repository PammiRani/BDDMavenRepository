Feature: Login Functionality

  Scenario: Login with valid credentials
    Given User navigates to login page
    When User enters valid email address "pammi12@gmail.com" into email field
    And User enters valid password "12345" into password field
    And User clicks on login button
    Then User should get successfully logged in

  Scenario: Login with invalid credentials
    Given User navigates to login page
    When User enters invalid email address into email field
    And User enters invalid password "123456" into password field
    And User clicks on login button
    Then User should get proper warning message about credentials mismatch

#  Scenario: Login with valid email and invalid password
    Given User navigates to login page
    When User enters valid email address "pammi12@gmail.com" into email field
    And User enters invalid password "123456" into password field
    And User clicks on login button
    Then User should get proper warning message about credentials mismatch

#  Scenario: Login with invalid email and valid password
    Given User navigates to login page
    When User enters invalid email address into email field
    And User enters valid password "12345" into password field
    And User clicks on login button
    Then User should get proper warning message about credentials mismatch

#  Scenario: Login without providing any credentials
    Given User navigates to login page
    When User don't enter email address into email field
    And User don't enter password into password field
    And User clicks on login button
    Then User should get proper warning message about credentials mismatch