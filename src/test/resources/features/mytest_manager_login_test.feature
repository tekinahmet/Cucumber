@login_test
Feature: Manager Login Test
  Scenario Outline: user should be able to login with "<manager credentials>"
    Given user navigates to "https://bluerentalcars.com/"
    Then user click on the login page
    Then user enter email address "<email>"
    Then user enter password "<password>"
    And click on the login button
    Then verify the login is successful
    And close the application
    Examples: credentials
      | email                          | password  |
      | sam.walker@bluerentalcars.com  | c!fas_art |
      | raj.khan@bluerentalcars.com    | v7Hg_va^  |
      | pam.raymond@bluerentalcars.com | Nga^g6!   |
      | jack1@gmail.com                | 12345  |