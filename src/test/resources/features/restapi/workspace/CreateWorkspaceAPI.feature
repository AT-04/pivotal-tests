Feature: Create workspace with api

  Scenario: create a new workspace with rest api
    When a POST request to "/my/workspaces" with the following data
      | name | New Workspaces |
    And stored as [workspace]
    Then the status code should be 200
