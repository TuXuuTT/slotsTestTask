package com.automation.stepDefinitions.web;

import com.automation.businessEntities.SlotsMachineDTO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageobjects.SlotsHomePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class SlotsHomePageStepDefs {

    static SlotsMachineDTO beforeSpin = new SlotsMachineDTO();
    static SlotsMachineDTO afterSpin = new SlotsMachineDTO();
    SlotsHomePage slotsHomePage = page(SlotsHomePage.class);

    @Given("^slots start page is opened$")
    public void slotsHomePageIsOpened() {
        open(SlotsHomePage.getAppURL(), SlotsHomePage.class);
    }


    @When("^client clicks Spin button$")
    public void clientClicksSpinButton() throws Throwable {
        slotsHomePage.storeSlotMachineState(beforeSpin);
        slotsHomePage.clickSpin();
        slotsHomePage.storeSlotMachineState(afterSpin);
    }


    @When("^client clicks Change Background button$")
    public void clientClicksChangeBackgroundButton() throws Throwable {
        slotsHomePage.storeSlotMachineState(beforeSpin);
        slotsHomePage.clickChangeBackground();
        slotsHomePage.storeSlotMachineState(afterSpin);
    }


    @When("^client clicks Change Icons button$")
    public void clientClicksChangeIconsButton() throws Throwable {
        slotsHomePage.storeSlotMachineState(beforeSpin);
        slotsHomePage.clickChangeIcons();
        slotsHomePage.storeSlotMachineState(afterSpin);
    }

    @When("^client clicks Change Machine button$")
    public void clientClicksChangeMachineButton() throws Throwable {
        slotsHomePage.storeSlotMachineState(beforeSpin);
        slotsHomePage.clickChangeMachine();
        slotsHomePage.storeSlotMachineState(afterSpin);
    }
}
