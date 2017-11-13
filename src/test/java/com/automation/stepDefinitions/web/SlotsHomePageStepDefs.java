package com.automation.stepDefinitions.web;

import com.automation.businessEntities.SlotsMachineDTO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pageobjects.SlotsHomePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class SlotsHomePageStepDefs {

    SlotsHomePage slotsHomePage = page(SlotsHomePage.class);

    SlotsMachineDTO beforeSpin = new SlotsMachineDTO();
    SlotsMachineDTO afterSpin = new SlotsMachineDTO();

    @Given("^slots start page is opened$")
    public void slotsHomePageIsOpened() {
        open(SlotsHomePage.getAppURL(), SlotsHomePage.class);
    }


    @Then("^slot machine and Try Me button are displayed$")
    public void slotMachineAndTryMeButtonAreDisplayed() throws Throwable {
        slotsHomePage.verifyCoreElementsAreDisplayed();
    }

    @Then("^current bet by default equals (\\d+)$")
    public void currentBetByDefaultEquals(int arg0) throws Throwable {
        slotsHomePage.verifyCurrentBet(arg0);
    }

    @When("^client clicks Spin button$")
    public void clientClicksSpinButton() throws Throwable {
        slotsHomePage.storeSlotMachineState(beforeSpin);
        slotsHomePage.clickSpin();
        slotsHomePage.storeSlotMachineState(afterSpin);
    }

    @Then("^slots are spinned$")
    public void slotsAreSpinned() throws Throwable {
        Assert.assertNotEquals(afterSpin.getReelsStates(), beforeSpin.getReelsStates());
    }

}
