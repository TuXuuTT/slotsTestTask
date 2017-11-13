Feature:
  As a potential customer I want to navigate through landing page and click everything related to slots machine to check how it works

  Background:
    Given slots start page is opened

  Scenario:
    Then current page url has text script

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