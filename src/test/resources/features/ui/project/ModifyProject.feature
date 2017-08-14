Feature: Modify Project

  Background:
    Given that POST request to "/projects" with the following data
      | name | ProjectToModify |
    And stored as [ProjectMod]

  @Login @DeleteProject
  Scenario: The user can modify the name an existing project
    Given the user go to Dashboard
    When the user enters to "[ProjectMod.name]" settings page
    And modify the name to "ProjectModified"
    Then message "Changes saved." should appear in settings page
    And the user go to Dashboard
    Then the old "[ProjectMod.name]" is not displayed in Dashboard
    And the new name is displayed in Dashboard