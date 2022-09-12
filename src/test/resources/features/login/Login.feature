@Login
Feature: Login
  As user, I want to be able to sign up to Fieldwire
  Background:
    Given user is on the login page
@SmokeTest
  Scenario: Login as a Fieldwire user
    When user enter email_address and clicks next
    Then verify user can see password field
    When user enter password and click login
    Then verify user lands on Project Page

@negative_test
  Scenario Outline: Verify that warning message is displayed when email address or/and password invalid
    When user enter email address "<email_address>" and press Enter
    Then verify user can see password field
    When user enter password "<password>" and press Enter
    Then validate "Invalid email or password. Try signing up or resetting your password." error message is displayed on the page

    Examples: users
      | email_address             | password          |
      | incorrectemail1@gmail.com | correctPassword   |
      | correctEmail1@gmail.com   | incorrectPassword |
      | incorrectemail1@gmail.com | incorrectPassword |
