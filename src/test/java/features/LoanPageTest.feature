Feature: Loan page test

  Scenario: Loan modal smoke test

    Given Open browser with loan page
    Given Open loan calculations modal
    Then Find out monthly payment and it should be "1217,50 SEK"
    Then Close loan calculations modal

  Scenario: Loan modal calculations test

    Given Open browser with loan page
    Given Open loan calculations modal
    When Adjust loan amount via input field to "50000" SEK
    When Adjust loan period via input field to "100" month
    Then Find out monthly payment and it should be "809,70 SEK"
    Then Submit selected loan params
    Then Find out loan amount on main page and it should be "50000"