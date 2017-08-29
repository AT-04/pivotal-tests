Feature: Workspace with a Project

  Background:
    Given a "POST" request to "/projects" with
      | name | ProjectForWorkspace |
    And the status code should be 200
    And stored as [ProjectForWorkspace]
    And goes to dashboard
    And goes to workspace tab
    And clicks on the new workspace button

  @DeleteSingleWorkspace @DeleteProject
  Scenario: The user can create a workspace
    When sets workspace with
      | Name | My New Workspace |
    And clicks on the add projects button
    And select the project with the name "ProjectForWorkspace"
    And clicks on the Save Workspace Changes button
    Then the workspace with a project is displayed in the workspace main page
    And goes to dashboard
    And goes to workspace tab
    Then workspace with a project is displayed in the dashboard
