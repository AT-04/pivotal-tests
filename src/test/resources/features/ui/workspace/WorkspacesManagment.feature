Feature: Update and Delete Workspace

  Background: create a workspace
    When a POST request to "/my/workspaces" with
      | name | My Workspace |
    Then the status code should be 200
    And stored as [WorkspaceToManage]
    And goes to dashboard
    And goes to workspace tab


  Scenario: The user can delete an existing workspace
    When opens the workspace settings created as "[WorkspaceToManage.name]"
    And delete the workspace
    Then message "[WorkspaceToManage.name] was successfully deleted." should displayed
    And goes to workspace tab
    Then the "[WorkspaceToManage.name]" is not displayed in the dashboard

  @DeleteWorkspace
  Scenario: The user can modify the name an existing workspace
    When opens the workspace settings created as "[WorkspaceToManage.name]"
    And modify the name workspace to "Workspace Modified"
    And goes to dashboard
    And goes to workspace tab
    Then workspace name should be displayed "Workspace Modified"

  @DeleteWorkspace
  Scenario: The user can't create a workspace with name already exist
    When clicks on the new workspace button
    And sets workspace with
      | Name | My Workspace |
    Then error message "The workspace name you entered is already taken." should be displayed
