@SignUp
Feature: SignUp
  As user, I want to be able to sign up to Fieldwire

  Scenario: Sign up to Fieldwire
    Given user is on the signUp page
    When User enter following information first name ,last name, work email and Password
    And click on Accept Agreement radio button
    And Click on Create account
    And User enter following information company name, company type, number of employees and phone number
    And click on complete button
    Then verify user is logged in and see project page
