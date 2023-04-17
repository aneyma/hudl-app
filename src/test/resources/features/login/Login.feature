Feature: Hudl login test

#  As a user
#  When I enter correct credentials on login page
#  Then I should be able to successfully login


  Scenario: Successful Login
    Given the login page displays successfully
    When I enter my correct credentials
    And click login button
    Then I should be logged in successfully

  Scenario: Unsuccessful Login
    Given the login page displays successfully
    When I enter my incorrect credentials
    And click login button
    Then I should be alerted with an error message


  Scenario: Login attempt with blank email input
    Given the login page displays successfully
    When I enter only password and blank email
    And click login button
    Then I should be alerted with an error message

  Scenario: Login attempt with blank password input
    Given the login page displays successfully
    When I enter only email and blank password
    And click login button
    Then I should be alerted with an error message

  Scenario: Verify the need help link in case of login trouble
    Given the login page displays successfully
    When I click on need help link
    Then I should be prompted to enter the email to reset password
    And I should see the check email message

