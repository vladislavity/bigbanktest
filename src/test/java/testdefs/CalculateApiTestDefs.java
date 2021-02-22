package testdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.json.JSONObject;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class CalculateApiTestDefs {

    String url;
    String response;

    @Given("Set calculate endpoint uri")
    public void setCalculateEndpoint(DataTable table) {
        List data = table.asList();
        url = data.get(1).toString();
    }

    @Given("Set request params: amount = {int}, month = {int}")
    public void setRequestParamsAmountMonth(int amount, int month) {
        CalculateApiHelper api = new CalculateApiHelper();
        String body = new JSONObject()
                .put("administrationFee", 40)
                .put("conclusionFee", 695)
                .put("currency", "SEK")
                .put("interestRate", 10.95)
                .put("monthlyPaymentDay", 27)
                .put("productType", "LOANSE02")
                .put("amount", amount)
                .put("maturity", month)
                .toString();
        response = api.doPostRequest(body, url).getBody().toString();
    }

    @Then("Check monthlyPayment and it should be {string} SEK")
    public void checkMonthlyPaymentAndItShouldBe(String monthlyPayment) {
        assertThat(response, containsString(String.valueOf(monthlyPayment)));

    }

    @Then("Check apr and totalRepayableAmount and it should be {string} and {string}")
    public void checkAprAndTotalRepayableAmountAndItShouldBeAnd(String apr, String totalRepayableAmount) {
        assertThat(response, containsString(String.valueOf(apr)));
        assertThat(response, containsString(String.valueOf(totalRepayableAmount)));
    }
}
