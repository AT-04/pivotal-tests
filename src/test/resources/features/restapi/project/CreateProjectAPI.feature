Feature: Create Project using REST API

  @DeleteProject
  Scenario: A Project can be created using REST API
    When a POST request to "/projects" with the following data
      | name | CreateProjectAPI001 |
    Then the status code should be 200
