Feature: Delete Story

  Background:
    Given a POST request to "/projects" with the following data
      | name | ProjectManage |
    And the status code should be 200
    And stored as [Project]
    And a POST request to "/projects/[Project.id]/stories" with:
      | name | MyStoryApi |
    And the status code should be 200
    And stored as [Story]
    And the user go to Dashboard

  @DeleteProject
  Scenario: The user can delete an existing story
    When the user enters to "[Project.name]" project page
    And the user enters to "[Story.name]" story page
    And And delete the Story
    Then the "[Story.name]" is not displayed in Project Page
