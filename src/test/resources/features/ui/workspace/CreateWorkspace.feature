Feature: Create Workspace
  Background:
    Given goes to dashboard
    And  goes to workspace tab
    And clicks on the new workspace button

  @DeleteSingleWorkspace
  Scenario: The user can create a workspace with default setting successfully
    When sets workspace with
      | Name | My New Workspace |
    Then New workspace name is displayed in the workspace main page
    And goes to dashboard
    And goes to workspace tab
    Then workspace is displayed in the dashboard

  Scenario: Verify if the user can't created a new workspace with the field empty name
    When sets workspace with
      | Name |  |
    Then Verify that message error "Workspace name can't be blank."
