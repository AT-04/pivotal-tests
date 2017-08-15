Feature: Delete Project

  Background:
    Given a POST request to "/projects" with the following data
      | name | ProjectToDelete |
    And the status code should be 200
    And stored as [ProjectDel]
    And the user go to Dashboard

  @DeleteProject
  Scenario: The user can delete an existing project
    When the user enters to "[ProjectDel.name]" settings page
    And delete the Project
    Then message "[ProjectDel.name] was successfully deleted." should appear
    And the "[ProjectDel.name]" is not displayed in Dashboard
