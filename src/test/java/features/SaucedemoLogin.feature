Feature: Verify that sign in works properly

  Scenario: Verify that sign in works properly
    Given I open Login page
    Then Login page is opened
    When I sign in with "standard_user" and "secret_sauce" credentials
    Then I am authorized