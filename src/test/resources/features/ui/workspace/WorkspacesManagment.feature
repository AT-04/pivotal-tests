Feature: Update and Delete Workspace

  Background: create a workspace
    When a POST request to "/my/workspaces" with the following data
      | name | My Workspace |
    Then the status code should be 200
    And stored as [WorkspaceToManage]
    And the user go to Dashboard


  Scenario: Delete A RequestWorkspace
    When the user enter to "[WorkspaceToManage.name]" workspace setting page
    And delete link
    And Confirm delete
    Then message "[WorkspaceToManage.name] was successfully deleted." should displayed
    And Go to Dashboard workspace
    And verify that "[WorkspaceToManage.name]" isn't displayed in the dashboard

  @DeleteWorkspace
  Scenario: Update a RequestWorkspace
    When the user enter to "[WorkspaceToManage.name]" workspace setting page
    And modify the name workspace to "Workspace Modified"
    And save change
    And the user go to Dashboard
    And Go to Dashboard workspace
    Then workspace name should be displayed "Workspace Modified"

  @DeleteWorkspace
  Scenario: The user can't create a workspace with name already exist
    When The user click on the workspace
    And the user click on the new workspace button
    When the user create a new workspace with the following parameters
      | Name | My Workspace |
    And click on the save button
    Then Verify that message error workspace "The workspace name you entered is already taken."
