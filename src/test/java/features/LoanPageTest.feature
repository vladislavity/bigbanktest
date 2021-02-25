Feature: Loan page test

  Scenario: Loan modal smoke test

    Given Open browser with loan page
    Given Open loan calculations modal
    Given Check calculate API response for amount 85000 and month 120
    Then Find out monthly payment and it should be equal to API response
    Then Close loan calculations modal

  Scenario: Loan modal calculations test

    Given Open browser with loan page
    Given Open loan calculations modal
    Given Check calculate API response for amount 50000 and month 100
    When Adjust loan amount via input field to "50000" SEK
    When Adjust loan period via input field to "100" month
    Then Find out monthly payment and it should be equal to API response
    Then Submit selected loan params
    Then Find out loan amount on main page and it should be "50000"