Feature: Loan calculate endpoint test

  Scenario: Check calculate endpoint response

    Given Set calculate endpoint uri
      | uri                                              |
      | https://ansokan.bigbank.se/api/v1/loan/calculate |
    Given Set request params: amount = 75000, month = 120
    Then Check monthlyPayment and it should be "1078.97" SEK
    Then Check apr and totalRepayableAmount and it should be "12.97" and "129475.65"