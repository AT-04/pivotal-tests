Feature: Create Project

  @DeleteSingleProject @DeleteAccount
  Scenario: The user can create a project with default settings successfully
    Given the user go to Dashboard
    And click on the new project button
    When the user create a new project with the following parameters
      | NAME    | AutomationProject001 |
      | ACCOUNT | AutomationAccount001 |
    Then new project name is displayed in the project main page
    And the user go to Dashboard
    Then new project name is displayed in the dashboard


  @DeleteSingleProject @DeleteAccount
  Scenario: The user can create a project with public privacy
    Given the user go to Dashboard
    And click on the new project button
    When the user create a new project with the following parameters
      | NAME    | AutomationProject002 |
      | ACCOUNT | AutomationAccount002 |
      | PRIVACY | public               |
    Then new project name is displayed in the project main page
    And the user go to Dashboard
    Then new project name is displayed in the dashboard
