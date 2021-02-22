package testdefs;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LoanPageTestDefs {

    LoanPageObjects calculator = new LoanPageObjects();

    @Given("Open browser with loan page")
    public void openLoanApplicationPage() {
        open("https://ansokan.bigbank.se/?amount=85000&period=120&interestRate=10.95&lang=sv&bbsource=google&bbchannel=organic");
    }

    @When("Open loan calculations modal")
    public void openLoanCalcModal() {
        calculator.loanPageModalShowBtn.click();
        calculator.loanModal.shouldBe(Condition.visible);
    }

    @Then("Close loan calculations modal")
    public void closeLoanCalculationsModal() {
        calculator.loanModal.shouldBe(Condition.visible);
        calculator.loanPageModalCloseBtn.click();
        calculator.loanModal.shouldNotBe(Condition.visible);
    }

    @When("Adjust loan amount via input field to {string} SEK")
    public void adjustLoanAmountViaInputFieldToSEK(String loanAmount) {
        calculator.loanAmountEditBtn.click();
        calculator.loanAmountInput.sendKeys(loanAmount);
        calculator.loanMonthlyPaymentLoader.shouldNotBe(Condition.exist);
    }

    @When("Adjust loan period via input field to {string} month")
    public void adjustLoanPeriodViaInputFieldToMonth(String loanPeriod) {
        String startAmount = calculator.loanMonthlyPayment.getText();
        calculator.loanPeriodEditBtn.click();
        calculator.loanPeriodInput.sendKeys(loanPeriod);
        calculator.loanMonthlyPayment.click();
        calculator.loanMonthlyPayment.shouldNotBe(Condition.text(startAmount));
    }

    @Then("Find out monthly payment and it should be {string}")
    public void findOutMonthlyPayment(String monthlyPayment) {
        calculator.loanMonthlyPayment.shouldBe(Condition.visible);
        calculator.loanMonthlyPaymentLoader.shouldNotBe(Condition.visible);
        String monthlyPaymentInPopup = calculator.loanMonthlyPayment.getText();
        calculator.loanMonthlyPayment.shouldBe(Condition.visible);
        assertThat(monthlyPaymentInPopup, is(monthlyPayment));
    }

    @Then("Submit selected loan params")
    public void submitSelectedLoanParams() {
        calculator.loanModal.shouldBe(Condition.visible);
        calculator.loanPageModalSaveBtn.click();
        calculator.loanModal.shouldNotBe(Condition.visible);
    }

    @Then("Find out loan amount on main page and it should be {string}")
    public void findOutLoanAmountOnMainPage(String loanAmount) {
        String loanAmountOnMainPage = calculator.loanPageLoanAmount.getText();
        assertThat(loanAmount, is(loanAmountOnMainPage));
    }
}