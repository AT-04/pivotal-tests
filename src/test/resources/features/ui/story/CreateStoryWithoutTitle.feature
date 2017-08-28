@nega
Feature: Create Story Without Title

  Background:
    Given a "POST" request to "/projects" with
      | name | MyProject2 |
    And the status code should be 200
    And stored as [Project]
    And goes to dashboard
    And opens the project created as "[Project.name]"
    And clicks on the new story button

  @DeleteProject
  Scenario: The user can't create a story without title
    When sets story with
      | STORY_NAME        |    |
    Then validation error message should be displayed

