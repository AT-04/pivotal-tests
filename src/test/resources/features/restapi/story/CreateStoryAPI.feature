@bvt
Feature: Create Story using REST API

  @DeleteProject
  Scenario: A Project can be created using REST API
    When a "POST" request to "/projects" with
      | name | MyProjectApi |
    And stored as [Project]
    Then the status code should be 200
    And a "POST" request to "/projects/[Project.id]/stories" with
      | name | MyStoryApi |
    Then the status code should be 200
    And a "POST" request to "/projects/[Project.id]/stories" with
      | name |    |
    Then the status code should be 400