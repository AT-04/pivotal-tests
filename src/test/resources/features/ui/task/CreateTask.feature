#Feature: Create task
#
#  Background:
#    Given a POST request to "/projects" with
#      | name | ProjectManage |
#    And the status code should be 200
#    And stored as [Project]
#    When a POST request to "/projects/[Project.id]/stories" with
#      | name | MyStoryApi |
#    And the status code should be 200
#    And stored as [Story]
#    When goes to dashboard
#    And opens the project created as "[Project.name]"
#    And opens the story created as "[Story.name]"
#
#  @DeleteProject
#  Scenario: The user can create a task successfully
#    When sets task with
#      | DESCRIPTION | MyTaskDescription |
#    Then task is displayed in the story page
