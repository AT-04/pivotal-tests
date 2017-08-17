Feature: Create Story

  Background:
    Given a POST request to "/projects" with
      | name | MyProject |
    And the status code should be 200
    And stored as [Project]
    And goes to dashboard
    And opens the project created as "[Project.name]"
    And clicks on the new story button

  @DeleteProject
  Scenario: The user can create a story with default settings successfully
    When sets story with
      | STORY_NAME | MyAutomatedStoryName |
    Then story is displayed in the project page

  @DeleteProject
  Scenario: The user can create a story with custom settings successfully
    When sets story with
      | STORY_NAME        | MyAutomatedStoryName   |
      | STORY_TYPE        | FEATURE                |
      | STORY_POINTS      | UN_ESTIMATE            |
      | STORY_BLOCKERS    | MyAutomatedBlockers    |
      | STORY_DESCRIPTION | MyAutomatedDescription |
      | STORY_LABEL       | MyAutomatedLabel       |
    Then story is displayed in the project page
