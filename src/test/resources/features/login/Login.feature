Feature: Hudl login test

  As a user
  When I enter correct credentials on login page
  Then I should be able to successfully login


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

#Additional test cases to test.
#
#    1. Verify when the login page opens up, the cursor is on the email input field.
#    2. Verify the password is masked form when typed into password field.
#    3. Verify accessibility of the site by using tab to navigate to different elements in the field.
#    4. Verify the user is able to log in by providing valid credentials and then pressing 'Enter' key.
#    5. Verify the 'Remember me' checkbox.
#    6. Verify the sign up link from login page.
#    7. Verify the 'Login with an Organization' link in the login page.
#    8. Verify the character limit in the input fields and the relevant error message is displayed.


#  Improvements to make in the tests:
#
#    1. Use 'Example' table in feature to input different variations of Username and password.
#    2. Remove username and password hardcoding and pass it from feature file or csv as arguments.