
Feature: First cucumber test demo
  Scenario: demo1
    When User print value: testmessage
    Then message should be：testmessage

  @demo2
  Scenario: demo2
    When User print value: testmessage1
    Then message should be：testmessage1

