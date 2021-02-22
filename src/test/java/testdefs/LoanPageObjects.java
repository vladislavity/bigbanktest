package testdefs;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoanPageObjects {
    public final SelenideElement loanPageModalShowBtn = $("div.bb-navbar__right-side");
    public final SelenideElement loanPageModalCloseBtn = $("div.bb-modal__header > button");
    public final SelenideElement loanPageModalSaveBtn = $("div.bb-modal__footer > button");
    public final SelenideElement loanPageLoanAmount = $("div.bb-edit-amount__amount");
    public final SelenideElement loanModal = $("div.bb-modal.wrapper.bb-modal--m");
    public final SelenideElement loanMonthlyPayment = $("p.bb-calculator__result-value");
    public final SelenideElement loanMonthlyPaymentLoader = $("p.bb-calculator__result-value--loader");
    public final SelenideElement loanAmountEditBtn = $("#header-calculator-amount > div.bb-slider__value > button");
    public final SelenideElement loanAmountInput = $("#header-calculator-amount > div.bb-slider__value > div > input");

    public final SelenideElement loanPeriodEditBtn = $("#header-calculator-period > div.bb-slider__value > button");
    public final SelenideElement loanPeriodInput = $("#header-calculator-period > div.bb-slider__value > div > input");

    public final SelenideElement moreThenOneDependantCheckbox = $x("//label[@for='dependantsCheck'][1]");
    public final SelenideElement dependantInTheFamilyRadioBtnTwo = $x("//label[@for='dependants2'][1]");
    public final SelenideElement totalMonthlyIncome = $("#income");
    public final SelenideElement downPaymentInput = $("#downpayment");
    public final SelenideElement loanTermInput = $x("//*[@id='slider2']/div[2]/input");
    public final SelenideElement maximumLoanAmount = $("#slider-financed");
}
