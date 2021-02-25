Feature: Loan calculate endpoint test

  Scenario: Check calculate endpoint response

    Given Set request params: amount = 75000, month = 120
    Then Check if apr, monthlyPayment and totalRepayableAmount should exist in response