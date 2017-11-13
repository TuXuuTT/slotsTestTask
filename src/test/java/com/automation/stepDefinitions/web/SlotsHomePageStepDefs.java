package com.automation.stepDefinitions.web;

import cucumber.api.java.en.Given;
import pageobjects.SlotsHomePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class SlotsHomePageStepDefs {

    SlotsHomePage slotsHomePage = page(SlotsHomePage.class);


    @Given("^slots start page is opened$")
    public void slotsHomePageIsOpened() {
        open(SlotsHomePage.getAppURL(), SlotsHomePage.class);
    }


}
