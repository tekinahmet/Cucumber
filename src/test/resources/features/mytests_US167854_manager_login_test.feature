@manager_login_test
Feature: manager_login_test
  Scenario Outline: user should be able to login with manager credentials
    Given user is on home page
    When user navigates to the login page
    And enter "<email>"
    And enter "<password>"
    And click on login button
    Then verify the login is successful
    Examples: test_data
    | email                           |password |
    | sam.walker@bluerentalcars.com   |c!fas_art|
    | kate.brown@bluerentalcars.com   |tad1$Fas |
    | raj.khan@bluerentalcars.com     |v7Hg_va^ |
    | pam.raymond@bluerentalcars.com  |Nga^g6!  |