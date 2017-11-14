Feature:
  As a potential customer I want to navigate through landing page and click everything related to slots machine to check how it works

  Scenario:
    Given slots start page is opened
    Then slot machine is displayed
    And Try Me button points to Spin button
    And current bet by default equals 1

  Scenario:
    When client clicks Spin button
    Then slots are spinned
    And Total spins amount has changed
    And Try Me button points to Change Background button

  Scenario:
    When client clicks Change Background button
    Then background changes
    And Try me button not displayed

  Scenario:
    When client clicks Change Icons button
    Then icons change

  Scenario:
    When client clicks Change Machine button
    Then machine changes

  @NewBrowser
  Scenario:
    Given slots start page is opened
    When client

#  @NewBrowser
#  Scenario:
#    When select one random manufacturer
#    And choose one of manufacturer models
#    Then at least one manufacturing model year is available
#    And selected car is set
#
#  #this test is heavy loaded because checks every entry, so runs few minutes. Can be excluded by tag
#  @LOAD
#  Scenario:
#    Then each model have its years of manufacturing