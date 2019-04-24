Feature: test employee
  Scenario: set employee salary
    When Employee get hire for job with salary: 10000
    Then Employee salary is 10000


  Scenario: update employee salary
    When Employee get hire for job with salary: 10000
    When Employee get salary increased by 1000 dollar.
    Then Employee salary is 11000