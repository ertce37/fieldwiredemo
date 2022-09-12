@Project
Feature: Project
  As user, I want to be able to create a project

  Background: Login
    Given user is on the login page
    When user enter email_address and clicks next
    Then verify user can see password field
    When user enter password and click login
    Then verify user lands on Project Page

@SmokeTest
  Scenario: Create a project
    Given user is on the projects page
    When User click on new project button
    When User enters a Project name
    And clicks Create button
    Then user verifies a project is created in the projects page
