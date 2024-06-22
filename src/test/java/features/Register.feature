Feature: Registration functionality

  Scenario: User creates an account only with mandatory field
    Given User navigates to Register Account page
    When User enters the details into below fields
    |firstName    |  Pammi                 |
    |lastName     | Rani                   |
    |email        | pammirani12@gmail.com  |
    |telephone    | 123456678              |
    |password     | 12345                  |
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should get created successfully


  Scenario: User creates an account with all fields
    Given User navigates to Register Account page
    When User enters the details into below fields
      |firstName    |  Pammi                 |
      |lastName     | Rani                   |
      |email        | pammirani123@gmail.com  |
      |telephone    | 123456678              |
      |password     | 12345                  |
    And User selects "Yes" for Newsletter
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should get created successfully

  Scenario: User creates a duplicate account
    Given User navigates to Register Account page
    When User enters the details into below fields with duplicate email
      |firstName    |  Pammi                 |
      |lastName     | Rani                   |
      |email        | pammirani12@gmail.com  |
      |telephone    | 123456678              |
      |password     | 12345                  |
    And User selects "Yes" for Newsletter
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should get a proper warning about duplicate email

#  Scenario: User creates an account without filling any details
#    Given User navigates to Register Account page
#    When User don't enter any details into fields
#    And User clicks on Continue button
#    Then User should get proper warning message for every mandatory field

