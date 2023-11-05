@contact_list_datatables
Feature: User can open an account and add contacts

  Scenario: Open account and add contacts
    Given user navigates to "https://thinking-tester-contact-list.herokuapp.com/"
    When user clicks on sign up button
    And user enters firstname "John"
    And user enters lastname "Doe"
    And user enters email "john.123@doe.com"
    And user enters password "John.123"
    And user clicks on submit button

    Given click on add a new contact button and fill form and click submit
      | John      | Doe      | 2015-10-31 | john@doe.com   | 1234567890 | street1         | street2 | Long Island | stateProvince1 | 567        | USA     |
      | Mary      | Star     | 2015-10-31 | mary@gmail.com | 2345678900 | street istanbul | street2 | istanbul    | Besiktas       | 123        | Turkey  |
      | Mary      | Star     | 2015-10-31 | mary@gmail.com | 7896541230 | street istanbul | street2 | istanbul    | Besiktas       | 123        | Turkey  |
      | Mary      | Star     | 2015-10-31 | mary@gmail.com | 1597853624 | street istanbul | street2 | istanbul    | Besiktas       | 123        | Turkey  |
      | Mary      | Star     | 2015-10-31 | mary@gmail.com | 9517532684 | street istanbul | street2 | istanbul    | Besiktas       | 123        | Turkey  |