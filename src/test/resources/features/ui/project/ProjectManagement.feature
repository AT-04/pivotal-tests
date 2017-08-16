Feature: Project Management

  Background:
    Given a POST request to "/projects" with the following data
      | name | ProjectToManage |
    And the status code should be 200
    And stored as [ProjectToManage]
    And the user go to Dashboard

  @DeleteProject
  Scenario: The user can delete an existing project
    When the user enters to "[ProjectToManage.name]" settings page
    And delete the Project
    Then message "[ProjectToManage.name] was successfully deleted." should appear
    And the "[ProjectToManage.name]" is not displayed in Dashboard

  @DeleteProject
  Scenario: The user can modify the name an existing project
    When the user enters to "[ProjectToManage.name]" settings page
    And modify the name to "ProjectModified"
    Then message "Changes saved." should appear in settings page
    And the user go to Dashboard
    Then "[ProjectToManage.name]" is not displayed in Dashboard
    And the new name is displayed in Dashboard