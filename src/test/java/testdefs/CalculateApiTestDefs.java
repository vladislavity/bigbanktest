package testdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.blankString;
import static org.hamcrest.Matchers.not;

public class CalculateApiTestDefs {

    String response;
    CalculateApiHelper calculateApi = new CalculateApiHelper();

    @Given("Set request params: amount = {int}, month = {int}")
    public void setRequestParamsAmountMonth(int amount, int month) {
        response = calculateApi.calculateRequest(amount, month).getBody().toString();
    }

    @Then("Check if apr, monthlyPayment and totalRepayableAmount should exist in response")
    public void checkIfAprMonthlyPaymentAndTotalRepayableAmountShouldExistInResponse() {
        assertThat(calculateApi.parseCalculateResponse(response, "$.apr"), not(blankString()));
        assertThat(calculateApi.parseCalculateResponse(response, "$.monthlyPayment"), not(blankString()));
        assertThat(calculateApi.parseCalculateResponse(response, "$.totalRepayableAmount"), not(blankString()));
    }
}