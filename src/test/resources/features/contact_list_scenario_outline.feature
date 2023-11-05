@contact_list_scenario_outline
Feature: User can open an account and add contacts

  Scenario: Open account
    Given user navigates to "https://thinking-tester-contact-list.herokuapp.com/"
    When user clicks on sign up button
    And user enters firstname "John"
    And user enters lastname "Doe"
    And user enters email "john.123@doe.com"
    And user enters password "John.123"
    And user clicks on submit button

  Scenario Outline: Add contacts
    Given click on add a new contact button
    When user enters firstName "<firstName>"
    And user enters lastName "<lastName>"
    And user enters birthdate "<birthdate>"
    And user enters email input "<email>"
    And user enters phone "<phone>"
    And user enters street1 "<street1>"
    And user enters street2 "<street2>"
    And user enters city "<city>"
    And user enters stateProvince "<stateProvince>"
    And user enters postalCode "<postalCode>"
    And user enters country "<country>"
    Then user clicks submit button

    Examples:
      | firstName | lastName | birthdate  | email          | phone | street1         | street2 | city        | stateProvince  | postalCode | country |
      | John      | Doe      | 2015-10-31 | john@doe.com   | 1234567890   | street1         | street2 | Long Island | stateProvince1 | 567        | USA     |
      | Mary      | Star     | 2015-10-31 | mary@gmail.com | 2345678900   | street istanbul | street2 | istanbul    | Besiktas       | 123        | Turkey  |
      | Mary      | Star     | 2015-10-31 | mary@gmail.com | 7896541230   | street istanbul | street2 | istanbul    | Besiktas       | 123        | Turkey  |
      | Mary      | Star     | 2015-10-31 | mary@gmail.com | 1597853624   | street istanbul | street2 | istanbul    | Besiktas       | 123        | Turkey  |
      | Mary      | Star     | 2015-10-31 | mary@gmail.com | 9517532684   | street istanbul | street2 | istanbul    | Besiktas       | 123        | Turkey  |