Feature: Create workspace with api

  @DeleteWorkspace
  Scenario: create a new workspace with rest api
    When a POST request to "/my/workspaces" with the following data
      | name | MyWorkspacesCreate |
    And stored as [Workspace]
    Then the status code should be 200
