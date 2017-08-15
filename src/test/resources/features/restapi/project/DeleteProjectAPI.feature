Feature: Delete Project using REST API

  Background:
    Given a POST request to "/projects" with the following data
      | name | ProjectToDeleteAPI |
    And the status code should be 200
    And stored as [ProjectDelAPI]

  @DeleteProject
  Scenario: An existing Project can be deleted using REST API
    When a DELETE request to "/projects/[projectDelAPI.id]"
    Then the status code should be 204
