@Tasks
Feature: Task
  As user, I want to be able to create a task

  Background: Login
    Given user is on the login page
    When user enter email_address and clicks next
    Then verify user can see password field
    When user enter password and click login
    Then verify user lands on Project Page

  Scenario: Create a task
    Given user is on the tasks page in a project
    When User click on new task button
    When enters a task title
    And user clicks ok
    And user selects a priority
    Then user verifies a task is created under the selected priority column in the tasks page
