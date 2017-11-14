package com.automation.stepDefinitions.web;

import com.automation.businessEntities.SlotsMachineDTO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageobjects.SlotsHomePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class SlotsHomePageStepDefs {

    static SlotsMachineDTO beforeChanges = new SlotsMachineDTO();
    static SlotsMachineDTO afterChanges = new SlotsMachineDTO();
    SlotsHomePage slotsHomePage = page(SlotsHomePage.class);

    @Given("^slots start page is opened$")
    public void slotsHomePageIsOpened() {
        open(SlotsHomePage.getAppURL(), SlotsHomePage.class);
    }


    @When("^client clicks Spin button$")
    public void clientClicksSpinButton() throws Throwable {
        slotsHomePage.storeSlotMachineStateSpin(beforeChanges);
        slotsHomePage.clickSpin();
        slotsHomePage.storeSlotMachineStateSpin(afterChanges);
    }


    @When("^client clicks Change Background button$")
    public void clientClicksChangeBackgroundButton() throws Throwable {
        slotsHomePage.storeSlotMachineStateAppearence(beforeChanges);
        slotsHomePage.clickChangeBackground();
        slotsHomePage.storeSlotMachineStateAppearence(afterChanges);
    }


    @When("^client clicks Change Icons button$")
    public void clientClicksChangeIconsButton() throws Throwable {
        slotsHomePage.storeSlotMachineStateAppearence(beforeChanges);
        slotsHomePage.clickChangeIcons();
        slotsHomePage.storeSlotMachineStateAppearence(afterChanges);
    }

    @When("^client clicks Change Machine button$")
    public void clientClicksChangeMachineButton() throws Throwable {
        slotsHomePage.storeSlotMachineStateAppearence(beforeChanges);
        slotsHomePage.clickChangeMachine();
        slotsHomePage.storeSlotMachineStateAppearence(afterChanges);
    }

    @When("^client press arrow to increase bet (\\d+) times$")
    public void clientPressArrowToIncreaseBetTimes(int arg0) throws Throwable {
        slotsHomePage.increaseBetByArrowNthTimes(arg0);
    }

    @When("^client press arrow to decrease bet (\\d+) times$")
    public void clientPressArrowToDecreaseBetTimes(int arg0) throws Throwable {
        slotsHomePage.decreaseBetByArrowNthTimes(arg0);
    }
}
