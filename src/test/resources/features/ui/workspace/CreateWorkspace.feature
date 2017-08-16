Feature: Create Workspace

  @DeleteWorkspace
  Scenario: The user can create a workspace with default setting successfully
    Given the user go to Dashboard
    And The user click on the workspace
    And the user click on the new workspace button
    When the user create a new workspace with the following parameters
      | Name | My New Workspace |
    And click on the save button
    Then New workspace name is displayed in the workspace main page
    And Go to Dashboard workspace
    Then New workspace name is displayed in the dashboard workspace


  Scenario: Verify if the user can't created a new workspace with the field empty name
    Given the user go to Dashboard
    When The user click on the workspace
    And the user click on the new workspace button
    When the user create a new workspace with the following parameters
      | Name |  |
    And click on the save button
    Then Verify that message error "Workspace name can't be blank."
