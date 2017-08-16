Feature: Create Story

  Background:
    Given a POST request to "/projects" with the following data
      | name | MyProject |
    And the status code should be 200
    And stored as [Project]
    And the user go to Dashboard

  @DeleteProject
  Scenario: The user can create a story with default settings successfully
    Given the user go to Dashboard
    And the user enters to "[Project.name]" project page
    When the user create a new story with the following parameters
      | STORY_NAME | MyAutomatedStoryName |
    Then new story name is displayed in the project page

  @DeleteProject
  Scenario: The user can create a story with default settings successfully
    Given the user go to Dashboard
    And the user enters to "[Project.name]" project page
    When the user create a new story with the following parameters
      | STORY_NAME        | MyAutomatedStoryName   |
      | STORY_TYPE        | FEATURE                |
      | STORY_POINTS      | UN_ESTIMATE            |
      | STORY_BLOCKERS    | MyAutomatedBlockers    |
      | STORY_DESCRIPTION | MyAutomatedDescription |
      | STORY_LABEL       | MyAutomatedLabel       |
    Then new story name is displayed in the project page
