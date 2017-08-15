Feature: Modify Project

  Background:
    Given a POST request to "/projects" with the following data
      | name | ProjectToModify |
    And the status code should be 200
    And stored as [ProjectMod]
    And the user go to Dashboard

  @DeleteProject
  Scenario: The user can modify the name an existing project
    When the user enters to "[ProjectMod.name]" settings page
    And modify the name to "ProjectModified"
    Then message "Changes saved." should appear in settings page
    And the user go to Dashboard
    Then "[ProjectMod.name]" is not displayed in Dashboard
    And the new name is displayed in Dashboard
