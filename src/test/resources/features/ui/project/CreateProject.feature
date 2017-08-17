Feature: Create Project

  Background:
    Given the user go to Dashboard
    And click on the new project button

  @DeleteSingleProject @DeleteAccount
  Scenario: The user can create a project with default settings successfully
    When the user create a new project with
      | NAME    | AutomationProject001 |
      | ACCOUNT | AutomationAccount001 |
    Then new project name is displayed in the project main page
    And the user go to Dashboard
    Then new project name is displayed in the dashboard


  @DeleteSingleProject @DeleteAccount
  Scenario: The user can create a project with public privacy
    When the user create a new project with
      | NAME    | AutomationProject002 |
      | ACCOUNT | AutomationAccount002 |
      | PRIVACY | public               |
    Then new project name is displayed in the project main page
    And the user go to Dashboard
    Then new project name is displayed in the dashboard
