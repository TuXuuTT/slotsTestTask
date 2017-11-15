package com.automation.stepDefinitions.web;

import cucumber.api.java.en.Then;
import pageobjects.CommonPage;

import static com.codeborne.selenide.Selenide.page;

public class CommonPageStepAsserts {

    CommonPage commonPage = page(CommonPage.class);

    @Then("^current page url has text (.*)$")
    public void checkUrlContains(String text) {
        commonPage.checkUrlContains(text);
    }
}
