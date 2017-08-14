Feature: Delete Project

  Background:
    Given that POST request to "/projects" with the following data
      | name | ProjectToDelete |
    And stored as [ProjectDel]

  @Login @DeleteProject
  Scenario: The user can delete an existing project
    Given the user go to Dashboard
    When the user enters to "[ProjectDel.name]" settings page
    And delete the Project
    Then message "[ProjectDel.name] was successfully deleted." should appear
    And the "[ProjectDel.name]" is not displayed in Dashboard