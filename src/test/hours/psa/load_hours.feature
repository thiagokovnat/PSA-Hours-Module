Feature: Load Hours
  Loading hours in system


  Scenario: Trying to load hours
    Given Task X exists
    When Trying to load 8 hours for Task X
    Then 8 Hours are loaded.

  Scenario: Trying to load hours but not the responsible user
    Given Task X exists
    When Trying to load 8 hours for Task X
    Then 8 Hours are not loaded.

  Scenario: Trying to load hours but not the responsible user
    Given Task X exists
    When Trying to load 0 hours for Task X
    Then 0 Hours are loaded.

  Scenario: Trying to load hours but not the responsible user
    Given Task X exists
    When Trying to load -1 hours for Task X
    Then an Error occurs.